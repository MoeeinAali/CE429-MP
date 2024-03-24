package com.Moeein.tictactoe

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Moeein.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var game: Array<Array<Int>>
    private lateinit var buttonGame: Array<Button>
    private var score_X = 0
    private var score_O = 0
    private var turn = false // false = x , true = O

    override fun onCreate(savedInnumncenumte: Bundle?) {
        super.onCreate(savedInnumncenumte)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0), arrayOf(0, 0, 0)) // X = 1 , O = 0
        buttonGame = arrayOf(
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9
        )
        play()
        binding.buttonRestart.setOnClickListener { resetGame() }


    }

    fun play() {
        buttonGame.forEach {
            it.setOnClickListener {
                checkTurn(turn, it as Button)
                it.isEnabled = false
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun checkTurn(t: Boolean, b: Button) {
        if (!t) {
            b.text = "X"
            binding.editTextOTitle.setTextColor(ContextCompat.getColor(this, R.color.yourturn))
            binding.editTextXTitle.setTextColor(ContextCompat.getColor(this, R.color.noturn))
            b.setTextColor(ContextCompat.getColor(this, R.color.back))
            turn = true

        } else {
            b.text = "O"
            binding.editTextXTitle.setTextColor(ContextCompat.getColor(this, R.color.yourturn))
            binding.editTextOTitle.setTextColor(ContextCompat.getColor(this, R.color.noturn))
            b.setTextColor(ContextCompat.getColor(this, R.color.back))
            turn = false
        }
    }

    fun case(b: Button, num: Int) {
        when (b) {
            binding.button1 -> game[0][0] = num
            binding.button2 -> game[0][1] = num
            binding.button3 -> game[0][2] = num
            binding.button4 -> game[1][0] = num
            binding.button5 -> game[1][1] = num
            binding.button6 -> game[1][2] = num
            binding.button7 -> game[2][0] = num
            binding.button8 -> game[2][1] = num
            binding.button9 -> game[2][2] = num
        }
    }

    fun gameEnd(num: Int) {
        var win = 0
        if ((game[0][0] == num) && (game[0][1] == num) && (game[0][2] == num)) {
            setcolorwin(buttonGame[0], buttonGame[1], buttonGame[2])
            win = num
        }
        if ((game[1][0] == num) && (game[1][1] == num) && (game[1][2] == num)) {
            setcolorwin(buttonGame[3], buttonGame[4], buttonGame[5])
            win = num
        }
        if (game[2][0] == num && game[2][1] == num && game[2][2] == num) {
            setcolorwin(buttonGame[6], buttonGame[7], buttonGame[8])
            win = num
        }
        if (game[0][0] == num && game[1][0] == num && game[2][0] == num) {
            setcolorwin(buttonGame[0], buttonGame[3], buttonGame[6])
            win = num
        }
        if (game[0][1] == num && game[1][1] == num && game[2][1] == num) {
            setcolorwin(buttonGame[1], buttonGame[4], buttonGame[7])
            win = num
        }
        if (game[0][2] == num && game[1][2] == num && game[2][2] == num) {
            setcolorwin(buttonGame[2], buttonGame[5], buttonGame[8])
            win = num
        }
        if (game[0][0] == num && game[1][1] == num && game[2][2] == num) {
            setcolorwin(buttonGame[0], buttonGame[4], buttonGame[8])
            win = num
        }
        if (game[0][2] == num && game[1][1] == num && game[2][0] == num) {
            setcolorwin(buttonGame[6], buttonGame[4], buttonGame[2])
            win = num
        }

        if (win == 1) {
            buttonGame.forEach {
                println("moeein")
                it.isActivated = false
            }
            score_X += 1
            binding.editTextXScore.text = "Score: $score_X"
        }
        if (win == 0) {
            score_O += 1
            binding.editTextOScore.text = "Score: $score_O"
            buttonGame.forEach {
                it.isActivated = false
                println("moeein")

            }
        }


    }

    private fun setcolorwin(btn1: Button, btn2: Button, btn3: Button) {
        val winningButtonIds = arrayOf(btn1.id, btn2.id, btn3.id)
        buttonGame.forEach {
            if (it.id !in winningButtonIds) {
                it.setTextColor(ContextCompat.getColor(this, R.color.noturn))
            }
        }
    }

    private fun resetGame() {
        buttonGame.forEach {
            it.isEnabled = true
            it.text = null
            it.setTextColor(ContextCompat.getColor(this, R.color.back))
        }
        turn = false
        binding.editTextXTitle.setTextColor(ContextCompat.getColor(this, R.color.yourturn))
        binding.editTextOTitle.setTextColor(ContextCompat.getColor(this, R.color.noturn))
        game = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0), arrayOf(0, 0, 0)) // X = 1 , O = 0
    }

}

