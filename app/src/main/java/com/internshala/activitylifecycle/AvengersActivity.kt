package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AvengersActivity : AppCompatActivity() {

    var  titleName : String? = "Avengers"
    lateinit var sharedPrefernces: SharedPreferences
    lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefernces = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_avengers)

        titleName = sharedPrefernces.getString("Title","The Avengers") as String

        btnLogout = findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener {
            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            sharedPrefernces.edit().clear().apply()
            finish()
        }

        title = titleName
    }


}