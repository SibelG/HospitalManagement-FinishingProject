package com.example.hbyssystemmanagement.Model

class CallDoctor {
    var uid:String?=null
    var userEmail: String?=null
    var doctorId: String?=null
    var comment: String?=null
    var name:String?=null
    var phone:String?=null
    var lng:Double=0.0
    var lat:Double=0.0
    var address:String?=null
    constructor(){}
    constructor( userThisEmail: String,doctorThisId: String,
                 rateThisValue: String,
                 CommentThis: String){
        userEmail=userThisEmail
        doctorId=doctorThisId
        comment=CommentThis
    }
}