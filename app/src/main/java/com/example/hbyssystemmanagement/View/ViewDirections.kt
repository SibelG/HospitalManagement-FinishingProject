package com.example.hbyssystemmanagement.View

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.AsyncTask
import android.os.Bundle
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.Helper.DirectionJSONParser
import com.example.hbyssystemmanagement.Interface.NearByApi
import com.example.hbyssystemmanagement.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import dmax.dialog.SpotsDialog
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ViewDirections : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    var locationCallback: LocationCallback? = null
    var locationRequest: LocationRequest? = null
    var mLastLocation: Location? = null
    var mCurrentMarker: Marker? = null
    var polyline: Polyline? = null
    var mService: NearByApi? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_directions)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        mService = Common.getGoogleAPIServiceScalars()
        buildLocationRequest()
        buildLocationCallback()
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationProviderClient!!.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.myLooper()
        )
    }

    override fun onStop() {
        fusedLocationProviderClient!!.removeLocationUpdates(locationCallback)
        super.onStop()
    }

    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                mLastLocation = locationResult.lastLocation
                mMap!!.uiSettings.isZoomControlsEnabled = true
                val markerOptions = MarkerOptions()
                    .position(LatLng(mLastLocation!!.getLatitude(), mLastLocation!!.getLongitude()))
                    .title("Your Location")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                mCurrentMarker = mMap!!.addMarker(markerOptions)
                mMap!!.moveCamera(
                    CameraUpdateFactory
                        .newLatLng(
                            LatLng(
                                mLastLocation!!.getLatitude(),
                                mLastLocation!!.getLongitude()
                            )
                        )
                )
                mMap!!.animateCamera(CameraUpdateFactory.zoomTo(12.0f))
                val destinationLatLng = LatLng(
                    Common.currentResults!!.geometry!!.location.latDir!!.toDouble(),
                    Common.currentResults!!.geometry!!.location.lngDir!!.toDouble()
                )
                mMap!!.addMarker(
                    MarkerOptions()
                        .position(destinationLatLng)
                        .title(Common.currentResults!!.name)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                )
                drawPath(mLastLocation, Common.currentResults!!.geometry!!.location)
            }
        }
    }

    @SuppressLint("RestrictedApi")
    private fun buildLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest!!.interval = 1000
        locationRequest!!.fastestInterval = 1000
        locationRequest!!.smallestDisplacement = 10f
        locationRequest!!.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
    }

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
            drawPath(mLastLocation, Common.currentResults!!.geometry!!.location)
        }
    }

    private fun drawPath(
        mLastLocation: Location?,
        location: com.example.hbyssystemmanagement.Model.Location
    ) {
        if (polyline != null) {
            polyline!!.remove()
        }
        val origin:String = StringBuilder(mLastLocation!!.latitude.toString())
            .append(",")
            .append(mLastLocation.longitude.toString())
            .toString()
        val destination:String= StringBuilder(
            location.lat.toString())
            .append(",")
            .append(location.lng.toString())
            .toString()


        mService!!.getDirections(origin, destination)
            .enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    ParserTask().execute(response.body().toString())

                }

                override fun onFailure(call: Call<String>, t: Throwable) {}
            })
    }

    private inner class ParserTask :
        AsyncTask<String?, Int?, List<List<HashMap<String, String>>>?>() {
        var waitingDialog: AlertDialog = SpotsDialog(this@ViewDirections)
        override fun onPreExecute() {
            super.onPreExecute()
            waitingDialog.show()
            waitingDialog.setMessage("Please wait...")
        }

        override fun doInBackground(vararg params: String?): List<List<HashMap<String, String>>>? {
            val jsonObject: JSONObject
            var routes: List<List<HashMap<String, String>>>? = null
            try {
                jsonObject = JSONObject(params[0])
                val parser = DirectionJSONParser()
                routes = parser.parse(jsonObject)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return routes
        }

        override fun onPostExecute(lists: List<List<HashMap<String, String>>>?) {
            super.onPostExecute(lists)
            var points: ArrayList<LatLng>? = null
            var polylineOptions: PolylineOptions? = null
            for (i in lists!!.indices) {
                points = ArrayList<LatLng>()
                polylineOptions = PolylineOptions()
                val path = lists[i]
                for (j in path.indices) {
                    val point = path[j]
                    val lat = point["lat"]!!.toDouble()
                    val lng = point["lng"]!!.toDouble()
                    val position = LatLng(lat, lng)
                    points.add(position)
                }
                polylineOptions.addAll(points)
                polylineOptions.width(12f)
                polylineOptions.color(Color.BLUE)
                polylineOptions.geodesic(true)
            }
            /*if (polylineOptions != null) {
                polyline = mMap!!.addPolyline(polylineOptions)
                //mMap.addPolyline(polylineOptions);
            }*/
            polyline = mMap!!.addPolyline(polylineOptions);
            waitingDialog.dismiss()
        }


        }
}