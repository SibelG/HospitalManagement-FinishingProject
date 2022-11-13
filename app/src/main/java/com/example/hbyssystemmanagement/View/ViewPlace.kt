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
import com.example.hbyssystemmanagement.Model.PlaceDetail
import com.example.hbyssystemmanagement.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ViewPlace : AppCompatActivity() {
    internal lateinit var mService:NearByApi
    var mPlace: PlaceDetail?=null
    lateinit var placeName:TextView
    lateinit var placeAdress:TextView
    lateinit var openNow:TextView
    lateinit var btnShowMap: Button
    lateinit var btnDirection: Button
    lateinit var photo:ImageView
    lateinit var rating_bar:RatingBar
    lateinit var phone:TextView
    lateinit var businessStatus:TextView
    lateinit var website:TextView

    private val PLACE_PICKER_REQUEST = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_place)

        placeName=findViewById(R.id.placeName)
        placeAdress=findViewById(R.id.placeAddress)
        openNow=findViewById(R.id.openNow)
        btnShowMap=findViewById(R.id.showOnMap)
        btnDirection=findViewById(R.id.buttonDirection)
        photo=findViewById(R.id.photo)
        rating_bar=findViewById(R.id.ratingBar2)
        phone=findViewById(R.id.Telephone)
        openNow=findViewById(R.id.openNow)
        businessStatus=findViewById(R.id.BusinessStatus)
        website=findViewById(R.id.Website)
        mService = Common.getGoogleAPIService()!!



        placeAdress.text=""
        placeName.text=""
        phone.text=""
        businessStatus.text=""
        website.text=""



        btnShowMap.setOnClickListener(View.OnClickListener {
            var intent= Intent(Intent.ACTION_VIEW, Uri.parse(mPlace!!.result!!.url))
            startActivity(intent)
        })
        /*if(Common.currentResults!!.photos != null&& Common.currentResults!!.photos!!.size> 0){
            Picasso.with(this).load(getPhotoOfPlaces(Common.currentResults!!.photos!![0].photo_reference!!,400))
                .into(photo)
        }else    {
            photo.setVisibility(View.GONE);
        }*/
        if (Common.currentResults!!.photos != null && Common.currentResults!!.photos!!.size > 0) {
            Picasso.with(this)
                .load(
                    getPhotoOfPlaces(
                        Common.currentResults!!.photos!!.get(0).photo_reference, 400
                    )
                )
                .placeholder(R.drawable.ic_image_black_24dp)
                .error(R.drawable.ic_error_black_24dp)
                .into(photo)
        }
        /*if (Common.currentResults!!.rating != null&&!TextUtils.isEmpty(Common.currentResults!!.rating))  {
            rating_bar.setRating((Common.currentResults!!.rating)!!.toFloat());
        }
        else    {
            rating_bar.setVisibility(View.GONE);
        }


        */
        if (Common.currentResults!!.opening_hours != null)  {
            if(Common.currentResults!!.opening_hours!!.open_now=="true")
                openNow.setText("Open Now : "+ "Open")
            else
                openNow.setText("Open Now : "+ "Close")

        }
        else    {
            openNow.setVisibility(View.GONE);
        }
        /*if (Common.currentResults!!.website!= null)  {
            website.setText("Website : "+ Common. currentResults!!.website!!);
        }
        else    {
            website.setVisibility(View.GONE);
        }*/
        btnDirection.setOnClickListener(View.OnClickListener {
            var intent= Intent(this@ViewPlace, Direction::class.java)
            startActivity(intent)
        })
        mService.getDetailPlace(getPlaceDetailUrl(Common.currentResults!!.place_id!!)!!)
            .enqueue(object: Callback<PlaceDetail> {



                override fun onResponse(call: Call<PlaceDetail>, response: Response<PlaceDetail>)
                {
                    mPlace = response.body()
                    placeAdress.setText("Address: "+mPlace!!.result!!.formatted_address);
                    placeName.setText(mPlace!!.result!!.name);
                    phone.setText("Phone: "+mPlace!!.result.formatted_phone_number)
                    businessStatus.setText("Business Status: "+mPlace!!.result.business_status)
                    //"
                    // Common.currentResults!!.website= mPlace!!.result.website!!
                    website.setText("Website:"+ mPlace!!.result.website)
                    rating_bar.rating= mPlace!!.result.rating!!.toFloat()
                    //openNow.setText("OpenNow:"+ mPlace!!.result.opening_hours!!.open_now)




                }

                override fun onFailure(call: Call<PlaceDetail>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            });


    }


    private fun getPlaceDetailUrl(place_id: String): String? {
        val url = StringBuilder("https://maps.googleapis.com/maps/api/place/details/json")
        url.append("?place_id=$place_id")
        url.append("&key=" + resources.getString(R.string.browser_key))
        return url.toString()
    }

    private fun getPhotoOfPlaces(photo_reference: String, maxWidth: Int): String? {
        val url = StringBuilder("https://maps.googleapis.com/maps/api/place/photo")
        url.append("?maxwidth=$maxWidth")
        url.append("&photo_reference=$photo_reference")
        url.append("&key=" + resources.getString(R.string.browser_key))
        return url.toString()
    }
}