package com.example.gb

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gb.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navView.setupWithNavController(navController)
    }

    fun press(view: android.view.View) {
        Toast.makeText(this@MenuActivity, "Мясо", Toast.LENGTH_SHORT).show()
    }

    fun exit(view: android.view.View) {
        val intent = Intent(this@MenuActivity, SignUpActivity::class.java)
        startActivity(intent)
    }
}