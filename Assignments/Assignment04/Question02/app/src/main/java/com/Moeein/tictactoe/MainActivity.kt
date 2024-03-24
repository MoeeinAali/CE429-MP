package com.Moeein.tictactoe

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.Moeein.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var game: Array<Array<Int>>
    private lateinit var buttons: Array<Button>
    private var score_X = 0
    private var score_O = 0
    var playMode = true
    private var turn = 1 // 1 = x , 2 = O

    override fun onCreate(savedInnumncenumte: Bundle?) {
        super.onCreate(savedInnumncenumte)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0), arrayOf(0, 0, 0)) // X = 1 , O = 2
        buttons = arrayOf(
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

    private fun resetGame() {
        enableButtons(buttons)
        clearButtons()
        toggleTurn(turn)

    }

    private fun clearGame() {
        game = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0), arrayOf(0, 0, 0)) // X = 1 , O = 2
    }

    private fun play() {
        if (playMode) {
            buttons.forEach {
                it.setOnClickListener {
                    checkTurn(it as Button)
                }
            }
        }
    }

    private fun clearButtons() {
        buttons.forEach {
            it.text = ""
        }
        clearGame()

    }

    private fun case(btn: Button) {
        when (btn) {
            buttons[0] -> game!![0][0] = turn
            buttons[1] -> game!![0][1] = turn
            buttons[2] -> game!![0][2] = turn
            buttons[3] -> game!![1][0] = turn
            buttons[4] -> game!![1][1] = turn
            buttons[5] -> game!![1][2] = turn
            buttons[6] -> game!![2][0] = turn
            buttons[7] -> game!![2][1] = turn
            buttons[8] -> game!![2][2] = turn
        }
    }

    private fun checkTurn(btn: Button) {
        if (turn == 1) { // X
            btn.text = "X"
        }
        if (turn == 2) { // O
            btn.text = "O"
        }
        btn.setTextColor(ContextCompat.getColor(this, R.color.back2))
        case(btn)
        toggleTurn(turn)
        disableButtons(arrayOf(btn))
    }

    private fun disableButtons(btns: Array<Button>) {
        btns.forEach {
            it.isEnabled = false
        }
    }

    private fun enableButtons(btns: Array<Button>) {
        btns.forEach {
            it.isEnabled = true
        }
    }

    private fun toggleTurn(trn: Int) {
        if (trn == 1) { // X
            binding.editTextXTitle.setTextColor(ContextCompat.getColor(this, R.color.noturn))
            binding.editTextOTitle.setTextColor(ContextCompat.getColor(this, R.color.yourturn))
            checkEndGame(turn)
            turn = 2
            return
        }
        if (trn == 2) {// O
            binding.editTextOTitle.setTextColor(ContextCompat.getColor(this, R.color.noturn))
            binding.editTextXTitle.setTextColor(ContextCompat.getColor(this, R.color.yourturn))
            checkEndGame(turn)
            turn = 1
        }
    }

    private fun checkEndGame(turn_Number: Int) {
        var winner_ID = 0
        val lines = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8),
            intArrayOf(0, 3, 6),
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            intArrayOf(0, 4, 8),
            intArrayOf(2, 4, 6)
        )

        for (line in lines) {
            if (game[line[0] / 3][line[0] % 3] == turn_Number &&
                game[line[1] / 3][line[1] % 3] == turn_Number &&
                game[line[2] / 3][line[2] % 3] == turn_Number
            ) {
                setColorWinner(buttons[line[0]], buttons[line[1]], buttons[line[2]])
                winner_ID = turn_Number
                break
            }
        }
        if (winner_ID > 0) {
            disableButtons(buttons)
            lateinit var winner_name: String
            if (winner_ID == 1) {
                score_X += 1
                updateScore()
                winner_name = "X"
            }
            if (winner_ID == 2) {
                score_O += 1
                updateScore()
                winner_name = "O"
            }
            dialogWiner(winner_name)
        }
    }

    fun updateScore() {
        binding.editTextXScore.text = "Score: $score_X"
        binding.editTextOScore.text = "Score: $score_O"
    }

    fun setColorWinner(b1: Button, b2: Button, b3: Button) {
        b1.setTextColor(ContextCompat.getColor(this, R.color.win))
        b2.setTextColor(ContextCompat.getColor(this, R.color.win))
        b3.setTextColor(ContextCompat.getColor(this, R.color.win))
    }

    fun dialogWiner(win: String) {
        var alertDialomenug: AlertDialog
        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.activity_win, null)
        val txtWin: TextView = dialogView.findViewById(R.id.playerwin)
        txtWin.text = win
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        dialogBuilder.setOnDismissListener {}
        dialogBuilder.setView(dialogView)
        alertDialomenug = dialogBuilder.create();
        alertDialomenug.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialomenug.show()
    }

}

