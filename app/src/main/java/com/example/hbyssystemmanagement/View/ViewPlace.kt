package com.example.hbyssystemmanagement.View

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.Interface.NearByApi
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ViewPlace : AppCompatActivity() {
    internal lateinit var mService:NearByApi
    var mPlace:MySelectedPlace?=null
    lateinit var placeName:TextView
    lateinit var placeAdress:TextView
    lateinit var openNow:TextView
    lateinit var btnShowMap: Button
    lateinit var btnDirection: Button
    lateinit var photo:ImageView
    lateinit var rating_bar:RatingBar
    private val PLACE_PICKER_REQUEST = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.hbyssystemmanagement.R.layout.activity_view_place)

        placeName=findViewById(com.example.hbyssystemmanagement.R.id.placeName)
        placeAdress=findViewById(com.example.hbyssystemmanagement.R.id.placeAddress)
        openNow=findViewById(com.example.hbyssystemmanagement.R.id.openNow)
        btnShowMap=findViewById(com.example.hbyssystemmanagement.R.id.showOnMap)
        btnDirection=findViewById(com.example.hbyssystemmanagement.R.id.buttonDirection)
        photo=findViewById(com.example.hbyssystemmanagement.R.id.photo)

        openNow.text=""
        placeAdress.text=""
        placeName.text=""

        btnShowMap.setOnClickListener(View.OnClickListener {
            var intent= Intent(Intent.ACTION_VIEW, Uri.parse(mPlace!!.result!!.url))
            startActivity(intent)
        })
        if(Common.currentResult!!.photos!=null && Common.currentResult!!.photos!!.size>0){
            Picasso.with(this).load(getPhotoOfPlace(Common.currentResult!!.photos!![0].photoReference!!))
                .into(photo)
        }
        if(Common.currentResult!!.rating!=null){
            rating_bar.rating= Common.currentResult!!.rating!!.toFloat()

        }
        else{
            rating_bar.setVisibility(View.GONE);
        }

        if (Common.currentResult!!.openingHours!= null)  {
            openNow.setText("Open Now : "+ Common.currentResult!!.openingHours);
        }
        else    {
            openNow.setVisibility(View.GONE);
        }
        btnDirection.setOnClickListener(View.OnClickListener {
            var intent= Intent(this@ViewPlace, ViewDirections::class.java)
            startActivity(intent)
        })
        mService.getDetailPlace(getPlaceDetailUrl(Common.currentResult!!.placeId!!)!!)
            .enqueue(object: Callback<MySelectedPlace> {


                override fun onResponse(call: Call<MySelectedPlace>, response: Response<MySelectedPlace>) {
                    mPlace = response!!.body();

                    placeAdress.setText(mPlace!!.result!!.formatted_address);
                    placeName.setText(mPlace!!.result!!.name);
                }

                override fun onFailure(call: Call<MySelectedPlace>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            });
    }


    private fun getPlaceDetailUrl(place_id: String): String? {
        val url = java.lang.StringBuilder("https://maps.googleapis.com/maps/api/place/details/json")
        url.append("?placeid=$place_id")
        url.append("&key=" + com.example.hbyssystemmanagement.R.string.browser_key)
        return url.toString()
    }

    private fun getPhotoOfPlace(place_id:String):String{
        val url=StringBuilder("https://maps.googleapis.com/maps/api/place/photo/json")
        url.append("?placeid=$place_id")
        url.append("key=AIzaSyA_9QOjL7fkLpF4mDnRjkv0LNz9dqO4x-A")
        return url.toString()
    }
}