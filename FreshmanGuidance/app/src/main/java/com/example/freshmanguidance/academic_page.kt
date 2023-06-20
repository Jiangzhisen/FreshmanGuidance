package com.example.freshmanguidance

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class academic_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_academic_page)

        findViewById<Button>(R.id.back).setOnClickListener {
            val intent= Intent(this,menu::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.resource1Btn).setOnClickListener {
            val url = "https://i-learning.cycu.edu.tw/home.php"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        findViewById<Button>(R.id.resource2Btn).setOnClickListener {
            val url = "https://itouch.cycu.edu.tw/home/#/ann"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        findViewById<Button>(R.id.resource3Btn).setOnClickListener {
            val url = "https://cycucoursewiki.info/courses"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        findViewById<Button>(R.id.resource4Btn).setOnClickListener {
            val url = "https://myself.cycu.edu.tw/#/login"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        findViewById<Button>(R.id.resource5Btn).setOnClickListener {
            val url = "https://www.dcard.tw/f/cycu"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }


    }
}