package com.example.hbyssystemmanagement.View

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import com.beust.klaxon.*
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

/** Simple Maps class to instantiate a map with two points, draw a route between both by querying Google Maps
 * API, and center it in the screen. You can read more about it on
 * Medium: https://medium.com/@irenenaya/drawing-path-between-two-points-in-google-maps-with-kotlin-in-android-app-af2f08992877
 */

class Direction : FragmentActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    var locationCallback: LocationCallback? = null
    var locationRequest: LocationRequest? = null
    var mLastLocation: Location? = null
    var mCurrentMarker: Marker? = null
    var polyline: Polyline? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = getSupportFragmentManager()
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationProviderClient!!.lastLocation.addOnSuccessListener { location ->
            mLastLocation = location
            mMap!!.uiSettings.isZoomControlsEnabled = true
            val markerOptions = MarkerOptions()
                .position(
                    LatLng(
                        mLastLocation!!.latitude,
                        mLastLocation!!.longitude
                    )
                )
                .title("Your Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
            mCurrentMarker = mMap!!.addMarker(markerOptions)
            mMap!!.moveCamera(
                CameraUpdateFactory
                    .newLatLng(
                        LatLng(
                            mLastLocation!!.latitude,
                            mLastLocation!!.longitude
                        )
                    )
            )
            mMap!!.animateCamera(CameraUpdateFactory.zoomTo(12.0f))
            val destinationLatLng = LatLng(
                Common.currentResults!!.geometry!!.location.lat!!.toDouble(),
                Common.currentResults!!.geometry!!.location.lng!!.toDouble()
            )
            mMap!!.addMarker(
                MarkerOptions()
                    .position(destinationLatLng)
                    .title(Common.currentResults!!.name)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
            )

            // declare bounds object to fit whole route in screen
            val LatLongB = LatLngBounds.Builder()

            // Add markers
            /* val sydney = LatLng(-34.0, 151.0)
        val opera = LatLng(-33.9320447,151.1597271)
        mMap!!.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap!!.addMarker(MarkerOptions().position(opera).title("Opera House"))*/
            val current = LatLng(mLastLocation!!.latitude, mLastLocation!!.longitude)
            // Declare polyline object and set up color and width
            val options = PolylineOptions()
            options.color(Color.RED)
            options.width(5f)

            // build URL to call API
            val url = getURL(current, destinationLatLng)

            async {
                // Connect to URL, download content and convert into string asynchronously
                val result = URL(url).readText()
                uiThread {
                    // When API call is done, create parser and convert into JsonObjec
                    val parser: Parser = Parser()
                    val stringBuilder: StringBuilder = StringBuilder(result)
                    val json: JsonObject = parser.parse(stringBuilder) as JsonObject
                    // get to the correct element in JsonObject
                    val routes = json.array<JsonObject>("routes")
                    val points = routes!!["legs"]["steps"][0] as JsonArray<JsonObject>
                    // For every element in the JsonArray, decode the polyline string and pass all points to a List
                    val polypts =
                        points.flatMap { decodePoly(it.obj("polyline")?.string("points")!!) }
                    // Add  points to polyline and bounds
                    options.add(current)
                    LatLongB.include(current)
                    for (point in polypts) {
                        options.add(point)
                        LatLongB.include(point)
                    }
                    options.add(destinationLatLng)
                    LatLongB.include(destinationLatLng)
                    // build bounds
                    val bounds = LatLongB.build()
                    // add polyline to the map
                    mMap!!.addPolyline(options)
                    // show map with route centered
                    mMap!!.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100))
                }
            }
        }
    }

    private fun getURL(from : LatLng, to : LatLng) : String {
        val origin = "origin=" + from.latitude + "," + from.longitude
        val dest = "destination=" + to.latitude + "," + to.longitude
        val sensor = "sensor=false"
        val params = "$origin&$dest&$sensor"
        return "https://maps.googleapis.com/maps/api/directions/json?$params"
    }

    /**
     * Method to decode polyline points
     * Courtesy : https://jeffreysambells.com/2010/05/27/decoding-polylines-from-google-maps-direction-api-with-java
     */
    private fun decodePoly(encoded: String): List<LatLng> {
        val poly = ArrayList<LatLng>()
        var index = 0
        val len = encoded.length
        var lat = 0
        var lng = 0

        while (index < len) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = encoded[index++].toInt() - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat

            shift = 0
            result = 0
            do {
                b = encoded[index++].toInt() - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng

            val p = LatLng(lat.toDouble() / 1E5,
                lng.toDouble() / 1E5)
            poly.add(p)
        }

        return poly
    }
}