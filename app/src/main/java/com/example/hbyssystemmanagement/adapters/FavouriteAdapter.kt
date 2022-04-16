package com.example.hbyssystemmanagement.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.hbyssystemmanagement.Model.Favourites
import com.example.hbyssystemmanagement.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.favourite_row.view.*

class FavouriteAdapter(context: Context, favouriteList: ArrayList<Favourites>) :
    BaseAdapter() {


    var context: Context
    var favouriteList: ArrayList<Favourites>


    override fun getCount(): Int {
        return favouriteList.size
    }

    override fun getItem(position: Int): Any {
        return favouriteList[position]
    }


    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.favourite_row, parent, false)
        } else {
            view = convertView
        }
        Picasso.with(context)
            .load(favouriteList[position].Image)
            .into(view.img_doctor)
        view.doctorNameFav.text=favouriteList[position].Name
        view.txt_section.text=favouriteList[position].Section

        return view
    }

    init {
        this.context = context
        this.favouriteList = favouriteList
    }
}