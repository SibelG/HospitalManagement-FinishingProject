package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001FB\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u00020$H\u0004J\b\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010\'\u001a\u00020(H\u0002J \u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010\'\u001a\u00020(H\u0002J\u0014\u0010-\u001a\u00020$2\n\b\u0001\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020$2\b\b\u0001\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\bH\u0016J\u0012\u00105\u001a\u00020$2\b\u00106\u001a\u0004\u0018\u00010/H\u0014J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\u001cH\u0016J+\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020(0@2\u0006\u0010A\u001a\u00020BH\u0016\u00a2\u0006\u0002\u0010CJ\u000e\u0010D\u001a\u00020$2\u0006\u00108\u001a\u000209J\b\u0010E\u001a\u00020$H\u0004R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006G"}, d2 = {"Lcom/example/hbyssystemmanagement/View/SearchNearPlace;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;", "Lcom/google/android/gms/location/LocationListener;", "()V", "PROXIMITY_RADIUS", "", "btnHospitalFind", "Landroid/widget/Button;", "btnPharmacyFind", "currentPlace", "Lcom/example/hbyssystemmanagement/Model/NearByApiResponse;", "getCurrentPlace$app_debug", "()Lcom/example/hbyssystemmanagement/Model/NearByApiResponse;", "setCurrentPlace$app_debug", "(Lcom/example/hbyssystemmanagement/Model/NearByApiResponse;)V", "isGooglePlayServicesAvailable", "", "()Z", "location", "Landroid/location/Location;", "mGoogleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "mLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "mService", "Lcom/example/hbyssystemmanagement/Interface/NearByApi;", "getMService", "()Lcom/example/hbyssystemmanagement/Interface/NearByApi;", "setMService", "(Lcom/example/hbyssystemmanagement/Interface/NearByApi;)V", "buildGoogleApiClient", "", "checkLocationPermission", "findPlaces", "placeType", "", "getUrl", "latitude", "", "longitude", "onConnected", "bundle", "Landroid/os/Bundle;", "onConnectionFailed", "connectionResult", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionSuspended", "i", "onCreate", "savedInstanceState", "onHospitalsFindClick", "view", "Landroid/view/View;", "onLocationChanged", "onMapReady", "googleMap", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestorentFindClick", "startLocationUpdates", "Companion", "app_debug"})
public final class SearchNearPlace extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.OnMapReadyCallback, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {
    private com.google.android.gms.maps.GoogleMap mMap;
    private com.google.android.gms.common.api.GoogleApiClient mGoogleApiClient;
    private android.widget.Button btnPharmacyFind;
    private android.widget.Button btnHospitalFind;
    private com.google.android.gms.location.LocationRequest mLocationRequest;
    private android.location.Location location;
    private int PROXIMITY_RADIUS = 8000;
    public com.example.hbyssystemmanagement.Interface.NearByApi mService;
    @org.jetbrains.annotations.Nullable()
    private com.example.hbyssystemmanagement.Model.NearByApiResponse currentPlace;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.hbyssystemmanagement.View.SearchNearPlace.Companion Companion = null;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private java.util.HashMap _$_findViewCache;
    
    public SearchNearPlace() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hbyssystemmanagement.Interface.NearByApi getMService() {
        return null;
    }
    
    public final void setMService(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Interface.NearByApi p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.NearByApiResponse getCurrentPlace$app_debug() {
        return null;
    }
    
    public final void setCurrentPlace$app_debug(@org.jetbrains.annotations.Nullable()
    com.example.hbyssystemmanagement.Model.NearByApiResponse p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean isGooglePlayServicesAvailable() {
        return false;
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @kotlin.jvm.Synchronized()
    protected final synchronized void buildGoogleApiClient() {
    }
    
    public final void onRestorentFindClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onHospitalsFindClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void findPlaces(java.lang.String placeType) {
    }
    
    private final java.lang.String getUrl(double latitude, double longitude, java.lang.String placeType) {
        return null;
    }
    
    private final boolean checkLocationPermission() {
        return false;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    public void onConnected(@org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.os.Bundle bundle) {
    }
    
    @java.lang.Override()
    public void onConnectionSuspended(int i) {
    }
    
    @java.lang.Override()
    public void onConnectionFailed(@org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    com.google.android.gms.common.ConnectionResult connectionResult) {
    }
    
    protected final void startLocationUpdates() {
    }
    
    @java.lang.Override()
    public void onLocationChanged(@org.jetbrains.annotations.NotNull()
    android.location.Location location) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/hbyssystemmanagement/View/SearchNearPlace$Companion;", "", "()V", "MY_PERMISSIONS_REQUEST_LOCATION", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}