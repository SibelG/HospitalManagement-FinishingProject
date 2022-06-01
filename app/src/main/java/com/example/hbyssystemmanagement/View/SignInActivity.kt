package com.example.hbyssystemmanagement.View

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.Model.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rey.material.widget.CheckBox
import io.paperdb.Paper

class SignInActivity : AppCompatActivity(), View.OnClickListener, GoogleApiClient.OnConnectionFailedListener{


    lateinit var mDatabase : DatabaseReference
    private lateinit var firebaseUser : FirebaseUser
    lateinit var forgotButton:TextView
    lateinit var edtEmail:EditText
    lateinit var edtPassword:EditText
    lateinit var btn_email_create_account:Button
    lateinit var btn_email_sign_in:Button
    lateinit var btn_sign_out:Button
    lateinit var btn_verify_email:Button
    lateinit var btn_forgot_password:Button
    lateinit var email_password_buttons:LinearLayout
    lateinit var email_password_fields:LinearLayout
    lateinit var signInButton:SignInButton
    lateinit var layout_signed_in_buttons:LinearLayout
    lateinit var layout_forgot_password:LinearLayout
    private val RC_SIGN_IN = 234
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth
    private val TAG = "FirebaseEmailPassword"
    lateinit var rememberMe: CheckBox
    lateinit var googleApiClient: GoogleApiClient
    var mAuthListner: AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)



        edtEmail=findViewById(R.id.edtEmail)
        edtPassword=findViewById(R.id.edtPassword)
        email_password_buttons=findViewById(R.id.email_password_buttons)
        email_password_fields=findViewById(R.id.email_password_fields)
        layout_signed_in_buttons=findViewById(R.id.layout_signed_in_buttons)
        layout_forgot_password=findViewById(R.id.layout_forgot_password)
        btn_email_create_account=findViewById(R.id.btn_email_create_account)
        btn_forgot_password=findViewById(R.id.btn_forgot_password)
        btn_email_sign_in=findViewById(R.id.btn_email_sign_in)
        rememberMe=findViewById(R.id.RememberCheck)
        signInButton=findViewById(R.id.sign_in_button)
        mAuth= FirebaseAuth.getInstance()



        btn_email_sign_in.setOnClickListener(this)
        btn_forgot_password.setOnClickListener(this)
        btn_email_create_account.setOnClickListener(this)

//        var uid = user!!.uid

        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        signInButton.setOnClickListener{ view: View? ->
            Toast.makeText(this,"Logging In",Toast.LENGTH_SHORT).show()
            signInGoogle()
        }




        //FirebaseApp.initializeApp(this)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient= GoogleSignIn.getClient(this,gso)

        /*googleApiClient= GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()*/


        /*val user: String = Paper.book().read("User_Key".toString())
        val pass: String = Paper.book().read("Pwd_Key".toString())
        if (user != null && pass != null) {
            if (!user.isEmpty() && !pass.isEmpty()) {
                signIn(user, pass)
            }
        }*/



    }

    private  fun signInGoogle(){

        val signInIntent: Intent =googleSignInClient.signInIntent
        startActivityForResult(signInIntent,RC_SIGN_IN)

    }



    private fun handleResult(completedTask: Task<GoogleSignInAccount>){
        try {
            val account: GoogleSignInAccount? =completedTask.getResult(ApiException::class.java)
            if (account != null) {
                UpdateUI(account)
            }
        } catch (e: ApiException){
            Toast.makeText(this,e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun UpdateUI(account: GoogleSignInAccount){
        val credential= GoogleAuthProvider.getCredential(account.idToken,null)
        mAuth.signInWithCredential(credential).addOnCompleteListener {task->
            if(task.isSuccessful) {
                val user=User()
                user.email=account.email.toString()
                user.name=account.displayName.toString()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(GoogleSignIn.getLastSignedInAccount(this)!=null){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                handleResult(task)
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information


                    startActivity(Intent(applicationContext,HomeActivity::class.java))
                    Log.d(TAG, "signInWithCredential:success")
                    val user = mAuth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)

                }
            }
    }
    // [END auth_with_google]

    // [START signin]
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onClick(view: View?) {
        val i = view!!.id

        if (i == R.id.btn_email_create_account) {
            startActivity(Intent(applicationContext, SignUpActivity::class.java))
        } else if (i == R.id.btn_email_sign_in) {
            signIn(edtEmail.text.toString(), edtPassword.text.toString())
        } else if (i == R.id.btn_forgot_password) {
            startActivity(Intent(applicationContext, ResetPasswordActivity::class.java))
        }
    }



    private fun signIn(email: String, password: String) {


        Log.e(TAG, "signIn:" + email)
        if (!validateForm(email, password)) {
            return
        }
        /*var mDialog= ProgressDialog(this@SignInActivity)
        mDialog.setMessage("Please waiting..")
        mDialog.show()*/
        if(Common.connectivityInternet(applicationContext)) {
            if (rememberMe.isChecked()) {
                Paper.book().write<String>("User_Key", email)
                Paper.book().write<String>("Pwd_Key", password)
            }
            mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        Log.e(TAG, "signIn: Success!")
                        startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                        finish()

                    } else {
                        Log.e(TAG, "signIn: Fail!", task.exception)
                        Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
                        validateForm(email,password)

                    }

                }
        }else{
            Toast.makeText(this, "Please Check Your Connection!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signOut() {
        mAuth!!.signOut()

    }




    private fun validateForm(email: String, password: String): Boolean {

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(applicationContext, "Enter email address!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "Enter password!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.length < 6) {
            Toast.makeText(applicationContext, "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }



}