package com.example.hbyssystemmanagement.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.Database.Database
import com.example.hbyssystemmanagement.Model.Favourites
import com.example.hbyssystemmanagement.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.favourite_row.view.*

class FavouriteAdapter(var context: Context, var favouriteList: ArrayList<Favourites>) :
    BaseAdapter() {






    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.favourite_row, parent, false)
        } else {
            view = convertView
        }
        var favListPos=favouriteList[position]
        Picasso.with(context)
            .load(favListPos.Image)
            .into(view.img_doctor)
        view.doctorNameFav.text=favListPos.Name
        view.txt_section.text=favListPos.Section
        view.delete_view.setOnClickListener {
            val database = Database(context,null)
            database.deleteFavourites(favListPos.DoctorId, Common.currentUser!!.email)
            favouriteList = database.getAllFavlist()
            notifyDataSetChanged()
        }
        return view
    }


    override fun getCount(): Int {
        return favouriteList.size
    }

    override fun getItem(position: Int): Any {
        return favouriteList[position]
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    init {
        this.context = context
        this.favouriteList = favouriteList
    }
}