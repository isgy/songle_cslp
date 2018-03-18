package com.songle.sgl.songle

import android.app.Activity
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ResultActivity : AppCompatActivity() {
    private var song = Song()
    private var wordlist = ""
    private var mTitleText: EditText? = null
    private var mWordText: TextView? = null
    private var mResultText: TextView? = null
    private var basicScore: String = ""
    private var cumScore: String = ""
    private var stime: String = ""
    private var distance: String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        mTitleText = findViewById<EditText>(R.id.editText_Title)
        mWordText = findViewById<TextView>(R.id.textView_Words)
        mResultText = findViewById<TextView>(R.id.textView_GuessResult)

        song.number = intent.getStringExtra("number")
        song.title = intent.getStringExtra("title")
        song.artist = intent.getStringExtra("artist")
        song.link = intent.getStringExtra("link")
        wordlist = intent.getStringExtra("wordlist")
        basicScore = intent.getStringExtra("basicScore")
        cumScore = intent.getStringExtra("cumScore")
        distance = intent.getStringExtra("distance")

        if(Build.VERSION.SDK_INT >= 26) {
            stime = intent.getStringExtra("time")
            mWordText?.text = "You took $stime and $distance meters to complete!\n\n" + wordlist
        } else {
            mWordText?.text = wordlist
        }
    }

    fun GotoGuess(view: View) {

        if(mTitleText != null && mResultText != null) {
            var text = mTitleText?.text.toString()

            if(matchWords(text, song.title)) {
                val titleList=readFile()
                writeFile(titleList, song.title)
                mResultText?.text = "Your guess was correct! \n\n It was " + song.title + "by " + song.artist + "\n Your score is " + basicScore + "\n Your total score is now "+ cumScore + "\n The youtube video: " + song.link
                val toneG = ToneGenerator(AudioManager.STREAM_ALARM, 100)
                toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200)
            } else {
                mResultText?.text = "wrong word, try again!"
            }
        }
    }

    fun matchWords(word1: String, word2: String): Boolean {
        var w1 = filterWord(word1).capitalize()
        var w2 = filterWord(word2).capitalize()
        if(w1!=w2) {
            return false
        }
        return true
    }

    fun readFile(): ArrayList<String> {
        var titleList = ArrayList<String>()
        if(fileList().contains("wordMusic.txt")) {
            try {
                val file = InputStreamReader(openFileInput("wordMusic.txt"))
                val br = BufferedReader(file)
                var lines =br.readLines()
                val num = lines.size
                for(i in 0..num-1) {
                    var title = lines[i]
                    title = title.replace("\t", "")
                    title = title.replace("\n", "")
                    titleList.add(title)
                }
                br.close()
                file.close()
            }
            catch (e: IOException) {
            }
        }
        return titleList
    }

    fun writeFile(titleList: ArrayList<String>, newTitle: String) {
        try {
            val file = OutputStreamWriter(openFileOutput("wordMusic.txt", Activity.MODE_PRIVATE))
            var titles = ""
            var notExist = true
            if(titleList.size>0) {
                for(i in 0..titleList.size-1) {
                    val name = titleList[i]
                    val seq = name.splitToSequence("<>")
                    val oldTitle = seq.elementAt(0)
                    if(oldTitle == newTitle) {
                        notExist = false
                        val score = seq.elementAt(1).toFloat()
                        if (basicScore.toFloat()>score) {
                            val date = getCurrentDate()
                            titles += "$newTitle<>$basicScore<>$date\n"
                        } else {
                            titles += titleList[i] + "\n"
                        }
                    }
                }
            }
            if (notExist) {
                val date = getCurrentDate()
                titles += "$newTitle<>$basicScore<>$date\n"
            }
            titles += "cumScore:" + cumScore
            file.write(titles)
            file.flush()
            file.close()
        } catch (e : IOException) {
        }
        //       Toast.makeText(this, "data were recorded", Toast.LENGTH_SHORT).show()
        //       finish()
    }

    fun getCurrentDate(): String {
        if(Build.VERSION.SDK_INT >= 26) {
            val date = LocalDate.now()
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            return date.format(formatter)
        }
        return "past"
    }

    fun filterWord(word: String): String {
        var w1 = word
        w1 = w1.replace(" ","")
        w1 = w1.replace(",","")
        w1 = w1.replace(".","")
        w1 = w1.replace("!","")
        w1 = w1.replace("-","")
        w1 = w1.replace(";","")
        w1 = w1.replace(":","")
        w1 = w1.replace("(","")
        w1 = w1.replace(")","")
        w1 = w1.replace("[","")
        w1 = w1.replace("]","")
        w1 = w1.replace("?","")
        w1 = w1.replace("<","")
        w1 = w1.replace(">","")
        w1 = w1.replace("/","")
        w1 = w1.replace("\\","")
        w1 = w1.replace("\"","")
        w1 = w1.replace("`","")
        w1 = w1.replace("*","")
        return w1
    }
}
