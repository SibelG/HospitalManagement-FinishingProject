package com.example.hbyssystemmanagement.View


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.Model.Doctor
import com.example.hbyssystemmanagement.adapters.DoctorAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Target


class DoctorListActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var doctorRef: DatabaseReference

    private lateinit var recyclerview:RecyclerView
    private lateinit var doctorArrayList : ArrayList<Doctor>
    private lateinit var searchdoctorArrayList : ArrayList<Doctor>

    lateinit var mSearchText : EditText
    lateinit var backHome:ImageView
    //lateinit var FirebaseRecyclerAdapter : FirebaseRecyclerAdapter<Doctor , DoctorViewHolder>

    var target: Target? = null
    lateinit var refreshLayout: SwipeRefreshLayout

    lateinit var adapter : DoctorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_list)

        db = FirebaseFirestore.getInstance()
        mSearchText =findViewById(R.id.searchText)
        backHome=findViewById(R.id.backHome)
        doctorRef = FirebaseDatabase.getInstance().getReference("Doctors/Doctor")



        recyclerview = findViewById<RecyclerView>(R.id.recycler_doctor)

        // this creates a vertical layout Manager

        GridLayoutManager(
            this, // context
            2, // span count
            RecyclerView.VERTICAL, // orientation
            false // reverse layout
        ).apply {

            recyclerview.layoutManager = this
        }


        doctorArrayList = arrayListOf<Doctor>()
        searchdoctorArrayList= arrayListOf<Doctor>()


        mSearchText.addTextChangedListener(object  : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                val searchText = mSearchText.getText().toString().trim()
                getSearchData(searchText)


            }
        })
        backHome.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@DoctorListActivity,HomeActivity::class.java))
        })
        getData()
        refreshLayout = findViewById(R.id.swipeRefreshLayout)
        refreshLayout.setOnRefreshListener {

            getData()
            Handler().postDelayed(Runnable {
                refreshLayout.isRefreshing = false
            }, 4000)
        }
    }





    private fun getData() {



        doctorRef!!.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){
                        val doctor = userSnapshot.getValue(Doctor::class.java)
                        doctorArrayList.add(doctor!!)

                    }

                    recyclerview!!.adapter = DoctorAdapter(doctorArrayList)



                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun getSearchData(searchText : String) {


            doctorRef.orderByChild("Name")
                .addValueEventListener(object : ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {

                        if (snapshot.exists()) {
                            searchdoctorArrayList.clear()

                            for (userSnapshot in snapshot.children) {


                                val doctor = userSnapshot.getValue(Doctor::class.java)
                                if (doctor!!.Name!!.toLowerCase().contains(searchText.toLowerCase())) {
                                    searchdoctorArrayList.add(doctor!!)
                                }


                            }

                            recyclerview!!.adapter = DoctorAdapter(searchdoctorArrayList)


                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })

    }
/*else {

            val firebaseSearchQuery = doctorRef.orderByChild("Name")

            FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<Doctor, DoctorViewHolder>(

                Doctor::class.java,
                R.layout.doctor_item,
                DoctorViewHolder::class.java,
                firebaseSearchQuery


            ) {
                override fun populateViewHolder(viewHolder: DoctorViewHolder, model: Doctor?, position: Int) {


                    viewHolder.doctorName.setText(model?.Name)
                    viewHolder.doctorSection.setText(model?.Section)
                    Picasso.get().load(model?.Image).into(viewHolder.doctorImage)

                }

            }

            recyclerview.adapter = FirebaseRecyclerAdapter

        }*/



    // // View Holder Class

   /* class DoctorViewHolder(var mview : View) : RecyclerView.ViewHolder(mview) {
        var doctorName: TextView =mview.findViewById(R.id.doctorName)
        var doctorSection: TextView =mview.findViewById(R.id.doctorBranch)
        var doctorImage: ImageView? = mview.findViewById(R.id.doctorImage)
    }*/



}

