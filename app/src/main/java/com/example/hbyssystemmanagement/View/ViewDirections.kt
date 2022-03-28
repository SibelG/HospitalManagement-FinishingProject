package com.example.hbyssystemmanagement.View

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.Helper.DirectionJSONParser
import com.example.hbyssystemmanagement.Interface.NearByApi
import com.example.hbyssystemmanagement.Model.NearByLocation
import com.example.hbyssystemmanagement.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import dmax.dialog.SpotsDialog
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class ViewDirections : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var locationCallback: LocationCallback
    private var fusedLocationClient: FusedLocationProviderClient?=null
    private lateinit var locationRequest: LocationRequest
    private lateinit var mService:NearByApi
    private lateinit var mLastLocation:Location
    private var mCurrentMarker:Marker?=null
    var polyLine: Polyline?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_directions)



        mService= Common.serviceScalars
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission()
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
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
        mMap.uiSettings.isZoomControlsEnabled=true
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }





    }
    private fun createLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000
        locationRequest.setSmallestDisplacement(10f);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);



    }
    override fun onStop() {
        super.onStop()
        fusedLocationClient!!.removeLocationUpdates(locationCallback)
    }
    private fun buildLocationCallback(){
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                mLastLocation=p0.lastLocation
                val markerOptions=MarkerOptions()
                    .position(LatLng(mLastLocation.latitude,mLastLocation.longitude))
                    .title("your position")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                mCurrentMarker=mMap.addMarker(markerOptions)
                mMap!!.moveCamera(CameraUpdateFactory.newLatLng(LatLng(mLastLocation.latitude,mLastLocation.longitude)))
                mMap.moveCamera(CameraUpdateFactory.zoomTo(12.0f))

                val destinationLatLng=LatLng(Common.currentResult!!.geometry!!.location!!.lat!!.toDouble(),Common.currentResult!!.geometry!!.location!!.lng!!.toDouble())
                mMap.addMarker(markerOptions.position(destinationLatLng)!!
                    .title(Common.currentResult!!.name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))

                drawPath(mLastLocation,Common.currentResult!!.geometry!!.location)



            }
        }

    }
    private fun drawPath(mLasLocation:Location?, location: NearByLocation?){
        if(polyLine!=null){
            polyLine!!.remove()
        }
        val origin:String=StringBuilder(mLastLocation.latitude.toString())
            .append(",")
            .append(mLastLocation.longitude.toString())
            .toString()

        val destination:String=StringBuilder(location!!.lat.toString())
            .append(",")
            .append(location.lng.toString())
            .toString()

        mService.getDirections(origin,destination)
            .enqueue(object:retrofit2.Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    ParserTask().execute(response.body().toString())
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })



    }

    inner class ParserTask(): AsyncTask<String, Int,List<List<HashMap<String,String>>>>() {
        internal var waitingDialog: android.app.AlertDialog = SpotsDialog.Builder().setContext(this@ViewDirections).build()
        override fun doInBackground(vararg params: String?): List<List<HashMap<String, String>>> {
            val jsonObject:JSONObject
            var routes:List<List<HashMap<String,String>>>?=null
            try{
                jsonObject=JSONObject(params[0])
                val parser= DirectionJSONParser()
                routes=parser.parse(jsonObject)

            }catch (e:Exception){
                e.printStackTrace()
            }
            return routes!!
        }

        override fun onPreExecute() {
            super.onPreExecute()
            waitingDialog.show()
            waitingDialog.setMessage("Please waiting...")

        }

        override fun onPostExecute(result: List<List<HashMap<String, String>>>?) {
            super.onPostExecute(result)
            var points:ArrayList<LatLng>?=null
            var polylineOptions:PolylineOptions?=null

            for(i in result!!.indices){
                points= ArrayList()
                polylineOptions=PolylineOptions()
                val path=result[i]
                for(j in path.indices){
                    val point=path[j]
                    val lat= point["lat"]!!.toDouble()
                    val lng= point["lng"]!!.toDouble()
                    val position=LatLng(lat,lng)

                    points.add(position)

                }
                polylineOptions.addAll(points)
                polylineOptions.width(12f)
                polylineOptions.color(Color.RED)
                polylineOptions.geodesic(true)

            }
            polyLine=mMap.addPolyline(polylineOptions!!)
            waitingDialog.dismiss()
        }
    }

    private fun checkLocationPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    SearchNearPlace.MY_PERMISSIONS_REQUEST_LOCATION
                )
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    SearchNearPlace.MY_PERMISSIONS_REQUEST_LOCATION
                )
            }
            false
        } else {
            true
        }
    }
}