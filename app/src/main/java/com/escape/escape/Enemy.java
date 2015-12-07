package com.escape.escape;

/**
 * Enemy GameObject inherits basic methods from Player
 * Overrides move method
 */
public class Enemy extends Player
{
    public Enemy(int x, int y)
    {
        super(x, y);
    }

    /**
     * Uses basic move method from parent class,
     * but adds check to see if the object that prevents movement is the Player
     */
    public int[] move(String direction)
    {
        super.move(direction);

        return getPosition();
    }
}