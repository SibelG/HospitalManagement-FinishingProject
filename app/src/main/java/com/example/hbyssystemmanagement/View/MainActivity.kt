package com.example.hbyssystemmanagement.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.R
import com.google.firebase.auth.FirebaseAuth
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {

    var mAuth = FirebaseAuth.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Paper.init(this)
        var UserKey:String= Paper.book().read("User_Key")
        var PassKey:String= Paper.book().read("Pwd_Key")
        if(UserKey!=null && PassKey!=null){
            if(!UserKey.isEmpty() && !PassKey.isEmpty()){
                Login(UserKey,PassKey)
            }
        }
    }
    private fun Login(userKey: String, passKey: String) {

        if(Common.connectivityInternet(applicationContext)){

            mAuth!!.signInWithEmailAndPassword(userKey, passKey)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                        finish()

                    }

                }.addOnFailureListener {
                    Toast.makeText(this@MainActivity,"Login in failed", Toast.LENGTH_LONG).show()
                }
        }else{
            Toast.makeText(this, "Please Check Your Connection!", Toast.LENGTH_SHORT).show()
            return
        }

    }
}
