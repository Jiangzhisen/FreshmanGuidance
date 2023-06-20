package com.example.freshmanguidance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class entertainment_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entertainment_page)

        findViewById<Button>(R.id.back).setOnClickListener {
            val intent= Intent(this,menu::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.store1Btn).setOnClickListener {
            val intent= Intent(this,entertainment_page_store1::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.store2Btn).setOnClickListener {
            val intent= Intent(this,entertainment_page_store2::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.store3Btn).setOnClickListener {
            val intent= Intent(this,entertainment_page_store3::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.store4Btn).setOnClickListener {
            val intent= Intent(this,entertainment_page_store4::class.java)
            startActivityForResult(intent,1)
        }

    }
}