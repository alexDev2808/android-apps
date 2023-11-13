package com.example.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidmaster.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludarApp = findViewById<Button>(R.id.btnSaludarApp)
        btnSaludarApp.setOnClickListener { navigateToSaludarApp() }
    }

    private fun navigateToSaludarApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}