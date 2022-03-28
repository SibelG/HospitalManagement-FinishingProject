package com.example.hbyssystemmanagement.adapters

import android.content.Intent
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.View.DoctorDetailActivity
import com.example.hbyssystemmanagement.View.Model.Doctor
import com.squareup.picasso.Picasso


class DoctorAdapter(val doctors : ArrayList<Doctor>) : RecyclerView.Adapter<DoctorAdapter.doctorViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): doctorViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.doctor_item,parent,false)
            return doctorViewHolder(v)

        }

        override fun getItemCount(): Int {
            return doctors.size
        }
        fun add(item: Doctor, position:Int) {
            doctors.add(position, item)
            notifyItemInserted(position)
        }

        fun remove(item: Doctor) {
            val position = doctors.indexOf(item)
            doctors.removeAt(position)
            notifyItemRemoved(position)
        }
        override fun onBindViewHolder(holder: doctorViewHolder, position: Int) {
            val doctor = doctors[position]
            var doctorDesc: String? =doctors.get(position).Description
            holder.doctorName.text= doctors.get(position).Name
            holder.doctorSection.text= doctors.get(position).Section
            Picasso.with(holder.itemView.context).load(doctor.Image).into(holder.doctorImage)
            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DoctorDetailActivity::class.java)
                intent.putExtra("doctorId", position.toString())
                intent.putExtra("doctorName", doctors.get(position).Name)
                intent.putExtra("doctorImage", doctors.get(position).Image)
                intent.putExtra("doctorSection", doctors.get(position).Section)
                intent.putExtra("doctorDesc", doctorDesc)
                holder.itemView.context.startActivity(intent)


            }
            holder.itemView.setOnLongClickListener {
                remove(doctor)
                return@setOnLongClickListener true
            }
        }


        class doctorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnCreateContextMenuListener{

            var doctorName: TextView =itemView.findViewById(R.id.doctorName)
            var doctorSection: TextView =itemView.findViewById(R.id.doctorBranch)
            var doctorImage: ImageView? = itemView.findViewById(R.id.doctorImage)


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