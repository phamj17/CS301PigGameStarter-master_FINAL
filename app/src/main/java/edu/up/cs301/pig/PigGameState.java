package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by phamj17 on 10/30/2015.
 */
public class PigGameState extends GameState {

    public int id;
    public int player0Score;
    public int player1Score;
    public int intermediateScore;
    public int dieValue;
    public int endOfHumanTurn;
    public String message;

    public PigGameState() {
        id = 0;
        player0Score = 0;
        player1Score = 0;
        intermediateScore = 0;
        dieValue = 2;
        endOfHumanTurn = 0;
    }

    public PigGameState(PigGameState state) {
        id = state.getId();
        player0Score = state.getPlayer0Score();
        player1Score = state.getPlayer1Score();
        intermediateScore = state.getIntermediateScore();
        dieValue = state.getDieValue();
        endOfHumanTurn = state.getEndOfHumanTurn();
    }

    public int getId() {
        return id;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getIntermediateScore() {
        return intermediateScore;
    }

    public int getDieValue() {
        return dieValue;
    }

    public int getEndOfHumanTurn() {
        return endOfHumanTurn;
    }

    public void hold() {
        if (id == 0) {
            player0Score = player0Score + intermediateScore;
            if (endOfHumanTurn == 0) {
                endOfHumanTurn = 1;
            } else {
                endOfHumanTurn = 0;
                id = 1;
            }
        } else if (id == 1) {
            player1Score = player1Score + intermediateScore;
            id = 0;
        }
        intermediateScore = 0;
    }

    public void roll() {
        if (endOfHumanTurn == 0) {
            Random rand = new Random();
            int die = rand.nextInt(6) + 1;
            dieValue = die;
            if (dieValue == 1) {
                intermediateScore = 0;
                if (id == 0) {
                    endOfHumanTurn = 1;
                    message = "Oh no! You rolled a 1 and lost everything ya shitter.";
                }
                else {
                    id = 0;
                }
            }
            else {

                    intermediateScore = intermediateScore + dieValue;

            }
        }
        else
        {
            id = 1;
            endOfHumanTurn = 0;
        }
    }
}


