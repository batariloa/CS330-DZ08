package com.example.cs330_dz08

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
const val SMS_BUNDLE: String = "pdus"
class SMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val body: StringBuilder = StringBuilder()
        var number = ""
        val bundle: Bundle? = intent.extras
        val messages: Array<SmsMessage?>
        if (bundle != null) {
            println("BLOP BLOP")
            val msgObjects: Array<*>? = bundle.get(SMS_BUNDLE) as Array<*>?
            messages = arrayOfNulls(msgObjects!!.size)
            for (i in messages.indices) {
                messages[i] = SmsMessage.createFromPdu(msgObjects[i] as ByteArray?)
                body.append(messages[i]!!.messageBody)
                number = messages[i]!!.originatingAddress.toString()
            }
        }

    }
}