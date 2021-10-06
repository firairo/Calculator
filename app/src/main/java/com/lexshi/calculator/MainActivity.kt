package com.lexshi.calculator


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lexshi.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //numbers
        binding.tvOne.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "1" else binding.tvExpression.text = binding.tvExpression.text.toString()+"1"}
        binding.tvTwo.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "2" else binding.tvExpression.text = binding.tvExpression.text.toString()+"2"}
        binding.tvThree.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "3" else binding.tvExpression.text = binding.tvExpression.text.toString()+"3"}
        binding.tvFour.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "4" else binding.tvExpression.text = binding.tvExpression.text.toString()+"4"}
        binding.tvFive.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "5" else binding.tvExpression.text = binding.tvExpression.text.toString()+"5"}
        binding.tvSix.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "6" else binding.tvExpression.text = binding.tvExpression.text.toString()+"6"}
        binding.tvSeven.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "7" else binding.tvExpression.text = binding.tvExpression.text.toString()+"7"}
        binding.tvEight.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "8" else binding.tvExpression.text = binding.tvExpression.text.toString()+"8"}
        binding.tvEleven.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "9" else binding.tvExpression.text = binding.tvExpression.text.toString()+"9"}
        binding.tvZero.setOnClickListener{ if (binding.tvExpression.text.equals("0")) binding.tvExpression.text = "0" else binding.tvExpression.text = binding.tvExpression.text.toString()+"0"}


        //actions
        binding.tvPlus.setOnClickListener{
            binding.tvResult.text = binding.tvResult.text.toString() + binding.tvExpression.text.toString()+"+"
            binding.tvExpression.text = ""
        }
        binding.tvMinus.setOnClickListener{
            binding.tvResult.text = binding.tvResult.text.toString() + binding.tvExpression.text.toString()+"-"
            binding.tvExpression.text = ""
        }
        binding.tvDivide.setOnClickListener{
            binding.tvResult.text = binding.tvResult.text.toString() + binding.tvExpression.text.toString()+"/"
            binding.tvExpression.text = ""
        }
        binding.tvMultiply.setOnClickListener{
            binding.tvResult.text = binding.tvResult.text.toString() + binding.tvExpression.text.toString()+"*"
            binding.tvExpression.text = ""
        }
        binding.tvOpen.setOnClickListener{
            binding.tvResult.text = binding.tvResult.text.toString() + binding.tvExpression.text.toString()+"("
            binding.tvExpression.text = ""
        }
        binding.tvClose.setOnClickListener{
            binding.tvResult.text = binding.tvResult.text.toString() + binding.tvExpression.text.toString()+")"
            binding.tvExpression.text = ""
        }
        binding.tvClear.setOnClickListener{
            binding.tvExpression.text = ""
            binding.tvResult.text = ""
        }


        binding.tvEquals.setOnClickListener {
            val temp = binding.tvExpression.text.toString()
            binding.tvResult.text = binding.tvResult.text.toString() + temp
            binding.tvExpression.text = binding.tvResult.text.toString()

        }




    }
}