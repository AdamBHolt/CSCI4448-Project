package com.escape.escape;

import android.util.Log;

import java.util.ArrayList;

/**
 * Player object class
 */
<<<<<<< HEAD
public class Player extends GameObject {
    GameObject foundObject;
    ArrayList<GameObject> gameObjects;
    int[] prevPos;

    public Player(int x, int y) {
=======
public class Player extends GameObject
{
    GameBoard gameBoard = GameBoard.getGameBoard();

    public Player(int x, int y)
    {
>>>>>>> origin/master
        super(x, y);
    }

    /**
     * Attempt to move the Player to the next available position
     * Stop if the next position is occupied
     * @param direction Direction to move
     * @return Array of new x,y position
     */
<<<<<<< HEAD
    public int[] move(String direction) {
        int[] currentPos = this.getPosition();
        setPrevious(this.getPosition());
        while(nextPosEmpty(direction)) {
            currentPos = this.getPosition();

            if(direction.equals("up"))
                currentPos[1]--;
            else if(direction.equals("down"))
                currentPos[1]++;
=======
    public int[] move(String direction)
    {
        int[] currentPos = new int[2];
        while(nextPosEmpty(direction))
        {
            currentPos = this.getPosition();

            if(direction.equals("up"))
                currentPos[1]++;
            else if(direction.equals("down"))
                currentPos[1]--;
>>>>>>> origin/master
            else if(direction.equals("right"))
                currentPos[0]++;
            else if(direction.equals("left"))
                currentPos[0]--;
            setPosition(currentPos[0], currentPos[1]);
        }
<<<<<<< HEAD
=======

>>>>>>> origin/master
        return currentPos;
    }

    /**
     * Determines whether the next location on the board contains
     * another GameObject based on the intended move direction
     * @param direction String representation of the intended direction
     * @return true if the next position is empty, otherwise, false
     */
    public boolean nextPosEmpty(String direction) {
        boolean isOccupied = false;
        int[] nextPos = this.getPosition();

<<<<<<< HEAD
        if(direction.equals("up")) {
            nextPos[1]--;
            isOccupied = checkLocation(nextPos);
=======
        if(direction.equals("up"))
        {
            nextPos[1]++;
            isOccupied = gameBoard.checkLocation(this.getXPos(), this.getYPos());
        }
        else if(direction.equals("down"))
        {
            nextPos[1]--;
            isOccupied = gameBoard.checkLocation(this.getXPos(), this.getYPos());
>>>>>>> origin/master
        }
        else if(direction.equals("down")) {
            nextPos[1]++;
            isOccupied = checkLocation(nextPos);
        }
        else if(direction.equals("right")) {
            nextPos[0]++;
<<<<<<< HEAD
            isOccupied = checkLocation(nextPos);
=======
            isOccupied = gameBoard.checkLocation(this.getXPos(), this.getYPos());
>>>>>>> origin/master
        }
        else if(direction.equals("left")) {
            nextPos[0]--;
<<<<<<< HEAD
            isOccupied = checkLocation(nextPos);
=======
            isOccupied = gameBoard.checkLocation(this.getXPos(), this.getYPos());
>>>>>>> origin/master
        }
        return !isOccupied;
    }

    public boolean checkLocation(int[] nextPos) {
        boolean isOccupied = false;
        int objectX;
        int objectY;
        int x = nextPos[0];
        int y = nextPos[1];
        if(x > 8 || x <= 0 || y > 8 || y <= 0){
            isOccupied = true;
            foundObject = null;
        }
        for(GameObject object: gameObjects){
            objectX = object.getXPos();
            objectY = object.getYPos();
            if(x == objectX && y == objectY){
                isOccupied = true;
                foundObject = object;
            }
        }
        return isOccupied;
    }
<<<<<<< HEAD

    public void setGameObjects(ArrayList<GameObject> gameObjects){
        this.gameObjects = gameObjects;
    }

    public void setPrevious(int[] prevPos){
        this.prevPos = prevPos;
    }

    public int[] getPrevious(){
        return this.prevPos;
    }

    public GameObject getFoundObject(){
        return foundObject;
    }
=======
>>>>>>> origin/master
}