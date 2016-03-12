package game.world;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import game.entity.Entity;
import game.entity.EntityManager;
import game.entity.entityObjects.EntityTile;
import game.entity.entityObjects.EntityWall;
import game.maths.Vector3f;
import game.utils.Index;
import game.utils.Utils;

public class World {
	//private BufferedImage map;
	//private int mapSize = 40;
	private int chunkSize = 4;
	
	
	public World() {	
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){;
				ChunkManager.chunks.add(new Chunk(new Vector3f(	x * (Index.TILESIZE * chunkSize),
																y * ((Index.TILESIZE*0.5f)*chunkSize), 0.1f)));	
			}
		}
		//ChunkManager.chunks.add(new Chunk(new Vector3f(0f,0f,0.1f)));
		//ChunkManager.chunks.add(new Chunk(new Vector3f(96f*chunkSize,(96f*0.5f)*chunkSize,0.1f)));
		//ChunkManager.chunks.add(new Chunk(new Vector3f(96f*chunkSize,0.0f, 0.1f)));
	}
	
/*	private void initMap() {
		for(int x = 0; x < mapSize; x++){
			for(int y = 0; y < mapSize; y++){
				int col = map.getRGB(x, y);
				switch(col & 0xFFFFFF){
					case 0x808080:
						EntityManager.createEntity(new EntityTile(new Vector3f(x*96f, y*(96*0.6f), 0.1f)));
						//debug.add(new DebugDraw(new Vector3f(x*96, y*(96*0.6f), 1.0f)));
						break;
					case 0x404040:
						//EntityManager.createEntity(new EntityTile(new Vector3f(x*96f, y*96f, 0.1f)));
						EntityManager.createEntity(new EntityWall(new Vector3f(x*96f, y*96f, 0.1f)));
						break;	
				}
			}
		}	
		for(int x = 0; x < mapSize; x++){
			for(int y = 0; y < mapSize; y++){
				int col = map.getRGB(x, y);
				switch(col & 0xFFFFFF){
					case 0x808080:
						EntityManager.createEntity(new EntityTile(new Vector3f((x*96)+(96*0.5f), y*(96*0.6f)+(96*0.3f), 0.0f)));
						break;
					case 0x404040:
						EntityManager.createEntity(new EntityTile(new Vector3f((x*96)+(96*0.5f), y*(96*0.6f)+(96*0.3f), 0.0f)));
						break;	
				}
			}
		}		
	}*/

}
