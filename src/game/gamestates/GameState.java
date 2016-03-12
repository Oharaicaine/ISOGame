package game.gamestates;

import org.lwjgl.glfw.GLFW;

import game.camera.Camera;
import game.entity.EntityManager;
import game.gui.Hud;
import game.input.KeyboardInput;
import game.inventory.InventoryMouse;
import game.main.Main;
import game.world.ChunkManager;
import game.world.World;

public class GameState extends State {
	
	private World world;
	private EntityManager entityManager;
	private ChunkManager chunkManager;
	private Camera camera;
	//private Hud hud;
	//private InventoryMouse mouseInventory;

	public GameState() {
	}

	@Override
	public void init() {
		world = new World();
		chunkManager = new ChunkManager();
		entityManager = new EntityManager();
		camera = new Camera();
		//hud = new Hud();
		//mouseInventory = new InventoryMouse();
		
	}

	@Override
	public void update() {
		camera.update();
		chunkManager.update();
		entityManager.update();
		
		//hud.update();
		//mouseInventory.update();
		
		if(KeyboardInput.keys[GLFW.GLFW_KEY_ESCAPE]){
			Main.running = false;
		}
	}

	@Override
	public void render() {
		chunkManager.render();
		entityManager.render();
		
		//hud.render();
		//mouseInventory.render();
	}
	
	

}
