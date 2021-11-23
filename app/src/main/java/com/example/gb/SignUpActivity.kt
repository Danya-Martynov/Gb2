package com.example.gb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        email = findViewById(R.id.email);
        password = findViewById(R.id.password)
        name = findViewById(R.id.name)
    }

    val paternt =("[a-z0-9]{1,256}" +
            "\\@" +
            "[a-z]{1,10}" +
            "\\." +
            "[a-z]{1,3}")
    fun EmailValid (email:String):Boolean {
        return Pattern.compile(paternt).matcher(email).matches()
    }

    fun main(view: View) {
        if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() && name.text.toString().isNotEmpty()) {
            if (EmailValid((email.text.toString()))) {
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
            }
        }
        else{
            Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
        }
    }

    fun enter(view: View) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}