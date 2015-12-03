package com.escape.escape;
import java.util.ArrayList;

public class EscapeDriver
{
	private ArrayList<GameObject> gameObjects;
	public static void main(String[] args){
		new EscapeDriver();
	}	
	public EscapeDriver(){
		gameObjects = new ArrayList<>();
		buildGameObjects();
		GameBoard.getGameBoard(gameObjects);
	}
	public void buildGameObjects(){
		gameObjects.add(GameObjectFactory.getGameObject("player", 1,8));
		gameObjects.add(GameObjectFactory.getGameObject("obstacle", 2,1));
		gameObjects.add(GameObjectFactory.getGameObject("obstacle", 4,3));
		gameObjects.add(GameObjectFactory.getGameObject("obstacle", 5,8));
		gameObjects.add(GameObjectFactory.getGameObject("obstacle", 6,8));
		gameObjects.add(GameObjectFactory.getGameObject("obstacle", 6,1));
		gameObjects.add(GameObjectFactory.getGameObject("obstacle", 7,1));
		gameObjects.add(GameObjectFactory.getGameObject("enemy", 2,2));
		gameObjects.add(GameObjectFactory.getGameObject("enemy", 3,5));
		gameObjects.add(GameObjectFactory.getGameObject("enemy", 8,3));
		gameObjects.add(GameObjectFactory.getGameObject("exit", 7,3));
		
	}
}
