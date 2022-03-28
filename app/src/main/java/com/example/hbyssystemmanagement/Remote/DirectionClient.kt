package com.example.hbyssystemmanagement.Remote

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object DirectionClient {
    private var retrofit: Retrofit? = null
    var PLACE_API_BASE_URL = "https://maps.googleapis.com/maps/"

    fun getApiService(): Retrofit {

        if (retrofit == null) {

            retrofit =
                Retrofit.Builder().baseUrl(PLACE_API_BASE_URL).addConverterFactory(
                    ScalarsConverterFactory.create()
                ).build()



        }
        return retrofit!!

    }
}