package com.example.androidmaster.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.R

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        initComponents()
        initUI()
    }


    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
    }
    private fun initUI() {

    }

}