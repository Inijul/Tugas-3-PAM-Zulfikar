package com.example.tugas3kalkulator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
    }

    fun onDigit(view: View) {
        val button = view as Button
        editText.append(button.text)
    }

    fun onClear(view: View) {
        editText.setText("")
        operand1 = 0.0
        operand2 = 0.0
        pendingOperation = "="
    }

    fun onOperator(view: View) {
        val button = view as Button
        val op = button.text.toString()
        val value = editText.text.toString()
        if (value.isNotEmpty()) {
            operand1 = value.toDouble()
        }
        pendingOperation = op
        editText.setText("")
    }

    fun onEqual(view: View) {
        val value = editText.text.toString()
        if (value.isNotEmpty()) {
            operand2 = value.toDouble()
        }

        when (pendingOperation) {
            "+" -> operand1 += operand2
            "-" -> operand1 -= operand2
            "*" -> operand1 *= operand2
            "/" -> if (operand2 != 0.0) operand1 /= operand2 else operand1 = Double.NaN
        }

        editText.setText(operand1.toString())
        pendingOperation = "="
    }
}