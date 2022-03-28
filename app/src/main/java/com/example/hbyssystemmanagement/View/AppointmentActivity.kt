package com.example.hbyssystemmanagement.View



import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.example.hbyssystemmanagement.Interface.ApiInterface
import com.example.hbyssystemmanagement.Model.*
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.Remote.RetrofitClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.iid.FirebaseInstanceId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.HashMap


class AppointmentActivity : AppCompatActivity(), View.OnClickListener {
    private var date: String=""
    private var time = ""
    private var shift: String? = null
    private lateinit var selectDate: TextView
    private lateinit var mToolbar: Toolbar
    private lateinit var mConfirm: Button
    private var flagChecked = 0
    private var morningLayout: LinearLayout? = null
    private var eveningLayout: LinearLayout? = null
    private lateinit var calendar: Calendar
    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var c1: CardView
    private lateinit var c2: CardView
    private lateinit var c3: CardView
    private lateinit var c4: CardView
    private lateinit var c5: CardView
    private lateinit var c6: CardView
    private lateinit var c7: CardView
    private lateinit var c8: CardView
    private lateinit var c9: CardView
    private lateinit var c10: CardView
    private lateinit var c11: CardView
    private lateinit var c12: CardView
    private lateinit var c13: CardView
    private var c14: CardView? = null
    private var c15: CardView? = null
    private var c16: CardView? = null
    private var c17: CardView? = null
    private var c18: CardView? = null
    private var c19: CardView? = null
    private var c20: CardView? = null
    private var c21: CardView? = null
    private var c22: CardView? = null
    private var c23: CardView? = null
    private var c24: CardView? = null
    private var c25: CardView? = null
    private var c26: CardView? = null
    private var c27: CardView? = null
    private var c28: CardView? = null
    private var c29: CardView? = null
    private var c30: CardView? = null
    private val mDataBaseRef = FirebaseDatabase.getInstance().reference.child("Appointment/Appointments")
    private val mPatientDatabase = FirebaseDatabase.getInstance().reference
    private val mAuth = FirebaseAuth.getInstance()
    var mApiInterface:ApiInterface?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        //Toolbar
        mApiInterface = RetrofitClient.getRetrofit.create(ApiInterface::class.java)

        mToolbar = findViewById<View>(R.id.appointmentToolbar) as Toolbar
        setSupportActionBar(mToolbar)
        supportActionBar!!.setTitle("Book Appointment")
        morningLayout = findViewById<View>(R.id.morning_shift) as LinearLayout
        eveningLayout = findViewById<View>(R.id.evening_shift) as LinearLayout
        /*shift = intent.getStringExtra("Shift")
        if (shift === "Morning") {
            morningLayout!!.visibility = View.VISIBLE
            eveningLayout!!.visibility = View.GONE
        } else {
            eveningLayout!!.visibility = View.VISIBLE
            morningLayout!!.visibility = View.GONE
        }*/
        mConfirm = findViewById<View>(R.id.confirm_appointment) as Button
        mConfirm!!.setOnClickListener {
            if (flagChecked != 0 ) {
                mDataBaseRef.child(intent.getStringExtra("doctorId")!!).child(date!!)
                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            var i = 1
                            while (i <= 30) {
                                if (dataSnapshot.hasChild(i.toString())) {
                                    if (dataSnapshot.child(i.toString())
                                            .value.toString() == mAuth.currentUser!!.uid
                                    ) {
                                        Toast.makeText(
                                            this@AppointmentActivity,
                                            "You Have Already An Appointment ",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        return
                                    }
                                }
                                i++
                            }
                            if (i > 30) {
                                setTime(flagChecked)
                                mDataBaseRef.child(intent.getStringExtra("doctorId").toString())
                                    .child(date).child(flagChecked.toString()).setValue(mAuth.currentUser!!.uid)

                                val doctorName =intent.getStringExtra("doctorName")
                                val details = HashMap<String, String?>()
                                details["doctorId"] =   intent.getStringExtra("doctorId")
                                details["date"] = date
                                details["time"] = time
                                mPatientDatabase.child("BookedAppointment/BookedAppointments").child(
                                    mAuth.currentUser!!.uid
                                ).push().setValue(details)
                                //sendNotificationAppointment()



                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {}
                    })
            } else {
                Toast.makeText(
                    this@AppointmentActivity,
                    "Please Select Time Slot",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        c1 = findViewById<View>(R.id.time1) as CardView
        c2 = findViewById<View>(R.id.time2) as CardView
        c3 = findViewById<View>(R.id.time3) as CardView
        c4 = findViewById<View>(R.id.time4) as CardView
        c5 = findViewById<View>(R.id.time5) as CardView
        c6 = findViewById<View>(R.id.time6) as CardView
        c7 = findViewById<View>(R.id.time7) as CardView
        c8 = findViewById<View>(R.id.time8) as CardView
        c9 = findViewById<View>(R.id.time9) as CardView
        c10 = findViewById<View>(R.id.time10) as CardView
        c11 = findViewById<View>(R.id.time11) as CardView
        c12 = findViewById<View>(R.id.time12) as CardView
        c13 = findViewById<View>(R.id.time13) as CardView
        c14 = findViewById<View>(R.id.time14) as CardView
        c15 = findViewById<View>(R.id.time15) as CardView
        c16 = findViewById<View>(R.id.time16) as CardView
        c17 = findViewById<View>(R.id.time17) as CardView
        c18 = findViewById<View>(R.id.time18) as CardView
        c19 = findViewById<View>(R.id.time19) as CardView
        c20 = findViewById<View>(R.id.time20) as CardView
        c21 = findViewById<View>(R.id.time21) as CardView
        c22 = findViewById<View>(R.id.time22) as CardView
        c23 = findViewById<View>(R.id.time23) as CardView
        c24 = findViewById<View>(R.id.time24) as CardView
        c25 = findViewById<View>(R.id.time25) as CardView
        c26 = findViewById<View>(R.id.time26) as CardView
        c27 = findViewById<View>(R.id.time27) as CardView
        c28 = findViewById<View>(R.id.time28) as CardView
        c29 = findViewById<View>(R.id.time29) as CardView
        c30 = findViewById<View>(R.id.time30) as CardView
        selectDate = findViewById<View>(R.id.bookAppointment_selectDate) as TextView
        //date = intent.getStringExtra("Date").toString()

        selectDate!!.setOnClickListener {
            calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            datePickerDialog = DatePickerDialog(
                this@AppointmentActivity,
                { view, year, month, dayOfMonth ->
                    date = dayOfMonth.toString() + "-" + (month + 1) + "-" + year
                    // Toast.makeText(Patient_BookAppointmentActivity.this, date , Toast.LENGTH_SHORT).show();
                    selectDate!!.text = date
                    onStart()
                }, day, month, year
            )
            datePickerDialog!!.updateDate(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog!!.datePicker.minDate =
                System.currentTimeMillis() + 3 * 60 * 60 * 1000
            datePickerDialog!!.datePicker.maxDate =
                System.currentTimeMillis() + 15 * 24 * 60 * 60 * 1000
            datePickerDialog!!.show()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.time1 -> checkIsBooked(1)
            R.id.time2 -> checkIsBooked(2)
            R.id.time3 -> checkIsBooked(3)
            R.id.time4 -> checkIsBooked(4)
            R.id.time5 -> checkIsBooked(5)
            R.id.time6 -> checkIsBooked(6)
            R.id.time7 -> checkIsBooked(7)
            R.id.time8 -> checkIsBooked(8)
            R.id.time9 -> checkIsBooked(9)
            R.id.time10 -> checkIsBooked(10)
            R.id.time11 -> checkIsBooked(11)
            R.id.time12 -> checkIsBooked(12)
            R.id.time13 -> checkIsBooked(13)
            R.id.time14 -> checkIsBooked(14)
            R.id.time15 -> checkIsBooked(15)
            R.id.time16 -> checkIsBooked(16)
            R.id.time17 -> checkIsBooked(17)
            R.id.time18 -> checkIsBooked(18)
            R.id.time19 -> checkIsBooked(19)
            R.id.time20 -> checkIsBooked(20)
            R.id.time21 -> checkIsBooked(21)
            R.id.time22 -> checkIsBooked(22)
            R.id.time23 -> checkIsBooked(23)
            R.id.time24 -> checkIsBooked(24)
            R.id.time25 -> checkIsBooked(25)
            R.id.time26 -> checkIsBooked(26)
            R.id.time27 -> checkIsBooked(27)
            R.id.time28 -> checkIsBooked(28)
            R.id.time29 -> checkIsBooked(29)
            R.id.time30 -> checkIsBooked(30)
            else -> {}
        }
    }

    private fun checkIsBooked(i: Int) {
        if (flagChecked != 0) {
            setDefaultColor(flagChecked)
            flagChecked = i
            setColorGreen(i)
        } else {
            flagChecked = i
            setColorGreen(i)
        }
    }

    private fun setDefaultColor(i: Int) {
        when (i) {
            1 -> {
                c1!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c1!!.isEnabled = true
            }
            2 -> {
                c2!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c2!!.isEnabled = true
            }
            3 -> {
                c3!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c3!!.isEnabled = true
            }
            4 -> {
                c4!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c4!!.isEnabled = true
            }
            5 -> {
                c5!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c5!!.isEnabled = true
            }
            6 -> {
                c6!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c6!!.isEnabled = true
            }
            7 -> {
                c7!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c7!!.isEnabled = true
            }
            8 -> {
                c8!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c8!!.isEnabled = true
            }
            9 -> {
                c9!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c9!!.isEnabled = true
            }
            10 -> {
                c10!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c10!!.isEnabled = true
            }
            11 -> {
                c11!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c11!!.isEnabled = true
            }
            12 -> {
                c12!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c12!!.isEnabled = true
            }
            13 -> {
                c13!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c13!!.isEnabled = true
            }
            14 -> {
                c14!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c14!!.isEnabled = true
            }
            15 -> {
                c15!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c15!!.isEnabled = true
            }
            16 -> {
                c16!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c16!!.isEnabled = true
            }
            17 -> {
                c17!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c17!!.isEnabled = true
            }
            18 -> {
                c18!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c18!!.isEnabled = true
            }
            19 -> {
                c19!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c19!!.isEnabled = true
            }
            20 -> {
                c20!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c20!!.isEnabled = true
            }
            21 -> {
                c21!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c21!!.isEnabled = true
            }
            22 -> {
                c22!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c22!!.isEnabled = true
            }
            23 -> {
                c23!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c23!!.isEnabled = true
            }
            24 -> {
                c24!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c24!!.isEnabled = true
            }
            25 -> {
                c25!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c25!!.isEnabled = true
            }
            26 -> {
                c26!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c26!!.isEnabled = true
            }
            27 -> {
                c27!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c27!!.isEnabled = true
            }
            28 -> {
                c28!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c28!!.isEnabled = true
            }
            29 -> {
                c29!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c29!!.isEnabled = true
            }
            30 -> {
                c30!!.setCardBackgroundColor(resources.getColor(R.color.skyBlue))
                c30!!.isEnabled = true
            }
            else -> {}
        }
    }

    private fun setColorGRAY(i: Int) {
        when (i) {
            1 -> {
                c1!!.setCardBackgroundColor(Color.GRAY)
                c1!!.isEnabled = false
            }
            2 -> {
                c2!!.setCardBackgroundColor(Color.GRAY)
                c2!!.isEnabled = false
            }
            3 -> {
                c3!!.setCardBackgroundColor(Color.GRAY)
                c3!!.isEnabled = false
            }
            4 -> {
                c4!!.setCardBackgroundColor(Color.GRAY)
                c4!!.isEnabled = false
            }
            5 -> {
                c5!!.setCardBackgroundColor(Color.GRAY)
                c5!!.isEnabled = false
            }
            6 -> {
                c6!!.setCardBackgroundColor(Color.GRAY)
                c6!!.isEnabled = false
            }
            7 -> {
                c7!!.setCardBackgroundColor(Color.GRAY)
                c7!!.isEnabled = false
            }
            8 -> {
                c8!!.setCardBackgroundColor(Color.GRAY)
                c8!!.isEnabled = false
            }
            9 -> {
                c9!!.setCardBackgroundColor(Color.GRAY)
                c9!!.isEnabled = false
            }
            10 -> {
                c10!!.setCardBackgroundColor(Color.GRAY)
                c10!!.isEnabled = false
            }
            11 -> {
                c11!!.setCardBackgroundColor(Color.GRAY)
                c11!!.isEnabled = false
            }
            12 -> {
                c12!!.setCardBackgroundColor(Color.GRAY)
                c12!!.isEnabled = false
            }
            13 -> {
                c13!!.setCardBackgroundColor(Color.GRAY)
                c13!!.isEnabled = false
            }
            14 -> {
                c14!!.setCardBackgroundColor(Color.GRAY)
                c14!!.isEnabled = false
            }
            15 -> {
                c15!!.setCardBackgroundColor(Color.GRAY)
                c15!!.isEnabled = false
            }
            16 -> {
                c16!!.setCardBackgroundColor(Color.GRAY)
                c16!!.isEnabled = false
            }
            17 -> {
                c17!!.setCardBackgroundColor(Color.GRAY)
                c17!!.isEnabled = false
            }
            18 -> {
                c18!!.setCardBackgroundColor(Color.GRAY)
                c18!!.isEnabled = false
            }
            19 -> {
                c19!!.setCardBackgroundColor(Color.GRAY)
                c19!!.isEnabled = false
            }
            20 -> {
                c20!!.setCardBackgroundColor(Color.GRAY)
                c20!!.isEnabled = false
            }
            21 -> {
                c21!!.setCardBackgroundColor(Color.GRAY)
                c21!!.isEnabled = false
            }
            22 -> {
                c22!!.setCardBackgroundColor(Color.GRAY)
                c22!!.isEnabled = false
            }
            23 -> {
                c23!!.setCardBackgroundColor(Color.GRAY)
                c23!!.isEnabled = false
            }
            24 -> {
                c24!!.setCardBackgroundColor(Color.GRAY)
                c24!!.isEnabled = false
            }
            25 -> {
                c25!!.setCardBackgroundColor(Color.GRAY)
                c25!!.isEnabled = false
            }
            26 -> {
                c26!!.setCardBackgroundColor(Color.GRAY)
                c26!!.isEnabled = false
            }
            27 -> {
                c27!!.setCardBackgroundColor(Color.GRAY)
                c27!!.isEnabled = false
            }
            28 -> {
                c28!!.setCardBackgroundColor(Color.GRAY)
                c28!!.isEnabled = false
            }
            29 -> {
                c29!!.setCardBackgroundColor(Color.GRAY)
                c29!!.isEnabled = false
            }
            30 -> {
                c30!!.setCardBackgroundColor(Color.GRAY)
                c30!!.isEnabled = false
            }
            else -> {}
        }
    }
    private fun UpdateToken(){
        var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        var refreshToken:String= FirebaseInstanceId.getInstance().getToken().toString()
        var token:Token=Token(refreshToken)
        FirebaseDatabase.getInstance().getReference("Tokens").child(FirebaseAuth.getInstance().getCurrentUser()!!.getUid()).setValue(token)
    }
    private fun sendNotification(usertoken:String,title: String,message: String){
        var data=Data(title,message)
        var sender= DataMessage(data,usertoken)
        mApiInterface!!.sendNotification(sender)!!.enqueue(object : Callback<MyResponse?> {

            override fun onResponse(call: Call<MyResponse?>, response: Response<MyResponse?>) {
                if (response.code() === 200) {
                    if (response.body()!!.success== 1) {
                        Toast.makeText(
                            this@AppointmentActivity,
                            "You have new Appointment Registration",
                            Toast.LENGTH_LONG
                        ).show()
                        finish()
                    }
                    else  {
                        Toast.makeText(this@AppointmentActivity, "Failed ", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<MyResponse?>, t: Throwable?) {
                Toast.makeText(
                    this@AppointmentActivity,
                    "Appointment  Updating is unSuccess,Please try again ",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
    private fun sendNotificationAppointment() {
       /* val intent = intent
        val message = intent.getStringExtra("message")
        if(!message.isNullOrEmpty()) {
        }*/

        val title:String="HBYS"
        val content:String="About Your New Appointment "
            FirebaseDatabase.getInstance().getReference().child("Tokens").child(mAuth.currentUser!!.uid).child("token").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var token:String=dataSnapshot.getValue(String::class.java).toString()
                    sendNotification(token, title.trim(),content.trim())
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })

        UpdateToken()


    }
    private fun setColorGreen(i: Int) {
        when (i) {
            1 -> c1!!.setCardBackgroundColor(Color.GREEN)
            2 -> c2!!.setCardBackgroundColor(Color.GREEN)
            3 -> c3!!.setCardBackgroundColor(Color.GREEN)
            4 -> c4!!.setCardBackgroundColor(Color.GREEN)
            5 -> c5!!.setCardBackgroundColor(Color.GREEN)
            6 -> c6!!.setCardBackgroundColor(Color.GREEN)
            7 -> c7!!.setCardBackgroundColor(Color.GREEN)
            8 -> c8!!.setCardBackgroundColor(Color.GREEN)
            9 -> c9!!.setCardBackgroundColor(Color.GREEN)
            10 -> c10!!.setCardBackgroundColor(Color.GREEN)
            11 -> c11!!.setCardBackgroundColor(Color.GREEN)
            12 -> c12!!.setCardBackgroundColor(Color.GREEN)
            13 -> c13!!.setCardBackgroundColor(Color.GREEN)
            14 -> c14!!.setCardBackgroundColor(Color.GREEN)
            15 -> c15!!.setCardBackgroundColor(Color.GREEN)
            16 -> c16!!.setCardBackgroundColor(Color.GREEN)
            17 -> c17!!.setCardBackgroundColor(Color.GREEN)
            18 -> c18!!.setCardBackgroundColor(Color.GREEN)
            19 -> c19!!.setCardBackgroundColor(Color.GREEN)
            20 -> c20!!.setCardBackgroundColor(Color.GREEN)
            21 -> c21!!.setCardBackgroundColor(Color.GREEN)
            22 -> c22!!.setCardBackgroundColor(Color.GREEN)
            23 -> c23!!.setCardBackgroundColor(Color.GREEN)
            24 -> c24!!.setCardBackgroundColor(Color.GREEN)
            25 -> c25!!.setCardBackgroundColor(Color.GREEN)
            26 -> c26!!.setCardBackgroundColor(Color.GREEN)
            27 -> c27!!.setCardBackgroundColor(Color.GREEN)
            28 -> c28!!.setCardBackgroundColor(Color.GREEN)
            29 -> c29!!.setCardBackgroundColor(Color.GREEN)
            30 -> c30!!.setCardBackgroundColor(Color.GREEN)
            else -> {}
        }
    }

    private fun setTime(i: Int) {
        when (i) {
            1 -> time = "08:00 AM"
            2 -> time = "08:20 AM"
            3 -> time = "08:40 AM"
            4 -> time = "09:00 AM"
            5 -> time = "09:20 AM"
            6 -> time = "09:40 AM"
            7 -> time = "10:00 AM"
            8 -> time = "10:20 AM"
            9 -> time = "10:40 AM"
            10 -> time = "11:00 AM"
            11 -> time = "11:20 AM"
            12 -> time = "11:40 AM"
            13 -> time = "02:00 PM"
            14 -> time = "02:20 PM"
            15 -> time = "02:40 PM"
            16 -> time = "03:00 PM"
            17 -> time = "03:20 PM"
            18 -> time = "03:40 PM"
            19 -> time = "04:00 PM"
            20 -> time = "04:20 PM"
            21 -> time = "04:40 PM"
            22 -> time = "05:00 PM"
            23 -> time = "05:20 PM"
            24 -> time = "05:40 PM"
            25 -> time = "06:00 PM"
            26 -> time = "06:20 PM"
            27 -> time = "06:40 PM"
            28 -> time = "09:00 PM"
            29 -> time = "09:20 PM"
            30 -> time = "09:40 PM"
            else -> {}
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser
        if (currentUser == null) {
            Toast.makeText(
                this,
                "You are not Logged In.....Login first for further process",
                Toast.LENGTH_SHORT
            ).show()
            val login_Intent = Intent(this@AppointmentActivity, SignInActivity::class.java)
            startActivity(login_Intent)
        } else {
            flagChecked = 0
            if(mDataBaseRef!=null){
                mDataBaseRef.child(intent.getStringExtra("doctorId").toString())
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.hasChild(date!!)) {
                                mDataBaseRef.child(intent.getStringExtra("doctorId").toString())
                                    .child(
                                        date!!
                                    ).addValueEventListener(object : ValueEventListener {
                                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                                            for (i in 1..30) {
                                                if (dataSnapshot.hasChild(i.toString())) {
                                                    setColorGRAY(i)
                                                } else {
                                                    setDefaultColor(i)
                                                }
                                            }
                                        }

                                        override fun onCancelled(databaseError: DatabaseError) {}
                                    })
                            } else {
                                for (i in 1..30) {
                                    setDefaultColor(i)
                                }
                                 Toast.makeText(this@AppointmentActivity, "all time is available on this date", Toast.LENGTH_SHORT).show();
                                // mDataBaseRef.child(intent.getStringExtra("doctorId")).child(date).child(slot).child("PatientID").setValue(userId);
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {}
                    })
            }
        }
    }

}






