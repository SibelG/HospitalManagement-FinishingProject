package com.example.hbyssystemmanagement.View;

import java.lang.System;

/**
 * Simple Maps class to instantiate a map with two points, draw a route between both by querying Google Maps
 * API, and center it in the screen. You can read more about it on
 * Medium: https://medium.com/@irenenaya/drawing-path-between-two-points-in-google-maps-with-kotlin-in-android-app-af2f08992877
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,H\u0002J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u00020#H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u00068"}, d2 = {"Lcom/example/hbyssystemmanagement/View/Direction;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "fusedLocationProviderClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationProviderClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationProviderClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "getLocationCallback", "()Lcom/google/android/gms/location/LocationCallback;", "setLocationCallback", "(Lcom/google/android/gms/location/LocationCallback;)V", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "getLocationRequest", "()Lcom/google/android/gms/location/LocationRequest;", "setLocationRequest", "(Lcom/google/android/gms/location/LocationRequest;)V", "mCurrentMarker", "Lcom/google/android/gms/maps/model/Marker;", "getMCurrentMarker", "()Lcom/google/android/gms/maps/model/Marker;", "setMCurrentMarker", "(Lcom/google/android/gms/maps/model/Marker;)V", "mLastLocation", "Landroid/location/Location;", "getMLastLocation", "()Landroid/location/Location;", "setMLastLocation", "(Landroid/location/Location;)V", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "polyline", "Lcom/google/android/gms/maps/model/Polyline;", "getPolyline", "()Lcom/google/android/gms/maps/model/Polyline;", "setPolyline", "(Lcom/google/android/gms/maps/model/Polyline;)V", "decodePoly", "", "Lcom/google/android/gms/maps/model/LatLng;", "encoded", "", "getURL", "from", "to", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "googleMap", "app_debug"})
public final class Direction extends androidx.fragment.app.FragmentActivity implements com.google.android.gms.maps.OnMapReadyCallback {
    private com.google.android.gms.maps.GoogleMap mMap;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.location.LocationCallback locationCallback;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.location.LocationRequest locationRequest;
    @org.jetbrains.annotations.Nullable()
    private android.location.Location mLastLocation;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.model.Marker mCurrentMarker;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.model.Polyline polyline;
    private java.util.HashMap _$_findViewCache;
    
    public Direction() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.location.FusedLocationProviderClient getFusedLocationProviderClient() {
        return null;
    }
    
    public final void setFusedLocationProviderClient(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.location.FusedLocationProviderClient p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.location.LocationCallback getLocationCallback() {
        return null;
    }
    
    public final void setLocationCallback(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.location.LocationCallback p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.location.LocationRequest getLocationRequest() {
        return null;
    }
    
    public final void setLocationRequest(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.location.LocationRequest p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.location.Location getMLastLocation() {
        return null;
    }
    
    public final void setMLastLocation(@org.jetbrains.annotations.Nullable()
    android.location.Location p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.maps.model.Marker getMCurrentMarker() {
        return null;
    }
    
    public final void setMCurrentMarker(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.Marker p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.maps.model.Polyline getPolyline() {
        return null;
    }
    
    public final void setPolyline(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.Polyline p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final java.lang.String getURL(com.google.android.gms.maps.model.LatLng from, com.google.android.gms.maps.model.LatLng to) {
        return null;
    }
    
    /**
     * Method to decode polyline points
     * Courtesy : https://jeffreysambells.com/2010/05/27/decoding-polylines-from-google-maps-direction-api-with-java
     */
    private final java.util.List<com.google.android.gms.maps.model.LatLng> decodePoly(java.lang.String encoded) {
        return null;
    }
}