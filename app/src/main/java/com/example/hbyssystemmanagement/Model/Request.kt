package com.example.hbyssystemmanagement.View.Model

import com.example.hbyssystemmanagement.Model.Appointment

class Request {
    private var Name: String? = null
    private var Email: String? = null
    private var Status: String? = null
    private var Comment: String? = null
    private var Doctors: List<Appointment>? = null



    constructor(
        name: String?,
        status: String?,
        email: String?,
        comment: String?,
        doctors: List<Appointment>?
    ) {

        Name = name
        Email = email
        Status = status
        Comment = comment
        Doctors=doctors
    }

    constructor() {}

    fun getName(): String? {
        return Name
    }


    fun setName(name: String?) {
        Name = name
    }


    fun setDoctors(doctors: List<Appointment>?) {
        Doctors = doctors
    }
    fun getDoctors(): List<Appointment?>? {
        return Doctors
    }

    fun getStatus(): String? {
        return Status
    }

    fun setStatus(status: String?) {
        Status = status
    }

    fun getEmail(): String? {
        return Email
    }

    fun setEmail(email: String?) {
        Email = email
    }

    fun getComment(): String? {
        return Comment
    }

    fun setComment(comment: String?) {
        Comment = comment
    }

}