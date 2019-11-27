package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        btnCalculate.setOnClickListener {

            val height:Double = editText.text.toString().toDouble();
            //val weight:Double = input1.toDouble();

            val weight:Double = editText2.text.toString().toDouble();
           // val height:Double = input2.toDouble();

            //calculate
            val BMI = calculateBMI(height,weight);
            val status : String;

            //result

            if (BMI < 18.5)
            {
                status = "Underweight"
                imageView2.setImageResource(R.drawable.under)
                result.text = ("BMI: " .format(BMI))
            }
            else if(BMI <= 24.9)
            {
                status = "Normal"
                imageView2.setImageResource(R.drawable.normal)
                result.text = ("BMI: " .format(BMI))
            }
            else
            {
                status = "Overweight"
                imageView2.setImageResource(R.drawable.over)
                result.text = ("BMI: " .format(BMI))
            }
            result.text = ("BMI: %.2f".format(BMI,status))


        }

        btnReset.setOnClickListener {
            editText.setText("")
            editText2.setText("");
            result.setText("")
            imageView2.setImageResource(R.drawable.empty)
            editText.requestFocus();
        }
    }
    public fun calculateBMI(height:Double, weight:Double):Double{

        return weight/(height * height)


    }

}
