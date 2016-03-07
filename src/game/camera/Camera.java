package game.camera;

import game.floortile.FloorTile;
import game.main.Main;
import game.maths.Vector3f;
import game.utils.Utils;
import game.world.World;

public class Camera {
	
	public static Vector3f position = new Vector3f(0,0,0);
	public static float zoom = 0;
	
	private float width = Main.width;
	private float StartWidth = 0.0f;
	private float height = Main.height;
	private float StartHeight = 0.0f;

	public Camera() {

	}
	
	public void update(){
		
		for(FloorTile tiles: World.worldMap){
			if(Utils.distanceBetweenVector3f(new Vector3f(Camera.position.x+(Main.width/2), Camera.position.y+(Main.height/2), 0), tiles.getPos()) < 800){
				if(!World.cameraMap.contains(tiles))World.cameraMap.add(tiles);	
			}else if(World.cameraMap.contains(tiles))World.cameraMap.remove(tiles);
		}
		/*
		if(!MouseScroll.set){
			
			double amount = MouseScroll.scrollY*30;
			width -= amount;
			height -= amount;
			StartWidth += amount;
			StartHeight += amount;
			
			if(width < Main.width)width = Main.width;
			if(height < Main.height)height = Main.height;
			if(StartWidth < 0)StartWidth = 0;
			if(StartHeight < 0)StartHeight = 0;
			
			Matrix4f pr_matrix = Matrix4f.orthographic(StartWidth, width, StartHeight, height, -1.0f, 1.0f);
			Shader.Basic.enable();
			Shader.Basic.setUniformMat4f("projection_matrix", pr_matrix);
			Shader.Basic.disable();
			MouseScroll.set = true;
		}
		*/
		
		/*if(MouseInput.mouseScreenX > Main.width - 150 && MouseInput.mouseScreenY > 100){
			position.x += 3f;
		}
		if(MouseInput.mouseScreenX < 150 && MouseInput.mouseScreenY > 100){
			position.x -= 3f;
		}
		if(MouseInput.mouseScreenY > Main.height - 150){
			position.y += 3f;
		}
		if(MouseInput.mouseScreenY < 150 && MouseInput.mouseScreenY > 100){
			position.y -= 3f;
		}*/
	}

	public static void setPosition(Vector3f position) {
		Camera.position = position;
	}

}
