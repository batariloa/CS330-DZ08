package com.example.cs330_dz08

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestSmsPermission()

        val smsBtn = findViewById<ImageButton>(R.id.btn_sms)
        val emailBtn = findViewById<ImageButton>(R.id.btn_email)

        smsBtn.setOnClickListener{
            openDefaultSMS()
        }

        emailBtn.setOnClickListener{
            openEmail()
        }

    }
    private fun requestSmsPermission() {
        val permission = Manifest.permission.RECEIVE_SMS
        val grant = ContextCompat.checkSelfPermission(this, permission)
        if (grant != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), 101)
        }
    }

    private fun openDefaultSMS(){

        val text = findViewById<TextView>(R.id.editTextTextPersonName).text.toString()
        val uri = Uri.parse("smsto:91192231")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", text)
        startActivity(intent)
    }
    private fun openEmail(){
        val i = Intent(Intent.ACTION_SENDTO)
        i.data = Uri.parse("mailto:support@mailname.com")
        i.putExtra(Intent.EXTRA_SUBJECT, "Feedback/Support")
        startActivity(Intent.createChooser(i, "Send feedback"))
    }

}