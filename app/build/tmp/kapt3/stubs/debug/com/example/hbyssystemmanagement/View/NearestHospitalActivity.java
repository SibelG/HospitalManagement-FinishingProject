package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0010\u0010O\u001a\u00020L2\u0006\u0010M\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020L2\u0006\u0010R\u001a\u00020\tH\u0016J\u0012\u0010S\u001a\u00020L2\b\u0010T\u001a\u0004\u0018\u00010NH\u0014J\u0010\u0010U\u001a\u00020L2\u0006\u0010V\u001a\u00020,H\u0016J\u0010\u0010W\u001a\u00020L2\u0006\u0010X\u001a\u000202H\u0016J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010M\u001a\u00020>H\u0016J\u0010\u0010[\u001a\u00020L2\b\u0010\\\u001a\u0004\u0018\u00010]J\u0010\u0010^\u001a\u00020L2\b\u0010\\\u001a\u0004\u0018\u00010]J\b\u0010_\u001a\u00020LH\u0014J\"\u0010`\u001a\u00020L2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010a\u001a\u00020\t2\b\u0010b\u001a\u0004\u0018\u00010NJ\b\u0010c\u001a\u00020LH\u0014J\b\u0010d\u001a\u00020LH\u0002J\b\u0010e\u001a\u00020LH\u0002R\u0014\u0010\b\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\'\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u0013\u0010-\u001a\u0004\u0018\u00010.\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010>\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010*R\u001c\u0010D\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010*R\u001c\u0010G\u001a\u0004\u0018\u00010>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010@\"\u0004\bI\u0010J\u00a8\u0006f"}, d2 = {"Lcom/example/hbyssystemmanagement/View/NearestHospitalActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/location/LocationListener;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;", "()V", "ROUND", "", "getROUND", "()I", "RequestPermissionCode", "getRequestPermissionCode", "bus", "Landroid/widget/Button;", "getBus", "()Landroid/widget/Button;", "currentLatitude", "", "getCurrentLatitude", "()D", "setCurrentLatitude", "(D)V", "currentLongitude", "getCurrentLongitude", "setCurrentLongitude", "fusedLocationProviderClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationProviderClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationProviderClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "getGoogleApiClient", "()Lcom/google/android/gms/common/api/GoogleApiClient;", "setGoogleApiClient", "(Lcom/google/android/gms/common/api/GoogleApiClient;)V", "hospital", "getHospital", "setHospital", "(Landroid/widget/Button;)V", "lastLocation", "Landroid/location/Location;", "mChildEventListener", "Lcom/google/firebase/database/ChildEventListener;", "getMChildEventListener", "()Lcom/google/firebase/database/ChildEventListener;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "getMMap", "()Lcom/google/android/gms/maps/GoogleMap;", "setMMap", "(Lcom/google/android/gms/maps/GoogleMap;)V", "mUsers", "Lcom/google/firebase/database/DatabaseReference;", "getMUsers", "()Lcom/google/firebase/database/DatabaseReference;", "setMUsers", "(Lcom/google/firebase/database/DatabaseReference;)V", "marker", "Lcom/google/android/gms/maps/model/Marker;", "getMarker", "()Lcom/google/android/gms/maps/model/Marker;", "petrolpump", "getPetrolpump", "setPetrolpump", "police", "getPolice", "setPolice", "yourMarker", "getYourMarker", "setYourMarker", "(Lcom/google/android/gms/maps/model/Marker;)V", "onConnected", "", "p0", "Landroid/os/Bundle;", "onConnectionFailed", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionSuspended", "i", "onCreate", "savedInstanceState", "onLocationChanged", "location", "onMapReady", "googleMap", "onMarkerClick", "", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStart", "onStatusChanged", "status", "extras", "onStop", "requestPermission", "setUpMap", "app_debug"})
public final class NearestHospitalActivity extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.OnMapReadyCallback, com.google.android.gms.location.LocationListener, com.google.android.gms.maps.GoogleMap.OnMarkerClickListener, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener {
    private double currentLatitude = 0.0;
    private final int ROUND = 10;
    private final int RequestPermissionCode = 1;
    private double currentLongitude = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final android.widget.Button bus = null;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button police;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button hospital;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button petrolpump;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.GoogleMap mMap;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.common.api.GoogleApiClient googleApiClient;
    @org.jetbrains.annotations.Nullable()
    private final com.google.firebase.database.ChildEventListener mChildEventListener = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.DatabaseReference mUsers;
    @org.jetbrains.annotations.Nullable()
    private final com.google.android.gms.maps.model.Marker marker = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.model.Marker yourMarker;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient;
    private android.location.Location lastLocation;
    private java.util.HashMap _$_findViewCache;
    
    public NearestHospitalActivity() {
        super();
    }
    
    public final double getCurrentLatitude() {
        return 0.0;
    }
    
    public final void setCurrentLatitude(double p0) {
    }
    
    public final int getROUND() {
        return 0;
    }
    
    public final int getRequestPermissionCode() {
        return 0;
    }
    
    public final double getCurrentLongitude() {
        return 0.0;
    }
    
    public final void setCurrentLongitude(double p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getBus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getPolice() {
        return null;
    }
    
    public final void setPolice(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getHospital() {
        return null;
    }
    
    public final void setHospital(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getPetrolpump() {
        return null;
    }
    
    public final void setPetrolpump(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.maps.GoogleMap getMMap() {
        return null;
    }
    
    public final void setMMap(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.GoogleMap p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.common.api.GoogleApiClient getGoogleApiClient() {
        return null;
    }
    
    public final void setGoogleApiClient(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.common.api.GoogleApiClient p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.database.ChildEventListener getMChildEventListener() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.database.DatabaseReference getMUsers() {
        return null;
    }
    
    public final void setMUsers(@org.jetbrains.annotations.Nullable()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.maps.model.Marker getMarker() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.maps.model.Marker getYourMarker() {
        return null;
    }
    
    public final void setYourMarker(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.Marker p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.location.FusedLocationProviderClient getFusedLocationProviderClient() {
        return null;
    }
    
    public final void setFusedLocationProviderClient(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.location.FusedLocationProviderClient p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setUpMap() {
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
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @java.lang.Override()
    public void onLocationChanged(@org.jetbrains.annotations.NotNull()
    android.location.Location location) {
    }
    
    public final void onStatusChanged(@org.jetbrains.annotations.Nullable()
    java.lang.String provider, int status, @org.jetbrains.annotations.Nullable()
    android.os.Bundle extras) {
    }
    
    public final void onProviderEnabled(@org.jetbrains.annotations.Nullable()
    java.lang.String provider) {
    }
    
    public final void onProviderDisabled(@org.jetbrains.annotations.Nullable()
    java.lang.String provider) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    public boolean onMarkerClick(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker p0) {
        return false;
    }
    
    private final void requestPermission() {
    }
    
    @java.lang.Override()
    public void onConnected(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    @java.lang.Override()
    public void onConnectionSuspended(int i) {
    }
    
    @java.lang.Override()
    public void onConnectionFailed(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.ConnectionResult p0) {
    }
}