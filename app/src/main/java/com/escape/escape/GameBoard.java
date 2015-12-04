package com.escape.escape;

import java.util.ArrayList;

public class GameBoard {

	private GameObject foundObject; 
	private static GameBoard board = null;
	private ArrayList<GameObject> gameObjects;

	private GameBoard()
	{
		gameObjects = new ArrayList<>();
		foundObject = null;
	}

	private GameBoard(ArrayList<GameObject> listA)
	{
		gameObjects = new ArrayList<>();
		for(GameObject object: listA){
			gameObjects.add(object);
			
		}
		foundObject = null;
	}

	public static GameBoard getGameBoard()
	{
		if (board == null)
			board = new GameBoard();
		return board;
	}

	public static GameBoard getGameBoard(ArrayList<GameObject> listA)
	{
		if (board == null)
			board = new GameBoard(listA);
		return board;
	}

	public boolean checkLocation(int x, int y) {
		boolean isOccupied = false;
		int objectX;
		int objectY;
		if(x > 8 || x < 0 || y > 8 || y < 8){
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
	public String objectTypeAt()
	{
		if(foundObject == null)
			return "obstacle";

		String foundObjectModel = foundObject.getObjectModel();

		if(foundObjectModel.equals("obstacle"))
			return foundObjectModel;

		if(foundObject.getObjectModel().equals("enemy"))
			loseGame();

		if(foundObject.getObjectModel().equals("exit"))
			winGame();

		return null;
	}

	private void loseGame()
	{

	}

	private void winGame()
	{

	}
}