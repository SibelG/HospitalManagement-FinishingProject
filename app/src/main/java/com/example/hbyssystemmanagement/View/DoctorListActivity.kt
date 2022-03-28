package com.example.hbyssystemmanagement.View


import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.Model.Doctor
import com.example.hbyssystemmanagement.adapters.DoctorAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.squareup.picasso.Target
import java.util.*


class DoctorListActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var doctorRef: DatabaseReference

    private lateinit var recyclerview:RecyclerView
    private lateinit var doctorArrayList : ArrayList<Doctor>
    private lateinit var searchdoctorArrayList : ArrayList<Doctor>

    lateinit var mSearchText : EditText
    //lateinit var FirebaseRecyclerAdapter : FirebaseRecyclerAdapter<Doctor , DoctorViewHolder>

    var target: Target? = null
    lateinit var refreshLayout: SwipeRefreshLayout
    lateinit var adapter : DoctorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_list)

        db = FirebaseFirestore.getInstance()
        mSearchText =findViewById(R.id.searchText)
        doctorRef = FirebaseDatabase.getInstance().getReference("Doctors/Doctor")

        //getDataFromFirestore()

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

        getData()
        refreshLayout = findViewById(R.id.swipeRefreshLayout)
        refreshLayout.setOnRefreshListener {

         getData()
            Handler().postDelayed(Runnable {
                refreshLayout.isRefreshing = false
            }, 4000)
        }
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

        if (searchText.isEmpty()) {

            recyclerview.adapter = DoctorAdapter(doctorArrayList)

        } else {
            doctorRef.orderByChild("Name").startAt(searchText).endAt(searchText + "\uf8ff")
                .addValueEventListener(object : ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {

                        if (snapshot.exists()) {

                            for (userSnapshot in snapshot.children) {


                                val doctor = userSnapshot.getValue(Doctor::class.java)
                                searchdoctorArrayList.add(doctor!!)

                            }
                            recyclerview.layoutManager = LinearLayoutManager(applicationContext)
                            recyclerview.setHasFixedSize(true)
                            recyclerview!!.adapter = DoctorAdapter(searchdoctorArrayList)


                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        }
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
    private fun getDataFromFirestore() {

        db.collection("Doctor").orderBy("date",Query.Direction.DESCENDING).addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
            } else {

                if(snapshot != null) {
                    if (!snapshot.isEmpty) {

                        doctorArrayList.clear()

                        val documents = snapshot.documents
                        for (document in documents) {
                            val post= document.toObject(Doctor::class.java)

                            if (post != null) {
                                doctorArrayList.add(post)
                            }
                            /*val name = document.get("Name") as String
                            val image = document.get("Image") as String
                            val section = document.get("Section") as String
                            //val timestamp = document.get("date") as Timestamp
                            //val date = timestamp.toDate()

                            val post = Doctor(image,name,section,"")*/

                        }
                        adapter!!.notifyDataSetChanged()

                    }
                }

            }
        }

    }
}

