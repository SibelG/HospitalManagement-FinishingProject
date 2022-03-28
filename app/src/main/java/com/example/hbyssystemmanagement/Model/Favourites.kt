package com.example.hbyssystemmanagement.Model

import com.example.hbyssystemmanagement.View.Model.Doctor

class Favourites {
    private var name: String? = null
    private var doctorId:String?=null
    private var image: String? = null
    private var quantity: String? = null
    private var userEmail: String? = null

    constructor(
        name: String?,
        doctorId: String?,
        userEmail: String?,
        quantity: String?,
        image: String?
    ) {

        this.name = name
        this.doctorId=doctorId
        this.userEmail = userEmail
        this.quantity = quantity
        this.image = image
    }

    constructor() {}

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }


    fun getImage(): String? {
        return image
    }

    fun setImage(image: String?) {
        this.image = image
    }

    fun getDescription(): String? {
        return quantity
    }

    fun setDescription(description: String?) {
        this.quantity = description
    }

    fun getDoctorId(): String? {
        return doctorId
    }

    fun setDoctorId(doctorId: String?) {
        this.doctorId = doctorId
    }

    fun getUserEmail(): String? {
        return userEmail
    }

    fun setUserEmail(userEmail: String?) {
        this.userEmail = userEmail
    }
}