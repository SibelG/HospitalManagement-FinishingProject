package com.example.hbyssystemmanagement.Common


import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.text.format.DateFormat
import com.example.hbyssystemmanagement.Interface.NearByApi
import com.example.hbyssystemmanagement.Model.Results
import com.example.hbyssystemmanagement.Remote.DirectionClient
import com.example.hbyssystemmanagement.Remote.GoogleRetrofitClient
import com.example.hbyssystemmanagement.View.Model.Request
import com.example.hbyssystemmanagement.View.Model.User
import java.util.*

object Common{

    lateinit var CurrentUser: User
    lateinit var CurrentEmail: User
    lateinit var CurrentRequest: Request
    var currentResult:Results?=null
    public val callData:String?="CallDoctorMap"
    val UPDATE:String = "Update"
    val User_Key: String = "User"
    val doctorId: String = "doctorId"
    val Pwd_Key: String = "Password"
    val DELETE: String = "Delete"
    val TopicName: String = "News"
    val pickImage: Int = 71
    val baseUrl:String="https://fcm/send/googleapis.com/"

    val service: NearByApi
        get()= GoogleRetrofitClient.getApiService().create(NearByApi::class.java)
    val serviceScalars: NearByApi
        get()= DirectionClient.getApiService().create(NearByApi::class.java)




    fun scaledBitmap(bitmap: Bitmap, newWidth: Int, newHeight: Int): Bitmap? {
        val scaledBitmap = Bitmap.createBitmap(newWidth, newWidth, Bitmap.Config.ARGB_8888)
        val scaledX = newWidth / bitmap.width.toFloat()
        val scaledY = newHeight / bitmap.height.toFloat()
        val pivotX = 0f
        val pivotY = 0f
        val scaledMatrix = Matrix()
        scaledMatrix.setScale(scaledX, scaledY, pivotX, pivotY)
        val canvas = Canvas(scaledBitmap)
        canvas.setMatrix(scaledMatrix)
        canvas.drawBitmap(bitmap, 0f, 0f, Paint(Paint.FILTER_BITMAP_FLAG))
        return scaledBitmap
    }

    fun getDate(time: Long): String? {
        val calendar = Calendar.getInstance(Locale.ENGLISH)
        calendar.timeInMillis = time
        val date = StringBuilder(DateFormat.format("dd-MM-yyyy HH:mm", calendar).toString())
        return date.toString()
    }

    fun convertToStatus(status: String): String? {
        return if (status === "0") {
            "Active"

        } else "Pasive"
    }

    fun connectivityInternet(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (manager != null) {
            val info = manager.allNetworkInfo
            if (info != null) {
                for (i in info.indices) {
                    if (info[i].state == NetworkInfo.State.CONNECTED) return true
                }
            }
        }
        return false
    }

    fun getNewAppointTopic(): String {
        return StringBuilder("/topics/newAppointment").toString()

    }
}