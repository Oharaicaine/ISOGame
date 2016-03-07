package game.gui;

import java.awt.geom.Rectangle2D;

import game.floortile.FloorTile;
import game.graphics.Shader;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.input.MouseButton;
import game.input.MouseInput;
import game.inventory.InventoryMouse;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.Assets;

public class Icons {

	protected Texture texture;
	protected VertexArray mesh;
	protected Vector3f pos;
	
	protected FloorTile building;
	
	private Rectangle2D.Float boundingBox;
	
	private float size;
	
	
	public Icons(Vector3f pos, FloorTile building, float size){
		this.pos = pos;
		this.building = building;
		this.size = size;
		texture = Assets.getIcon();
		mesh = Assets.getIconMesh();
		boundingBox = new Rectangle2D.Float(pos.x-(size/2), pos.y-(size/2), size, size);
	}
	
	public void update(){
		if(boundingBox.contains(MouseInput.mousePointScreen) && MouseButton.mouseLeft){
			InventoryMouse.item = building;
		}
	}
	
	public FloorTile getBuilding() {
		return building;
	}

	public void render(){
		Shader.Hud.enable();
		Shader.Hud.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
		texture.bind();
		mesh.render();
		texture.unbind();
		Shader.Hud.disable();
	}
}
