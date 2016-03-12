package game.utils;

import java.util.HashMap;

import game.entity.entityObjects.EntityTile;
import game.graphics.SimpleVertexArray;
import game.graphics.Texture;
import game.graphics.VertexArray;

public class Assets {

	private static Texture stone, player, map, icon, entityObject;
	
	private static VertexArray tileMesh, iconMesh, playerMesh, wallMesh;
	
	private static SimpleVertexArray worldObjectMesh;
	
	public static HashMap<Integer, EntityTile> tilesMap;
	
	
	public static void loadAll(){
		tilesMap = new HashMap<Integer, EntityTile>();
		stone = new Texture("res/stonefloor.png");
		player = new Texture("res/player.png");
		map = new Texture("res/map2.png");
		icon = new Texture("res/icon.png");
		entityObject = new Texture("res/player.png");
		
		//tileMesh = new VertexArray(Index.vertcies(96f, 0.0f), Index.indices(), Index.tcs());
		tileMesh = new VertexArray(Index.verticesIsoTile(Index.TILESIZE, 0.0f), Index.indices(), Index.tcs());
		iconMesh = new VertexArray(Index.verticesIsoTile(64f, 0.9f), Index.indices(), Index.tcs());
		playerMesh = new VertexArray(Index.vertcies(48f, 0.1f), Index.indices(), Index.tcs());
		wallMesh = new VertexArray(Index.verticesIsoWall(Index.TILESIZE, 0.2f), Index.wallIndices(), Index.tcs());
		
		//worldObjectMesh = new SimpleVertexArray(vertices, indices)
		
		tilesMap.put(1, new EntityTile());
	}
	
	public static Texture getStone() {
		return stone;
	}
	public static Texture getPlayer() {
		return player;
	}
	public static Texture getMap() {
		return map;
	}
	public static Texture getWorldObject() {
		return entityObject;
	}
	public static SimpleVertexArray getWorldObjectMesh() {
		return worldObjectMesh;
	}
	
	public static VertexArray getTileMesh() {
		return tileMesh;
	}
	public static VertexArray getPlayerMesh() {
		return playerMesh;
	}
	
	public static Texture getIcon() {
		return icon;
	}
	public static VertexArray getIconMesh() {
		return iconMesh;
	}
	
	public static EntityTile getTilesMap(int key) {
		EntityTile result = new EntityTile();
		result = tilesMap.get(key);
		return result;
	}

	public static VertexArray getWallMesh() {
		return wallMesh;
	}
	
}
