package com.example.hbyssystemmanagement.adapters

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.Model.Section
import com.example.hbyssystemmanagement.R
import com.squareup.picasso.Picasso


class SectionAdapter(private val sections : ArrayList<Section>) : RecyclerView.Adapter<SectionAdapter.sectionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sectionViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.section_item,parent,false)
        return sectionViewHolder(v)

    }

    override fun getItemCount(): Int {
        return sections.size
    }
    fun add(item: Section, position:Int) {
        sections.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(item: Section) {
        val position = sections.indexOf(item)
        sections.removeAt(position)
        notifyItemRemoved(position)
    }
    override fun onBindViewHolder(holder: sectionViewHolder, position: Int) {
        val section = sections[position]
        holder.sectionName.text= sections.get(position).SectionName
        Picasso.with(holder.itemView.context).load(section.SectionImage).into(holder.sectionImage)
        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context,"${section.SectionName} is the best section in the world.",
            Toast.LENGTH_SHORT).show() }
        holder.itemView.setOnLongClickListener {
            remove(section)
            return@setOnLongClickListener true
        }
    }


    class sectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnCreateContextMenuListener{

        var sectionName: TextView =itemView.findViewById(R.id.sectionName)
        var sectionImage: ImageView? = itemView.findViewById(R.id.sectionImage)
        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            menu!!.setHeaderTitle("Select the action")
            menu.add(Menu.NONE, DoctorViewHolder.Update, 0, "UPDATE")
            menu.add(Menu.NONE, DoctorViewHolder.Delete, 1, "DELETE")
        }
    }
}