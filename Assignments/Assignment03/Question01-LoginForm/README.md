# Assignment03 - Question01 - LoginForm

* **Successful Login**
  
![Logined](https://github.com/MoeeinAali/CE429-MP/blob/771e64695a9b4bf08cbfd0e68979094407b77455/Assignments/Assignment03/Question01-LoginForm/LoginForm1.png)
* **Failed Login**
  
![Logined](https://github.com/MoeeinAali/CE429-MP/blob/771e64695a9b4bf08cbfd0e68979094407b77455/Assignments/Assignment03/Question01-LoginForm/LoginForm2.png)

## MainActivity Codes ~ Kotlin

```
class MainActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            if (isValidCredentials(username, password)) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        return (username == "moeeeinaali@gmail.com") && (password == "12345678m")
    }
}
```
