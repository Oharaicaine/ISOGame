package game.inventory;

import java.awt.geom.Rectangle2D;

import game.floortile.FloorTile;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.maths.Vector3f;

public class InventorySlot {

	protected Texture texture;
	protected VertexArray mesh;
	
	protected Vector3f pos;
	protected Rectangle2D.Float bounds;
	
	protected boolean showSlot;
	
	protected FloorTile slotItem;
	
	public InventorySlot(Vector3f pos){
		this.pos = pos;	
	}
	
	public void update(){
		
	}
	
	public void render(){
		if(showSlot){
			
		}
	}
	
	public boolean hasItem(){
		if(slotItem == null){
			return false;
		}else{
			return true;
		}
	}
	
	public FloorTile getSlotItem() {
		return slotItem;
	}
	
	public void setSlotItem(FloorTile slotItem) {
		this.slotItem = slotItem;
	}
	
}
