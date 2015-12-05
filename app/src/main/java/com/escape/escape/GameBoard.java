package com.escape.escape;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class GameBoard extends ActionBarActivity {
    private static GameBoard board = null;
    private ArrayList<GameObject> gameObjects;
    private Player player;
    private int levelNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        buildNextLevel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void buildNextLevel() {
        levelNumber += 1;
        Level level = LevelFactory.getLevel(levelNumber);
        String[] objectModels = level.objectModels;
        int[] xCoords = level.xCoords;
        int[] yCoords = level.yCoords;
        buildGameBoard(objectModels, xCoords, yCoords);
    }

    private void buildGameBoard(String[] objectModels, int[] xCoords, int[] yCoords) {
        for (int i = 1; i<9; i++){
            for (int j = 0; j<8; j++){
                String cell_number = "cell" + Integer.toString(j) + Integer.toString(i);
                int id = getResources().getIdentifier(cell_number, "id", this.getPackageName());
                ImageView image = (ImageView) findViewById(id);
                image.setImageResource(R.drawable.ice);
            }
        }
        ArrayList<GameObject> objects = new ArrayList<>();
        for (int i = 0; i < objectModels.length; i++) {
            try {
                objects.add(GameObjectFactory.getGameObject(objectModels[i], xCoords[i], yCoords[i]));
            } catch (InvalidObjectException e) {
                e.printStackTrace();
            }
        }
        this.gameObjects = objects;
        for (GameObject gameObject : gameObjects){
            String type = gameObject.getObjectModel();
            int[] location = gameObject.getPosition();
            String cell_number = "cell" + Integer.toString(location[1]-1) + Integer.toString(location[0]);
            int id = getResources().getIdentifier(cell_number, "id", this.getPackageName());
            if (type == "obstacle"){
                ImageView image = (ImageView) findViewById(id);
                image.setImageResource(R.drawable.wall);
            }
            else if (type == "player"){
                this.player = (Player) gameObject;
                ImageView image = (ImageView) findViewById(id);
                image.setImageResource(R.drawable.character);
                player.setGameObjects(gameObjects);
            }
            else if (type == "enemy"){
                ImageView image = (ImageView) findViewById(id);
                image.setImageResource(R.drawable.trap);
            }
            else if (type == "exit"){
                ImageView image = (ImageView) findViewById(id);
                image.setImageResource(R.drawable.exit);
            }
        }
    }

    public static GameBoard getGameBoard() {
        if (board == null)
            board = new GameBoard();
        return board;
    }

    public void moveUp(View view){
        int[] newPos = player.move("up");
        move(newPos);
    }
    public void moveRight(View view){
        int[] newPos = player.move("right");
        move(newPos);
    }
    public void moveLeft(View view){
        int[] newPos = player.move("left");
        move(newPos);
    }
    public void moveDown(View view){
        int[] newPos = player.move("down");
        move(newPos);
    }

    private void move(int[] newPos){
        GameObject objectInWay = player.getFoundObject();
        if (objectInWay == null || objectInWay.getObjectModel() == "obstacle") {
            if (!Arrays.equals(newPos, player.getPrevious())){
                changeImage(newPos, "character");
                changeImage(player.getPrevious(), "ice");
            }
        }
        else if (objectInWay.getObjectModel() == "enemy") {
            loseGame();
        }
        else if (objectInWay.getObjectModel() == "exit" && levelNumber < 3) {
            changeImage(player.getPrevious(), "ice");
            buildNextLevel();
        }
        else if (objectInWay.getObjectModel() == "exit" && levelNumber >= 3) {
            winGame();
        }
    }

    public void changeImage(int[] coord, String color){
        String cell_number = "cell" + Integer.toString(coord[1] - 1) + Integer.toString(coord[0]);
        int id = getResources().getIdentifier(cell_number, "id", this.getPackageName());
        ImageView image = (ImageView) findViewById(id);
        int colorId = getResources().getIdentifier(color, "drawable", this.getPackageName());
        image.setImageResource(colorId);
    }

    public void loseGame(){
        Intent intent = new Intent(GameBoard.this, LoseScreen.class);
        startActivity(intent);
    }

    public void winGame(){
        Intent intent = new Intent(GameBoard.this, WinScreen.class);
        startActivity(intent);
    }


}
