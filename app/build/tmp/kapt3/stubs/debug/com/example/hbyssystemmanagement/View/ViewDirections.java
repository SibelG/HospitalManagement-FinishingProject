package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001<B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0003J\u001a\u00103\u001a\u0002012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u00104\u001a\u000205H\u0002J\u0012\u00106\u001a\u0002012\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020#H\u0016J\b\u0010;\u001a\u000201H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u0006="}, d2 = {"Lcom/example/hbyssystemmanagement/View/ViewDirections;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "fusedLocationProviderClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationProviderClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationProviderClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "getLocationCallback", "()Lcom/google/android/gms/location/LocationCallback;", "setLocationCallback", "(Lcom/google/android/gms/location/LocationCallback;)V", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "getLocationRequest", "()Lcom/google/android/gms/location/LocationRequest;", "setLocationRequest", "(Lcom/google/android/gms/location/LocationRequest;)V", "mCurrentMarker", "Lcom/google/android/gms/maps/model/Marker;", "getMCurrentMarker", "()Lcom/google/android/gms/maps/model/Marker;", "setMCurrentMarker", "(Lcom/google/android/gms/maps/model/Marker;)V", "mLastLocation", "Landroid/location/Location;", "getMLastLocation", "()Landroid/location/Location;", "setMLastLocation", "(Landroid/location/Location;)V", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "mService", "Lcom/example/hbyssystemmanagement/Interface/NearByApi;", "getMService", "()Lcom/example/hbyssystemmanagement/Interface/NearByApi;", "setMService", "(Lcom/example/hbyssystemmanagement/Interface/NearByApi;)V", "polyline", "Lcom/google/android/gms/maps/model/Polyline;", "getPolyline", "()Lcom/google/android/gms/maps/model/Polyline;", "setPolyline", "(Lcom/google/android/gms/maps/model/Polyline;)V", "buildLocationCallback", "", "buildLocationRequest", "drawPath", "location", "Lcom/example/hbyssystemmanagement/Model/Location;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "googleMap", "onStop", "ParserTask", "app_debug"})
public final class ViewDirections extends androidx.fragment.app.FragmentActivity implements com.google.android.gms.maps.OnMapReadyCallback {
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
    @org.jetbrains.annotations.Nullable()
    private com.example.hbyssystemmanagement.Interface.NearByApi mService;
    private java.util.HashMap _$_findViewCache;
    
    public ViewDirections() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Interface.NearByApi getMService() {
        return null;
    }
    
    public final void setMService(@org.jetbrains.annotations.Nullable()
    com.example.hbyssystemmanagement.Interface.NearByApi p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void buildLocationCallback() {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    private final void buildLocationRequest() {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    private final void drawPath(android.location.Location mLastLocation, com.example.hbyssystemmanagement.Model.Location location) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002B\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012.\u0012,\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00060\u0004\u0018\u00010\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0007JO\u0010\u000e\u001a,\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00060\u0004\u0018\u00010\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0010\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u0011J:\u0010\u0012\u001a\u00020\u001320\u0010\u0014\u001a,\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00060\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/example/hbyssystemmanagement/View/ViewDirections$ParserTask;", "Landroid/os/AsyncTask;", "", "", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Lcom/example/hbyssystemmanagement/View/ViewDirections;)V", "waitingDialog", "Landroid/app/AlertDialog;", "getWaitingDialog", "()Landroid/app/AlertDialog;", "setWaitingDialog", "(Landroid/app/AlertDialog;)V", "doInBackground", "params", "", "([Ljava/lang/String;)Ljava/util/List;", "onPostExecute", "", "lists", "onPreExecute", "app_debug"})
    final class ParserTask extends android.os.AsyncTask<java.lang.String, java.lang.Integer, java.util.List<? extends java.util.List<? extends java.util.HashMap<java.lang.String, java.lang.String>>>> {
        @org.jetbrains.annotations.NotNull()
        private android.app.AlertDialog waitingDialog;
        
        public ParserTask() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.app.AlertDialog getWaitingDialog() {
            return null;
        }
        
        public final void setWaitingDialog(@org.jetbrains.annotations.NotNull()
        android.app.AlertDialog p0) {
        }
        
        @java.lang.Override()
        protected void onPreExecute() {
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.util.List<java.util.List<java.util.HashMap<java.lang.String, java.lang.String>>> doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.String... params) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.Nullable()
        java.util.List<? extends java.util.List<? extends java.util.HashMap<java.lang.String, java.lang.String>>> lists) {
        }
    }
}