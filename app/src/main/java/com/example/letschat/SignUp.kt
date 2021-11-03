package com.example.letschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    private lateinit var edtFname: EditText
    private lateinit var edtSname: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //hides Action bar
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        edtFname = findViewById(R.id.edt_fname)
        edtSname = findViewById(R.id.edt_sname)
        edtEmail = findViewById(R.id.edt_email_phone)
        edtPassword = findViewById(R.id.password)
        btnSignUp = findViewById(R.id.btn_signup)

        btnSignUp.setOnClickListener {

            val fName = edtFname.text.toString()
            val sName = edtSname.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signUp(fName, sName, email, password)
        }
    }
    private fun signUp(fname: String, sname: String, email: String, password: String) {

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                     addUserToDatabase(fname, sname, email, mAuth.currentUser?.uid!!)
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@SignUp, "Some error occurred", Toast.LENGTH_SHORT).show()

                }
            }

    }

    private fun addUserToDatabase(sname: String, fname: String, email: String, uid: String) {
        mDbRef = FirebaseDatabase.getInstance().getReference()

        mDbRef.child("user").child(uid).setValue(User(sname, fname, email, uid))
    }

}