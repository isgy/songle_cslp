package com.jingyang.songname

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var title = ""
    private var number = ""
    private var artist = ""
    private var link = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!isNetworkConnected()) {
            Toast.makeText(this, "network connection failed", Toast.LENGTH_SHORT).show()
            finish()
        }

        var dt = DataTask()
        dt.execute()
    }

    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.getActiveNetworkInfo() != null
    }

    private inner class DataTask : AsyncTask<String, Void, ArrayList<Song>>() {

        private var networkOK = true
        // Parsing the data in non-ui thread
        override fun doInBackground(vararg url: String): ArrayList<Song> {

            try {
                var d = DataParser()
                var songs = d.readXML()
                if (songs.size > 0) {
//                    val num = Random().nextInt(songs.size-1)
                    val num =1
                    number = songs[num].number
                    title = songs[num].title
                    artist = songs[num].artist
                    link = songs[num].link
                } else {
                    networkOK = false
                }
                return songs
            } catch (e: Exception) {
                Log.d("XML DataInput", e.toString())
                e.printStackTrace()
                val esongs = ArrayList<Song>()
                return esongs
            }
        }

        // Executes in UI thread, after the parsing process
        override fun onPostExecute(songs: ArrayList<Song>) {

        }
    }

    fun DoDataExchange(intent2: Intent) {
        intent2.putExtra("number", number)
        intent2.putExtra("title", title);
        intent2.putExtra("artist", artist);
        intent2.putExtra("link", link);
    }


    fun GotoLevel1(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "1");

        startActivity(intent2)
    }

    fun GotoLevel2(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "2");

        startActivity(intent2)
    }

    fun GotoLevel3(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "3");

        startActivity(intent2)
    }

    fun GotoLevel4(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "4");

        startActivity(intent2)
    }

    fun GotoLevel5(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "5");

        startActivity(intent2)
    }

}
