package com.example.hbyssystemmanagement.Model





class Results {

        var photos: Array<Photos> ?=null

        val id: String? = null

        val place_id: String? = null

        val icon: String? = null

        val vicinity: String? = null

        val scope: String? = null

        val name: String? = null

        val rating: String? = null

        val types: Array<String>?=null

        val reference: String? = null

        var opening_hours: OpeningHours?=null

        lateinit var geometry: Geometry


        override fun toString(): String {
                return "ClassPojo [photos = $photos, id = $id, place_id = $place_id, icon = $icon, vicinity = $vicinity, scope = $scope, name = $name, rating = $rating, types = $types, reference = $reference, opening_hours = $opening_hours, geometry = $geometry]"
        }


}
