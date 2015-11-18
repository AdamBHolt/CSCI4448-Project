package com.escape.escape;

/**
 * Singleton class of GameObject that returns a single Exit object
 */
public class Exit extends GameObject
{
    private static Exit theExit;
    private Exit(int x, int y)
    {
        super(x, y);
    }

    public static Exit getExit(int x, int y)
    {
        if(theExit == null)
            theExit = new Exit(x, y);
        return theExit;
    }
}
