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

class entertainment_page_store2 : AppCompatActivity() , OnMapReadyCallback {
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
        setContentView(R.layout.activity_entertainment_page_store2)
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
            marker.position(LatLng(24.95739080520847, 121.2407827283575))
            marker.title("中原大學")
            marker.draggable(true)
            map.addMarker(marker)
            marker.position(LatLng(24.956252741317822, 121.24106167809124))
            marker.title("桌弄")
            marker.draggable(true)
            map.addMarker(marker)

            val polylineOpt = PolylineOptions()
            polylineOpt.add(LatLng(24.957242468420194, 121.24046354551149))
            polylineOpt.add(LatLng(24.956778002889987, 121.24071567314257))
            polylineOpt.add(LatLng(24.956426964341752, 121.240937041481))
            polylineOpt.color(Color.BLUE)
            val polyline = map.addPolyline(polylineOpt)
            polyline.width = 10f
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(24.956252741317822, 121.24106167809124), 19f))
        }
    }
    private fun loadMap(){
        val map=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        map.getMapAsync(this)
    }
}