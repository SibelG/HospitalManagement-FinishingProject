package com.example.hbyssystemmanagement.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.R


class FavouriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var img_doctor: ImageView
    var txt_doctor_name: TextView
    var txt_section: TextView
    var view_foreground: LinearLayoutCompat

    init {
        img_doctor = itemView.findViewById(R.id.img_doctor)
        txt_doctor_name = itemView.findViewById(R.id.doctorNameFav)
        txt_section = itemView.findViewById(R.id.txt_section)
        view_foreground = itemView.findViewById(R.id.view_foreground)
    }
}