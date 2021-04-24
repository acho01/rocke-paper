package com.gajo.rps

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    val player_human = Player("human", 0)
    val player_computer = Player("computer", 0)

    var game_not_started = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.rock_btn).setOnClickListener {
            handleButtonClick(TURN.ROCK)
        }
        findViewById<TextView>(R.id.paper_btn).setOnClickListener {
            handleButtonClick(TURN.PAPER)
        }
        findViewById<TextView>(R.id.sciss_btn).setOnClickListener {
            handleButtonClick(TURN.SCISSOR)
        }

    }

    private fun handleButtonClick(playerTurn: TURN) {
        if (game_not_started) {
            findViewById<ImageView>(R.id.human_img).setImageResource(R.drawable.rock)
            findViewById<TextView>(R.id.intro).setVisibility(View.INVISIBLE)
            findViewById<ImageView>(R.id.comp_img).setVisibility(View.VISIBLE)
            findViewById<ImageView>(R.id.human_img).setVisibility(View.VISIBLE)
            game_not_started = false
        }
        val compTurn = AppUtils.getRandomTurn()
        val playerImage = AppUtils.getImageSourceByTurn(playerTurn)
        val compImage = AppUtils.getImageSourceByTurn(compTurn)
        findViewById<ImageView>(R.id.human_img).setImageResource(playerImage)
        findViewById<ImageView>(R.id.comp_img).setImageResource(compImage)

        handleWin(playerTurn, compTurn)


    }

    private fun handleWin(playerTurn: TURN, compTurn: TURN) {
        handleScores(playerTurn, compTurn)
    }

    private fun handleScores(playerTurn: TURN, compTurn: TURN) {
        val compareResult = AppUtils.compareTurns(playerTurn, compTurn)
        val humanScore = findViewById<TextView>(R.id.player_score)
        val compScore = findViewById<TextView>(R.id.computer_score)

        if (compareResult > 0) {
            player_human.inc_score()
            humanScore.setText(player_human._score.toString())
            humanScore.setTextColor(resources.getColor(R.color.green))
            compScore.setTextColor(getResources().getColor(R.color.black))
        } else if (compareResult < 0) {
            player_computer.inc_score()
            compScore.setText(player_computer._score.toString())
            compScore.setTextColor(getResources().getColor(R.color.green))
            humanScore.setTextColor(resources.getColor(R.color.black))
        } else {
            compScore.setTextColor(getResources().getColor(R.color.yellow))
            humanScore.setTextColor(resources.getColor(R.color.yellow))
        }
    }


}