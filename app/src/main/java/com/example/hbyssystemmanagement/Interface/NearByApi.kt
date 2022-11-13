package com.example.hbyssystemmanagement.Interface


import com.example.hbyssystemmanagement.Model.NearByApiResponse
import com.example.hbyssystemmanagement.Model.PlaceDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NearByApi {
    @GET()
    fun getNearbyPlaces(@Url url:String): Call<NearByApiResponse>

    @GET()
    fun getDetailPlace(@Url url:String):Call<PlaceDetail>



    @GET("maps/api/directions/json")
    fun getDirections(
        @Query("origin") origin: String?,
        @Query("destination") destination: String?
    ): Call<String>


}
