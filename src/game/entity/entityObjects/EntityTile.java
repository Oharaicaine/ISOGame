package game.entity.entityObjects;


import game.camera.Camera;
import game.entity.Entity;
import game.graphics.Shader;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.maths.FloatPolygon;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.Assets;
import game.utils.Index;

public class EntityTile extends Entity{

	private final int ID =  0;
	
	protected VertexArray mesh;
	protected Texture texture;

	public EntityTile(Vector3f pos) {	
		super(pos);
		bounds = Index.polyIsoTile(pos);
		mesh = Assets.getTileMesh();
		texture = Assets.getStone();
		
	}
	public EntityTile(){
		pos = new Vector3f();
		bounds = Index.polyIsoTile(pos);
		mesh = Assets.getTileMesh();
		texture = Assets.getStone();
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void render() {
		Shader.Basic.enable();
		Shader.Basic.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
		Shader.Basic.setUniformMat4f("camera_matrix", Matrix4f.translate(new Vector3f(-Camera.pos.x, -Camera.pos.y, 0.0f)));
		texture.bind();
		mesh.render();
		texture.unbind();
		Shader.Basic.disable();
	}
	
	public boolean isSolid(){
		return false;
	}
	
	@Override
	public FloatPolygon getBounds() {
		return bounds;
	}

	public Texture getTexture() {
		return texture;
	}

}
