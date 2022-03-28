package com.example.hbyssystemmanagement.View

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.Database.Database
import com.example.hbyssystemmanagement.Model.Favourites
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.adapters.FavouriteAdapter

class FavouriteActivity : AppCompatActivity() {
    lateinit var recyclerView: ListView
    lateinit var manager: RecyclerView.LayoutManager
    var favList = ArrayList<Favourites>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)

        recyclerView = findViewById(R.id.recycler_fav)
        //recyclerView.setLayoutManager(LinearLayoutManager(this))
        //
    // loadFavourites()

    }


    private fun loadFavourites(){
        val database = Database(this,null)
        favList = database.getAllFavlist()
        val adapter= FavouriteAdapter(this, favList)
        recyclerView.adapter=adapter
    }

    override fun onResume() {
        super.onResume()
        loadFavourites()
    }
}