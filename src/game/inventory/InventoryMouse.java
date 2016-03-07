package game.inventory;

import game.floortile.FloorTile;
import game.graphics.Shader;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.input.MouseInput;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.Assets;

public class InventoryMouse{
	
	public static FloorTile item;
	
	private Vector3f pos;
	private Texture texture;
	private VertexArray mesh;

	public InventoryMouse() {
		pos = new Vector3f((float)MouseInput.mouseScreenX+36, (float)MouseInput.mouseScreenY-32, 0.0f);
		mesh = Assets.getIconMesh();
		item = new FloorTile();
		texture = item.getTexture();
	}
	
	public void update(){
		pos.x = (float)MouseInput.mouseScreenX+36;
		pos.y = (float)MouseInput.mouseScreenY-32;
		if(texture != item.getTexture())texture = item.getTexture();
	}
	
	public void render(){
		if(item != null){
			Shader.Hud.enable();
			Shader.Hud.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
			texture.bind();
			mesh.render();
			texture.unbind();
			Shader.Hud.disable();
		}	
	}

	public static boolean hasItem() {
		if(item != null)return true;
		return false;
	}

	public static FloorTile getItem() {
		return item;
	}

	public static int getItemId() {
		int result = item.getId();

		return result;
	}

}
