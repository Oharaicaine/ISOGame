package game.entity;


import java.awt.geom.Ellipse2D;
import java.security.GeneralSecurityException;

import game.camera.Camera;
import game.graphics.Shader;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.maths.FloatPolygon;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.Index;

public class Entity {
	
	protected int id;
	
	protected Texture texture;
	protected VertexArray mesh;
	
	protected Vector3f pos;
	protected FloatPolygon bounds;

	public Entity(Vector3f pos) {
		this.pos = pos;
	}
	
	public Entity(){
		pos = new Vector3f(); 
	}
	
	public void update(){
	
	}
	
	public void render(){
		/*Shader.Entity.enable();
		Shader.Entity.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
		Shader.Entity.setUniformMat4f("camera_matrix", Matrix4f.translate(new Vector3f(-Camera.position.x, -Camera.position.y, 0f)));
		texture.bind();
		mesh.render();
		texture.unbind();
		Shader.Entity.disable();*/
	}
	
	public void setPosition(Vector3f pos){
		this.pos = pos;
	}
	
	public Vector3f getPosition() {
		return pos;
	}
	
	public FloatPolygon getBounds() {
		return bounds;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public int getId() {
		return id;
	}

}
