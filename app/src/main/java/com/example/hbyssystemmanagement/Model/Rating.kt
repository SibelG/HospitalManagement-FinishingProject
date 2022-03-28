package com.example.hbyssystemmanagement.Model

class Rating{
    var userEmail: String?=null
    var doctorId: String?=null
    var rateValue: String?=null
    lateinit var comment: String
    constructor(){}
    constructor( userThisEmail: String,doctorThisId: String,
                 rateThisValue: String,
                 CommentThis: String){
        this.userEmail=userThisEmail
        this.doctorId=doctorThisId
        this.rateValue=rateThisValue
        this.comment=CommentThis
    }


}





