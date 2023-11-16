package com.example.androidmaster.IMCCalculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 40
    private var currentAge: Int = 12
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var fabPlusWeight: FloatingActionButton
    private lateinit var fabSubstractionWeight: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var fabPlusAge: FloatingActionButton
    private lateinit var fabSubstractionAge: FloatingActionButton
    private lateinit var btnCalculate: Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }
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
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        fabPlusWeight = findViewById(R.id.fabPlusWeight)
        fabSubstractionWeight = findViewById(R.id.fabSubstractionWeight)
        tvAge = findViewById(R.id.tvAge)
        fabPlusAge = findViewById(R.id.fabPlusAge)
        fabSubstractionAge = findViewById(R.id.fabSubstractionAge)
        btnCalculate = findViewById(R.id.btnCalculate)

    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()

            tvHeight.text = "$currentHeight cm"
        }

        fabPlusWeight.setOnClickListener {
            currentWeight += 1
            setCurrentWeight()
        }

        fabSubstractionWeight.setOnClickListener {
            currentWeight -= 1
            setCurrentWeight()

        }

        fabPlusAge.setOnClickListener {
            currentAge += 1
            setCurrentAge()
        }

        fabSubstractionAge.setOnClickListener {
            currentAge -= 1
            setCurrentAge()

        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()

            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)

        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        return df.format(currentWeight / ( currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)).toDouble()

    }
    private fun setCurrentWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setCurrentAge() {
        tvAge.text = currentAge.toString()
    }

    private fun changeGender() {

        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }

    private fun setGenderColor() {
        viewMale.setBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setCurrentWeight()
        setCurrentAge()
    }


}