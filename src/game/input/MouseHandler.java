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
		if(EntityManager.cameraEntities.isEmpty()){
			return null;
		}else{
			for(Entity entity: EntityManager.cameraEntities){
				if(entity.getBounds().contains(MouseInput.mousePointWorld)){
					return entity;
				}
			}
		}
		return null;
	}
}
