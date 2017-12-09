package com.songle.sgl.songle

class Placemark(val name: String, val description: String, val style: String, val longitude: Double, val latitude: Double) {

        fun asKml() = """
        <Placemark>
            <name>$name</name>
            <description>$description</description>
            <styleUrl>#$style</styleUrl>
            <Point>
               <coordinates>$longitude,$latitude,0</coordinates>
            </Point>
        </Placemark>
    """

}