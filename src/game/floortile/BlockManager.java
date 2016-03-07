package game.floortile;

import game.graphics.Shader;
import game.input.MouseButton;
import game.input.MouseInput;
import game.inventory.InventoryMouse;
import game.maths.Vector3f;
import game.world.World;

public class BlockManager {
	
	
	public void update(){
		for(FloorTile tile : World.worldMap){
			tile.update();
			if(tile.getBounds().contains(MouseInput.mousePointWorld) && MouseButton.mouseLeft && InventoryMouse.hasItem()){
				if(InventoryMouse.getItemId() == tile.getId())continue;
					//replaceTile(tile);
					Vector3f pos = tile.getPos();
					int key = InventoryMouse.getItemId();
					if(key == 1){
						FloorTile newTile = new Building(pos);
						newTile.setPos(pos);
						System.out.println("1 ");
						World.worldMap.add(newTile);
						World.cameraMap.add(newTile);
					}else{
						FloorTile newTile = new FloorTile(pos);
						newTile.setPos(pos);
						System.out.println("2 ");
						World.worldMap.add(newTile);
						World.cameraMap.add(newTile);
					}	
				World.worldMap.remove(tile);
				World.cameraMap.remove(tile);
			}
		}
	}
	
	private void replaceTile(FloorTile tile) {
		
		
	}

	public void render(){
		Shader.Basic.enable();
		if(!World.cameraMap.isEmpty()){
			for(FloorTile tile : World.cameraMap){
				tile.render();
			}
		}
		Shader.Basic.disable();
	}
	
}



