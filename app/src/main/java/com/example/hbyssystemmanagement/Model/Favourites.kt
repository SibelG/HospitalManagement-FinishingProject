package com.example.hbyssystemmanagement.Model

/*class Favourites {
    private var name: String? = null
    private var doctorId:String?=null
    private var image: String? = null
    private var quantity: String? = null
    private var userEmail: String? = null

}*/


class Favourites {
    var DoctorId:String=""
    var Image: String=""
    var Name: String=""
    var Section: String=""
    var UserEmail:String=""

    constructor(DoctorId:String,Image: String,Name: String,Section: String,UserEmail:String) {
        this.DoctorId=DoctorId
        this.Image=Image
        this.Name=Name
        this.Section=Section
        this.UserEmail=UserEmail
    }
    constructor()




}