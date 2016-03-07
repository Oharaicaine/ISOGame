package game.graphics;

import static org.lwjgl.opengl.GL20.*;

import java.util.HashMap;
import java.util.Map;

import game.main.Main;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.ShaderUtils;

public class Shader {
	
	public static final int VERTEX_ATTRIB = 0;
	public static final int TCOORD_ATTRIB = 1;
	
	public static Shader Basic, Entity, Hud, Primitives, Player;
	
	private final int ID;
	
	private Map<String, Integer> locationCache = new HashMap<String, Integer>();
	
	public Shader(String vertex, String fargment) {
		ID = ShaderUtils.load(vertex, fargment);
	}
	
	public static void loadAll(){
		Basic = new Shader("shaders/basicShader.vert", "shaders/basicShader.frag");
		Entity = new Shader("shaders/entityShader.vert", "shaders/entityShader.frag");
		Hud = new Shader("shaders/hudShader.vert", "shaders/hudShader.frag");
		Primitives = new Shader("shaders/prim.vert", "shaders/prim.frag");
		Player = new Shader("shaders/entityPlayer.vert", "shaders/entityPlayer.frag");
		
		
		Matrix4f pr_matrix = Matrix4f.orthographic(0.0f, Main.width, 0.0f, Main.height, -1.0f, 1.0f);
		
		Primitives.enable();
		Primitives.setUniformMat4f("projection_matrix", pr_matrix);
		Primitives.disable();
		
		Basic.enable();
		Basic.setUniformMat4f("projection_matrix", pr_matrix);
		Basic.setUniform1i("tex", 1);
		Basic.disable();
		
		Entity.enable();
		Entity.setUniformMat4f("projection_matrix", pr_matrix);
		Entity.setUniform1i("tex", 1);
		Entity.disable();
		
		Player.enable();
		Player.setUniformMat4f("projection_matrix", pr_matrix);
		Player.setUniform1i("tex", 1);
		Player.disable();
		
		Hud.enable();
		Hud.setUniformMat4f("projection_matrix", pr_matrix);
		Hud.setUniform1i("tex", 1);
		Hud.disable();
		
	}
	
	public int getUniform(String name){
		if(locationCache.containsKey(name)){
			return locationCache.get(name);
		}
		int result = glGetUniformLocation(ID, name);
		if(result == -1){
			System.out.println("Could not find uniform variable "+name);
		}else{
			locationCache.put(name, result);
		}
		return result;
	}
	
	public void setUniform1i(String name, int value){
		glUniform1i(getUniform(name), value);
	}
	public void setUniform1f(String name, float value){
		glUniform1f(getUniform(name), value);
	}
	public void setUniform2f(String name, float x, float y){
		glUniform2f(getUniform(name), x, y);
	}
	public void setUniform3f(String name, Vector3f vector){
		glUniform3f(getUniform(name), vector.x, vector.y, vector.z);
	}
	
	public void setUniformMat4f(String name, Matrix4f matrix){
		glUniformMatrix4fv(getUniform(name), false, matrix.toFloatBuffer());
	}
	
	public void enable(){
		glUseProgram(ID);
	}
	
	public void disable(){
		glUseProgram(0);
	}
}
