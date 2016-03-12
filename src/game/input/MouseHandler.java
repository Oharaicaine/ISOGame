package game.input;

import java.util.concurrent.CopyOnWriteArrayList;

import game.entity.Entity;
import game.entity.EntityManager;

public class MouseHandler {

	public static CopyOnWriteArrayList<Entity> selectedEntities = new CopyOnWriteArrayList<Entity>();

	
	public void update(){
		if(MouseButton.mouseLeft && clickedEntity() != null){
			selectedEntities.add(clickedEntity());
		}
	}
	
	private Entity clickedEntity(){
		if(EntityManager.loadedEntities.isEmpty()){
			return null;
		}else{
			for(Entity entity: EntityManager.loadedEntities){
				if(entity.getBounds().contains((float)MouseInput.mousePointWorld.x, (float)MouseInput.mousePointWorld.y)){
					return entity;
				}
			}
		}
		return null;
	}
}
