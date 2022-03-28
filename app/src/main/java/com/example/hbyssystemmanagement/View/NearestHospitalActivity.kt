package com.example.hbyssystemmanagement.View

import android.Manifest.permission
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.hbyssystemmanagement.Model.HospitalCoordinat
import com.example.hbyssystemmanagement.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.firebase.database.*

class NearestHospitalActivity : AppCompatActivity(), OnMapReadyCallback,
    LocationListener,GoogleMap.OnMarkerClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    var currentLatitude = 0.0
    val ROUND = 10
    val RequestPermissionCode = 1
    var currentLongitude = 0.0
    val bus: Button? = null
    var police:Button? = null
    var hospital:Button? = null
    var petrolpump:Button? = null
    var mMap: GoogleMap? = null
    var googleApiClient: GoogleApiClient? = null
    val mChildEventListener: ChildEventListener? = null
    var mUsers: DatabaseReference? = null
    val marker: Marker? = null
    var yourMarker:Marker?=null
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private lateinit var lastLocation: Location


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_nearest_hospital2)


        //calling google api's client to establish location connections
        googleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build()

        //fusedLocationProviderClient provides the current location coordinates

        //fusedLocationProviderClient provides the current location coordinates
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "MyNotification",
                "MyNotification",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        var mChildEventListener: ChildEventListener
        mUsers = FirebaseDatabase.getInstance().getReference("coordinates")
        mUsers!!.push().setValue(marker)
    }




    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermission()
            return
        }

        mMap!!.isMyLocationEnabled = true
        mMap!!.mapType = GoogleMap.MAP_TYPE_NORMAL

        fusedLocationProviderClient!!.lastLocation.addOnSuccessListener(this) { location ->
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                val markerOptions = MarkerOptions().position(currentLatLng)
                markerOptions.title("You")
                mMap!!.addMarker(markerOptions)
                mMap!!.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }
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
        googleMap.setOnMarkerClickListener(this)
        mMap!!.uiSettings.isZoomControlsEnabled = true

        setUpMap()
        //setting the size of marker in map by using Bitmap Class

        //setting the size of marker in map by using Bitmap Class
        val height = 80
        val width = 80
        val bitmapdraw = resources.getDrawable(R.drawable.emergence) as BitmapDrawable
        val b = bitmapdraw.bitmap
        val smallMarker = Bitmap.createScaledBitmap(b, width, height, false)
        mUsers!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (s in dataSnapshot.children) {
                    val hospitalPosition= s.getValue(HospitalCoordinat::class.java)
                    val location = LatLng(hospitalPosition!!.lat!!.toDouble(), hospitalPosition.lot!!.toDouble())
                    mMap!!.addMarker(MarkerOptions().position(location))!!
                        .setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker))
                    mMap!!.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 13f))
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

    }
    override fun onLocationChanged(location: Location) {
        currentLatitude = location.latitude //getting current latitude
        currentLongitude = location.longitude //getting current longitude
    }

    fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

    fun onProviderEnabled(provider: String?) {}

    fun onProviderDisabled(provider: String?) {}



    override fun onStart() {
        super.onStart()
        googleApiClient!!.connect() //establishment of google api client connection
    }

    override fun onStop() {
        if (googleApiClient!!.isConnected) {
            googleApiClient!!.disconnect() //discarding the google api client service if the activity is in onStop condition
        }
        super.onStop()
    }

    override fun onMarkerClick(p0: Marker): Boolean {
        return false
    }
    private fun requestPermission() {

        ActivityCompat.requestPermissions(
            this@NearestHospitalActivity,
            arrayOf(permission.ACCESS_FINE_LOCATION),
            RequestPermissionCode
        )
    }

    override fun onConnected(p0: Bundle?) {
        if (ActivityCompat.checkSelfPermission(
                this,
                permission.ACCESS_FINE_LOCATION
            ) !== PackageManager.PERMISSION_GRANTED
        ) {
            requestPermission()
        }/*else{

            fusedLocationProviderClient!!.getLastLocation()                             //Through this we are fetching the last location of user recorded
                    .addOnSuccessListener(this, object: OnSuccessListener<Location> {
                        override fun onSuccess(p0: Location?) {
                            if (p0 != null) {
                                val yourLocation=LatLng(p0.lastLocation.latitude,p0.lastLocation.longitude)
                                if(yourMarker==null){
                                    val height=80
                                    val width=80
                                    val bitmapDrawable=
                                        ContextCompat.getDrawable(this@NearestHospitalActivity,R.drawable.emergence)
                                    val btm= bitmapDrawable!!.toBitmap()
                                    val smallMarker= Bitmap.createScaledBitmap(btm,width,height,false)
                                    yourMarker= mMap!!.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
                                        .position(yourLocation)
                                        .title("You"))!!
                                }else{
                                    yourMarker!!.position=yourLocation
                                    mMap!!.animateCamera(CameraUpdateFactory.newLatLngZoom(yourLocation,15f))

                                }

                            }
                            }
                        })
                 }*/
        }



    override fun onConnectionSuspended(i: Int) {}
    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }


}