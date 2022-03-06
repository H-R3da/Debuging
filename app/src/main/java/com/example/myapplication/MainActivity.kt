package com.example.myapplication

import android.animation.AnimatorSet
import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Image_Button1 : ImageButton = findViewById<ImageButton>(R.id.dizzy)
        var Image_Button2 : ImageButton = findViewById<ImageButton>(R.id.dizzy2)
        var color: Int = Color.parseColor("white")

        Image_Button1.setColorFilter(color)

    }


}