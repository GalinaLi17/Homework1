package com.example.smhomework2

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        submitButton = findViewById(R.id.goToThirdScreenButton)

        submitButton.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkFields()
            }

            override fun afterTextChanged(s: Editable?) { }
        }


        emailEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)

        submitButton.setOnClickListener() {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }


    private fun checkFields() {
        val emailInput = emailEditText.text.toString()
        val passwordInput = passwordEditText.text.toString()

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()
        val isPasswordValid = isPasswordValid(passwordInput)

        submitButton.isEnabled = isEmailValid && isPasswordValid
    }


    private fun isPasswordValid(password: String): Boolean {
        if (password.length < 8) return false
        if (!password.any { it.isDigit() }) return false
        if (!password.any { it.isLowerCase() }) return false
        if (!password.any { it.isUpperCase() }) return false
        return true
    }
}
