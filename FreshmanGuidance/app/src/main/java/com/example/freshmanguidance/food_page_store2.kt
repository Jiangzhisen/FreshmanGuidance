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

class food_page_store2 : AppCompatActivity(), OnMapReadyCallback {

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
        setContentView(R.layout.activity_food_page_store2)
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
            marker.position(LatLng(24.957339431062266, 121.24073305264405))
            marker.title("中原大學")
            marker.draggable(true)
            map.addMarker(marker)
            marker.position(LatLng(24.955644446835567, 121.24070573548211))
            marker.title("御冠園鮮肉湯包")
            marker.draggable(true)
            map.addMarker(marker)

            val polylineOpt = PolylineOptions()
            polylineOpt.add(LatLng(24.956817258581495, 121.24071383511797))
            polylineOpt.add(LatLng(24.95607921704514, 121.2412382069525))
            polylineOpt.add(LatLng(24.955913856219976, 121.24101290140985))
            polylineOpt.color(Color.BLUE)
            val polyline = map.addPolyline(polylineOpt)
            polyline.width = 10f
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                LatLng(24.955650615930804, 121.24071048236209), 19f))
        }
    }

    private fun loadMap(){
        val map=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        map.getMapAsync(this)
    }

}