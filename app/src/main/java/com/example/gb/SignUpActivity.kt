package com.example.gb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var name: EditText
    lateinit var pattern: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        email = findViewById(R.id.email);
        password = findViewById(R.id.password)
        name = findViewById(R.id.name)

    }

    val paternt = (
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,50}" +
            "\\@" +
            "[a-z][a-z\\-]{0,8}" +
            "(" +
            "\\." +
            "[a-z][a-z\\-]{0,6}" +
            ")+"
        );
    fun EmailValid (email:String):Boolean {
        return Pattern.compile(paternt).matcher(email).matches()
    }

    fun main(view: View) {
        if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() && name.text.toString().isNotEmpty()) {
            if (EmailValid((email.text.toString()))) {
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
            }
            else{
                val alert2 = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Неверный Email")
                    .setPositiveButton("Ок",null)
                    .create()
                    .show()
            }
        }
        else{
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("Ок",null)
                .create()
                .show()
        }
    }

    fun enter(view: View) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}