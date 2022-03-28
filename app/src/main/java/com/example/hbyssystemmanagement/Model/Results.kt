package com.example.hbyssystemmanagement.Model

import com.google.android.libraries.places.api.model.OpeningHours


class Results {


        var geometry: Geometry? = null

        var icon: String? = null

        var id: String? = null

        var name: String? = null

        var openingHours: OpeningHours? = null

        var photos: Array<Photo> ?=null

        var placeId: String? = null

        var rating: Double? = 0.0

        var reference: String? = null

        var scope: String? = null

        var types: Array<String> ?=null

        var vicinity: String? = null

        var priceLevel: Int? = 0

        var website: String? = null

        var international_phone_number: String? = null

        var adr_address: String? = null

        var url: String? = null

        var utc_offset: String? = null

        var formatted_address:String? = null
}

