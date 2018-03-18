package com.songle.songle

import android.media.AudioManager
import android.media.ToneGenerator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private var song = Song()
    private var wordlist = ""
    private var mTitleText: EditText? = null
    private var mWordText: TextView? = null
    private var mResultText: TextView? = null
    private var distance: String = ""
    private var minutes: String = ""
    private var seconds: String = ""
    private var basicScore: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        mTitleText = findViewById(R.id.editText_Title) as EditText
        mWordText = findViewById(R.id.textView_Words) as TextView
        mResultText = findViewById(R.id.textView_GuessResult) as TextView

        song.number = intent.getStringExtra("number")
        song.title = intent.getStringExtra("title")
        song.artist = intent.getStringExtra("artist")
        song.link = intent.getStringExtra("link")
        wordlist = intent.getStringExtra("wordlist")
        distance = intent.getStringExtra("distance")
        basicScore = intent.getStringExtra("basicScore")
        val dis = distance.toFloat()

        mWordText?.text = wordlist
    }

    fun GotoGuess(view: View) {

        if(mTitleText != null && mResultText != null) {
            var text = mTitleText?.text.toString() as String

            if(matchWords(text, song.title)) {
                mResultText?.text = "Yes ! You win.\n\n The title: " + song.title + "\n The artist: " + song.artist + "\n Your score: " + basicScore + "\n The URL: " + song.link
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
