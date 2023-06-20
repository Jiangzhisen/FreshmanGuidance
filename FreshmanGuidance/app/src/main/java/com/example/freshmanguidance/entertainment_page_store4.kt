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

class entertainment_page_store4 : AppCompatActivity() , OnMapReadyCallback {
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
        setContentView(R.layout.activity_entertainment_page_store4)
        loadMap()

        findViewById<Button>(R.id.back).setOnClickListener {
            val intent= Intent(this,entertainment_page::class.java)
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
            marker.position(LatLng(24.957383982698964, 121.24076878824091))
            marker.title("中原大學")
            marker.draggable(true)
            map.addMarker(marker)
            marker.position(LatLng(24.95568315459252, 121.24040029218456))
            marker.title("瘋時尚TV")
            marker.draggable(true)
            map.addMarker(marker)

            val polylineOpt = PolylineOptions()
            polylineOpt.add(LatLng(24.957114587877175, 121.24041705307657))
            polylineOpt.add(LatLng(24.9563429599132, 121.24102932657279))
            polylineOpt.add(LatLng(24.956080328485747, 121.2412331744447))
            polylineOpt.color(Color.BLUE)
            val polyline = map.addPolyline(polylineOpt)
            polyline.width = 10f
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(24.95568315459252, 121.24040029218456), 19f))
        }
    }
    private fun loadMap(){
        val map=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        map.getMapAsync(this)
    }
}
