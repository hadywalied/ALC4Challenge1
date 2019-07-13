package com.test.challenge1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val about = findViewById<Button>(R.id.About)
        val profile = findViewById<Button>(R.id.Profile)

        about.setOnClickListener(){
            startActivity(Intent(this@MainActivity,Main2Activity::class.java))
        }
        profile.setOnClickListener(){
            startActivity(Intent(this@MainActivity,Main3Activity::class.java))
        }

    }
}
