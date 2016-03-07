package game.entity.entityLiving;


import game.entity.Entity;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.maths.Vector3f;
import game.utils.Index;

public class EntityMob extends Entity{

	public EntityMob(Vector3f pos, float size) {
		super(pos, size);
		mesh = new VertexArray(Index.vertcies(size, 0.1f), Index.indices(), Index.tcs());
		texture = new Texture("res/box.png");

	}
	
	public void render(){
		super.render();	
	}

}
