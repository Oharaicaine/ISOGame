package game.floortile;

import game.maths.Vector3f;
import game.utils.Assets;

public class Building extends FloorTile{
	
	private final int id = 1;

	public Building(Vector3f pos) {
		super(pos);
		texture = Assets.getPlayer();		
	}
	
	public Building(){
		super();
		texture = Assets.getPlayer();
	}
	
	@Override
	public boolean isBuilding(){
		return true;
	}
	
	public int getId() {
		return id;
	}

}
