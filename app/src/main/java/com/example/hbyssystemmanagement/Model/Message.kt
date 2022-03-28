package com.example.hbyssystemmanagement.Model

class Message{

    constructor() //empty for firebase

    constructor(messageText: String){
        text = messageText
    }
    var text: String? = null
    var timestamp: Long = System.currentTimeMillis()

}