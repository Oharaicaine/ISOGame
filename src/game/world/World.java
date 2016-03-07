package game.world;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import game.floortile.FloorTile;
import game.maths.Vector3f;
import game.utils.Utils;

public class World {
	
	private BufferedImage map;
	private int mapSize = 100;
	

	public static ArrayList<FloorTile> tiles = new ArrayList<FloorTile>();
	
	public static CopyOnWriteArrayList<FloorTile> worldMap = new CopyOnWriteArrayList<FloorTile>();
	public static CopyOnWriteArrayList<FloorTile> cameraMap = new CopyOnWriteArrayList<FloorTile>();
	
	//public static CopyOnWriteArrayList<DebugDraw> debug = new CopyOnWriteArrayList<DebugDraw>();
	

	public World() {	
		map = Utils.loadBufferedImage("res/map2.png");
		initMap();
	}
	
	private void initMap() {
		for(int x = 0; x < mapSize; x++){
			for(int y = 0; y < mapSize; y++){
				int col = map.getRGB(x, y);
				switch(col & 0xFFFFFF){
					case 0x808080:
						worldMap.add(new FloorTile(new Vector3f(x*96, y*(96*0.6f), 0.0f)));
						//debug.add(new DebugDraw(new Vector3f(x*96, y*(96*0.6f), 1.0f)));
						break;
					case 0x404040:
						worldMap.add(new FloorTile(new Vector3f(x*96, y*96, 0.0f)));
						break;	
				}
			}
		}	
		for(int x = 0; x < mapSize; x++){
			for(int y = 0; y < mapSize; y++){
				int col = map.getRGB(x, y);
				switch(col & 0xFFFFFF){
					case 0x808080:
						worldMap.add(new FloorTile(new Vector3f((x*96)+(96*0.5f), y*(96*0.6f)+(96*0.3f), 0.0f)));
						//debug.add(new DebugDraw(new Vector3f((x*96)+(96*0.5f), y*(96*0.6f)+(96*0.3f), 1.0f)));
						break;
					case 0x404040:
						worldMap.add(new FloorTile(new Vector3f(x*96, y*96, 0.0f)));
						break;	
				}
			}
		}		
	}

}
