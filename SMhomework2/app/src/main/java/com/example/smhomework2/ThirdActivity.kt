package com.example.smhomework2


import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    private lateinit var emailTextView: TextView
    private lateinit var passwordTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        emailTextView = findViewById(R.id.emailTextView)
        passwordTextView = findViewById(R.id.passwordTextView)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        emailTextView.text = "Email: $email"
        passwordTextView.text = "Password: $password"
    }
}
