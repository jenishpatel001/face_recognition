package com.androchef.cameraxfacedetection

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.androchef.cameraxfacedetection.camerax.CameraManager
import com.androchef.cameraxfacedetection.face_detection.FaceStatus
import kotlinx.android.synthetic.main.activity_main.graphicOverlay_finder
import kotlinx.android.synthetic.main.activity_main.previewView_finder

class Splash_activity : AppCompatActivity() {


    private lateinit var cameraManager: CameraManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({ move() }, 3000)
    }

    fun move() {
        val intent = Intent(this, Signup_Activity::class.java)
        startActivity(intent)
        finish()
    }
}
