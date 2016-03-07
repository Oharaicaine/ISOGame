package game.input;

import java.awt.geom.Point2D;

import org.lwjgl.glfw.GLFWCursorPosCallback;

import game.camera.Camera;
import game.main.Main;

public class MouseInput extends GLFWCursorPosCallback{

	public static double mouseX, mouseY, mouseScreenX, mouseScreenY;
	public static Point2D.Double mousePointScreen = new Point2D.Double(0.0, 0.0);
	public static Point2D.Double mousePointWorld = new Point2D.Double(0.0, 0.0);

	
	@Override
	public void invoke(long window, double mouseX, double mouseY) {

		this.mouseX = mouseX + Camera.position.x;
		this.mouseY = (Main.height - mouseY) + Camera.position.y;
		this.mouseScreenX = mouseX;
		this.mouseScreenY = Main.height - mouseY;
		mousePointScreen.x = mouseScreenX; 
		mousePointScreen.y = mouseScreenY; 
		mousePointWorld.x = this.mouseX;
		mousePointWorld.y = this.mouseY;
		
	}

}
