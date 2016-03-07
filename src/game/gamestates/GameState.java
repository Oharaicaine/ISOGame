package game.gamestates;

import org.lwjgl.glfw.GLFW;

import game.camera.Camera;
import game.entity.EntityManager;
import game.entity.entityLiving.EntityMob;
import game.entity.entityLiving.Player;
import game.floortile.BlockManager;
import game.gui.Hud;
import game.input.KeyboardInput;
import game.inventory.InventoryMouse;
import game.main.Main;
import game.maths.Vector3f;
import game.world.World;

public class GameState extends State {
	
	private World world;
	private EntityManager entityManager;
	private BlockManager tileManager;
	private Camera camera;
	private Hud hud;
	private InventoryMouse mouseInventory;

	public GameState() {
	}

	@Override
	public void init() {
		world = new World();
		entityManager = new EntityManager();
		tileManager = new BlockManager();
		camera = new Camera();
		hud = new Hud();
		mouseInventory = new InventoryMouse();

		EntityManager.createEntity(new Player(new Vector3f((float)(Main.width/2), (float)Main.height/2, 0.1f)));
		EntityManager.createEntity(new EntityMob(new Vector3f((float)(Main.width/2)+64, (float)Main.height/2, 0.1f), 64f));
		
	}

	@Override
	public void update() {
		tileManager.update();
		camera.update();
		entityManager.update();
		hud.update();
		mouseInventory.update();
		
		if(KeyboardInput.keys[GLFW.GLFW_KEY_ESCAPE]){
			Main.running = false;
		}
	}

	@Override
	public void render() {
		tileManager.render();
		entityManager.render();
		hud.render();
		mouseInventory.render();
	}
	
	

}
