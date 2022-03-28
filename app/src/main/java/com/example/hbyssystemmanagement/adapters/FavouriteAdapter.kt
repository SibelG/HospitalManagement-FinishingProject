package com.example.hbyssystemmanagement.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.NonNull
import com.example.hbyssystemmanagement.Model.Favourites
import com.example.hbyssystemmanagement.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.favourite_row.view.*

class FavouriteAdapter(context: Context, favouriteList: ArrayList<Favourites>) :
    BaseAdapter() {


    var context: Context
    var favouriteList: ArrayList<Favourites>

    @NonNull
    /*override fun onCreateViewHolder(
        @NonNull parent: ViewGroup,
        viewType: Int
    ): FavouriteViewHolder {
        val itemView: View = LayoutInflater.from(context)
            .inflate(R.layout.favourite_row, parent, false)
        return FavouriteViewHolder(itemView)
    }

    override fun onBindViewHolder(@NonNull holder: FavouriteViewHolder, position: Int) {
        Picasso.with(context)
            .load(favouriteList[position].Image)
            .into(holder.img_doctor)
        holder.txt_doctor_name.text=favouriteList[position].Name
        holder.txt_section.text=favouriteList[position].Section

    }

    override fun getItemCount(): Int {
        return favouriteList.size
    }*/

    override fun getCount(): Int {
        return favouriteList.size
    }

    override fun getItem(position: Int): Any {
        return favouriteList[position]
    }

    /*fun getItem(position: Int):Favourites{
        return favouriteList.get(position)

    }*/

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

    /*fun removeItem(position: Int) {
        favouriteList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(item: Favourites, position: Int) {
        favouriteList.add(position, item)
        notifyItemInserted(position)
    }*/

    init {
        this.context = context
        this.favouriteList = favouriteList
    }
}