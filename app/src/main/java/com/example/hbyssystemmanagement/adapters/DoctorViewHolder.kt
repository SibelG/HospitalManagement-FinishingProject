package com.example.hbyssystemmanagement.adapters

import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Menu
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.R



class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, OnCreateContextMenuListener {
    lateinit var itemClickListener: ItemClickListener
    var doctorName: TextView
    var doctorImage: ImageView
    override fun onClick(view: View) {
        itemClickListener.onClick(view, adapterPosition, false)
    }

    override fun onCreateContextMenu(
        contextMenu: ContextMenu,
        view: View,
        contextMenuInfo: ContextMenuInfo
    ) {
        contextMenu.setHeaderTitle("Select the action")
        contextMenu.add(Menu.NONE, Update, 0, "UPDATE")
        contextMenu.add(Menu.NONE, Delete, 1, "DELETE")
    }

    interface ItemClickListener {
        fun onClick(view: View?, pozition: Int, isLongClick: Boolean)
    }

    companion object {
        const val Update = Menu.FIRST
        const val Delete = Menu.FIRST + 1
    }

    init {
        doctorName = itemView.findViewById(R.id.sectionName)
        doctorImage = itemView.findViewById(R.id.sectionImage)
        itemView.setOnClickListener(this)
        itemView.setOnCreateContextMenuListener(this)
    }
}