package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TableRow
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.countup_button)
        countButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { resetVal() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        if (resultText.text.matches("-?\\d+(\\.\\d+)?".toRegex())) {
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                Toast.makeText(this, "+1",
                    Toast.LENGTH_SHORT).show()

                resultInt++
                resultText.text = resultInt.toString()
            } else {
                Toast.makeText(this, "max value",
                    Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "roll the dice first",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetVal() {
        val resultText: TextView = findViewById(R.id.result_text)


        if (resultText.text.matches("-?\\d+(\\.\\d+)?".toRegex())) {
            resultText.text = "0"
        } else {
            Toast.makeText(this, "roll the dice first",
                Toast.LENGTH_SHORT).show()
        }
    }
}