package com.example.xda0


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.collections.ArrayList


private fun disableButtons(b: Boolean) {

}




class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var resetscore: Button
    private lateinit var reset: Button

    private var firstPlayer = ArrayList<Int>()
    private var secondePlayer = ArrayList<Int>()
    private var activePlayer = 1
    private var firstPlayerScore = 0
    private var secondePlaterScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        reset = findViewById(R.id.reset)
        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)
        resetscore = findViewById(R.id.resetscore)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetscore.setOnClickListener {
            score1.text = "0"
            score2.text = "0"
        }

        reset.setOnClickListener {

            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            button1.setBackgroundColor(Color.BLUE)
            button2.setBackgroundColor(Color.BLUE)
            button3.setBackgroundColor(Color.BLUE)
            button4.setBackgroundColor(Color.BLUE)
            button5.setBackgroundColor(Color.BLUE)
            button6.setBackgroundColor(Color.BLUE)
            button7.setBackgroundColor(Color.BLUE)
            button8.setBackgroundColor(Color.BLUE)
            button9.setBackgroundColor(Color.BLUE)


            firstPlayer.clear()
            secondePlayer.clear()

            activePlayer = 1

            disableButtons(true)

        }

    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button ) {
            var ButtonNumber=0
            when (clickedView.id){
                R.id.button1 -> ButtonNumber = 1
                R.id.button2 -> ButtonNumber = 2
                R.id.button3 -> ButtonNumber = 3
                R.id.button4 -> ButtonNumber = 4
                R.id.button5 -> ButtonNumber = 5
                R.id.button6 -> ButtonNumber = 6
                R.id.button7 -> ButtonNumber = 7
                R.id.button8 -> ButtonNumber = 8
                R.id.button9 -> ButtonNumber = 9

            }
            if (ButtonNumber != 0 ){
                PlayGame(clickedView,ButtonNumber)
            }
        }
    }
    private fun GilakebiTurnOff(isEnabled:Boolean){
        button1.isEnabled=isEnabled
        button2.isEnabled=isEnabled
        button3.isEnabled=isEnabled
        button4.isEnabled=isEnabled
        button5.isEnabled=isEnabled
        button6.isEnabled=isEnabled
        button7.isEnabled=isEnabled
        button8.isEnabled=isEnabled
        button9.isEnabled=isEnabled

    }
    private fun PlayGame(clickedView: Button,ButtonNumber:Int){
        if (activePlayer == 1 ){
            clickedView.text="X"
            clickedView.setBackgroundColor(Color.RED)
            clickedView.setTextColor(Color.BLACK)
            activePlayer=2
            firstPlayer.add(ButtonNumber)
        }
        else {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.MAGENTA)
            clickedView.setTextColor(Color.YELLOW)
            activePlayer = 1
            secondePlayer.add(ButtonNumber)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {
        var winnerPlayer = 0


        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }


        if (secondePlayer.contains(1) && secondePlayer.contains(2) && secondePlayer.contains(3)){
            winnerPlayer = 2
        }

        if (secondePlayer.contains(4) && secondePlayer.contains(5) && secondePlayer.contains(6)){
            winnerPlayer = 2
        }

        if (secondePlayer.contains(7) && secondePlayer.contains(8) && secondePlayer.contains(9)){
            winnerPlayer = 2
        }

        if (secondePlayer.contains(1) && secondePlayer.contains(4) && secondePlayer.contains(7)){
            winnerPlayer = 2
        }

        if (secondePlayer.contains(2) && secondePlayer.contains(5) && secondePlayer.contains(8)){
            winnerPlayer = 2
        }

        if (secondePlayer.contains(3) && secondePlayer.contains(6) && secondePlayer.contains(9)){
            winnerPlayer = 2
        }

        if (secondePlayer.contains(1) && secondePlayer.contains(5) && secondePlayer.contains(9)){
            winnerPlayer = 2
        }

        if (secondePlayer.contains(3) && secondePlayer.contains(5) && secondePlayer.contains(7)){
            winnerPlayer = 2
        }


        if (winnerPlayer == 1) {
            Toast.makeText(this,  "FirstPlayer win", Toast.LENGTH_LONG).show()
            disableButtons(false)
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
        }


        else if (winnerPlayer == 2) {
            Toast.makeText(this, "SecondPlayer Win", Toast.LENGTH_LONG).show()
            disableButtons(false)
            secondePlaterScore += 1
            score2.text = secondePlaterScore.toString()


        }

        else if (
            button1.text.isNotEmpty() && button2.text.isNotEmpty() && button3.text.isNotEmpty() && button4.text.isNotEmpty() && button5.text.isNotEmpty() && button6.text.isNotEmpty() && button7.text.isNotEmpty() && button8.text.isNotEmpty() && button9.text.isNotEmpty() ){
            Toast.makeText(this, "Tie", Toast.LENGTH_LONG).show()
            disableButtons(false)
        }
    }
}




