package com.example.hbyssystemmanagement.Interface

import com.example.hbyssystemmanagement.Model.HospitalCoordinat

interface IoListener {
    fun onLocationSuccessListener(latLngs:List<HospitalCoordinat>)
    fun onLocationFailureListener(message:String)

}