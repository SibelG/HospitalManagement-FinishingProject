package com.example.hbyssystemmanagement.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.Model.Place
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.VisitedPlacesActivity

class PlaceAdapter(var placeList: List<Place>) : RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {


    class PlaceHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var recyclerView: TextView =itemView.findViewById(R.id.recyclerViewTextView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return PlaceHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.recyclerView.setText(placeList[position].name)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, VisitedPlacesActivity::class.java)
            intent.putExtra("place", placeList[position])
            intent.putExtra("info", "old")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }
}

