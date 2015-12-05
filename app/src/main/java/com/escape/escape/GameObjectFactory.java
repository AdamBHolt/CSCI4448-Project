package com.escape.escape;

public class GameObjectFactory
{
    public static GameObject getGameObject(String o, int x, int y) throws InvalidObjectException
    {
        GameObject object = null;
<<<<<<< HEAD
        if(o.equals("player")){
            object = new Player(x, y);
            object.setObjectModel("player");
        }
        else if(o.equals("enemy")) {
            object = new Enemy(x, y);
            object.setObjectModel("enemy");
        }
        else if(o.equals("obstacle")) {
            object = new Obstacle(x, y);
            object.setObjectModel("obstacle");
        }
        else if(o.equals("exit")) {
            object = Exit.getExit(x, y);
            object.setObjectModel("exit");
        }
=======
        if(o.equals("player"))
            object = new Player(x, y);
        else if(o.equals("enemy"))
            object = new Enemy(x, y);
        else if(o.equals("obstacle"))
            object = new Obstacle(x, y);
        else if(o.equals("exit"))
            object = Exit.getExit(x, y);
>>>>>>> origin/master
        else
            throw(new InvalidObjectException());
        return object;
    }
}