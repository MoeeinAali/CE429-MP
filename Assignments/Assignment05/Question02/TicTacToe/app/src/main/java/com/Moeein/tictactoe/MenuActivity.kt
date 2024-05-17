package com.Moeein.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Moeein.tictactoe.databinding.ActivityMainBinding
import com.Moeein.tictactoe.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        var mode: String = ""
        var role: String = ""
        binding.gameModeRadioGroup.setOnCheckedChangeListener { _, i ->
            mode = findViewById<RadioButton>(i).text.toString()
        }
        binding.gameRoleRadioGroup.setOnCheckedChangeListener { _, i ->
            role = findViewById<RadioButton>(i).text.toString()
        }

        binding.btnStart.setOnClickListener {
            if (mode.isNotEmpty() and role.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("MODE", mode).putExtra("ROLE", role)
                startActivity(intent)
//                finish()

            } else {
                Toast.makeText(this, "Cant Start the Game!!!", Toast.LENGTH_SHORT).show()
            }
        }


    }
}