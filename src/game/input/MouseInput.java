package game.input;

import java.awt.geom.Point2D;

import org.lwjgl.glfw.GLFWCursorPosCallback;

import game.camera.Camera;
import game.main.Main;

public class MouseInput extends GLFWCursorPosCallback{

	public static float mouseX, mouseY, mouseScreenX, mouseScreenY;
	public static Point2D.Float mousePointScreen = new Point2D.Float(0.0f, 0.0f);
	public static Point2D.Float mousePointWorld = new Point2D.Float(0.0f, 0.0f);

	
	@Override
	public void invoke(long window, double mouseX, double mouseY) {

		this.mouseX = (float) (mouseX + Camera.pos.x);
		this.mouseY = (float) ((Main.height - mouseY) + Camera.pos.y);
		this.mouseScreenX = (float) mouseX;
		this.mouseScreenY = (float) (Main.height - mouseY);
		mousePointScreen.x = mouseScreenX; 
		mousePointScreen.y = mouseScreenY; 
		mousePointWorld.x = this.mouseX;
		mousePointWorld.y = this.mouseY;
		
	}

}
