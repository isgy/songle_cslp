package com.songle.sgl.songle

import android.os.AsyncTask
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class DownloadXmlTask(private val caller : DownloadCompleteListener) : AsyncTask<String, Void, String>() {
    override fun doInBackground(vararg urls: String): String {
        return try {
            loadXmlFromNetwork(urls[0])
        } catch (e: IOException) {
            "Unable to load content . Check your network connection"
        } catch (e: XmlPullParserException) {
            "Error parsing XML"
        }
    }
    @Throws(IOException::class)
    private fun downloadUrl(urlString: String): InputStream {
        val url = URL(urlString)
        val conn = url.openConnection() as HttpURLConnection
// Also available: HttpsURLConnection
        conn.readTimeout = 10000 // milliseconds
        conn.connectTimeout = 15000 // milliseconds
        conn.requestMethod = "GET"
        conn.doInput = true
// Starts the query
        conn.connect()
        return conn.inputStream
    }
    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        caller.downloadComplete(result)
    }

    private fun loadXmlFromNetwork(urlString: String): String {
        val result = StringBuilder()
        val stream = downloadUrl(urlString)
// Do something with stream e.g. parse as XML, build result
        return result.toString()
    }
}