package com.Moeein.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.Moeein.tictactoe.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(this.binding.root)


        val emails = arrayListOf<String>()
        val passwords = arrayListOf<String>()

        binding.btnSignUp.setOnClickListener {
            if ((binding.txtEmailSignUp.text.toString()
                    .isNotEmpty()) and (binding.txtPasswordSignUp.text.toString().isNotEmpty())
            ) {
                val signupEmail = binding.txtEmailSignUp.text.toString()
                val signupPassword = binding.txtPasswordSignUp.text.toString()
                Toast.makeText(this, "Sign Up Shodiiiii!", Toast.LENGTH_SHORT).show()
                emails.add(signupEmail)
                passwords.add(signupPassword)
                binding.txtEmailSignUp.text.clear()
                binding.txtPasswordSignUp.text.clear()
            } else {
                Toast.makeText(this, "Lotfan Field haye SignUp ro por kon !", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        binding.btnSignIn.setOnClickListener {
            val loginEmail = binding.txtEmailLogin.text.toString()
            val loginPassword = binding.txtPasswordLogin.text.toString()
            if (loginEmail.isNotEmpty() and loginPassword.isNotEmpty()) {

                for (i in 0 until emails.size) {
                    if (emails.get(i).equals(loginEmail)) {
                        if (passwords.get(i).equals(loginPassword)) {
                            val intent = Intent(this, MenuActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Eshtebah zadi dadash!", Toast.LENGTH_SHORT)
                                .show()
                            continue
                        }
                    }
                }

            } else {
                Toast.makeText(this, "Lotfan Field haye Login ro por kon !", Toast.LENGTH_SHORT)
                    .show()
            }

        }


    }
}
