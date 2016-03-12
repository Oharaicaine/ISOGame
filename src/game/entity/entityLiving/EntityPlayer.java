package game.entity.entityLiving;

import static org.lwjgl.glfw.GLFW.*;

import game.camera.Camera;
import game.entity.entityObjects.EntityTile;
import game.graphics.Shader;
import game.input.KeyboardInput;
import game.main.Main;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.Assets;
import game.utils.Index;
import game.utils.Utils;
import game.world.Chunk;
import game.world.ChunkManager;

public class EntityPlayer extends EntityLiving{
	
	private boolean canMove = true;
	
	public EntityPlayer(Vector3f pos) {
		super(pos, 48f);
		mesh = Assets.getPlayerMesh();
		texture = Assets.getPlayer();
	}
	
	@Override
	public void update(){

		for(Chunk chunk : ChunkManager.loadedChunks){
			for(EntityTile solidtile : chunk.getSolidTiles()){
				if(solidtile.isSolid()){
					if(Utils.distanceBetweenVector3f(solidtile.getPosition(), pos) < Index.TILESIZE *0.5f){
						canMove = false;
					}
				}
			}
		}	

		
		if(canMove){
		
			if(KeyboardInput.keys[GLFW_KEY_W]){
				pos.y += 3.0f;
			}
			if(KeyboardInput.keys[GLFW_KEY_S]){
				pos.y -= 3.0f;
			}
			if(KeyboardInput.keys[GLFW_KEY_A]){
				pos.x -= 6.0f;
			}
			if(KeyboardInput.keys[GLFW_KEY_D]){
				pos.x += 6.0f;
			}
		}
		
		
		Camera.setPosition(new Vector3f(pos.x-(Main.width/2), pos.y-(Main.height/2), 0.0f));
		//Camera.setPosition(pos);
		//super.update();
	}
	
	@Override
	public void render(){
		Shader.Player.enable();
		//Shader.Player.setUniformMat4f("view_matrix", Matrix4f.translate(new Vector3f(pos.x, pos.y, 0.2f)));
		Shader.Player.setUniformMat4f("view_matrix", Matrix4f.translate(pos));
		Shader.Player.setUniformMat4f("camera_matrix", Matrix4f.translate(new Vector3f((Main.width/2)-pos.x, (Main.height/2)-pos.y, 0.0f)));
		texture.bind();
		mesh.render();
		texture.unbind();
		Shader.Player.disable();
		
	}

}
