package com.moeein.calculatordb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.Toast
import com.moeein.calculatordb.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onNumberClicked()
        onOperatorClicked()
        binding.BtnHistory.setOnClickListener {
            val intent = Intent(this, history::class.java)
            startActivity(intent)
        }

    }

    @SuppressLint("SetTextI18n")
    private fun onOperatorClicked() {
        binding.BtnJam.setOnClickListener {
            if (binding.ETOutput.text.isNotEmpty()) {
                binding.ETInput.text = binding.ETOutput.text.toString()
                    .substring(1, binding.ETOutput.text.toString().length) + "+"
            }
            if (!binding.ETInput.text.toString().endsWith("+")) {
                appendText("+")
            }
        }
        binding.BtnMenha.setOnClickListener {
            if (binding.ETOutput.text.isNotEmpty()) {
                binding.ETInput.text = binding.ETOutput.text.toString()
                    .substring(1, binding.ETOutput.text.toString().length) + "-"
            }
            if (!binding.ETInput.text.toString().endsWith("-")) {
                appendText("-")
            }
        }
        binding.BtnZarb.setOnClickListener {

            if (binding.ETOutput.text.isNotEmpty()) {
                binding.ETInput.text = binding.ETOutput.text.toString()
                    .substring(1, binding.ETOutput.text.toString().length) + "*"
            }
            if (!binding.ETInput.text.toString().endsWith("*")) {
                appendText("*")
            }
        }
        binding.BtnTaghsim.setOnClickListener {
            if (binding.ETOutput.text.isNotEmpty()) {
                binding.ETInput.text = binding.ETOutput.text.toString()
                    .substring(1, binding.ETOutput.text.toString().length) + "/"
            }
            if (!binding.ETInput.text.toString().endsWith("/")) {
                appendText("/")
            }
        }
        binding.BtnParOpen.setOnClickListener {
            appendText("(")
        }
        binding.BtnParClose.setOnClickListener {
            appendText(")")
        }
        binding.BtnAC.setOnClickListener {
            binding.ETInput.text = ""
            if (binding.ETInput.text.isEmpty()) {
                binding.ETOutput.text = ""
            }
        }
        binding.BtnDelete.setOnClickListener {
            val oldText = binding.ETInput.text.toString()
            if (oldText.isNotEmpty()) {
                binding.ETInput.text = oldText.substring(0, oldText.length - 1)

            }
        }
        binding.BtnMosavi.setOnClickListener {
            try {
                val expression = ExpressionBuilder(binding.ETInput.text.toString()).build()
                val result: Double = expression.evaluate()
                if (binding.ETInput.text.toString().contains('.')) {
                    binding.ETOutput.text = "=$result"
                } else {
                    binding.ETOutput.text = "=" + result.toLong().toString()
                }

//                Write to File
                val fileName = "history.txt"
                val dataToWrite = FileUtils.readFromFile(
                    fileName,
                    this
                ) + "\n" + binding.ETInput.text.toString() + binding.ETOutput.text.toString() + "\n"
                FileUtils.writeToFile(fileName, dataToWrite, this)
            } catch (e: Exception) {
                binding.ETInput.text = ""
                binding.ETOutput.text = ""
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()

            }

        }

    }

    private fun onNumberClicked() {
        binding.BtnNum0.setOnClickListener {
            if (binding.ETInput.text.isNotEmpty()) {
                appendText("0")
            }

        }
        binding.BtnNum1.setOnClickListener {
            appendText("1")
        }
        binding.BtnNum2.setOnClickListener {
            appendText("2")
        }
        binding.BtnNum3.setOnClickListener {
            appendText("3")
        }
        binding.BtnNum4.setOnClickListener {
            appendText("4")
        }
        binding.BtnNum5.setOnClickListener {
            appendText("5")
        }
        binding.BtnNum6.setOnClickListener {
            appendText("6")
        }
        binding.BtnNum7.setOnClickListener {
            appendText("7")
        }
        binding.BtnNum8.setOnClickListener {
            appendText("8")
        }
        binding.BtnNum9.setOnClickListener {
            appendText("9")
        }
        binding.BtnDot.setOnClickListener {
            if (binding.ETInput.text.isEmpty()) {
                appendText("0.")
            } else {
                if (!binding.ETInput.text.toString().contains('.')) {
                    appendText(".")
                }
            }
        }

    }

    private fun appendText(inputStr: String) {

        if (binding.ETOutput.text.isNotEmpty()) {
            binding.ETOutput.text = ""
        }
        binding.ETInput.append(inputStr)

//        Fix Horizontal Scroll Bar
        val viewTree: ViewTreeObserver = binding.horizontalScrollViewETInput.viewTreeObserver
        viewTree.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.horizontalScrollViewETInput.viewTreeObserver.removeOnGlobalLayoutListener(
                    this
                )
                binding.horizontalScrollViewETInput.smoothScrollTo(binding.ETInput.width, 0)
            }


        })

    }


}