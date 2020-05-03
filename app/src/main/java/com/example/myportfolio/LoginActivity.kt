package com.example.myportfolio

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val shared = getSharedPreferences("My Shared Preference", Context.MODE_PRIVATE)
        val registeredEmail = shared.getString("EMAIL ADDRESS", "")
        val registeredPassword = shared.getString("PASSWORD", "")
        val registeredFirstName = shared.getString("FIRST NAME", "")
        val registeredLastName = shared.getString("LAST NAME", "")
        val registeredBio = shared.getString("BIO DESCRIPTION", "")

        val logIn = findViewById<Button>(R.id.login_button)
        val signUp = findViewById<TextView>(R.id.sign)
        val email = findViewById<EditText>(R.id.email_box)
        val password = findViewById<EditText>(R.id.password_box)

        val textToast = intent.getStringExtra("Toast Alert Success")
        val toastMsgSuccess = Toast.makeText(this, textToast, Toast.LENGTH_SHORT)
        toastMsgSuccess.setGravity(Gravity.TOP, 0, 140)
       toastMsgSuccess.show()

        logIn.setOnClickListener{
            val text: String
            if(email.text.toString().isEmpty() || password.text.toString().isEmpty()){
                text = "No field should be left empty"
                alert(text)
            }else if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                email.error = "Invalid Email"
            }else if((email.text.toString() != registeredEmail) || (password.text.toString() != registeredPassword)){
                email.error = "Incorrect Email"
                password.error = "Incorrect password"
            }else {
                val fullName = "$registeredFirstName $registeredLastName"
                val desc = "$registeredBio"

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Name", fullName)
                intent.putExtra("Description", desc)
                startActivity(intent)
                finish()
            }
        }
        signUp.setOnClickListener{
            signUp()
        }
    }

    private  fun signUp(){
        val intent = Intent(this, SignUpActivity::class.java)
        Log.i("R", "WHY?!")
        startActivity(intent)
    }
    private fun alert(text: String){
        val toaster = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        toaster.setGravity(Gravity.TOP, 0, 140)
        toaster.show()
    }
}
