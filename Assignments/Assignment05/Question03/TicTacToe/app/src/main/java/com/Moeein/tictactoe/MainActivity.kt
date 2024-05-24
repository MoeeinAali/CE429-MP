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
    data class Move(var row: Int = 0, var col: Int = 0)

    private var player = 1
    private var opponent = 2

    private lateinit var binding: ActivityMainBinding
    private lateinit var game: Array<Array<Int>>
    private lateinit var buttons: Array<Button>
    private var scoreX: Int = 0
    private var scoreO: Int = 0
    private var mode: String = "human"


    //    X = 1 , O = 2
    private var turn: Int = 1

    override fun onCreate(savedInnumncenumte: Bundle?) {
        super.onCreate(savedInnumncenumte)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
//        X = 1 , O = 0
        setMode(this.intent)
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
        play()
        binding.buttonRestart.setOnClickListener { resetGame() }
    }

    private fun setMode(intent: Intent) {
        val receivedMode = intent.getStringExtra("MODE").toString()
        if (receivedMode == "CPU") {
            this.mode = "cpu"
        }
        Toast.makeText(this, "${this.mode} Mode!", Toast.LENGTH_SHORT).show()

    }

    private fun setRole(intent: Intent) {
        val receivedRole = intent.getStringExtra("ROLE")
        if (receivedRole.equals("O") and (this.turn != 2)) {
            this.player = 2
            this.opponent = 1
            toggleTurn(turn)
        }
        if (receivedRole.equals("X") and (this.turn != 1)) {
            this.player = 1
            this.opponent = 2
            toggleTurn(turn)
        }
    }

    private fun play() {
        this.buttons.forEach { it0 ->
            it0.setOnClickListener { it1 ->
                checkTurn(it1 as Button)
                if (this.mode == "cpu") {
                    val bestMove = findBestMove(this.game, player, opponent)
                    if (isMovesLeft(game)) {
                        checkTurn(this.buttons[bestMove.row * 3 + bestMove.col])
                    } else {
                        disableButtons(buttons)
                        toggleTurn(turn)
                    }
                }
            }
        }
    }


    /////////////////////////////////CPU FUNCTIONS//////////////////////////////////////////
    private fun isMovesLeft(board: Array<Array<Int>>): Boolean {
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == 0) {
                    return true
                }
            }
        }
        return false
    }

    private fun evaluate(b: Array<Array<Int>>, player: Int, opponent: Int): Int {
        for (row in 0..2) {
            if (b[row][0] == b[row][1] && b[row][1] == b[row][2]) {
                if (b[row][0] == player) {
                    return 10
                } else if (b[row][0] == opponent) {
                    return -10
                }
            }
        }

        for (col in 0..2) {
            if (b[0][col] == b[1][col] && b[1][col] == b[2][col]) {
                if (b[0][col] == player) {
                    return 10
                } else if (b[0][col] == opponent) {
                    return -10
                }
            }
        }

        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            if (b[0][0] == player) {
                return 10
            } else if (b[0][0] == opponent) {
                return -10
            }
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            if (b[0][2] == player) {
                return 10
            } else if (b[0][2] == opponent) {
                return -10
            }
        }

        return 0
    }

    private fun minimax(
        board: Array<Array<Int>>,
        depth: Int,
        isMax: Boolean,
        player: Int,
        opponent: Int,
        alpha: Int,
        beta: Int,
        memo: MutableMap<Array<Array<Int>>, Int>,
    ): Int {
        val score = evaluate(board, player, opponent)

        if (score == 10 || score == -10) return score

        val boardKey = board.map { it.copyOf() }.toTypedArray()

        if (memo.containsKey(boardKey)) return memo[boardKey]!!

        if (!isMovesLeft(board)) return 0

        var alpha = alpha
        var beta = beta

        var best = if (isMax) Int.MIN_VALUE else Int.MAX_VALUE

        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == 0) {
                    if (isMax) {
                        board[i][j] = player
                        best = maxOf(
                            best,
                            minimax(board, depth + 1, !isMax, player, opponent, alpha, beta, memo)
                        )
                        alpha = maxOf(alpha, best)
                    } else {
                        board[i][j] = opponent
                        best = minOf(
                            best,
                            minimax(board, depth + 1, !isMax, player, opponent, alpha, beta, memo)
                        )
                        beta = minOf(beta, best)
                    }
                    board[i][j] = 0

                    if (beta <= alpha) break
                }
            }
        }

        memo[boardKey] = best
        return best
    }


    private fun findBestMove(board: Array<Array<Int>>, player: Int, opponent: Int): Move {
        val memo = mutableMapOf<Array<Array<Int>>, Int>()
        var bestVal = Int.MIN_VALUE
        val bestMove = Move(-1, -1)

        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == 0) {
                    board[i][j] = player
                    val moveVal = minimax(board, 0, false, player, opponent, -999, +999, memo)
                    board[i][j] = 0

                    if (moveVal > bestVal) {
                        bestMove.row = i
                        bestMove.col = j
                        bestVal = moveVal
                    }
                }
            }
        }
        return bestMove
    }


    /////////////////////////////////HUMAN FUNCTIONS//////////////////////////////////////////
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

    //    use this for check
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
            disableButtons(buttons)
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

