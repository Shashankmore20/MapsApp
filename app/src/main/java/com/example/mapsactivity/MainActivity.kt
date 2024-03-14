package com.example.mapsactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.mapsactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val originEditText = findViewById<EditText>(R.id.origin)
        val destinationEditText = findViewById<EditText>(R.id.destination)
        val mapButton = findViewById<Button>(R.id.mapButton)

        mapButton.setOnClickListener {
            val origin = originEditText.text.toString()
            val destination = destinationEditText.text.toString()
            openGoogleMaps(origin, destination)
        }
    }

    private fun openGoogleMaps(origin: String, destination: String) {
//        val gmmIntentUri = Uri.parse("google.navigation:q=$destination&mode=d&origin=$origin")
        val uri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=$origin&destination=$destination")

        val mapIntent = Intent(Intent.ACTION_VIEW, uri)
        mapIntent.setPackage("com.google.android.apps.maps")

        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {
            Log.d("error","Unexpected Error Occurred")
        }
    }
}