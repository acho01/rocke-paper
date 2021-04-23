package com.gajo.rps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var player_score = 0
    var computer_score = 0
    var game_not_started = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rockBtn = findViewById<TextView>(R.id.rock_btn)
        val paperBtn = findViewById<TextView>(R.id.paper_btn)
        val scissBtn = findViewById<TextView>(R.id.sciss_btn)
        rockBtn.setOnClickListener {
            handleButtonClick(rockBtn.id)
        }
        paperBtn.setOnClickListener {
            handleButtonClick(paperBtn.id)
        }
        scissBtn.setOnClickListener {
            handleButtonClick(scissBtn.id)
        }
    }

    private fun handleButtonClick(id: Int) {
//        if (game_not_started) {
//            val txt = findViewById<TextView>(R.id.intro)
//            txt.setVisibility(View.INVISIBLE);
//            game_not_started = false;
//        } else {
//            val img = findViewById<ImageView>(R.id.player_img)
//            img.setVisibility(View.VISIBLE);
//
//        }

    }
}