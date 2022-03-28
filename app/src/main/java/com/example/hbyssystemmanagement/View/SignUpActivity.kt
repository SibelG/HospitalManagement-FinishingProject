package com.example.hbyssystemmanagement.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.Model.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class SignUpActivity : AppCompatActivity() {
    lateinit var mDatabase : DatabaseReference
    private val TAG = "FirebaseEmailPassword"
    private lateinit var mAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val nameTxt = findViewById<View>(R.id.editName) as TextView
        mAuth= FirebaseAuth.getInstance()
        var user = FirebaseAuth.getInstance().currentUser

        mDatabase = FirebaseDatabase.getInstance().getReference("Users/User")



    }

    fun goToLogin(view: View){
        val intent= Intent(this,SignInActivity::class.java)
        startActivity(intent)
    }
    fun registerUser (view: View) {
        val emailTxt = findViewById<View>(R.id.editEmail) as EditText
        val passwordTxt = findViewById<View>(R.id.editPassword) as EditText
        val passwordConfirm = findViewById<View>(R.id.confirmPass) as EditText
        val nameTxt = findViewById<View>(R.id.editName) as EditText

        var email = emailTxt.text.toString()
        var password = passwordTxt.text.toString()
        var confirmPass=passwordConfirm.text.toString()
        var name = nameTxt.text.toString()

        if (email.isBlank() || password.isBlank() || confirmPass.isBlank()|| name.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPass) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }

       /* mDatabase.child(mAuth.currentUser!!.uid).addValueEventListener(object:
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(!snapshot.child(mAuth.currentUser!!.uid).exists()){
                    mDatabase!!.push().setValue(user)
                        .addOnCompleteListener {
                            Toast.makeText(
                                this@SignUpActivity,
                                "Thank you signup",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                }else{
                    Toast.makeText(this@SignUpActivity,"User signup failure",Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })*/
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                if (it.isSuccessful) {


                    Toast.makeText(this, "Successfully registered :)", Toast.LENGTH_LONG).show()
                    sendEmailVerification()
                    FirebaseAuth.getInstance().signOut()

                   /* mDatabase.setValue(user).addOnSuccessListener {
                        Toast.makeText(this,"User signup success",Toast.LENGTH_LONG).show()
                    }.addOnFailureListener{
                        Toast.makeText(this,"User signup failure",Toast.LENGTH_LONG).show()
                    }*/

                }else {
                    Toast.makeText(this, "Error registering, try again later :(", Toast.LENGTH_LONG).show()
                }
            }

    }
    private fun sendEmailVerification() {
        // Disable Verify Email button
        var user=FirebaseAuth.getInstance().currentUser
        if (user != null){
            user.sendEmailVerification()
                .addOnCompleteListener(object : OnCompleteListener<Void>{
                    override fun onComplete(p0: Task<Void>) {
                        if(p0.isSuccessful){
                            Toast.makeText(applicationContext, "Verification email sent to " + user.email!!, Toast.LENGTH_SHORT).show()
                        }else{
                            Log.e(TAG, "sendEmailVerification failed!", p0.exception)
                            Toast.makeText(applicationContext, "Failed to send verification email.", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        }
    }
}