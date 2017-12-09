package com.songle.sgl.songle

//package uk.ac.ed.inf.universitymap

/**
 * A class for places of interest.
 *
 * Careful not to use Integer here: the Kotlin type is Int.
 */
class PointOfInterest (
        val id : Int,
        val name : String = "",
        val stub : String = "",
        val area : String = "",
        val type : String,
        val longitude : Double,
        val latitude : Double,
        val address1 : String ="",
        val address2 : String ="",
        val city : String = "Edinburgh",
        val postcode : String = "",
        var distanceInMetres : Float = 0F
) {
    fun showAddress() =
            if (address2 == "") {
                "$name\n$address1\n$city $postcode"
            } else {
                "$name\n$address1\n$address2\n$city $postcode"
            }
}
