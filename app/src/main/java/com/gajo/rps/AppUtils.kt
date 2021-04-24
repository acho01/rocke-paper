package com.gajo.rps

import android.widget.TextView
import androidx.annotation.DrawableRes

class AppUtils {
    companion object Factory {
        fun getImageSourceByTurn(turn: TURN) : Int{
            return when (turn) {
                TURN.PAPER -> R.drawable.paper
                TURN.ROCK -> R.drawable.rock
                TURN.SCISSOR -> R.drawable.scissors
             }
        }

        fun getTurnById(id: Int) {
            when (id) {
                R.id.paper_btn -> TURN.PAPER
                R.id.rock_btn -> TURN.ROCK
                R.id.sciss_btn -> TURN.SCISSOR
            }
        }

        fun getRandomTurn(): TURN {
            return TURN.values().random()
        }

        fun compareTurns(playerTurn: TURN, compTurn: TURN) : Int {
            if (playerTurn == compTurn) {
                return 0
            }

            if (playerTurn == TURN.SCISSOR && compTurn == TURN.PAPER) {
                return 1
            }

            if (playerTurn == TURN.ROCK && compTurn == TURN.SCISSOR) {
                return 1
            }

            if (playerTurn == TURN.PAPER && compTurn == TURN.ROCK) {
                return 1
            }

            return -1
        }
    }
}
