package game.entity;

import game.graphics.Shader;
import game.graphics.SimpleVertexArray;
import game.maths.Matrix4f;
import game.maths.Vector3f;

public class DebugDraw {
	
	private SimpleVertexArray mesh;
	private Vector3f pos;
	private final float SIZE = 80f;
	private float[] vertices;

	public DebugDraw(Vector3f pos) {
		this.pos = pos;
		vertices = new float[] {
				-SIZE / 2.0f, 0f,
				0f,  SIZE * 0.3f,
				SIZE / 2.0f,  0f,
				0f, -SIZE * 0.3f
			};
		mesh = new SimpleVertexArray(vertices, new byte[]{0, 1, 2, 3});
	}
	
	public void update(){
		
	}
	public void render(){
		
		Shader.Primitives.enable();
		Shader.Primitives.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
		//Shader.Primitives.setUniformMat4f("camera_matrix", Matrix4f.translate(new Vector3f(-Camera.position.x, -Camera.position.y, 0f)));
		mesh.render();
		Shader.Primitives.disable();
	}

}
