package game.worldobjects;

import game.graphics.SimpleVertexArray;
import game.graphics.Texture;
import game.maths.FloatPolygon;
import game.maths.Vector3f;
import game.utils.Assets;

public class WorldObject {

	protected Vector3f pos;
	protected float size = 64f;
	protected FloatPolygon bounds;
	protected SimpleVertexArray mesh;
	protected Texture texture;
	
	public WorldObject() {
		pos = new Vector3f();
		bounds = new FloatPolygon(	new float[]{pos.x-(size/2), pos.x-(size/2), pos.x + (size/2), pos.x + (size/2), pos.x},
									new float[]{pos.y, pos.y+100f, pos.y+100f, pos.y, (float)(pos.y-(size*0.3))}, 5);
		texture = Assets.getWorldObject();
	}
	public WorldObject(Vector3f pos) {
		this.pos = pos;
		bounds = new FloatPolygon(	new float[]{pos.x-(size/2), pos.x-(size/2), pos.x + (size/2), pos.x + (size/2), pos.x},
				new float[]{pos.y, pos.y+100f, pos.y+100f, pos.y, (float)(pos.y-(size*0.3))}, 5);
		texture = Assets.getWorldObject();
	}
	
	public void update(){
		
	}
	
	public void render(){
		
	}
	
	public void setPosition(Vector3f pos){
		this.pos = pos;
		bounds = new FloatPolygon(	new float[]{pos.x-(size/2), pos.x-(size/2), pos.x + (size/2), pos.x + (size/2), pos.x},
				new float[]{pos.y, pos.y+100f, pos.y+100f, pos.y, (float)(pos.y-(size*0.3))}, 5);
	}

}
