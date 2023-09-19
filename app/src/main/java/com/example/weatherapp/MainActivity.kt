package com.example.weatherapp

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val error = findViewById<TextView>(R.id.error)
        error.text = ""
    }

    fun getCity(view: View?) {
        val cityText = findViewById<EditText>(R.id.city)
        val city = cityText.text.toString().toLowerCase()
        val address = "$city,lk"

        if(city.isNotBlank()){
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("city_name", address)
            }

            startActivity(intent)
        }else{
            val error = findViewById<TextView>(R.id.error)
            error.text = "Please enter a city to get weather"
        }

    }
}
