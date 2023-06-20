package com.example.freshmanguidance

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class food_page_store1 : AppCompatActivity(), OnMapReadyCallback {
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray) {
        if (grantResults.isNotEmpty()&&requestCode==0){
            for (result in grantResults)
                if (result !=PackageManager.PERMISSION_GRANTED)
                    finish()
            loadMap()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_page_store1)
        loadMap()

        findViewById<Button>(R.id.back).setOnClickListener {
            val intent= Intent(this,food_page1::class.java)
            startActivityForResult(intent,1)
        }

    }

    override fun onMapReady(map: GoogleMap){
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) !=PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                    ) !=PackageManager.PERMISSION_GRANTED
            ){
                ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                0)
        }else {
            map.isMyLocationEnabled = true
            val marker = MarkerOptions()
            marker.position(LatLng(24.95747290696817, 121.24074654207732))
            marker.title("中原大學")
            marker.draggable(true)
            map.addMarker(marker)
            marker.position(LatLng(24.955763103197235, 121.24023137824489))
            marker.title("開運屋地瓜球QQ蛋")
            marker.draggable(true)
            map.addMarker(marker)

            val polylineOpt = PolylineOptions()
            polylineOpt.add(LatLng(24.956843138619192, 121.24069305312382))
            polylineOpt.add(LatLng(24.95613063086614, 121.24125899920581))
            polylineOpt.add(LatLng(24.955731819267186, 121.24075742613688))
            polylineOpt.color(Color.BLUE)
            val polyline = map.addPolyline(polylineOpt)
            polyline.width = 10f
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    LatLng(24.955763103197235, 121.24023137824489), 19f))
            }
        }
    

    private fun loadMap(){
        val map=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        map.getMapAsync(this)
    }
}