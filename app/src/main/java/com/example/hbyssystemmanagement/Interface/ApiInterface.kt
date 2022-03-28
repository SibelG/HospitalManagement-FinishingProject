package com.example.hbyssystemmanagement.Interface

import android.database.Observable
import com.example.hbyssystemmanagement.Model.DataMessage
import com.example.hbyssystemmanagement.Model.MyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.*


interface ApiInterface {
    @Headers(
        "Content-Type:application/json",
        "Authorization:key=AAAAnbpawK8:APA91bGGrGC7S4Sdd-O3_VtJXU354j8cjYzGiB8Ni7ktWBzX4a8bj3rcrmK6zExJtnpdTtIykZGB4m3H-9eNFPpIpvv_twL6FEF7zIHmpRxHfR54JrqKldnIs2fs40YKpAINbiaiLXy9"
    )
    @POST("fcm/send")
    open fun sendNotification(@Body body: DataMessage?): Call<MyResponse?>?

}