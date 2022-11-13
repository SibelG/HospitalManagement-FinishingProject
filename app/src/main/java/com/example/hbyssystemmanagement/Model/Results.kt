package com.example.hbyssystemmanagement.Model





class Results {

        internal var photos: Array<Photos>?=null

        private val id: String? = null

        internal val place_id: String? = null

        private val icon: String? = null

        internal val vicinity: String? = null

        private val scope: String? = null

        internal val name: String? = null

        internal val rating: String? = null

        private lateinit var types: Array<String>

        private val reference: String? = null

        internal val opening_hours: OpeningHours? = null

        internal val geometry: Geometry? = null

        var formatted_phone_number:String?=null

        var business_status:String?=null

        var website:String?=null

        /* var photos: Array<Photos> ?=null

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

         var formatted_phone_number:String?=null

         var business_status:String?=null

         var website:String?=null*/



        override fun toString(): String {
                return "ClassPojo [photos = $photos, id = $id, place_id = $place_id, icon = $icon, vicinity = $vicinity, scope = $scope, name = $name, rating = $rating, types = $types, reference = $reference, opening_hours = $opening_hours, geometry = $geometry]"
        }


}
