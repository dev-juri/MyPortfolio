package com.example.myportfolio

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val firstName = findViewById<EditText>(R.id.first_name)
        val lastName = findViewById<EditText>(R.id.last_name)
        val email = findViewById<EditText>(R.id.email)
        val phoneNo = findViewById<EditText>(R.id.phone_no)
        val description = findViewById<EditText>(R.id.desc)
        val password = findViewById<EditText>(R.id.password)
        val signUp = findViewById<Button>(R.id.sign_up)

        signUp.setOnClickListener {
            if (firstName.text.toString().isEmpty() ||
                lastName.text.toString().isEmpty() ||
                email.text.toString().isEmpty()  ||
                phoneNo.text.toString().isEmpty() ||
                description.text.toString().isEmpty()||
                password.text.toString().isEmpty()) {
                alert()
            } else if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                email.error = "Invalid Email"
            } else if(password.text.toString().length < 6){
                password.error = "Password not long enough"
            } else if (phoneNo.text.toString().length < 11){
                phoneNo.error = "Invalid phone number"
            } else {
                val sharedPref = getSharedPreferences("My Shared Preference", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                editor.putString("FIRST NAME", firstName.text.toString())
                editor.putString("LAST NAME", lastName.text.toString())
                editor.putString("EMAIL ADDRESS", email.text.toString())
                editor.putString("PHONE NUMBER", phoneNo.text.toString())
                editor.putString("BIO DESCRIPTION", description.text.toString())
                editor.putString("PASSWORD", password.text.toString())
                editor.apply()

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("Toast Alert Success", "Sign up successful, you may login now")
                startActivity(intent)
                finish()

            }

        }
    }
    private fun alert(){
        val alertMsg = getString(R.string.msg_alert)
        val toaster = Toast.makeText(this, alertMsg, Toast.LENGTH_SHORT)
        toaster.setGravity(Gravity.TOP, 0, 140)
        toaster.show()
    }

}
