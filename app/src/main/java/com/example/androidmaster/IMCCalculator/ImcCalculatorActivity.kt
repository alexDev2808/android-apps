package com.example.androidmaster.IMCCalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.androidmaster.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected : Boolean = true
    private var isFemaleSelected : Boolean = false

    private var verificadorMale = 0


    private lateinit var viewMale : CardView
    private lateinit var viewFemale : CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        initListeners()
        initUI()
    }


    private fun initComponents() {
        viewFemale = findViewById(R.id.viewFemale)
        viewMale = findViewById(R.id.viewMale)
    }
    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor() }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor() }
    }

    private fun changeGender() {

        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }
    private fun setGenderColor() {
        viewMale.setBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent : Boolean): Int {
        val colorReference = if ( isSelectedComponent ) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }


}