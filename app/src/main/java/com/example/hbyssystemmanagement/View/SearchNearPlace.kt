package com.example.hbyssystemmanagement.View

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.Interface.NearByApi
import com.example.hbyssystemmanagement.Model.NearByApiResponse
import com.example.hbyssystemmanagement.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchNearPlace : AppCompatActivity(), OnMapReadyCallback,
    GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
    LocationListener {
    private lateinit var mMap: GoogleMap
    private var mGoogleApiClient: GoogleApiClient? = null
    private lateinit var btnPharmacyFind: Button
    private lateinit var btnHospitalFind: Button
    private var mLocationRequest: LocationRequest? = null
    private var location: Location? = null
    private var PROXIMITY_RADIUS = 8000
    lateinit var mService: NearByApi
    internal  var currentPlace:NearByApiResponse?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_near_place)

        //To check permissions above M as below it making issue and gives permission denied on samsung and other phones.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission()
        }
        btnPharmacyFind = findViewById(R.id.btnPharmacyFind)
        btnHospitalFind = findViewById(R.id.btnHospitalFind)

        //To check google play service available
        if (!isGooglePlayServicesAvailable) {
            Toast.makeText(this, "Google Play Services not available.", Toast.LENGTH_LONG).show()
            finish()
        } else {
            // when the map is ready to be used.
            val mapFragment =
                supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment!!.getMapAsync(this)
        }
        mService= Common.getGoogleAPIService()!!
    }

    private val isGooglePlayServicesAvailable: Boolean
        private get() {
            val googleAPI = GoogleApiAvailability.getInstance()
            val result = googleAPI.isGooglePlayServicesAvailable(this)
            if (result != ConnectionResult.SUCCESS) {
                if (googleAPI.isUserResolvableError(result)) {
                    googleAPI.getErrorDialog(this, result, 0)!!.show()
                }
                return false
            }
            return true
        }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled=true

        //Initialize Google Play Services
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                buildGoogleApiClient()
                mMap.isMyLocationEnabled = true
            }
        } else {
            buildGoogleApiClient()
            mMap.isMyLocationEnabled = true
        }
        mMap.setOnMarkerClickListener { marker ->
            if (marker.snippet != null) {
                Common.currentResults = currentPlace!!.results!!.get(marker.snippet!!.toInt())
                startActivity(Intent(this@SearchNearPlace, ViewPlace::class.java))
            }
            true
        }
    }

    @Synchronized
    protected fun buildGoogleApiClient() {
        mGoogleApiClient = GoogleApiClient.Builder(this).addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this).addApi(LocationServices.API).build()
        mGoogleApiClient!!.connect()
    }

    fun onPharmacyFindClick(view: View) {
        findPlaces("pharmacy")
    }

    fun onHospitalsFindClick(view: View) {
        findPlaces("hospital")
    }

    private fun findPlaces(placeType: String) {
        mMap!!.clear()

        var url=getUrl(location!!.latitude, location!!.longitude,placeType)
        mService.getNearbyPlaces(url)
            .enqueue(object : Callback<NearByApiResponse> {
                override fun onResponse(
                    call: Call<NearByApiResponse>,
                    response: Response<NearByApiResponse>
                ) {
                    currentPlace= response.body()!!
                    if(response.isSuccessful){
                        for (i in 0 until response.body()!!.results!!.size) {
                            val lat: Double =
                                response.body()!!.results!![i].geometry!!.location!!.lat!!.toDouble()
                            val lng: Double =
                                response.body()!!.results!![i].geometry!!.location!!.lng!!.toDouble()
                            val placeName: String = response.body()!!.results!![i].name!!
                            val vicinity: String = response.body()!!.results!![i].vicinity!!
                            val markerOptions = MarkerOptions()
                            val latLng = LatLng(lat, lng)
                            // Location of Marker on Map
                            markerOptions.position(latLng)
                            // Title for Marker
                            markerOptions.title("$placeName : $vicinity")
                            // Color or drawable for marker
                            /*if(placeType.equals("hospital"))
                                markerOptions.icon(
                                    BitmapDescriptorFactory.fromResource(
                                        R.drawable.ic_baseline_local_hospital_24
                                    )
                                )
                            else if(placeType.equals("pharmacy"))
                                markerOptions.icon(
                                    BitmapDescriptorFactory.fromResource(
                                        R.drawable.ic_baseline_local_pharmacy_24
                                    )
                                )
                            else*/
                            markerOptions.icon(
                                BitmapDescriptorFactory.defaultMarker(
                                    BitmapDescriptorFactory.HUE_BLUE
                                )
                            )
                            markerOptions.snippet(i.toString())




                            // add marker
                            mMap!!.addMarker(markerOptions)
                            // move map camera
                            mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                            mMap!!.animateCamera(CameraUpdateFactory.zoomTo(13f))
                        }

                    }
                }



                override fun onFailure(call: Call<NearByApiResponse>, t: Throwable) {
                    Log.d("onFailure", t.toString())
                    t.printStackTrace()
                    PROXIMITY_RADIUS += 10000
                }


            })
    }


    private fun getUrl(latitude: Double, longitude: Double, placeType: String):String{
        val googlePlaceUrl=StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json")
        googlePlaceUrl.append("?location=$latitude,$longitude")
        googlePlaceUrl.append("&radius="+10000)
        googlePlaceUrl.append("&type=$placeType")
        googlePlaceUrl.append("&key="+getResources().getString(R.string.browser_key))
        Log.d("getUrl", googlePlaceUrl.toString())
        return googlePlaceUrl.toString()

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
                    MY_PERMISSIONS_REQUEST_LOCATION
                )
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    MY_PERMISSIONS_REQUEST_LOCATION
                )
            }
            false
        } else {
            true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient()
                        }
                        mMap!!.isMyLocationEnabled = true
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Location Permission has been denied, can not search the places you want.",
                        Toast.LENGTH_LONG
                    ).show()
                }
                return
            }
        }
    }

    override fun onConnected(@Nullable bundle: Bundle?) {
        startLocationUpdates()
    }

    override fun onConnectionSuspended(i: Int) {}
    override fun onConnectionFailed
                (@NonNull connectionResult: ConnectionResult) {
        Toast.makeText(this, "Could not connect google api", Toast.LENGTH_LONG).show()
    }

    protected fun startLocationUpdates() {
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = 1000
        mLocationRequest!!.fastestInterval = 1000
        mLocationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient!!,
                mLocationRequest!!, this
            )
        }
    }

    override fun onLocationChanged(location: Location) {
        if (location != null) {
            this.location = location
            if (!btnHospitalFind!!.isEnabled) {
                val latLng = LatLng(location.latitude, location.longitude)
                mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                mMap!!.animateCamera(CameraUpdateFactory.zoomTo(15f))
                btnPharmacyFind!!.isEnabled = true
                btnHospitalFind!!.isEnabled = true
            }
        }
    }

    companion object {
        const val MY_PERMISSIONS_REQUEST_LOCATION = 99
    }
}/*
class SearchNearPlace : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    private var latitude = 0.0
    private var longitude = 0.0
    private var mLastLocation: Location? = null
    private var mMarker: Marker? = null
    private var mLocationRequest: LocationRequest? = null
    var mService: NearByApi? = null
    var currentPlaces: NearByApiResponse? = null
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    var locationCallback: LocationCallback? = null
    private lateinit var btnPharmacyFind: Button
    private lateinit var btnHospitalFind: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        mService = Common.getGoogleAPIService()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            checkLocationPermission()
        }


        /*val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_hospital -> nearByPlaces("hospital")
                R.id.action_pharmacy -> nearByPlaces("pharmacy")

            }
            true
        }*/

        buildLocationRequest()
        buildLocationCallback()
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationProviderClient!!.requestLocationUpdates(
            mLocationRequest,
            locationCallback,
            Looper.myLooper()
        )
    }

    override fun onStop() {
        fusedLocationProviderClient!!.removeLocationUpdates(locationCallback)
        super.onStop()
    }

    fun onPharmacyFindClick(view: View) {
        nearByPlaces("pharmacy")
    }

    fun onHospitalsFindClick(view: View) {
        nearByPlaces("hospital")
    }

    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                mLastLocation = locationResult.lastLocation
                if (mMarker != null) {
                    mMarker!!.remove()
                }
                latitude = mLastLocation!!.getLatitude()
                longitude = mLastLocation!!.getLongitude()
                val latLng = LatLng(latitude, longitude)
                val markerOptions = MarkerOptions().position(latLng)
                    .title("Your Location")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                mMarker = mMap!!.addMarker(markerOptions)
                mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                mMap!!.animateCamera(CameraUpdateFactory.zoomTo(11f))
            }
        }
    }

    @SuppressLint("RestrictedApi")
    private fun buildLocationRequest() {
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = 1000
        mLocationRequest!!.fastestInterval = 1000
        mLocationRequest!!.smallestDisplacement = 10f
        mLocationRequest!!.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
    }

    private fun nearByPlaces(placeType: String) {
        mMap!!.clear()
        val url = getUrl(latitude, longitude, placeType)
        mService!!.getNearbyPlaces(url)
            .enqueue(object : Callback<NearByApiResponse> {
                override fun onResponse(call: Call<NearByApiResponse>, response: Response<NearByApiResponse>) {
                    currentPlaces = response.body()
                    if (response.isSuccessful()) {
                        for (i in 0 until response.body()!!.results!!.size) {
                            val markerOptions = MarkerOptions()
                            val googlePlaces: Results = response.body()!!.results!!.get(i)
                            val lat: Double =
                                googlePlaces.geometry!!.location.lat.toDouble()
                            val lng: Double =
                                googlePlaces.geometry.location.lng.toDouble()
                            val placeName: String = googlePlaces.name!!
                            val vicinity: String = googlePlaces.vicinity!!
                            val latLng = LatLng(lat, lng)
                            markerOptions.position(latLng)
                            markerOptions.title(placeName)
                            if (placeType == "hospital") {
                                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_hospital))
                            } else if (placeType == "pharmacy") {
                                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_pharmacy))
                            } else {
                                markerOptions.icon(
                                    BitmapDescriptorFactory.defaultMarker(
                                        BitmapDescriptorFactory.HUE_RED
                                    )
                                )
                            }
                            markerOptions.snippet(i.toString())
                            mMap!!.addMarker(markerOptions)
                            mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                            mMap!!.animateCamera(CameraUpdateFactory.zoomTo(11f))
                        }
                    }
                }

                override fun onFailure(call: Call<NearByApiResponse>, t: Throwable) {}
            })
    }

    private fun getUrl(latitude: Double, longitude: Double, placeType: String): String {
        val googlePlacesUrl =
            StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?")
        googlePlacesUrl.append("location=$latitude,$longitude")
        googlePlacesUrl.append("&radius=" + 10000)
        googlePlacesUrl.append("&type=$placeType")
        googlePlacesUrl.append("&sensor=true")
        googlePlacesUrl.append("&key=" + resources.getString(R.string.browser_key))
        Log.d("getUrl", googlePlacesUrl.toString())
        return googlePlacesUrl.toString()
    }

    private fun checkLocationPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ), MY_PERMISSION_CODE
                )
            } else {
                ActivityCompat.requestPermissions(
                    this, arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ), MY_PERMISSION_CODE
                )
            }
            false
        } else {
            true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        mMap!!.isMyLocationEnabled = true
                        buildLocationRequest()
                        buildLocationCallback()
                        fusedLocationProviderClient =
                            LocationServices.getFusedLocationProviderClient(this)
                        fusedLocationProviderClient!!.requestLocationUpdates(
                            mLocationRequest,
                            locationCallback,
                            Looper.myLooper()
                        )
                    }
                }
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                mMap!!.isMyLocationEnabled = true
            }
        } else {
            mMap!!.isMyLocationEnabled = true
        }
        mMap!!.setOnMarkerClickListener { marker ->
            if (marker.snippet != null) {
                Common.currentResults = currentPlaces!!.results!!.get(marker.snippet.toInt())
                startActivity(Intent(this@SearchNearPlace, ViewPlace::class.java))
            }
            true
        }
    }

    companion object {
        private const val MY_PERMISSION_CODE = 1000
    }
}*/
