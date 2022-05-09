package com.example.cs330_dz08

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager

object SMSUtil {

    fun sendSMS(phoneNumber: String, message: String, context:Context) {
        SmsManager.getDefault().sendTextMessage(phoneNumber, null, message, null,null);
    }
}