package game.main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import game.gamestates.GameStateManager;
import game.graphics.Shader;
import game.input.KeyboardInput;
import game.input.MouseButton;
import game.input.MouseInput;
import game.input.MouseScroll;
import game.utils.Assets;


public class Main implements Runnable{
	
	private Thread thread;
	public static boolean running = false;
	
	private GLFWKeyCallback keyCallBack;
	private GLFWCursorPosCallback mouseCallBack;
	private GLFWMouseButtonCallback mouseButtonCallback;
	private GLFWScrollCallback mouseScroll;
	
	public long window;
	public static int width = 1280;//1920;
	public static int height = 720;//1080;
	
	private GameStateManager gsm;

	public static void main(String[] args) {
		Main game = new Main();
		game.start();

	}
	public void start(){
		running =  true;
		thread = new Thread(this, "Main Game");
		thread.start();
	}
	
	public void init(){
		gsm = new GameStateManager();
		Assets.loadAll();
	}
	
	public void update(){
		glfwPollEvents();	
		
		gsm.update();
		Timer.update();
		
	}
	
	public void render(){
		//Preparing
		glfwSwapBuffers(window);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		//-----
		gsm.render();
		//obj.render();

	}
	
	@Override
	public void run() {
		loadOpenGL();
		loadShaders();
		init();
		
		long lastTime = System.nanoTime();
		double delta = 0.0;
		double ns = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1.0) {
				update();
				updates++;
				delta--;
			}
			render();		
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ticks, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
			if(glfwWindowShouldClose(window) == GL_TRUE){
				running = false;
			}
		}
		keyCallBack.release();
		mouseCallBack.release();
		mouseButtonCallback.release();
		mouseScroll.release();
	}
	private void loadShaders() {
		Shader.loadAll();
		
	}
	private void loadOpenGL() {
		if(glfwInit() != GL_TRUE){
			System.err.println("glfw Init failed");
		}
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
		//glfwWindowHint(GLFW_DECORATED, GL_FALSE);
		
		window =  glfwCreateWindow(width, height, "Demo", NULL, NULL);
		if(window== NULL){
			System.err.println("Could not create window");
		}
		
		glfwSetKeyCallback(window, keyCallBack = new KeyboardInput());
		glfwSetCursorPosCallback(window, mouseCallBack = new MouseInput());
		glfwSetMouseButtonCallback(window, mouseButtonCallback = new MouseButton());
		glfwSetScrollCallback(window, mouseScroll = new MouseScroll());
		
		GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window,+ (vidMode.width() - width) / 2,
								+ (vidMode.height() - height) / 2);
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		glfwSwapInterval(1);
		
		GL.createCapabilities();
		glClearColor(1f, 1f, 1f, 1f);
		glEnable(GL_DEPTH_TEST);
		glEnable (GL_BLEND);
		glBlendFunc (GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glActiveTexture(GL_TEXTURE1);
		
	}

}
