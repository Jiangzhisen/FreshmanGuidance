package com.example.freshmanguidance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val academic=findViewById<ImageView>(R.id.academic)
        val food=findViewById<ImageView>(R.id.food)
        val entertainment=findViewById<ImageView>(R.id.entertainment)
        val transportation=findViewById<ImageView>(R.id.transportation)
        val rotateBtn=findViewById<Button>(R.id.rotateBtn)

        rotateBtn.setOnClickListener {
            val anim=RotateAnimation(
                0f,
                360f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration=4000
            anim.repeatCount=100
            academic.startAnimation(anim)
            food.startAnimation(anim)
            entertainment.startAnimation(anim)
            transportation.startAnimation(anim)
        }

        findViewById<Button>(R.id.back).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.academicBtn).setOnClickListener {
            val intent= Intent(this,academic_page::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.foodBtn).setOnClickListener {
            val intent= Intent(this,food_page1::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.entertainmentBtn).setOnClickListener {
            val intent= Intent(this,entertainment_page::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.transportationBtn).setOnClickListener {
            val intent= Intent(this,transportation_page::class.java)
            startActivityForResult(intent,1)
        }
    }
}