package com.escape.escape;

import android.util.Log;

import java.util.ArrayList;

/**
 * Player object class
 */
public class Player extends GameObject {
    GameObject foundObject;
    ArrayList<GameObject> gameObjects;
    int[] prevPos;

    public Player(int x, int y) {
        super(x, y);
    }

    /**
     * Attempt to move the Player to the next available position
     * Stop if the next position is occupied
     * @param direction Direction to move
     * @return Array of new x,y position
     */
    public int[] move(String direction) {
        int[] currentPos = this.getPosition();
        setPrevious(this.getPosition());
        while(nextPosEmpty(direction)) {
            currentPos = this.getPosition();

            if(direction.equals("up"))
                currentPos[1]--;
            else if(direction.equals("down"))
                currentPos[1]++;
            else if(direction.equals("right"))
                currentPos[0]++;
            else if(direction.equals("left"))
                currentPos[0]--;
            setPosition(currentPos[0], currentPos[1]);
        }
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

        if(direction.equals("up")) {
            nextPos[1]--;
            isOccupied = checkLocation(nextPos);
        }
        else if(direction.equals("down")) {
            nextPos[1]++;
            isOccupied = checkLocation(nextPos);
        }
        else if(direction.equals("right")) {
            nextPos[0]++;
            isOccupied = checkLocation(nextPos);
        }
        else if(direction.equals("left")) {
            nextPos[0]--;
            isOccupied = checkLocation(nextPos);
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
}