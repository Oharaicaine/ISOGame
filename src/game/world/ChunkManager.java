package game.world;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import game.camera.Camera;
import game.main.Main;
import game.maths.Vector3f;
import game.utils.Utils;

public class ChunkManager {

	public static ArrayList<Chunk> chunks = new ArrayList<Chunk>();
	public static ArrayList<Chunk> loadedChunks = new ArrayList<Chunk>();	
	
	public ChunkManager(){
		
	}
	
	public void update(){
		
		for(Chunk chunk: chunks){
			if(Utils.distanceBetweenVector3f(new Vector3f(Camera.getX()+(Main.width/2), Camera.getY()+(Main.height/2), 0.0f), chunk.getPos()) < 800){
				if(!ChunkManager.loadedChunks.contains(chunk))ChunkManager.loadedChunks.add(chunk);	
			}else if(ChunkManager.loadedChunks.contains(chunk))ChunkManager.loadedChunks.remove(chunk);
		}
		
		if(!loadedChunks.isEmpty()){
			for(Chunk chunk : loadedChunks){
				chunk.update();
			}
		}
	}
	
	public void render(){
		if(!loadedChunks.isEmpty()){
			for(Chunk chunk : loadedChunks){
				chunk.render();
			}
		}
	}
	
	public static void addChunk(Vector3f pos){
		chunks.add(new Chunk(pos));
	}
}
