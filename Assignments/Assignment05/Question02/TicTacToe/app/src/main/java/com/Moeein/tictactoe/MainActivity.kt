package com.Moeein.tictactoe

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.Moeein.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var game: Array<Array<Int>>
    private lateinit var buttons: Array<Button>
    private var scoreX: Int = 0
    private var scoreO: Int = 0

    //    X = 1 , O = 2
    private var turn: Int = 1

    override fun onCreate(savedInnumncenumte: Bundle?) {
        super.onCreate(savedInnumncenumte)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
//        X = 1 , O = 0
        this.game = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0), arrayOf(0, 0, 0))
        this.buttons = arrayOf(
            this.binding.button1,
            this.binding.button2,
            this.binding.button3,
            this.binding.button4,
            this.binding.button5,
            this.binding.button6,
            this.binding.button7,
            this.binding.button8,
            this.binding.button9
        )
        setRole(this.intent)
        setMode(this.intent)
        play()
        binding.buttonRestart.setOnClickListener { resetGame() }
    }

    private fun setMode(intent: Intent) {
//        TODO("CPU Mode")
        val receivedMode = intent.getStringExtra("MODE")
        Toast.makeText(this, "$receivedMode Mode!", Toast.LENGTH_SHORT).show()

    }

    private fun setRole(intent: Intent) {
        val receivedRole = intent.getStringExtra("ROLE")
        if (receivedRole.equals("O") and (this.turn != 2)) {
            toggleTurn(turn)
        }
        if (receivedRole.equals("X") and (this.turn != 1)) {
            toggleTurn(turn)
        }
    }

    private fun play() {
        this.buttons.forEach { it0 ->
            it0.setOnClickListener { it1 ->
                checkTurn(it1 as Button)
            }
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

    private fun case(btn: Button) {
        when (btn) {
            this.buttons[0] -> this.game[0][0] = turn
            this.buttons[1] -> this.game[0][1] = turn
            this.buttons[2] -> this.game[0][2] = turn
            this.buttons[3] -> this.game[1][0] = turn
            this.buttons[4] -> this.game[1][1] = turn
            this.buttons[5] -> this.game[1][2] = turn
            this.buttons[6] -> this.game[2][0] = turn
            this.buttons[7] -> this.game[2][1] = turn
            this.buttons[8] -> this.game[2][2] = turn
        }
    }

    private fun toggleTurn(trn: Int) {
        if (trn == 1) { // X
            this.binding.editTextXTitle.setTextColor(ContextCompat.getColor(this, R.color.noturn))
            this.binding.editTextOTitle.setTextColor(ContextCompat.getColor(this, R.color.yourturn))
            checkEndGame(this.turn)
            this.turn = 2
            return
        }
        if (trn == 2) {// O
            this.binding.editTextOTitle.setTextColor(ContextCompat.getColor(this, R.color.noturn))
            this.binding.editTextXTitle.setTextColor(ContextCompat.getColor(this, R.color.yourturn))
            checkEndGame(this.turn)
            this.turn = 1
        }
    }

    private fun checkEndGame(turnNumber: Int) {
        var winnerId = 0
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
            if (game[line[0] / 3][line[0] % 3] == turnNumber &&
                game[line[1] / 3][line[1] % 3] == turnNumber &&
                game[line[2] / 3][line[2] % 3] == turnNumber
            ) {
                setColorWinner(buttons[line[0]], buttons[line[1]], buttons[line[2]])
                winnerId = turnNumber
                break
            }
        }
        selectWinner(winnerId)
    }

    private fun selectWinner(winnerId: Int) {
        if (winnerId > 0) {
            disableButtons(this.buttons)
            lateinit var winnerName: String
            if (winnerId == 1) {
                this.scoreX += 1
                updateScore()
                winnerName = "X"
            }
            if (winnerId == 2) {
                this.scoreO += 1
                updateScore()
                winnerName = "O"
            }
            dialogWinner(winnerName)
        }
    }

    private fun disableButtons(buttons: Array<Button>) {
        buttons.forEach {
            it.isEnabled = false
        }
    }

    private fun enableButtons(buttons: Array<Button>) {
        buttons.forEach {
            it.isEnabled = true
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateScore() {
        binding.editTextXScore.text = "Score: $scoreX"
        binding.editTextOScore.text = "Score: $scoreO"
    }

    private fun setColorWinner(b1: Button, b2: Button, b3: Button) {
        b1.setTextColor(ContextCompat.getColor(this, R.color.win))
        b2.setTextColor(ContextCompat.getColor(this, R.color.win))
        b3.setTextColor(ContextCompat.getColor(this, R.color.win))
    }

    private fun dialogWinner(win: String) {
        val alertdialog: AlertDialog
        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.activity_win, null)
        val txtWin: TextView = dialogView.findViewById(R.id.playerwin)
        txtWin.text = win
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        dialogBuilder.setOnDismissListener {}
        dialogBuilder.setView(dialogView)
        alertdialog = dialogBuilder.create()
        alertdialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.show()
    }

    private fun resetGame() {
        enableButtons(this.buttons)
        clearButtons()
        toggleTurn(this.turn)

    }

    private fun clearGame() {
        this.game = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0), arrayOf(0, 0, 0)) // X = 1 , O = 2
    }

    private fun clearButtons() {
        this.buttons.forEach {
            it.text = ""
        }
        clearGame()

    }


}

