package com.example.hbyssystemmanagement.Helper

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.net.Uri
import android.os.Build
import com.example.hbyssystemmanagement.R


class NotificationHelper(base: Context?) : ContextWrapper(base) {
    var manager: NotificationManager? = null
    private fun createChannel() {
        val channel =
            NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
        channel.enableLights(false)
        channel.enableVibration(true)
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        if (manager == null) {
            manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        }
        manager!!.createNotificationChannel(channel)
    }

    fun getBuilder(
        title: String?,
        body: String?,
        contentIntent: PendingIntent?,
        soundUri: Uri?
    ): Notification.Builder {
        return Notification.Builder(applicationContext, CHANNEL_ID)
            .setContentIntent(contentIntent)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setSound(soundUri)
            .setAutoCancel(false)
    }

    fun getBuilderApp(title: String?, body: String?, soundUri: Uri?): Notification.Builder {
        return Notification.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setSound(soundUri)
            .setAutoCancel(false)
    }

    companion object {
        private const val CHANNEL_ID = "com.example.hbyssystemmanagement.Appointment"
        private const val CHANNEL_NAME = "AppointmentApp"
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel()
        }
    }
}