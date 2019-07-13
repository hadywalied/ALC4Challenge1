package com.test.challenge1

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val image: ImageView = findViewById(R.id.mypic)
        Glide.with(this@Main3Activity).load(R.drawable.mypic).into(image)

    }
}
