package game.entity.entityLiving;

import game.entity.Entity;
import game.maths.FloatPolygon;
import game.maths.Vector3f;
import game.utils.Index;

public class EntityLiving extends Entity{	
	
	protected float size;

	
	public EntityLiving(Vector3f pos, float size) {
		super(pos);
		this.size = size;
		//bounds = Index.polyRectangle(pos, size);
		bounds = Index.polyIsoTile(pos);
	}

}
