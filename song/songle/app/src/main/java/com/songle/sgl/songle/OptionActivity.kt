package com.songle.sgl.songle

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class OptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)
    }

    fun DoDataExchange(intent2: Intent) {
        val number = intent.getStringExtra("number")
        val title = intent.getStringExtra("title")
        val artist = intent.getStringExtra("artist")
        val link = intent.getStringExtra("link")
        val cumScore = intent.getStringExtra("cumScore")

        intent2.putExtra("number", number)
        intent2.putExtra("title", title)
        intent2.putExtra("artist", artist)
        intent2.putExtra("link", link)
        intent2.putExtra("cumScore", cumScore)
    }


    fun GotoLevel1(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "1")

        startActivity(intent2)
    }

    fun GotoLevel2(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "2")

        startActivity(intent2)
    }

    fun GotoLevel3(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "3")

        startActivity(intent2)
    }

    fun GotoLevel4(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "4")

        startActivity(intent2)
    }

    fun GotoLevel5(view: View) {
        val intent2 = Intent(this, MapsActivity::class.java)
        DoDataExchange(intent2)
        intent2.putExtra("option", "5")

        startActivity(intent2)
    }

}
