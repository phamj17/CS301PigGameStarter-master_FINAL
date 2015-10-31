package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        Random rand = new Random();
        int move = rand.nextInt(2) + 1;
        if (move == 1)
        {
            PigHoldAction hold = new PigHoldAction(this);
            game.sendAction(hold);
        }
        else
        {
            PigRollAction roll = new PigRollAction(this);
            game.sendAction(roll);
        }
    }//receiveInfo

}
