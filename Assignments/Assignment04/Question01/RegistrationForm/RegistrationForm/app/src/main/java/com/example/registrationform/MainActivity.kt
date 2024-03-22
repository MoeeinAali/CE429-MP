package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnSignUp: Button
    lateinit var etFirstName: EditText
    lateinit var etLastName: EditText
    lateinit var etPassword: EditText
    lateinit var etPasswordReWrite: EditText
    lateinit var etEmail: EditText
    var users: ArrayList<User> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.add(User("moeein", "aali", "moeeeinaali@gmail.com", "1234m"))
        users.add(User("samin", "akbari", "saminakbari.e@gmail.com", "1234s"))

        btnSignUp = findViewById<Button>(R.id.btnSignUp)
        etFirstName = findViewById<EditText>(R.id.etFirstName)
        etLastName = findViewById<EditText>(R.id.etLastName)
        etPassword = findViewById<EditText>(R.id.etPassword)
        etPasswordReWrite = findViewById<EditText>(R.id.etPasswordReWrite)
        etEmail = findViewById<EditText>(R.id.etEmail)




        btnSignUp.setOnClickListener {
            if (notNullFields()) {
                var isAvailable: Boolean = false
                for (user in users) {
                    if (user.email == etEmail.text.toString().trim()) {
                        isAvailable = true
                        Toast.makeText(this, "Email Exists!", Toast.LENGTH_SHORT).show()
                        break
                    }
                }

                if (!isAvailable) {
                    if (etPassword.text.toString() == etPasswordReWrite.text.toString()) {
                        users.add(
                            User(
                                etFirstName.text.toString(),
                                etLastName.text.toString(),
                                etEmail.text.toString(),
                                etPassword.text.toString()
                            )
                        )
                        Toast.makeText(this, "User Added!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Password is Incorrect!", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Complete All Fields!", Toast.LENGTH_SHORT).show()

            }
        }


    }

    fun notNullFields(): Boolean {
        return etFirstName.text.isNotBlank() &&
                etLastName.text.isNotBlank() &&
                etPassword.text.isNotBlank() &&
                etPasswordReWrite.text.isNotBlank() &&
                etEmail.text.isNotBlank()
    }

    class User {
        val firstName: String
        val lastName: String
        val fullName: String
        val email: String
        val password: String

        constructor(fname: String, lname: String, email: String, password: String) {
            this.firstName = fname
            this.lastName = lname
            this.email = email
            this.password = password
            this.fullName = "$firstName $lastName"
        }
    }

}
