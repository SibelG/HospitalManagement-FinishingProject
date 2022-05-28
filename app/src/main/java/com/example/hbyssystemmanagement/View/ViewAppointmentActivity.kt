package com.example.hbyssystemmanagement.View

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RemoteViews
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.Interface.ApiInterface
import com.example.hbyssystemmanagement.Model.*
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.Remote.RetrofitClient
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.iid.FirebaseInstanceId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ViewAppointmentActivity : AppCompatActivity() {
    private lateinit var mToolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private var BookedAPKey:String=""
    private var Appointment_date: String? = null
    private var slot: String? = null
    private var Appointment_time: String? = null
    private var doctorID: String? = null
    lateinit var doctorList: ArrayList<Booked_Appointments>
    lateinit var manager: NotificationManager
    lateinit var channel: NotificationChannel
    lateinit var notificationBuilder: Notification.Builder

    private val channelId: String = " com.example.hbyssystemmanagement.View"
    private val description: String = "Notification Sample Description"
    private val notoficationId = 1001
    private val requestCode = 1002




    private val mDatabase = FirebaseDatabase.getInstance().reference
    private val mAuth = FirebaseAuth.getInstance()
    private lateinit var mApiInterface: ApiInterface
    private val mPatientDatabase = FirebaseDatabase.getInstance().reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_appointment)
        mToolbar = findViewById<View>(R.id.showAppointment) as Toolbar
        setSupportActionBar(mToolbar)
        supportActionBar!!.title = "Booked Appointments"
        recyclerView = findViewById<View>(R.id.show_Appointment_recyclerView) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager
        mApiInterface = RetrofitClient.getRetrofit.create(ApiInterface::class.java)

    }

    override fun onStart() {
        super.onStart()
        val query: Query = mDatabase.child("BookedAppointment/BookedAppointments").child(
            mAuth.currentUser!!.uid!!
        )
        val firebaseRecyclerOptions: FirebaseRecyclerOptions<Booked_Appointments> =
            FirebaseRecyclerOptions.Builder<Booked_Appointments>()
                .setQuery(query,Booked_Appointments::class.java)
                .build()
         val firebaseRecyclerAdapter: FirebaseRecyclerAdapter<Booked_Appointments, AppointmentViewHolder> =
            object : FirebaseRecyclerAdapter<Booked_Appointments, AppointmentViewHolder>(
                firebaseRecyclerOptions
            ) {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): AppointmentViewHolder {
                    val view: View = LayoutInflater.from(parent.context)
                        .inflate(R.layout.appointment_view_item, parent, false)
                    return AppointmentViewHolder(view)
                }

                override fun onBindViewHolder(
                    holder: AppointmentViewHolder,
                    position: Int,
                    model: Booked_Appointments
                ) {



                        holder.removeButton.setOnClickListener(View.OnClickListener {
                            doctorID = model.doctorId.toString()
                            BookedAPKey = getRef(position).key!!.toString()
                            //                                Toast.makeText(Patient_ShowBookedAppointmentActivity.this, "Key = "+BookedAPKey, Toast.LENGTH_SHORT).show();
                            Appointment_date = model.date
                            Appointment_time = model.time
                            changeSlotToTime(Appointment_time)
                            alertDialog()



                        })





                    mDatabase.child("Doctors/Doctor").child(model.doctorId!!)
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {


                                var doctorName = dataSnapshot.child("Name").getValue(
                                    String::class.java)
                                var specialization = dataSnapshot.child("Section").getValue(
                                    String::class.java)
                                System.out.println("name"+doctorName)


                                holder.name.text=doctorName
                                holder.specializationTV.text=specialization
                                holder.appointmentDate.text=model.date
                                holder.appointmentTime.text=model.time


                            }

                            override fun onCancelled(databaseError: DatabaseError) {}

                        })




                }
            }

        firebaseRecyclerAdapter.notifyDataSetChanged()
        recyclerView!!.adapter = firebaseRecyclerAdapter
        firebaseRecyclerAdapter.startListening()
    }
    inner class AppointmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        var name = itemView.findViewById<View>(R.id.appDoctorName) as TextView
        var specializationTV = itemView.findViewById<View>(R.id.appDoktorSection) as TextView
        var appointmentTime = itemView.findViewById<View>(R.id.appTime) as TextView
        var appointmentDate = itemView.findViewById<View>(R.id.appDate) as TextView
        var removeButton= itemView.findViewById<View>(R.id.remove) as Button
        var editButton=itemView.findViewById<View>(R.id.edit) as Button

   }
    private fun UpdateToken(){
        var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        var refreshToken:String= FirebaseInstanceId.getInstance().getToken().toString()
        var token:Token=Token(refreshToken)
        FirebaseDatabase.getInstance().getReference("Tokens").child(FirebaseAuth.getInstance().getCurrentUser()!!.getUid()).setValue(token)
    }
    private fun sendNotification(usertoken:String,title: String,message: String){
        var data=Data(title,message)
        var sender:DataMessage= DataMessage(data,usertoken)
        mApiInterface!!.sendNotification(sender)!!.enqueue(object : Callback<MyResponse?> {

            override fun onResponse(call: Call<MyResponse?>, response: Response<MyResponse?>) {
                if (response.code() === 200) {
                    if (response.body()!!.success== 1) {
                        Toast.makeText(
                            this@ViewAppointmentActivity,
                            "You have cancel appointment",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                    else  {
                        Toast.makeText(this@ViewAppointmentActivity, "Failed ", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<MyResponse?>, t: Throwable?) {
                Toast.makeText(
                    this@ViewAppointmentActivity,
                    "Appointment  Cancelling is unSuccess,Please try again ",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
    private fun sendAppointmentStatusUser() {
        val intent = Intent(this, LauncherActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, requestCode, intent, PendingIntent.FLAG_IMMUTABLE)


        val notificationTitle = "HBYS"
        val notificationContent = "You canceled Appointment Registration"
        val contentView = RemoteViews(packageName, R.layout.activity_after_notification)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            channel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.BLUE
            channel.enableVibration(true)

            manager.createNotificationChannel(channel)

            notificationBuilder = Notification.Builder(this, channelId)
                .setContentTitle(notificationTitle)
                .setContentText(notificationContent)
                //.setContent(contentView)
                .setSmallIcon(R.mipmap.notify)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.notify))
                .setContentIntent(pendingIntent)
            } else {
                notificationBuilder = Notification.Builder(this)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationContent)
                    //.setContent(contentView)
                    .setSmallIcon(R.mipmap.notify)
                    .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.notify))
                    .setContentIntent(pendingIntent)
            }

            manager.notify(notoficationId, notificationBuilder.build())


        /*val title:String="HBYS"
        val content:String="About Your New Appointment "
        FirebaseDatabase.getInstance().getReference().child("Tokens").child(mAuth.currentUser!!.uid).child("token").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var token:String=dataSnapshot.getValue(String::class.java).toString()
                sendNotification(token, title.trim(),content.trim())
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

        UpdateToken()*/


    }

    private fun alertDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@ViewAppointmentActivity)
        builder.setIcon(R.drawable.question).setTitle("Cancel Appointment")
        builder.setMessage("Are You Sure! Want to Cancel Appointment")
        builder.setPositiveButton("OK",
            DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                //                Toast.makeText(Patient_ShowBookedAppointmentActivity.this, Appointment_date, Toast.LENGTH_SHORT).show();
                //                Toast.makeText(Patient_ShowBookedAppointmentActivity.this, "KEY = "+BookedAPKey, Toast.LENGTH_SHORT).show();
                //                Toast.makeText(Patient_ShowBookedAppointmentActivity.this, "Slot = "+slot, Toast.LENGTH_SHORT).show();
                mDatabase.child("Appointment/Appointments").child(doctorID!!).child(Appointment_date!!).child(
                    slot!!
                ).removeValue()
                mDatabase.child("BookedAppointment/BookedAppointments").child(mAuth.currentUser!!.uid).child(
                    BookedAPKey!!
                ).removeValue()
                onStart()

                sendAppointmentStatusUser()

            })

        builder.setNegativeButton("Cancel",
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
        val dialog: AlertDialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }



    private fun changeSlotToTime(appointment_time: String?){
        when (appointment_time) {
            "08:00 AM" -> slot = "1"
            "08:20 AM" -> slot = "2"
            "08:40 AM" -> slot = "3"
            "09:00 AM" -> slot = "4"
            "09:20 AM" -> slot = "5"
            "09:40 AM" -> slot = "6"
            "10:00 AM" -> slot = "7"
            "10:20 AM" -> slot = "8"
            "10:40 AM" -> slot = "9"
            "11:00 AM" -> slot = "10"
            "11:20 AM" -> slot = "11"
            "11:40 AM" -> slot = "12"
            "02:00 PM" -> slot = "13"
            "02:20 PM" -> slot = "14"
            "02:40 PM" -> slot = "15"
            "03:00 PM" -> slot = "16"
            "03:20 PM" -> slot = "17"
            "03:40 PM" -> slot = "18"
            "04:00 PM" -> slot = "19"
            "04:20 PM" -> slot = "20"
            "04:40 PM" -> slot = "21"
            "05:00 PM" -> slot = "22"
            "05:20 PM" -> slot = "23"
            "05:40 PM" -> slot = "24"
            "06:00 PM" -> slot = "25"
            "06:20 PM" -> slot = "26"
            "06:40 PM" -> slot = "27"
            "09:00 PM" -> slot = "28"
            "09:20 PM" -> slot = "29"
            "09:40 PM" -> slot = "30"
            else -> {}
        }

    }

}
