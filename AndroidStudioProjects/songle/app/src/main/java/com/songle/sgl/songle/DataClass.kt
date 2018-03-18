package com.songle.songle

import com.google.android.gms.maps.model.LatLng

/**
 * Created by JY on 19/12/2017.
 */
class Song {
    @JvmField var number: String = ""
    @JvmField var artist: String = ""
    @JvmField var title: String = ""
    @JvmField var link: String = ""
}

class WordMarker {
    @JvmField var word: String = ""
    @JvmField var style: String = ""
    @JvmField var coordinate: LatLng = LatLng(-1.00,-1.00)
}

class IconStyle {
    @JvmField var id: String = ""
    @JvmField var scale: Double = 1.00
    @JvmField var url: String = ""
}

class Word {
    @JvmField var word: String = ""
    @JvmField var id: Int = -1
}