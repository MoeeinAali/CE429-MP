package com.moeein.calculatordb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.moeein.calculatordb.databinding.ActivityHistoryBinding

class history : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtviewHistory.text = FileUtils.readFromFile("history.txt", this).toString()
//        Toast.makeText(this, binding.txtviewHistory.text.toString(), Toast.LENGTH_SHORT).show()
        binding.buttonClear.setOnClickListener {
            FileUtils.writeToFile("history.txt", "", this)
            binding.txtviewHistory.text = ""

        }
    }
}