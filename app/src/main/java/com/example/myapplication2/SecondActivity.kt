package com.example.myapplication2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.more_fragment)
        var nameTxt: TextView = findViewById(R.id.text1_name)
        var summaryTxt: TextView = findViewById(R.id.text1_information)
        val i = this.intent
        val name    = i.extras!!.getString("NAME_KEY")
        val summary = i.extras!!.getString("SUMMARY_KEY")
        title = "$name"
        nameTxt.text = name
        summaryTxt.text = summary

    }

}