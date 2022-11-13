package com.example.hbyssystemmanagement.Model


class Location{
    var lat:Double=0.0
    var lng:Double=0.0

    lateinit var lngDir: String

    lateinit var latDir: String

    override fun toString(): String {
        return "ClassPojo [lng = $lng, lat = $lat]"
    }
}