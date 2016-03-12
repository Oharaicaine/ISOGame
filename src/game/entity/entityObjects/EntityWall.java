package game.entity.entityObjects;

import game.maths.Vector3f;
import game.utils.Assets;

public class EntityWall extends EntityTile{
	
	public EntityWall(Vector3f pos){
		super(pos);
		//bounds = Index.polyIsoTile(pos);
		texture = Assets.getStone();
		mesh = Assets.getWallMesh();
	}
	
	/*@Override
	public void render(){
		Shader.Basic.enable();
		Shader.Basic.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
		Shader.Basic.setUniformMat4f("camera_matrix", Matrix4f.translate(new Vector3f(-Camera.pos.x, -Camera.pos.y, 0.0f)));
		texture.bind();
		mesh.render();
		texture.unbind();
		Shader.Basic.disable();
	}*/
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
