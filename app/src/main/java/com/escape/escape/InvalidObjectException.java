package com.escape.escape;

/**
 * This class acts as an exception if an invalid GameObject is requested from the GameObjectFactory
 */
public class InvalidObjectException extends Exception
{
    public InvalidObjectException()
    {
        super("Invalid GameObject requested.");
    }

    public InvalidObjectException(String message)
    {
        super(message);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
