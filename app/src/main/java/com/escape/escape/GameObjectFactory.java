package com.escape.escape;

public class GameObjectFactory
{
    public GameObject getGameObject(String o, int x, int y) throws InvalidObjectException
    {
        GameObject object = null;
        if(o.equals("player"))
            object = new Player(x, y);
        else if(o.equals("enemy"))
            object = new Enemy(x, y);
        else if(o.equals("obstacle"))
            object = new Obstacle(x, y);
        else if(o.equals("exit"))
            object = Exit.getExit(x, y);
        else
            throw(new InvalidObjectException);
        return object;
    }
}
