package com.example.androidmaster.IMCCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.androidmaster.IMCCalculator.ImcCalculatorActivity.Companion.IMC_KEY
import com.example.androidmaster.R

class ResultIMCActivity : AppCompatActivity() {


    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents()

        initUI(result)

        setListeners()
    }

    private fun setListeners() {
        btnRecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {

        tvIMC.text = result.toString()

        when(result) {
            in 0.00..18.50 -> {
                tvResult.text = getString(R.string.title_bajoPeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))

                tvDescription.text = getString(R.string.description_bajoPeso)
            }
            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.title_pesoNormal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))

                tvDescription.text = getString(R.string.description_pesoNormal)
            }
            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))

                tvDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))

                tvDescription.text = getString(R.string.description_obesidad)
            }else -> {
                tvResult.text = getString(R.string.error)
                tvIMC.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
}