package com.example.hbyssystemmanagement.Service


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class FirebaseMessagingService : FirebaseMessagingService() {
    private var user = FirebaseAuth.getInstance().currentUser
    private lateinit var title:String;
    private lateinit var message:String;

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        remoteMessage.data.isNotEmpty().let {
            val title = remoteMessage.data["title"].toString()
            val text = remoteMessage.data["text"].toString()
            sendNotification(title, text)
        }
       /* title = remoteMessage.getData().get("Title").toString()
        message = remoteMessage.getData().get("Message").toString()
        val builder =NotificationCompat.Builder(applicationContext)
            .setSmallIcon(android.R.drawable.stat_sys_download)
            .setContentTitle(title)
            .setContentText(message)
        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())

        val TAG = "FirebaseMessagingService"


            Log.d(TAG, "Dikirim dari: ${remoteMessage.from}")

            if (remoteMessage.notification != null) {
                showNotification(remoteMessage.notification?.title, remoteMessage.notification?.body)
            }*/


    }
    // Check if message contains a data payload.


    // Check if message contains a notification payload.
    /* remoteMessage.notification?.let {
         val title = remoteMessage.notification?.title
         val text = remoteMessage.notification?.body
         sendNotification(title, text)
     }*/


//포그라운드 푸쉬알람을 만들어주는 메서드
private fun sendNotification(title: String?, text: String?) {
    val intent = Intent(this, HomeActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    }
    val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
    val channelId= "channel"
    val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    val notificationBuilder = NotificationCompat.Builder(this, channelId)
        .setSmallIcon(R.drawable.notify_icon)
        .setContentTitle(title)
        .setContentText(text)
        .setAutoCancel(true)
        .setSound(defaultSoundUri)
        .setPriority(Notification.PRIORITY_HIGH)
        .setContentIntent(pendingIntent)

    val notificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Since android Oreo notification channel is needed.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(channelId,
            "Channel human readable title",
            NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(channel)
    }

    notificationManager.notify(0 , notificationBuilder.build())
}
}