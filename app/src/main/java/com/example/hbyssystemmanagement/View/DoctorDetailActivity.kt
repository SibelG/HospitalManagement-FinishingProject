package com.example.hbyssystemmanagement.View



import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.Database.Database
import com.example.hbyssystemmanagement.Model.Appointment
import com.example.hbyssystemmanagement.Model.Favourites
import com.example.hbyssystemmanagement.Model.Rating
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.Model.Doctor
import com.google.android.gms.maps.GoogleMap
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import com.stepstone.apprating.AppRatingDialog
import com.stepstone.apprating.listener.RatingDialogListener
import io.paperdb.Paper
import java.util.*


class DoctorDetailActivity : AppCompatActivity(), RatingDialogListener {
    lateinit var doctorName: TextView
    lateinit var doctorDesc: TextView
    lateinit var doctorSection: TextView
    lateinit var showComment: Button
    lateinit var orderButtonDesc: TextView
    lateinit var newAppointBtn: Button
    lateinit var sendMessage:Button
    lateinit var doctorImage: ImageView
    lateinit var database: FirebaseDatabase
    lateinit var doctorDetailRef: DatabaseReference
    lateinit var ratingTbl: DatabaseReference
    lateinit var UserModel: DatabaseReference
    lateinit var callDoctorTbl: DatabaseReference
    lateinit var toolbar: Toolbar
    lateinit var doctor: Doctor
    lateinit var calldoctor:TextView
    lateinit var appointment: Appointment
    lateinit var makeComment:TextView
    lateinit var imageFav:ImageView
    private final lateinit var rtn: RatingBar
    lateinit var back:ImageView
    var doctorId: String? = ""
    var getDoctorName:String=""
    var getDoctorSection:String=""
    var getDoctorImage:String=""
    private val mAuth = FirebaseAuth.getInstance()



    lateinit var addressSave:String
    lateinit var commentSave:String
    private var btnFrag: Button? = null
    var name: String?=null
    var section:String?=null
    var image:String?=null
    var desc:String?=null
    lateinit var customView: View
    private val EXTRA_LAT = "lat"
    private val EXTRA_LNG = "lng"

    private val DEFAULT_ZOOM = 15f
    private var googleMap: GoogleMap? = null


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_detail)


        database = FirebaseDatabase.getInstance()
        doctorDetailRef = database!!.getReference("Doctors/Doctor")
        doctorName = findViewById(R.id.doctorDetailName)
        doctorSection = findViewById(R.id.doctorSection)
        doctorDesc = findViewById(R.id.doctorDetail)
        doctorImage = findViewById(R.id.imageUrl)
        ratingTbl = database!!.getReference("Rating")
        UserModel=database.getReference("User")
        callDoctorTbl = database!!.getReference("CallDoctor")
        newAppointBtn=findViewById(R.id.newAppoint)
        sendMessage=findViewById(R.id.sendMessage)
        makeComment=findViewById(R.id.makeComment)
        calldoctor=findViewById(R.id.makeComment)
        imageFav=findViewById(R.id.imageFav)
        rtn = findViewById(R.id.ratingBar)
        Paper.init(this)
        btnFrag=findViewById(R.id.commentButton)


        back = findViewById(R.id.buttonBack)
        back.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@DoctorDetailActivity, DoctorListActivity::class.java)
            startActivity(intent)
        })
        if (intent != null) {
            doctorId = intent.getStringExtra("doctorId")
            getDoctorName= intent.getStringExtra("doctorName").toString()
            getDoctorSection=intent.getStringExtra("doctorSection").toString()
            getDoctorImage=intent.getStringExtra("doctorImage").toString()
            Log.d("doctorN",getDoctorName)
        }
        newAppointBtn.setOnClickListener(View.OnClickListener {
            val intent=Intent(this@DoctorDetailActivity,AppointmentActivity::class.java)
            intent.putExtra("doctorId",doctorId)
            intent.putExtra("doctorName",getDoctorName)
            startActivity(intent)
        })
        System.out.println("ıd"+doctorId)
        toolbar = findViewById(R.id.toolbarName)
        toolbar.title=intent.getStringExtra("doctorName")
        sendMessage.setOnClickListener(View.OnClickListener {

            val intent=Intent(this@DoctorDetailActivity,SendMessageActivity::class.java)
            intent.putExtra("doctorId",doctorId)
            startActivity(intent)
        })
        makeComment.setOnClickListener(View.OnClickListener {
            showRating()
        })

        if (!doctorId!!.isEmpty()) {
                getData(doctorId!!)
                //getRating(doctorId!!)

        }


        showComment = findViewById(R.id.commentButton)
        showComment.setOnClickListener(View.OnClickListener {
            showComment.setBackgroundColor(Color.BLUE)
            val intent=Intent(this@DoctorDetailActivity,ShowCommentActivity::class.java)
            intent.putExtra("doctorId",doctorId)
            startActivity(intent)

        })

        var favourite= Favourites(doctorId!!, getDoctorImage,getDoctorName,getDoctorSection, Common.currentUser!!.email!!)

        var  databaseFav= Database(this,null)
        if(databaseFav!!.isFavourite(doctorId, Common.currentUser!!.email))
            imageFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        imageFav.setOnClickListener(View.OnClickListener {
            if(!databaseFav!!.isFavourite(doctorId, Common.currentUser!!.email)){
                databaseFav!!.addFavourites(favourite)
                Log.d("favourite", favourite.Name!!)
                imageFav.setImageResource(R.drawable.ic_baseline_favorite_24)
                Toast.makeText(this@DoctorDetailActivity,"Favourite added",Toast.LENGTH_LONG).show()
            }
            else{
                databaseFav!!.deleteFavourites(doctorId, Common.currentUser!!.email)
                imageFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                Toast.makeText(this@DoctorDetailActivity,"Favourite deleted",Toast.LENGTH_LONG).show()

            }

        })



    }


    fun addFragment(fragment: Fragment, addToBackStack: Boolean, tag: String) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.doctorDetail, fragment, tag)
        ft.commitAllowingStateLoss()
    }

    private fun  getRating(doctorId:String){
        ratingTbl.orderByChild("doctorId").equalTo(doctorId)
            .addValueEventListener(object:ValueEventListener{
                var count:Int=0
                var sum:Int=0

                override fun onDataChange(snapshot: DataSnapshot) {
                    for(postSnapshot in snapshot.children){
                        var ratingItem=snapshot.getValue(Rating::class.java)
                        if(ratingItem!=null){
                            sum+=Integer.parseInt(ratingItem?.rateValue)
                            count++
                        }else{
                            continue

                        }

                    }
                    if(count!=0){
                        var avarage:Float=(sum/count).toFloat()
                        rtn.rating=avarage
                    }

                }


                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })


    }
    private fun getData(doctorId: String){


        doctorDetailRef.child(doctorId)
            .addValueEventListener(object:ValueEventListener{

                override fun onDataChange(snapshot: DataSnapshot) {

                        val doctor:Doctor? = snapshot.getValue(Doctor::class.java)
                        Picasso.with(applicationContext).load(doctor!!.Image).into(doctorImage);
                        doctorName.setText(doctor!!.Name);
                        doctorDesc.setText(doctor.Description);
                        doctorSection.setText(doctor.Section);



                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })



    }


    private fun showRating() {

        AppRatingDialog.Builder()
            .setPositiveButtonText("Submit")
            .setNegativeButtonText("Cancel")
            .setNoteDescriptions(
                Arrays.asList(
                    "Very Bad",
                    "Not Good",
                    "quite Ok",
                    "Very Good",
                    "Excellent"
                )
            )
            .setDefaultRating(1)
            .setDescription("Please some select give your rating")
            .setTitleTextColor(R.color.design_default_color_primary)
            .setDescriptionTextColor(R.color.design_default_color_primary)
            .setHint("Please write your comment here")
            .setHintTextColor(R.color.colorAccent)
            .setCommentTextColor(R.color.white)
            .setCommentBackgroundColor(R.color.design_default_color_primary_dark)
            .create(this@DoctorDetailActivity)
            .show()
    }



    override fun onNegativeButtonClicked() {
        rtn!!.cancelLongPress()
    }
    fun EncodeString(string: String): String? {
        return string.replace(".", ",")
    }
    override fun onPositiveButtonClicked(rate: Int, comment: String) {


        var userEmail=EncodeString(mAuth.currentUser!!.email!!)
        val rating = Rating(
            userEmail!!,
            doctorId!!, java.lang.String.valueOf(rate), comment)
        ratingTbl.orderByChild("userEmail").equalTo(userEmail).addListenerForSingleValueEvent(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    ratingTbl.removeValue()
                    ratingTbl.child(userEmail).setValue(rating)
                }else{
                    //ratingTbl.child(userEmail).setValue(rating)
                    ratingTbl!!.push().setValue(rating)
                        .addOnCompleteListener {
                            Toast.makeText(
                                this@DoctorDetailActivity,
                                "Thank you your rating",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                }
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}



