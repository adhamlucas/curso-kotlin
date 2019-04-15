package com.example.projetinho_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener{
            val email = email_edittext_login.text.toString()
            val password = password_edittext_login.text.toString()

            if(email.isEmpty() || password.isEmpty()) {
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this,"Login Realizado com Sucesso ${it.result}", Toast.LENGTH_SHORT).show()
                        Log.d("LoginActivity", "${it.result}")
                    }
                    else{
                        return@addOnCompleteListener
                    }
                }
                .addOnFailureListener{
                    Toast.makeText(this,"Failed Login ${it.message}",Toast.LENGTH_SHORT).show()
                    Log.d("LoginActivity", "${it.message}")
                }

            Log.d("Login", "Attempt login with email/pw: $email/***")
        }

        back_to_register_textview.setOnClickListener {
            finish()
        }
    }

}