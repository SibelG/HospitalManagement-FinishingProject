package com.example.hbyssystemmanagement.Interface;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H\'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/hbyssystemmanagement/Interface/NearByApi;", "", "getDetailPlace", "Lretrofit2/Call;", "Lcom/example/hbyssystemmanagement/Model/PlaceDetail;", "url", "", "getDirections", "origin", "destination", "getNearbyPlaces", "Lcom/example/hbyssystemmanagement/Model/NearByApiResponse;", "app_debug"})
public abstract interface NearByApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET()
    public abstract retrofit2.Call<com.example.hbyssystemmanagement.Model.NearByApiResponse> getNearbyPlaces(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Url()
    java.lang.String url);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET()
    public abstract retrofit2.Call<com.example.hbyssystemmanagement.Model.PlaceDetail> getDetailPlace(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Url()
    java.lang.String url);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "maps/api/directions/json")
    public abstract retrofit2.Call<java.lang.String> getDirections(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "origin")
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "destination")
    java.lang.String destination);
}