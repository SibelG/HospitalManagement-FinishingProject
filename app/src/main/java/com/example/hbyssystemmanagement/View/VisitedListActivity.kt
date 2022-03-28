package com.example.hbyssystemmanagement.View

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.hbyssystemmanagement.Model.Place
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.adapters.PlaceAdapter
import com.example.hbyssystemmanagement.roomdb.PlaceDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class VisitedListActivity : AppCompatActivity() {


    lateinit var nameTxt: EditText
    private val mDisposable = CompositeDisposable()
    private lateinit var places: ArrayList<Place>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visited_list)

        places = ArrayList()

        val db = Room.databaseBuilder(applicationContext, PlaceDatabase::class.java, "Places")
            //.allowMainThreadQueries()
            .build()

        val placeDao = db.placeDao()

        mDisposable.add(placeDao.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }
    private fun handleResponse(placeList: List<Place>) {
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val placeAdapter = PlaceAdapter(placeList)
        recyclerView.adapter = placeAdapter
    }


    override fun onDestroy() {
        super.onDestroy()
        mDisposable.clear()
    }
}