package com.example.hbyssystemmanagement.Remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null
    var BaseUrl = "https://fcm.googleapis.com/"
    var GoogleBaseUrl = "https://maps.googleapis.com/"


    val getRetrofit: Retrofit
        get(){
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(
                    GsonConverterFactory
                        .create()).build()


            }
            return retrofit!!
        }



    val googleRetrofit: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(GoogleBaseUrl).addConverterFactory(
                    GsonConverterFactory
                        .create()
                )
                    .client(OkHttpClient())
                    .build()

            }
            return retrofit
        }
}
