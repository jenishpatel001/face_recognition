package com.androchef.cameraxfacedetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Login_Activity : AppCompatActivity() {

    private lateinit var ed1: EditText
    private lateinit var ed2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)
    }

    fun login(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun reset(view: View) {
        ed1.text.clear()
        ed2.text.clear()
    }
}
