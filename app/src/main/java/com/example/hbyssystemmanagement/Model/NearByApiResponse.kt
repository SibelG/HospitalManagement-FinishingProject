package com.example.hbyssystemmanagement.Model


class NearByApiResponse {

    /*val next_page_token: String? = null

    val results: Array<Results>?=null

    val html_attributions: Array<String>?=null

    val status: String? = null*/
    var next_page_token: String? = null

    lateinit var  results: Array<Results>

    lateinit var  html_attributions: Array<String>

    private val status: String? = null


}