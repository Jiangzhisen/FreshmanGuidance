package com.example.freshmanguidance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class transportation_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transportation_page)

        findViewById<Button>(R.id.back).setOnClickListener {
            val intent= Intent(this,menu::class.java)
            startActivityForResult(intent,1)
        }

    }
}