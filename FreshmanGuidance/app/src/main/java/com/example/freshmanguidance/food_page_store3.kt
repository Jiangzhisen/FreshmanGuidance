package com.example.freshmanguidance

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
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class food_page_store3 : AppCompatActivity() , OnMapReadyCallback {
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray) {
        if (grantResults.isNotEmpty()&&requestCode==0){
            for (result in grantResults)
                if (result != PackageManager.PERMISSION_GRANTED)
                    finish()
            loadMap()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_page_store3)
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
            marker.position(LatLng(24.95734025420992, 121.24072699367791))
            marker.title("中原大學")
            marker.draggable(true)
            map.addMarker(marker)
            marker.position(LatLng(24.955596234190338, 121.24076429248328))
            marker.title("包好甲葱燒包")
            marker.draggable(true)
            map.addMarker(marker)

            val polylineOpt = PolylineOptions()
            polylineOpt.add(LatLng(24.956839230378666, 121.24070191478563))
            polylineOpt.add(LatLng(24.956075655343447, 121.24123835655801))
            polylineOpt.add(LatLng(24.95585436359566, 121.24092185590642))
            polylineOpt.color(Color.BLUE)
            val polyline = map.addPolyline(polylineOpt)
            polyline.width = 10f
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(24.955596234190338, 121.24076429248328), 19f))
        }
    }
    private fun loadMap(){
        val map=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        map.getMapAsync(this)
    }

}