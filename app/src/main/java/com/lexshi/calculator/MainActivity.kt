package com.lexshi.calculator


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lexshi.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var numberFromScreen: Double = 0.0
    private var firstNum: Double = 0.0
    private var operation: String? = null
    private var mathSign: Boolean = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttons()
    }

    private fun buttons() {
        //digits
        binding.tvOne.setOnClickListener {digitsClick(1)}
        binding.tvTwo.setOnClickListener {digitsClick(2)}
        binding.tvThree.setOnClickListener {digitsClick(3)}
        binding.tvFour.setOnClickListener {digitsClick(4)}
        binding.tvFive.setOnClickListener {digitsClick(5)}
        binding.tvSix.setOnClickListener {digitsClick(6)}
        binding.tvSeven.setOnClickListener {digitsClick(7)}
        binding.tvEight.setOnClickListener {digitsClick(8)}
        binding.tvEleven.setOnClickListener {digitsClick(9)}
        binding.tvZero.setOnClickListener {digitsClick(0)}

        //actions
        binding.tvPlus.setOnClickListener {operationsClick("+")}
        binding.tvMinus.setOnClickListener {operationsClick("-")}
        binding.tvDivide.setOnClickListener {operationsClick("/")}
        binding.tvMultiply.setOnClickListener {operationsClick("*")}
        binding.tvOpen.setOnClickListener {}
        binding.tvClose.setOnClickListener {}
        binding.tvClear.setOnClickListener {clear()}
        binding.tvEquals.setOnClickListener {equals()}
    }

    private fun clear() {
        binding.tvExpression.text = ""
        firstNum = 0.0
        numberFromScreen = 0.0
        operation = null
    }

    private fun equals(){
        binding.tvExpression.text = when (operation) {
            "/" -> (firstNum / numberFromScreen).toString()
            "*" -> (firstNum * numberFromScreen).toString()
            "+" -> (firstNum + numberFromScreen).toString()
            "-" -> (firstNum - numberFromScreen).toString()
            else -> ""
        }
    }

    //Click to numbers
    @SuppressLint("SetTextI18n")
    private fun digitsClick(number: Int) {
        if (mathSign == true) {
            binding.tvExpression.text = number.toString()
            mathSign = false
        } else {
            binding.tvExpression.text = binding.tvExpression.text.toString() + number.toString()
        }

        numberFromScreen = (binding.tvExpression.text.toString()).toDouble()
    }

    //Click to operations
    private fun operationsClick(tag: String) {
        if (binding.tvExpression.text.toString() != "") {
            firstNum = numberFromScreen
            when (tag) {
                "/" -> binding.tvExpression.text = "/"
                "*" -> binding.tvExpression.text = "*"
                "+" -> binding.tvExpression.text = "+"
                "-" -> binding.tvExpression.text = "-"
            }
            operation = tag
            mathSign = true

        } else{
            Toast.makeText(this, "Пустая строка", Toast.LENGTH_SHORT).show()
        }
    }
}

