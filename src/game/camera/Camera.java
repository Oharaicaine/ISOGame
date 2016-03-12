package game.camera;

import game.entity.Entity;
import game.entity.EntityManager;
import game.entity.entityObjects.EntityTile;
import game.main.Main;
import game.maths.Vector3f;
import game.utils.Utils;
import game.world.World;

public class Camera{
	
	public static Vector3f pos = new Vector3f();

	public Camera() {
	}
	
	public void update(){
		
		for(Entity entity: EntityManager.entities){
			if(Utils.distanceBetweenVector3f(new Vector3f(pos.x+(Main.width/2), pos.y+(Main.height/2), 0.0f), entity.getPosition()) < 400){
				if(!EntityManager.loadedEntities.contains(entity))EntityManager.loadedEntities.add(entity);	
			}else if(EntityManager.loadedEntities.contains(entity))EntityManager.loadedEntities.remove(entity);
		}
	}

	public static void setPosition(Vector3f pos) {
		Camera.pos = pos;
	}
	//new Vector3f(Camera.position.x+(Main.width/2), Camera.position.y+(Main.height/2), 0.0f
	
	public static float getX(){
		return pos.x;
	}
	
	public static float getY(){
		return pos.y;
	}
}
