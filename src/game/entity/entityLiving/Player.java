package game.entity.entityLiving;

import static org.lwjgl.glfw.GLFW.*;

import game.camera.Camera;
import game.entity.Entity;
import game.graphics.Shader;
import game.graphics.VertexArray;
import game.input.KeyboardInput;
import game.main.Main;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.Assets;
import game.utils.Index;

public class Player extends Entity{
	
	
	public Player(Vector3f pos) {
		super(pos, 48f);
		mesh = new VertexArray(Index.vertcies(size, 0.9f), Index.indices(), Index.tcs());
		texture = Assets.getPlayer();
	}
	
	@Override
	public void update(){
		
		if(KeyboardInput.keys[GLFW_KEY_W]){
			pos.y += 3f;
		}
		if(KeyboardInput.keys[GLFW_KEY_S]){
			pos.y -= 3f;
		}
		if(KeyboardInput.keys[GLFW_KEY_A]){
			pos.x -= 5.0f;
		}
		if(KeyboardInput.keys[GLFW_KEY_D]){
			pos.x += 5.0f;
		}
		
		
		Camera.setPosition(pos);
		//super.update();
	}
	
	@Override
	public void render(){
		Shader.Player.enable();
		Shader.Player.setUniformMat4f("view_matrix", Matrix4f.translate(new Vector3f(Main.width/2, Main.height/2, 0.0f)));
		texture.bind();
		mesh.render();
		texture.unbind();
		Shader.Player.disable();
		
	}

}
