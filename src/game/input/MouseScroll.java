package game.input;

import org.lwjgl.glfw.GLFWScrollCallback;

public class MouseScroll extends GLFWScrollCallback {
	
	public static double scrollX = 0.0;
	public static double scrollY = 0.0;
	public static boolean set = true;

	@Override
	public void invoke(long window, double xoffset, double yoffset) {
		if(set){
			this.scrollX = xoffset;
			this.scrollY = yoffset;
			set = false;
		}
		System.out.println(yoffset);
	}

}
