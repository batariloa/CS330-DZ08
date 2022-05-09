package com.example.cs330_dz08

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Log.d("What the", "what the flip")
        val smsBtn = findViewById<ImageButton>(R.id.btn_sms)
        val emailBtn = findViewById<ImageButton>(R.id.btn_email)
        val msg = findViewById<TextView>(R.id.msg)
        requestSmsPermission()
        smsBtn.setOnClickListener{
            SMSUtil.sendSMS("","",this)

        }




    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val intent = getIntent()
        if (intent.getStringExtra("SMSBODY") != null) {
            val msg = intent.getStringExtra("SMSBODY")
//append msg to scroll view
        }
    }

    private fun requestSmsPermission() {
        val permission = Manifest.permission.RECEIVE_SMS
        val grant = ContextCompat.checkSelfPermission(this, permission)
        if (grant != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), 101)
        }
    }


}