package game.entity;

import java.util.concurrent.CopyOnWriteArrayList;

import game.camera.Camera;
import game.entity.entityLiving.Player;
import game.graphics.Shader;
import game.main.Main;
import game.maths.Vector3f;
import game.utils.Utils;

public class EntityManager {
	
	public static CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();
	public static CopyOnWriteArrayList<Entity> cameraEntities = new CopyOnWriteArrayList<Entity>();
	
	public Player player;
	
	public EntityManager() {
		player = new Player(new Vector3f(Main.width/2, Main.height/2, 0.5f));
	}
	
	public void update(){
		for(Entity entity : entities){
			entity.update();
			if(Utils.distanceBetweenVector3f(new Vector3f(Camera.position.x+(Main.width/2), Camera.position.y+(Main.height/2), 0), entity.getPosition()) < 800){
				if(!cameraEntities.contains(entity))cameraEntities.add(entity);
			}else if(cameraEntities.contains(entity))cameraEntities.remove(entity);
		}
		player.update();
	}
	
	public void render(){
		Shader.Entity.enable();
		for(Entity entity : cameraEntities){
			entity.render();
		}
		Shader.Entity.disable();
		player.render();
		
		// Debug code
		/*Shader.primitives.enable();
		for(DebugDraw draw : World.debug){
			draw.render();
		}
		Shader.primitives.disable();*/
		
	}
	
	public static void createEntity(Entity entity){
		entities.add(entity);
	}
	
	public static void removeEntity(Entity entity){
		entities.remove(entity);
		if(cameraEntities.contains(entity))cameraEntities.remove(entity);
	}

}
