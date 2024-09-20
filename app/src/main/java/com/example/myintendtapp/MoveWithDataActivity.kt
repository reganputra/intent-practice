package com.example.myintendtapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// Latihan Mengirim Data pada Intent
class MoveWithDataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_AGE = "extra_age" // static variable
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

       val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(EXTRA_NAME) // mengambil data dari main activity
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Nama $name, umur $age"
        tvDataReceived.text = text
    }
}