package com.example.hbyssystemmanagement.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.esotericsoftware.kryo.NotNull
import com.google.type.DateTime


@Entity(tableName="AppointCart")
class AppointmentItem {
    @PrimaryKey
    @NotNull
    @ColumnInfo(name="appointmentId")
    var appointId:String=""
    @ColumnInfo(name="DoctorName")
    var DoctorName:String?=null
    @ColumnInfo(name="Section")
    var Section:String=""
    /*@ColumnInfo(name="Time")
    var appointTime:DateTime*/



}