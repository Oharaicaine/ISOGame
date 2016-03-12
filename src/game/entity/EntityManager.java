package game.entity;

import java.util.concurrent.CopyOnWriteArrayList;

import game.entity.entityLiving.EntityPlayer;
import game.maths.Vector3f;

public class EntityManager {
	
	public static CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();
	public static CopyOnWriteArrayList<Entity> loadedEntities = new CopyOnWriteArrayList<Entity>();
	
	public EntityPlayer player;
	
	public EntityManager() {
		player = new EntityPlayer(new Vector3f(500, 500, 0.2f));
	}
	
	public void update(){
		for(Entity entity : entities){
			entity.update();
		}
		player.update();
	}
	
	public void render(){
		for(Entity entity : loadedEntities){
			entity.render();
		}
		player.render();
		
	}
	
	public static void createEntity(Entity entity){
		entities.add(entity);
	}
	
	public static void removeEntity(Entity entity){
		entities.remove(entity);
		if(loadedEntities.contains(entity))loadedEntities.remove(entity);
	}

}
