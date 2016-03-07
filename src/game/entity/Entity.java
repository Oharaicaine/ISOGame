package game.entity;


import java.awt.geom.Ellipse2D;

import game.camera.Camera;
import game.graphics.Shader;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.maths.Matrix4f;
import game.maths.Vector3f;

public class Entity {
	
	protected Texture texture;
	protected VertexArray mesh;
	
	protected Texture boxTex;
	protected VertexArray boxMesh;
	
	protected float scale;
	
	protected Vector3f pos;
	protected float size;
	
	protected Ellipse2D.Float hitBox;
	
	protected boolean isSelected = false;
	
	private float moveToX, moveToY;

	public Entity(Vector3f pos, float size) {
		this.pos = pos;
		this.size = size;
		hitBox = new Ellipse2D.Float(pos.x-(size/2),pos.y-(size/2), size, size);
		moveToX = pos.x;
		moveToY = pos.y;
	}
	
	public Entity(){
		pos = new Vector3f(0,0,0); 
		size = 64f;
		hitBox = new Ellipse2D.Float(pos.x-(size/2),pos.y-(size/2), size, size);
	}
	
	//private long time = 0;
	
	public void update(){
		/*if(time==0){
			time = Timer.getTime();
		}*/
		hitBox.x = pos.x-(size/2);
		hitBox.y = pos.y-(size/2);
		
		/*if(hitBox.contains(new Point.Float((float)MouseInput.mouseX, (float)MouseInput.mouseY)) &&
				MouseButton.mouseLeft && Timer.timePassed(time) > 1.0){
			isSelected = true;
		}*/
		
		/*if(isSelected){
			if(MouseButton.mouseRight && MouseInput.mouseScreenY > Main.height/8){
				moveToX = (float) Utils.clickedBlock().getPos().x;
				moveToY = (float) Utils.clickedBlock().getPos().y;
				System.out.println("X "+moveToX);
				System.out.println("Y "+moveToY);
			}
			double diffX = moveToX - pos.x;
			double diffY = moveToY - pos.y;
			float angle =(float)(Math.atan2(diffY, diffX) * 180 /Math.PI);
			
			if(diffX > 5 || diffX < -5)pos.x += Math.cos(angle * Math.PI/180) * 2f;
			if(diffY > 5 || diffY < -5)pos.y += Math.sin(angle * Math.PI/180) * 2f;
		}*/
	}
	
	public void render(){
		Shader.Entity.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
		Shader.Entity.setUniformMat4f("camera_matrix", Matrix4f.translate(new Vector3f(-Camera.position.x, -Camera.position.y, 0f)));
		texture.bind();
		mesh.render();
		texture.unbind();
	}
	
	public void setPosition(Vector3f pos){
		this.pos = pos;
	}
	
	public void setSize(float size){
		this.size = size;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public Vector3f getPosition() {
		return pos;
	}
	public Ellipse2D.Float getBounds() {
		return hitBox;
	}

}
