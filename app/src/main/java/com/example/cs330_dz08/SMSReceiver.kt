package com.example.cs330_dz08

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Looper
import android.provider.Telephony
import android.widget.Toast


class SMSReceiver()
    : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {


        for (smsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
            val messageBody = smsMessage.messageBody
            Toast.makeText(context, messageBody.toString(), Toast.LENGTH_SHORT).show()

        }

        }


    fun runOnMainThread(runnable: Runnable){
        val uiHandler:android.os.Handler = android.os.Handler(Looper.getMainLooper())
        uiHandler.post(runnable)
    }




}