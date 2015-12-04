package com.escape.escape;

import java.util.ArrayList;

public class EscapeDriver
{
	//List of GameObjects
	private ArrayList<GameObject> gameObjects;

	public static void main(String[] args)
	{
		new EscapeDriver();
	}

	public EscapeDriver()
	{
		gameObjects = new ArrayList<>();
		buildGameObjects();
		GameBoard.getGameBoard(gameObjects);
	}

	public void buildGameObjects()
	{
		//List of GameObjects to be placed on the board
		String[] objectModels = {"player","obstacle","obstacle","obstacle","obstacle","obstacle","obstacle","enemy","enemy","enemy","exit"};
		int[] xCoords = {1,2,4,5,6,6,7,2,3,8,7};
		int[] yCoords = {8,1,3,8,8,1,1,2,5,3,3};

		for(int i=0; i<objectModels.length; i++) {
			try {
				gameObjects.add(GameObjectFactory.getGameObject(objectModels[i], xCoords[i], yCoords[i]));
			} catch (InvalidObjectException e) {
				e.printStackTrace();
			}
		}
	}
}