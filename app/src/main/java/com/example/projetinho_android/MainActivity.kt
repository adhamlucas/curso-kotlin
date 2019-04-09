package com.example.projetinho_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button_register.setOnClickListener{
            val email = email_edittext_register.text.toString()
            val password = password_edittext_register.text.toString()

            Log.d("MainActivity", "Emails is: " + email)
            Log.d("MainActivity", "Password is:  $password")

            //Firebase Authenticate to Create a user with email and password

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if(!it.isSuccessful) return@addOnCompleteListener

                    Log.d("Main", "Sucessufly create user with uid: ${it.result.user.uid}")
                }
//            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener {
//                    if(!it.isSuccessful) return@addOnCompleteListener
//
//                    Log.d("Main", "Sucessfully created user with uid: ${it.result.user.uid}")
//                }
        }

        already_have_account_text_view.setOnClickListener{
            Log.d("MainActivity", "Try to show Login Activity")

            //lanch the login activity somehow
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
