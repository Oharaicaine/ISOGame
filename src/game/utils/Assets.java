package game.utils;

import java.util.HashMap;

import game.floortile.Building;
import game.floortile.FloorTile;
import game.graphics.Texture;
import game.graphics.VertexArray;

public class Assets {

	private static Texture stone, player, map, icon;
	
	private static VertexArray tileMesh, iconMesh;
	
	public static HashMap<Integer, FloorTile> tilesMap;
	
	
	public static void loadAll(){
		 tilesMap = new HashMap<Integer, FloorTile>();
		stone = new Texture("res/stonefloor.png");
		player = new Texture("res/player.png");
		map = new Texture("res/map2.png");
		icon = new Texture("res/icon.png");
		
		//tileMesh = new VertexArray(Index.vertcies(96f, 0.0f), Index.indices(), Index.tcs());
		tileMesh = new VertexArray(Index.vertciesISO(96f, 0.0f), Index.indices(), Index.tcs());
		iconMesh = new VertexArray(Index.vertcies(64f, 0.9f), Index.indices(), Index.tcs());
		
		tilesMap.put(1, new Building());
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
	
	public static VertexArray getTileMesh() {
		return tileMesh;
	}
	
	public static Texture getIcon() {
		return icon;
	}
	public static VertexArray getIconMesh() {
		return iconMesh;
	}
	
	public static FloorTile getTilesMap(int key) {
		FloorTile result = new FloorTile();
		result = tilesMap.get(key);
		return result;
	}
	
}
