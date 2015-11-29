package com.escape.escape;

/**
 * Player object class
 */
public class Player extends GameObject
{
    public Player(int x, int y)
    {
        super(x, y);
    }

    /**
     * Attempt to move the Player to the next available position
     * Stop if the next position is occupied
     * @param direction Direction to move
     */
    public void move(String direction)
    {
        while(nextPosEmpty(direction))
        {
            int[] currentPos = this.getPosition();

            if(direction.equals("up"))
                currentPos[1]++;
            else if(direction.equals("down"))
                currentPos[1]--;
            else if(direction.equals("right"))
                currentPos[0]++;
            else if(direction.equals("left"))
                currentPos[0]--;
            setPosition(currentPos[0], currentPos[1]);
        }
    }

    /**
     * Determines whether the next location on the board contains
     * another GameObject based on the intended move direction
     * @param direction String representation of the intended direction
     * @return true if the next position is empty, otherwise, false
     */
    public boolean nextPosEmpty(String direction)
    {
        boolean isOccupied = false;
        int[] nextPos = this.getPosition();

        if(direction.equals("up"))
        {
            nextPos[1]++;
            //Need to create static method in GameBoard to get a position
            isOccupied = GameBoard.ObjectExists(this.getXPos(), this.getYPos());
        }
        else if(direction.equals("down"))
        {
            nextPos[1]--;
            isOccupied = GameBoard.ObjectExists(this.getXPos(), this.getYPos());
        }
        else if(direction.equals("right"))
        {
            nextPos[0]++;
            isOccupied = GameBoard.ObjectExists(this.getXPos(), this.getYPos());
        }
        else if(direction.equals("left"))
        {
            nextPos[0]--;
            isOccupied = GameBoard.ObjectExists(this.getXPos(), this.getYPos());
        }

        return isOccupied;
    }
}
