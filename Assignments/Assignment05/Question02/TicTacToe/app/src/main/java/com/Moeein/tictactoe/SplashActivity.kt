package com.Moeein.tictactoe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.Moeein.tictactoe.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val SPLASH_DISPLAY_LENGTH: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.splashText.text = "TicTacToe\nGame"

        val deviceUUID = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        Toast.makeText(this, "Device UUID: $deviceUUID", Toast.LENGTH_SHORT).show()


        Handler().postDelayed({
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}


