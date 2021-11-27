package com.example.gb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.gb.net.ApiRet
import com.example.gb.net.MyRetrofit
import retrofit2.Call
import retrofit2.Response
import java.util.regex.Pattern

class SignInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.emails);
        password = findViewById(R.id.pass2)
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
        if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
            if (EmailValid((email.text.toString()))) {
                val log = MyRetrofit().getRetrofit()
                val getApi = log.create(ApiRet::class.java)
                val hashMap: HashMap<String,String> = HashMap<String,String>()
                hashMap.put("email",email.text.toString())
                hashMap.put("password", password.text.toString())
                val log_call: retrofit2.Call<login> = getApi.getAuth(hashMap)
                log_call.enqueue(object : retrofit2.Callback<login>{
                    override fun onResponse(call: Call<login>, response: Response<login>) {
                        if (response.isSuccessful){
                            val intent = Intent(this@SignInActivity, MenuActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this@SignInActivity, "Неверный пароль", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<login>, t: Throwable) {
                        Toast.makeText(this@SignInActivity, t.message, Toast.LENGTH_LONG).show()
                    }
                })
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
}