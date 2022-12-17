package com.example.bookreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView



class BookDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        val bundle: Bundle? = intent.extras
        val positionFrag1 = bundle?.get("clickedID_frag1")
        val positionFrag2 = bundle?.get("clickedID_frag2")
        val index: Int = if (positionFrag1 == null)
            positionFrag2 as Int
        else
            positionFrag1 as Int
        val authorToDisplay = findViewById<TextView>(R.id.authorDetail)
        val Cover = findViewById<ImageView>(R.id.imageView)
        val summary = findViewById<TextView>(R.id.Summary)
        val publish = findViewById<TextView>(R.id.Publish)
        val version = findViewById<TextView>(R.id.version)
        when (index){
            0 -> {
                authorToDisplay.text = getString(R.string.author1)
                summary.text = getString(R.string.summary1)
                publish.text = getString(R.string.publish1)
                version.text = getString(R.string.version1)
                Cover.setImageResource(R.drawable.download)
            }
            1 -> {
                authorToDisplay.text = getString(R.string.author2)
                summary.text = getString(R.string.summary2)
                publish.text = getString(R.string.publish2)
                version.text = getString(R.string.version2)
                Cover.setImageResource(R.drawable.download2)
            }
            2 -> {
                authorToDisplay.text = getString(R.string.author3)
                summary.text = getString(R.string.summary3)
                publish.text = getString(R.string.publish3)
                version.text = getString(R.string.version3)
                Cover.setImageResource(R.drawable.download3)
            }
            3 -> {
                authorToDisplay.text = getString(R.string.author4)
                summary.text = getString(R.string.summary4)
                publish.text = getString(R.string.publish4)
                version.text = getString(R.string.version4)
                Cover.setImageResource(R.drawable.download4)
            }
            4 -> {
                authorToDisplay.text = getString(R.string.author5)
                summary.text = getString(R.string.summary5)
                publish.text = getString(R.string.publish5)
                version.text = getString(R.string.version5)
                Cover.setImageResource(R.drawable.download5)
            }
        }
        val backToMainMenuButton : Button = findViewById(R.id.backToMainMenu)
        backToMainMenuButton.setOnClickListener{
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
        }
        //Toast.makeText(applicationContext, res.toString(), Toast.LENGTH_LONG).show()
    }
}