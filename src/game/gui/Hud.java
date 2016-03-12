package game.gui;


import game.entity.entityObjects.EntityTile;
import game.graphics.Shader;
import game.graphics.Texture;
import game.graphics.VertexArray;
import game.main.Main;
import game.maths.Matrix4f;
import game.maths.Vector3f;
import game.utils.Index;

public class Hud {
	
	private Texture texture;
	private VertexArray mesh;
	private Icons hubicon;
	//private ArrayList<Icons> hudIcons;

	public Hud(){
		texture = new Texture("res/bg2.png");
		mesh = new VertexArray(Index.vertciesWidthHeight(Main.width, Main.height/8, 0.5f), Index.indices(), Index.tcs());
		
		hudIcons();
	}
	
	private void hudIcons() {
		hubicon = new Icons(new Vector3f(65, (Main.height/8)/2, 0), new EntityTile(), 64);
		
	}

	public void update(){
		hubicon.update();
	}
	
	public void render(){
		Shader.Hud.enable();
		Shader.Hud.setUniformMat4f("view_matrix", Matrix4f.translate(new Vector3f(Main.width/2, Main.height/16, 0)));
		texture.bind();
		mesh.render();
		texture.unbind();
		Shader.Hud.disable();
		hubicon.render();
	}
	
}
