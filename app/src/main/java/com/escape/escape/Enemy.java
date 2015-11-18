package com.escape.escape;

/**
 * Enemy GameObject inherits basic methods from Player
 * Overrides move method
 */
public class Enemy extends Player
{
    /**
     * Uses basic move method from parent class,
     * but adds check to see if the object that prevents movement is the Player
     */
    public void move(direction)
    {
        super.move(direction)
                //Implement static method getPlayerPosition in GameBoard
        if(this.getPosition() == GameBoard.getPlayerPosition())
            killPlayer();
    }

    /**
     * Tell the EscapeDriver to end the game.
     */
    private void killPlayer()
    {
        //Implement static method in EscapeDriver.
        EscapeDriver.loseGame()
    }
}
