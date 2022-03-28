package com.example.hbyssystemmanagement.View

/*class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener, GeoQueryEventListener {
    private lateinit var auth : FirebaseAuth
    private var hospitalRef = FirebaseDatabase.getInstance().getReference("Hospital/Hospitals")

    private var map: GoogleMap?=null

    private  var lastLocation: Location?=null


    private  var geoQuery: GeoQuery?=null
    private lateinit var geoFire: GeoFire
    private lateinit var myLocationRef: DatabaseReference
    private var currentLoc:LatLng?=null
    private lateinit var locationCallback: LocationCallback
    private var fusedLocationClient: FusedLocationProviderClient?=null

    private lateinit var locationRequest: LocationRequest
    private var locationUpdateState = false
    private  var yourMarker: Marker?=null
    private var locationList:ArrayList<LatLng>?=null
    private var locList:ArrayList<LatLng>?=null
    private var originLatitude: Double = 28.5021359
    private var originLongitude: Double = 77.4054901
    private var destinationLatitude: Double = 28.5151087
    private var destinationLongitude: Double = 77.3932163

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
        private const val REQUEST_CHECK_SETTINGS = 2
        private const val PLACE_PICKER_REQUEST = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val ai: ApplicationInfo = applicationContext.packageManager
            .getApplicationInfo(applicationContext.packageName, PackageManager.GET_META_DATA)
        val value = ai.metaData["com.google.android.geo.API_KEY"]
        val apiKey = value.toString()
        // Initializing the Places API with the help of our API_KEY
        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, apiKey)
        }

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val gd = findViewById<Button>(R.id.directions)
        gd.setOnClickListener{
            mapFragment.getMapAsync {
                map = it
                val originLocation = LatLng(originLatitude, originLongitude)
                map!!.addMarker(MarkerOptions().position(originLocation))
                val destinationLocation = LatLng(destinationLatitude, destinationLongitude)
                map!!.addMarker(MarkerOptions().position(destinationLocation))
                val urll = getDirectionURL(originLocation, destinationLocation, apiKey)
                GetDirection(urll).execute()
                map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(originLocation, 14F))
            }
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.



        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this@MapsActivity)
        settingGeoFire()
        addDangerousToFirebase()


        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                super.onLocationResult(p0)

                lastLocation = p0.lastLocation
                val currentLatLng = LatLng(lastLocation!!.latitude, lastLocation!!.longitude)
                yourMarker= map!!.addMarker(MarkerOptions().title("You").position(currentLatLng))!!
                map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
                placeMarkerOnMap(LatLng(lastLocation!!.latitude, lastLocation!!.longitude))

            }


        }

        createLocationRequest()

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            loadPlacePicker()
        }
    }

    private fun addDangerousToFirebase() {
        locationList=ArrayList()
        locationList!!.add(LatLng(40.7608, 29.9264))
        locationList!!.add(LatLng(40.7601, 29.9343))
        locationList!!.add(LatLng(40.7568, 29.9441))
        locationList!!.add(LatLng(40.7641, 29.9656))
        locationList!!.add(LatLng(40.7701, 29.9611))
        hospitalRef.setValue(locationList)
            .addOnCompleteListener(object:OnCompleteListener<Void> {
                override fun onComplete(p0: Task<Void>) {
                    Toast.makeText(this@MapsActivity,"update",Toast.LENGTH_LONG).show()
                }

            }).addOnFailureListener(object:OnFailureListener{
                override fun onFailure(p0: Exception) {
                    Toast.makeText(this@MapsActivity,p0.localizedMessage,Toast.LENGTH_LONG).show()
                }

            })
    }

    private fun addAreaMarker() {
        if(geoQuery!=null){
            geoQuery!!.removeGeoQueryEventListener(this@MapsActivity)
            geoQuery!!.removeAllListeners()

        }
        val height = 80
        val width = 80
        val bitmapdraw = resources.getDrawable(R.drawable.emergence) as BitmapDrawable
        val b = bitmapdraw.bitmap
        val smallMarker = Bitmap.createScaledBitmap(b, width, height, false)
        for(i in locationList!!.indices){
            System.out.println(locationList!![i])

            map!!.addMarker(MarkerOptions().position(locationList!![i]).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)))
            map!!.animateCamera(CameraUpdateFactory.zoomTo(25.0f))
            map!!.moveCamera(CameraUpdateFactory.newLatLng(locationList!!.get(i)))


            geoQuery=geoFire.queryAtLocation(GeoLocation(locationList!![i].latitude,locationList!![i].longitude),0.5)
            geoQuery!!.addGeoQueryEventListener(this@MapsActivity)
        }



    }

    private fun settingGeoFire() {
        myLocationRef=FirebaseDatabase.getInstance().getReference("MyLocation")
        geoFire=GeoFire(myLocationRef)
    }

    /*private fun initArea() {


        hospitalRef!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (s in dataSnapshot.children) {
                    val hospitalPosition = s.getValue(HospitalCoordinat::class.java)
                    locationList!!.add(LatLng(hospitalPosition!!.lat,hospitalPosition.lot))
                }


            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }*/


    private fun addUserMarker() {
        geoFire.setLocation("You",
            GeoLocation(lastLocation!!.latitude, lastLocation!!.longitude)){ _, _->
            if(yourMarker!=null) yourMarker!!.remove()
            yourMarker= map!!.addMarker(MarkerOptions().position(LatLng(lastLocation!!.latitude, lastLocation!!.longitude)).title("You"))!!
            map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(yourMarker!!.position, 12.0f))
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CHECK_SETTINGS) {
            if (resultCode == Activity.RESULT_OK) {
                locationUpdateState = true
                startLocationUpdates()
            }
        }
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                val place = PlacePicker.getPlace(this, data)
                var addressText = place.name.toString()
                addressText += "\n" + place.address.toString()

                placeMarkerOnMap(place.latLng)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        fusedLocationClient!!.removeLocationUpdates(locationCallback)
    }

    public override fun onResume() {
        super.onResume()
        if (!locationUpdateState) {
            startLocationUpdates()
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
        map = googleMap

        map!!.uiSettings.isZoomControlsEnabled = true

        startLocationUpdates()
        addAreaMarker()
        setUpMap()
        //

        val originLocation = LatLng(originLatitude, originLongitude)
        map!!.clear()
        map!!.addMarker(MarkerOptions().position(originLocation))
        map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(originLocation, 18F))


    }




    private fun getDirectionURL(origin:LatLng, dest:LatLng, secret: String) : String{
        return "https://maps.googleapis.com/maps/api/directions/json?origin=${origin.latitude},${origin.longitude}" +
                "&destination=${dest.latitude},${dest.longitude}" +
                "&sensor=false" +
                "&mode=driving" +
                "&key=$secret"
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetDirection(val url : String) : AsyncTask<Void, Void, List<List<LatLng>>>(){
        override fun doInBackground(vararg params: Void?): List<List<LatLng>> {
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            val data = response.body!!.string()

            val result =  ArrayList<List<LatLng>>()
            try{
                val respObj = Gson().fromJson(data, MapData::class.java)
                val path =  ArrayList<LatLng>()
                for (i in 0 until respObj.routes[0].legs[0].steps.size){
                    path.addAll(decodePolyline(respObj.routes[0].legs[0].steps[i].polyline.points))
                }
                result.add(path)
            }catch (e:Exception){
                e.printStackTrace()
            }
            return result
        }

        override fun onPostExecute(result: List<List<LatLng>>) {
            val lineoption = PolylineOptions()
            for (i in result.indices){
                lineoption.addAll(result[i])
                lineoption.width(10f)
                lineoption.color(Color.RED)
                lineoption.geodesic(true)
            }
            map!!.addPolyline(lineoption)
        }
    }

    fun decodePolyline(encoded: String): List<LatLng> {
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
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat
            shift = 0
            result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng
            val latLng = LatLng((lat.toDouble() / 1E5),(lng.toDouble() / 1E5))
            poly.add(latLng)
        }
        return poly
    }


    override fun onMarkerClick(p0: Marker): Boolean = false

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }

        map!!.isMyLocationEnabled = true
        map!!.mapType = GoogleMap.MAP_TYPE_NORMAL

        fusedLocationClient!!.lastLocation.addOnSuccessListener(this) { location ->
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(currentLatLng)
                map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }
    }

    private fun placeMarkerOnMap(location: LatLng) {
        val markerOptions = MarkerOptions().position(location)

        val titleStr = getAddress(location)  // add these two lines
        markerOptions.title(titleStr)

        map!!.addMarker(markerOptions)
    }

    private fun getAddress(latLng: LatLng): String {
        // 1
        val geocoder = Geocoder(this)
        val addresses: List<Address>?
        val address: Address?
        var addressText = ""

        try {
            // 2
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
            // 3
            if (null != addresses && !addresses.isEmpty()) {
                address = addresses[0]
                for (i in 0 until address.maxAddressLineIndex) {
                    addressText += if (i == 0) address.getAddressLine(i) else "\n" + address.getAddressLine(i)
                }
            }
        } catch (e: IOException) {
            Log.e("MapsActivity", e.localizedMessage)
        }

        return addressText
    }

    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
        fusedLocationClient!!.requestLocationUpdates(locationRequest, locationCallback,
            Looper.myLooper()!! /* Looper */)
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000
        locationRequest.smallestDisplacement=10f
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)

        // 4
        val client = LocationServices.getSettingsClient(this)
        val task = client.checkLocationSettings(builder.build())

        // 5
        task.addOnSuccessListener {
            locationUpdateState = true
            startLocationUpdates()
        }
        task.addOnFailureListener { e ->
            // 6
            if (e is ResolvableApiException) {
                // Location settings are not satisfied, but this can be fixed
                // by showing the user a dialog.
                try {
                    // Show the dialog by calling startResolutionForResult(),
                    // and check the result in onActivityResult().
                    e.startResolutionForResult(this@MapsActivity,
                        REQUEST_CHECK_SETTINGS)
                } catch (sendEx: IntentSender.SendIntentException) {
                    // Ignore the error.
                }
            }
        }

    }

    private fun loadPlacePicker() {
        val builder = PlacePicker.IntentBuilder()

        try {
            startActivityForResult(builder.build(this@MapsActivity), PLACE_PICKER_REQUEST)
        } catch (e: GooglePlayServicesRepairableException) {
            e.printStackTrace()
        } catch (e: GooglePlayServicesNotAvailableException) {
            e.printStackTrace()
        }
    }



    override fun onKeyEntered(key: String?, location: GeoLocation?) {
        sendNotification("HBYS", String.format("%s hospital",key))
        Toast.makeText(this@MapsActivity,"basıldı",Toast.LENGTH_LONG).show()
    }

    private fun sendNotification(title: String, content: String) {
        val NOTIFICATION_CHANNEL_ID="Multiple location"
        val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "MyNotify",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationChannel.description = "Channel Description"
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = R.color.red
            notificationChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)
            notificationChannel.enableVibration(true)

            notificationManager.createNotificationChannel(notificationChannel)
        }

            val builder=NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID)
            builder.setContentTitle(title)
                .setContentText(content)
                .setAutoCancel(false)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher))
                val notification=builder.build()
                notificationManager.notify(Random.nextInt(),notification)




    }

    override fun onKeyExited(key: String?) {
        sendNotification("HBYS", String.format("%s hospital",key))
    }

    override fun onKeyMoved(key: String?, location: GeoLocation?) {
        sendNotification("HBYS", String.format("%s hospital moved",key))
    }

    override fun onGeoQueryReady() {

    }

    override fun onGeoQueryError(error: DatabaseError?) {
        Toast.makeText(this,""+ error!!.message,Toast.LENGTH_LONG).show()
    }


}*/



