package com.example.myapplication

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animate_button1 = findViewById<Button>(R.id.button1)
        val animate_button2 = findViewById<Button>(R.id.button2)
        val textView = findViewById<TextView>(R.id.textView)

        var pop = AnimatorSet()
        animate_button1.setOnClickListener {
            pop = popAnim(100, animate_button1,pop)
        }

        animate_button2.setOnClickListener {
            pop = popAnim(100, animate_button2,pop)
        }
    }

    fun popAnim(pause_duration: Long, view:View, pop: AnimatorSet) : AnimatorSet{
        pop.end()
        val popOutX = setAnim(view,"scaleX", 1f,1.1f, 400)
        popOutX.interpolator = OvershootInterpolator()
        val popOutY = setAnim(view,"scaleY", 1f,1.1f, 400)
        popOutY.interpolator = OvershootInterpolator()
        val popOutAlpha = setAnim(view,"Alpha", 0.7f,1f, 50)

        val popOffX = setAnim(view,"scaleX", 1.1f,1f, 200)
        popOffX.interpolator = AccelerateInterpolator()
        val popOffY = setAnim(view,"scaleY", 1.1f,1f, 200)
        popOffY.interpolator = AccelerateInterpolator()
        val popOffAlpha = setAnim(view,"Alpha", 1f,0.7f, 250)

        val pop = AnimatorSet()
        pop.play(popOutX).with(popOutY).with(popOutAlpha).after(100.toLong())
        pop.play(popOutX).after(100.toLong())


        pop.play(popOffX).with(popOffY).with(popOffAlpha).after(pause_duration)
        pop.play(popOffX).after(pause_duration)

        pop.play(popOutX).before(popOffX)
        pop.start()

        return pop
    }

    fun setAnim(view: View, propName:String, valueFrom:Float, valueTo:Float,duration:Long) : ObjectAnimator {
        val animator = ObjectAnimator.ofFloat(view, propName, valueFrom, valueTo)
        animator.duration = duration
        return animator
    }
}