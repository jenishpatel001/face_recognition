package com.androchef.cameraxfacedetection

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Signup_Activity : AppCompatActivity() {


    private lateinit var ed1: EditText
    private lateinit var ed2: EditText
    private lateinit var ed3: EditText
    private lateinit var ed4: EditText
    private lateinit var ed5: EditText
    private lateinit var ed6: EditText
    private lateinit var signupbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)
        ed3 = findViewById(R.id.ed3)
        ed4 = findViewById(R.id.ed4)
        ed5 = findViewById(R.id.ed5)
        ed6 = findViewById(R.id.ed6)

        signupbutton = findViewById(R.id.signupbutton)

        signupbutton.setOnClickListener {
            val name: String
            val lastname: String
            val emailid: String
            val contact: String
            val password: String
            val retypepassword: String

            name = ed1.text.toString()
            lastname = ed2.text.toString()
            emailid = ed3.text.toString()
            contact = ed4.text.toString()
            password = ed5.text.toString()
            retypepassword = ed6.text.toString()

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(lastname)) {
                Toast.makeText(this, "Enter lastname", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(emailid)) {
                Toast.makeText(this, "Enter emailid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(contact)) {
                Toast.makeText(this, "Enter contact number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(retypepassword)) {
                Toast.makeText(this, "Enter retypepassword", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun submit(view: View) {
        val intent = Intent(this, Login_Activity::class.java)
        startActivity(intent)
    }

    fun reset(view: View) {
        ed1.setText("")
        ed2.setText("")
        ed3.setText("")
        ed4.setText("")
        ed5.setText("")
        ed6.setText("")
    }
}