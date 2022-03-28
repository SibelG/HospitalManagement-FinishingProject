package com.example.hbyssystemmanagement.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.Model.Message
import com.example.hbyssystemmanagement.R

class SendMessageAdapter(val messages: ArrayList<Message>):RecyclerView.Adapter<SendMessageAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.messageName.text=messages[position].text

    }

    override fun getItemCount() = messages.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var messageName: TextView =view.findViewById(R.id.messageAdapterMessageItem)

 }




}


