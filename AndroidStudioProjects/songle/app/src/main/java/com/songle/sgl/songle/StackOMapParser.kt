package com.songle.sgl.songle

import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.*

/**
 * Created by jing on 28/11/17.
 */
class StackOMapParser {
    data class Entry(val title: String, val summary: String, val link: String)
    // We don’t use namespaces

    private val ns: String? = null
    @Throws(XmlPullParserException::class, IOException::class)
    fun parse(input : InputStream): List<Entry> {
        input.use {
            val parser = Xml.newPullParser()
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,
                    false)
            parser.setInput(input, null)
            parser.nextTag()
            return readFeed(parser)
        }
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readFeed(parser: XmlPullParser): List<Entry> {
        val entries = ArrayList<Entry>()
        parser.require(XmlPullParser.START_TAG, ns, "feed")
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }
// Starts by looking for the entry tag
            if (parser.name == "entry") {
                entries.add(readEntry(parser))
            } else {
                skip(parser)
            }
        }
        return entries
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readEntry(parser: XmlPullParser): Entry {
        parser.require(XmlPullParser.START_TAG, ns, "placemark")
        var name = ""
        var description = ""
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG)
                continue
            when(parser.name){
                    "name" -> name = readName(parser)
                    "description" -> description = readDesc(parser)
                    "Point" -> readPoint(parser)
                else -> skip(parser)
            }
        }
        return Entry(name, summary, link)
    }
    @Throws(IOException::class, XmlPullParserException::class)
    private fun readTitle(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, ns, "title")
        val title = readText(parser)
        parser.require(XmlPullParser.END_TAG, ns, "title")
        return title
    }
    @Throws(IOException::class, XmlPullParserException::class)
    private fun readLink(parser: XmlPullParser): String {
        var link = ""
        parser.require(XmlPullParser.START_TAG, ns, "link")
        val relType = parser.getAttributeValue(null, "rel")
        if (parser.name == "link") {
            if (relType == "alternate") {
                link = parser.getAttributeValue(null, "href")
                parser.nextTag()
            }
        }
        parser.require(XmlPullParser.END_TAG, ns, "link")
        return link
    }
  /*  @Throws(IOException::class, XmlPullParserException::class)
    private fun readSummary(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, ns, "summary")
        val summary = readText(parser)
        parser.require(XmlPullParser.END_TAG, ns, "summary”)
        return summary
    }
    */
    @Throws(IOException::class, XmlPullParserException::class)
    private fun readText(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.nextTag()
        }
        return result
    }
    @Throws(XmlPullParserException::class, IOException::class)
    private fun skip(parser: XmlPullParser) {
        if (parser.eventType != XmlPullParser.START_TAG) {
            throw IllegalStateException()
        }
        var depth = 1
        while (depth != 0) {
            when (parser.next()) {
                XmlPullParser.END_TAG -> depth--
                XmlPullParser.START_TAG -> depth++
            }
        }
    }

}