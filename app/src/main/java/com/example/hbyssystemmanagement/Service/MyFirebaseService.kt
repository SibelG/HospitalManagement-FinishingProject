package com.example.hbyssystemmanagement.Service

import com.example.hbyssystemmanagement.Model.Token
import com.example.hbyssystemmanagement.View.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseService : FirebaseMessagingService() {
    lateinit var mAuth:FirebaseAuth
    override fun onNewToken(s: String) {
        super.onNewToken(s)
        var RefreshToken = FirebaseInstanceId.getInstance().token.toString()
        if (mAuth.currentUser != null) {
            refreshToken(RefreshToken)
        }
    }

    fun refreshToken(RefreshToken: String?) {
        val db = FirebaseDatabase.getInstance()
        val tokens = db.getReference("Tokens")
        val token = Token(RefreshToken!!)
        tokens.child(mAuth.currentUser!!.uid).setValue(token)
    }
}