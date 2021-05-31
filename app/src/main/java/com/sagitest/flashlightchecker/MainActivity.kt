package com.sagitest.flashlightchecker

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

//for reference, check: https://www.youtube.com/watch?v=hX3ZYm3aZgE
//Camera permission is not needed for flash light

class MainActivity : AppCompatActivity() {
    private lateinit var cameraM :CameraManager
    private var isFlash = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun onOff(view: View) {
        if(!isFlash) {
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId, true)
            isFlash = true
            btn_power.setImageResource(R.drawable.ic_power_on)
            Toast.makeText(this@MainActivity, "Flash Light is On", Toast.LENGTH_SHORT).show()
        }else {
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId, false)
            isFlash = false
            btn_power.setImageResource(R.drawable.ic_power_off)
            Toast.makeText(this@MainActivity, "Flash Light is Off", Toast.LENGTH_SHORT).show()
        }
    }
}