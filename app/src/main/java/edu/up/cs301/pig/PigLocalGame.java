package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigLocalGame extends LocalGame {

    public PigGameState state;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    public boolean canMove(int playerIdx) {
        if (state.getId() == playerIdx) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    public boolean makeMove(GameAction action) {
        if (canMove(state.getId()) == false) {
            return false;
        }
        if (action instanceof PigRollAction) {
            state.roll();
            return true;
        }
        if (action instanceof PigHoldAction) {
            state.hold();
            return true;
        }
        return false;

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copy = new PigGameState(state);
        p.sendInfo(copy);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    public String checkIfGameOver() {
        String victory = null;
        if (state.getPlayer0Score() >= 50) {
            victory = "You Won!";
        }
        if (state.getPlayer1Score() >= 50) {
            victory = "Piggy Won!";
        }
        return victory;
    }

}// class PigLocalGame
