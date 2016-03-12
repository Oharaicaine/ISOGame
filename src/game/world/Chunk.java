package game.world;

import java.util.ArrayList;
import java.util.Random;

import game.entity.entityObjects.EntityTile;
import game.entity.entityObjects.EntityWall;
import game.maths.Vector3f;
import game.utils.Index;

public class Chunk {

	public final int SIZE = 4;
	public Vector3f pos;
	public ArrayList<EntityTile> tiles = new ArrayList<EntityTile>();
	public ArrayList<EntityTile> solidTiles = new ArrayList<EntityTile>();
	private Random random = new Random();
	// size = how many tiles
	// position = center of the chunk
	
	public Chunk(Vector3f pos){
		this.pos = pos;
		generateChunk();
	}
	
	private void generateChunk(){
		for(int x = 0; x < SIZE; x++){
			for(int y = 0; y < SIZE; y++){
				if(random.nextInt(10)==0){
					EntityWall wall = new EntityWall(new Vector3f(
							pos.x+(x*Index.TILESIZE)-(SIZE*(Index.TILESIZE*0.5f)),
							pos.y+(y*(Index.TILESIZE*0.5f))-(SIZE*(Index.TILESIZE*0.5f)), 0.1f));
					tiles.add(wall);
					solidTiles.add(wall);
				}else{
					tiles.add(new EntityTile(new Vector3f(
						pos.x+(x*Index.TILESIZE)-(SIZE*(Index.TILESIZE*0.5f)),
						pos.y+(y*(Index.TILESIZE*0.5f))-(SIZE*(Index.TILESIZE*0.5f)), 0.1f)));
				}
			}
		}
		for(int x = 0; x < SIZE; x++){
			for(int y = 0; y < SIZE; y++){
				tiles.add(new EntityTile(new Vector3f(	
					pos.x+(x*Index.TILESIZE)+(Index.TILESIZE*0.5f)-(SIZE*(Index.TILESIZE*0.5f)),
					pos.y+(y*(Index.TILESIZE*0.5f)+(Index.TILESIZE*0.25f))-(SIZE*(Index.TILESIZE*0.5f)), 0.1f)));
			}
		}
	}
	
	public void update(){
		if(!tiles.isEmpty()){
			for(EntityTile tile : tiles){
				tile.update();
			}
		}	
	}
	
	public void render(){
		if(!tiles.isEmpty()){
			for(EntityTile tile : tiles){
				tile.render();
			}
		}	
	}
	
	public ArrayList<EntityTile> getTiles(){
		return tiles;
	}
	public ArrayList<EntityTile> getSolidTiles() {
		return solidTiles;
	}
	
	public Vector3f getPos() {
		return pos;
	}
}
