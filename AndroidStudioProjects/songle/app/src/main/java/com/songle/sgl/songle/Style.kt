package com.songle.sgl.songle

/**
 * Created by jing on 09/11/17.
 */
    class Style(val id: String, val scale: Double, val icon: String) {

        fun asKml() = """
        <Style id="$id">
            <IconStyle>
               <scale>$scale</scale>
               <Icon>
                   <href>http://maps.google.com/mapfiles/kml/paddle/$icon.png</href>
               </Icon>
            </IconStyle>
        </Style>
    """

    }

