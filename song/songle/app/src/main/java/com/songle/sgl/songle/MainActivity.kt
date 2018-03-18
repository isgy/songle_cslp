package com.songle.sgl.songle

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private var mListView: ListView? = null
    var titleItems = ArrayList<String>()
    var numItems = ArrayList<String>()
    var artistItems = ArrayList<String>()sa\
    var linkItems = ArrayList<String>()
    var listItems = ArrayList<String>()
    var cumScore = "0"
    private var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListView = findViewById<ListView>(R.id.MW_ListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        mListView?.adapter = adapter

        if (!isNetworkConnected()) {
            Toast.makeText(this, "no network connection" +
                    "", Toast.LENGTH_SHORT).show()
            finish()
        }

        var dt = DataTask()
        dt.execute()

        mListView?.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(context, OptionActivity::class.java)
            intent.putExtra("number", numItems[position]);
            intent.putExtra("title", titleItems[position]);
            intent.putExtra("artist", artistItems[position]);
            intent.putExtra("link", linkItems[position]);
            intent.putExtra("cumScore", cumScore);

            startActivity(intent)
        }
    }

    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return cm.getActiveNetworkInfo() != null;
    }

    private inner class DataTask : AsyncTask<String, Void, ArrayList<Song>>() {

        var networkOK = true
        // Parsing the data in non-ui thread
        override fun doInBackground(vararg url: String): ArrayList<Song> {

            try {
                var d = DataParser()
                var songs = d.readXML()
                if (songs.size > 0) {
                    val titles = readFile()
                    for (i in 0 until songs.size - 1) {
                        val music = songs[i]
                        numItems.add(music.number)
                        titleItems.add(music.title)
                        artistItems.add(music.artist)
                        linkItems.add(music.link)
                        var notExist = true
                        if (titles.size > 0) {
                            for (j in 0..titles.size - 1) {
                                if(titles[j].contains("<>")) {
                                    var seq = titles[j].splitToSequence("<>")
                                    val title = seq.elementAt(0)
                                    if (title == music.title) {
                                        val score = seq.elementAt(1)
                                        val pDate = seq.elementAt(2)
                                        val snum = music.number
                                        var item = "$snum completed with a score of %$score"
                                        if (Build.VERSION.SDK_INT >= 26) {
                                            item += " on $pDate"
                                        }
                                        listItems.add(item)
                                        notExist = false
                                        break
                                    }
                                }
                            }
                        }
                        if (notExist) {
                            val title = music.number
                            listItems.add(title)
                        }
                    }
                    if(titles.size>0) {
                        if(titles[titles.size-1].contains("cumScore:")) {
                            var cum = titles[titles.size-1]
                            cumScore = cum.replace("cumScore:","")
                        }
                        else {
                            cumScore = "0"
                        }
                    }

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


            val adapter = mListView?.adapter as BaseAdapter
            adapter.notifyDataSetChanged()

        }

        fun readFile(): ArrayList<String> {
            var titleList = ArrayList<String>()
            if (fileList().contains("wordMusic.txt")) {
                try {
                    val file = InputStreamReader(openFileInput("wordMusic.txt"))
                    val br = BufferedReader(file)
                    var lines = br.readLines()
                    val num = lines.size
                    var item = ""
                    for (i in 0..num - 1) {
                        var line = lines[i]
                        line = line.replace("\t", "")
                        line = line.replace("\n", "")
                        titleList.add(line)
                    }
                    br.close()
                    file.close()
                } catch (e: IOException) {
                }
            }
            return titleList
        }

    }
}