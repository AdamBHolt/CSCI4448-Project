package com.escape.escape;

public class LevelFactory {

    public static Level getLevel(int number){
        if (number == 1) {
            String[] models = {"player", "obstacle", "obstacle", "obstacle", "obstacle", "obstacle", "obstacle", "enemy", "enemy", "enemy", "exit"};
            int[] x = {1, 2, 4, 5, 6, 6, 7, 2, 3, 8, 7};
            int[] y = {8, 1, 3, 8, 8, 1, 1, 2, 5, 3, 3};
            return new Level(models, x, y);
        }
        else if (number == 2) {
            String[] models = {"player","exit","obstacle","obstacle","obstacle","obstacle","obstacle","enemy","enemy","enemy","enemy","enemy","enemy"};
            int[] x = {8,1,1,1,4,6,8,2,2,3,3,3,6};
            int[] y = {8,1,2,4,7,6,5,6,7,1,2,3,3};
            return new Level(models, x, y);
        }
        else if (number == 3) {
            String[] models = {"player","exit","enemy","enemy","enemy","enemy","obstacle","obstacle","obstacle","obstacle","obstacle","obstacle","obstacle"};
            int[] x = {1,8,2,5,5,6,1,3,4,5,6,7,8};
            int[] y = {1,4,6,8,3,1,5,8,4,2,3,1,7};
            return new Level(models, x, y);
        }
        return null;
    }

}
