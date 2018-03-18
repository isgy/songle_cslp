package com.songle.sgl.songle

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.util.*
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory


class DataParser {

    @Throws(Exception::class)
    private fun parseXML(stream: InputStream): Document? {
        var objDocumentBuilderFactory: DocumentBuilderFactory? = null
        var objDocumentBuilder: DocumentBuilder? = null
        var doc: Document? = null
        try {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            objDocumentBuilder = objDocumentBuilderFactory!!.newDocumentBuilder()

            doc = objDocumentBuilder!!.parse(stream)
        } catch (ex: Exception) {
            throw ex
        }

        return doc
    }

    fun readWordLine(urlFolder : String): ArrayList<String> {
        val url = URL("http://www.inf.ed.ac.uk/teaching/courses/cslp/data/songs/" + urlFolder + "/words.txt")
        val connection = url.openConnection()
        val br = BufferedReader(InputStreamReader(connection.getInputStream()))
        var linelist = br.readLines()
        var newLinelist = ArrayList<String>()      //store lines from the xml
        for (i in 0 until linelist.size ) {
            var l1 = linelist.elementAt(i).trimStart()
            var l2 = l1.trimEnd()
            newLinelist.add(l2)
        }
        br.close()
        return newLinelist
    }

    fun readXML() : ArrayList<Song> {

        val url = URL("http://www.inf.ed.ac.uk/teaching/courses/cslp/data/songs/songs.xml")
        val connection = url.openConnection()
        val doc = parseXML(connection.getInputStream())

        doc!!.documentElement.normalize()
        val songList: NodeList = doc!!.getElementsByTagName("Song")
        var set = ArrayList<Song>()   //stores data for each song

        for(i in 0 until songList.length)
        {
            var songNode: Node = songList.item(i)                //get the xml for song i
            val song=Song()
            if (songNode.getNodeType() === Node.ELEMENT_NODE) {

                val elem = songNode as Element
                val mMap = mutableMapOf<String, String>()

                for(j in 0 until elem.attributes.length)
                {
                    mMap.putIfAbsent(elem.attributes.item(j).nodeName, elem.attributes.item(j).nodeValue)
                }
                song.number=elem.getElementsByTagName("Number").item(0).textContent  //get the data from the xml
                song.title=elem.getElementsByTagName("Title").item(0).textContent
                song.artist=elem.getElementsByTagName("Artist").item(0).textContent
                song.link=elem.getElementsByTagName("Link").item(0).textContent
                set.add(song)
            }
        }
        return set
    }

    fun getNodeNum(urlFolder : String, urlOption: String): Int {     //get the number of markers
        val url = URL("http://www.inf.ed.ac.uk/teaching/courses/cslp/data/songs/" + urlFolder + "/map" + urlOption + ".kml")
        val connection = url.openConnection()
        val doc = parseXML(connection.getInputStream())

        doc!!.documentElement.normalize()
        val pointList: NodeList = doc!!.getElementsByTagName("Point")

        return pointList.length
    }
}
