package game.floortile;

import java.awt.geom.Rectangle2D;

import game.camera.Camera;
import game.graphics.Shader;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.Assets;

public class FloorTile {

	private final int id =  0;
	
	protected float size = 96.0f;
	protected VertexArray mesh;
	protected Texture texture;
	
	protected Vector3f pos;
	protected Rectangle2D.Float bounds;
	//protected Polygon bounds;

	public FloorTile(Vector3f pos) {	
		this.pos = pos;
		/*bounds = new Polygon(	new int[]{(int)(pos.x - (size*0.5f)),0,(int)(pos.x + (size*0.5f)),0},
								new int[]{0,(int)(pos.y - (size*0.3f)),0,(int)(pos.x + (size*0.3f))}, 4);*/
		bounds = new Rectangle2D.Float(pos.x - (size/2.0f), pos.y - (size/2.0f), size, size);
		mesh = Assets.getTileMesh();
		texture = Assets.getStone();
		
	}
	public FloorTile(){
		this.pos = new Vector3f();
		bounds = new Rectangle2D.Float(pos.x - (size/2.0f), pos.y - (size/2.0f), size, size);
		/*bounds = new Polygon(	new int[]{(int)(pos.x - (size*0.5f)),0,(int)(pos.x + (size*0.5f)),0},
				new int[]{0,(int)(pos.y - (size*0.3f)),0,(int)(pos.x + (size*0.3f))}, 4);*/
		mesh = Assets.getTileMesh();
		texture = Assets.getStone();
	}
	
	public void update() {
	}
	
	public void render() {
		Shader.Basic.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
		Shader.Basic.setUniformMat4f("camera_matrix", Matrix4f.translate(new Vector3f(-Camera.position.x, -Camera.position.y, 0f)));
		texture.bind();
		mesh.render();
		texture.unbind();
	}
	
	public float getSize() {
		return size;
	}
	
	public Vector3f getPos() {
		return pos;
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public Rectangle2D.Float getBounds() {
		return bounds;
	}
	
	public boolean isBuilding(){
		return false;
	}

	public Texture getTexture() {

		return texture;
	}

	public void setPos(Vector3f pos) {
		this.pos.x = pos.x;
		this.pos.y = pos.y;

	}

	public int getId() {
		return id;
	}
}
