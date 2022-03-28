package com.example.hbyssystemmanagement.View


import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.hbyssystemmanagement.Model.Section
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.Model.Doctor
import com.example.hbyssystemmanagement.adapters.DoctorAdapter
import com.example.hbyssystemmanagement.adapters.SectionAdapter
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.util.*


class SectionList : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var recyclerview:RecyclerView
    private lateinit var sectionRef: DatabaseReference
    private lateinit var sectionArrayList : ArrayList<Section>
    private lateinit var SearchSectionArrayList : ArrayList<Section>
    lateinit var FirebaseRecyclerAdapter : FirebaseRecyclerAdapter<Section, SectionViewHolder>

    lateinit var mSearchText : EditText

    var target: Target? = null
    lateinit var refreshLayout: SwipeRefreshLayout
    var adapter : SectionAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section_list)

        db = FirebaseFirestore.getInstance()
        //getDataFromFirestore()
        sectionRef = FirebaseDatabase.getInstance().getReference("Sections/Section")
        recyclerview = findViewById<RecyclerView>(R.id.recycler_section)
        mSearchText =findViewById(R.id.searchTextSection)
        /*recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)*/
        GridLayoutManager(
            this, // context
            2, // span count
            RecyclerView.VERTICAL, // orientation
            false // reverse layout
        ).apply {

            recyclerview.layoutManager = this
        }
        sectionArrayList = arrayListOf<Section>()
        SearchSectionArrayList = arrayListOf<Section>()
        getData()
        refreshLayout=findViewById(R.id.swipeRefreshLayoutSection)
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
        } )

    }
    private fun getData() {



        sectionRef!!.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val section = userSnapshot.getValue(Section::class.java)
                        sectionArrayList.add(section!!)

                    }

                    recyclerview!!.adapter = SectionAdapter(sectionArrayList)



                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
    private fun getSearchData(searchText : String) {

        if (searchText.isEmpty()) {

            recyclerview.adapter = SectionAdapter(sectionArrayList)

        } else {
            sectionRef.orderByChild("SectionName").startAt(searchText).endAt(searchText + "\uf8ff")
                .addValueEventListener(object : ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {

                        if (snapshot.exists()) {

                            for (userSnapshot in snapshot.children) {


                                val section = userSnapshot.getValue(Section::class.java)
                                SearchSectionArrayList.add(section!!)

                            }
                            recyclerview.layoutManager = LinearLayoutManager(applicationContext)
                            recyclerview.setHasFixedSize(true)
                            recyclerview!!.adapter = SectionAdapter(SearchSectionArrayList)


                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        }
    }



    // // View Holder Class

    class SectionViewHolder(var mview : View) : RecyclerView.ViewHolder(mview) {
        var sectionName: TextView =mview.findViewById(R.id.sectionName)
        var sectionImage: ImageView? = mview.findViewById(R.id.sectionImage)
    }
    private fun getDataFromFirestore() {

        db.collection("Section").orderBy("date",Query.Direction.DESCENDING).addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
            } else {

                if (snapshot != null) {
                    if (!snapshot.isEmpty) {

                        sectionArrayList.clear()

                        val documents = snapshot.documents
                        for (document in documents) {
                            val sectionName = document.get("SectionName") as String
                            val sectionImage = document.get("SectionImage") as String

                            //val timestamp = document.get("date") as Timestamp
                            //val date = timestamp.toDate()

                            val post = Section(sectionImage,sectionName)
                            sectionArrayList.add(post)
                        }
                        adapter!!.notifyDataSetChanged()

                    }
                }

            }
        }

    }
}

