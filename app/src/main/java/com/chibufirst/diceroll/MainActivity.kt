package com.chibufirst.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRoll: Button = findViewById(R.id.buttonRoll)
        buttonRoll.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val firstDiceRoll = dice.roll()
        val secondDiceRoll = dice.roll()

        val firstDiceImage: ImageView = findViewById(R.id.firstDiceImage)
        val secondDiceImage: ImageView = findViewById(R.id.secondDiceImage)

        val firstDrawableResource = when (firstDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val secondDrawableResource = when (secondDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        firstDiceImage.setImageResource(firstDrawableResource)
        firstDiceImage.contentDescription = firstDiceRoll.toString()
        secondDiceImage.setImageResource(secondDrawableResource)
        secondDiceImage.contentDescription = secondDiceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}