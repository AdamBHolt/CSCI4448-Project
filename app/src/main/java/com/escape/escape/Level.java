package com.escape.escape;

public class Level {
    String[] objectModels;
    int[] xCoords;
    int[] yCoords;

    public Level(String[] types, int[] x, int[] y){
        objectModels = types;
        xCoords = x;
        yCoords = y;
    }
}
