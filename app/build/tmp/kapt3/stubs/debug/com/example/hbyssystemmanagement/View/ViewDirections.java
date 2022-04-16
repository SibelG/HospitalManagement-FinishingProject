package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001.B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020\u001fH\u0002J\u0012\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u0019H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006/"}, d2 = {"Lcom/example/hbyssystemmanagement/View/ViewDirections;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "mCurrentMarker", "Lcom/google/android/gms/maps/model/Marker;", "mLastLocation", "Landroid/location/Location;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "mService", "Lcom/example/hbyssystemmanagement/Interface/NearByApi;", "polyLine", "Lcom/google/android/gms/maps/model/Polyline;", "getPolyLine", "()Lcom/google/android/gms/maps/model/Polyline;", "setPolyLine", "(Lcom/google/android/gms/maps/model/Polyline;)V", "buildLocationCallback", "", "checkLocationPermission", "", "createLocationRequest", "decodePolyline", "", "Lcom/google/android/gms/maps/model/LatLng;", "encoded", "", "drawPath", "location", "Lcom/example/hbyssystemmanagement/Model/Location;", "getDirectionURL", "origin", "dest", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "googleMap", "onStop", "GetDirection", "app_debug"})
public final class ViewDirections extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.OnMapReadyCallback {
    private com.google.android.gms.maps.GoogleMap mMap;
    private com.google.android.gms.location.LocationCallback locationCallback;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private com.google.android.gms.location.LocationRequest locationRequest;
    private com.example.hbyssystemmanagement.Interface.NearByApi mService;
    private android.location.Location mLastLocation;
    private com.google.android.gms.maps.model.Marker mCurrentMarker;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.model.Polyline polyLine;
    private java.util.HashMap _$_findViewCache;
    
    public ViewDirections() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.maps.model.Polyline getPolyLine() {
        return null;
    }
    
    public final void setPolyLine(@org.jetbrains.annotations.Nullable()
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
    
    private final void createLocationRequest() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void buildLocationCallback() {
    }
    
    private final void drawPath(android.location.Location mLastLocation, com.example.hbyssystemmanagement.Model.Location location) {
    }
    
    private final java.lang.String getDirectionURL(com.google.android.gms.maps.model.LatLng origin, com.google.android.gms.maps.model.LatLng dest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.google.android.gms.maps.model.LatLng> decodePolyline(@org.jetbrains.annotations.NotNull()
    java.lang.String encoded) {
        return null;
    }
    
    private final boolean checkLocationPermission() {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J1\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\f\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/example/hbyssystemmanagement/View/ViewDirections$GetDirection;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/google/android/gms/maps/model/LatLng;", "url", "", "(Lcom/example/hbyssystemmanagement/View/ViewDirections;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/util/List;", "onPostExecute", "", "result", "app_debug"})
    final class GetDirection extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<? extends java.util.List<? extends com.google.android.gms.maps.model.LatLng>>> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String url = null;
        
        public GetDirection(@org.jetbrains.annotations.NotNull()
        java.lang.String url) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.util.List<java.util.List<com.google.android.gms.maps.model.LatLng>> doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... params) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.NotNull()
        java.util.List<? extends java.util.List<com.google.android.gms.maps.model.LatLng>> result) {
        }
    }
}