# Assignment03 - Question03 - RegistrationForm
* Duplicated Email

![Duplicated Email](https://github.com/MoeeinAali/CE429-MP/blob/e3a7ad91716dfcc37179988818608a232b857b4a/Assignments/Assignment03/Question03-RegistrationForm/RegistrationForm01.png)
* Null Fields Error

![Null Fields Error](https://github.com/MoeeinAali/CE429-MP/blob/e3a7ad91716dfcc37179988818608a232b857b4a/Assignments/Assignment03/Question03-RegistrationForm/RegistrationForm02.png)
* Incorrect Password Error

![Incorrect Password Error](https://github.com/MoeeinAali/CE429-MP/blob/e3a7ad91716dfcc37179988818608a232b857b4a/Assignments/Assignment03/Question03-RegistrationForm/RegistrationForm03.png)
* Successful Registration

![Successful Registration](https://github.com/MoeeinAali/CE429-MP/blob/e3a7ad91716dfcc37179988818608a232b857b4a/Assignments/Assignment03/Question03-RegistrationForm/RegistrationForm04.png)

## MainActivity Codes ~ Kotlin

```
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
```
