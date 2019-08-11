import java.util.HashMap;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * LevelTwoGUI creates the scene (and shows it) for level one of the GUI based
 * game. Here, the world is instantiated with it's dimensions. The player is
 * set, the enemies of the level are set, the platforms are set. In other words,
 * all the world objects of the level are created here. As well, the keyboard
 * listener for the level/scene is called for here.
 *
 */
public class LevelTwoGUI extends GameplayGUI {
	
	private static final int WORLDWIDTH = 800;
	private static final int WORLDHEIGHT = 500;
	
	Map<WorldObject, ImageView> worldObjectMap = new HashMap<WorldObject, ImageView>();
	Map<Platform, HBox> platformGUIMap = new HashMap<Platform, HBox>();

	/**
	 * The method which creates the level including its world, player, enemies,
	 * platforms, other world objects and calls the keyboard listener. The method
	 * also then shows the scene on the stage given.
	 * 
	 * @param stage   - the stage of the javaFX application
	 * @param aPlayer - the player to copy into this level
	 */
	public void create(Stage stage, Player aPlayer) {
		
		// Set scene
		Pane root = new Pane();		
		Scene scene = new Scene(root, WORLDWIDTH, WORLDHEIGHT);

		// Set world
		World levelTwo = new World(WORLDWIDTH, WORLDHEIGHT);
		
		// Create background
        createBackground(root, "Full-Background.png", 800, 500, 0, 0);
        createBackground(root, "layer-2-mountain.png", 800, 500, 0, 0);
        
		// Add player
		// Note: Don't turn into method as need to be updated on keyboard
		// press/separately from other world objects
		Player player = new Player(aPlayer);
		player.setXYCoord(20, 300);
		player.setWorld(levelTwo);
		levelTwo.addPlayer(player);

		// Create an ImageView representation of the player
		// Note: Don't turn into method as need to be updated on keyboard
		// press/separately from other world objects
        Image im = new Image("giphy.gif",false);
		ImageView iv = new ImageView(im);
		iv.setFitHeight(player.getHeight());
		iv.setFitWidth(player.getWidth());
        root.getChildren().add(iv);
        
        
        //Add bullet
    	Bullet bullet = new Bullet(WORLDHEIGHT+100,WORLDWIDTH+100,10,10,levelTwo);
		Rectangle bulletRect = new Rectangle(bullet.getxCoord(),bullet.getyCoord(),bullet.getWidth(),bullet.getHeight());
		root.getChildren().add(bulletRect);
        
        
		// Add the enemies
        createEnemyType1(root, levelTwo, worldObjectMap, 580, 230, 560, 670, 20, 20);
        createEnemyType1(root, levelTwo, worldObjectMap, 600, 135, 590, 650, 20, 20);
        createEnemyType1(root, levelTwo, worldObjectMap, 440, 95, 430, 480, 20, 20);
        createTrapType1(root, levelTwo, worldObjectMap, 310, 350, 325, 345, 20, 20);
        createFlyingEnemy(root, levelTwo, worldObjectMap, 180, 300, 260, 345, 30, 35);
        createFlyingEnemy(root, levelTwo, worldObjectMap, 760, 200, 100, 190, 30, 35);
        createFlyingEnemy(root, levelTwo, worldObjectMap, 300, 65, 0, 55, 30, 35);
        
		// Create the platforms in the level
		createPlatform( root, levelTwo, platformGUIMap, 0, 450, 1000, 50);
		createPlatform( root, levelTwo, platformGUIMap, 0, 420, 100, 20);
		createPlatform( root, levelTwo, platformGUIMap, 140, 380, 100, 20);
		createPlatform( root, levelTwo, platformGUIMap, 280, 345, 100, 20);
		createPlatform( root, levelTwo, platformGUIMap, 420, 305, 100, 20);
		createPlatform( root, levelTwo, platformGUIMap, 560, 265, 150, 20);
		createPlatform( root, levelTwo, platformGUIMap, 750, 225, 50, 20);
		createPlatform( root, levelTwo, platformGUIMap, 140, 50, 100, 20);
		createPlatform( root, levelTwo, platformGUIMap, 280, 90, 100, 20);
		createPlatform( root, levelTwo, platformGUIMap, 420, 130, 100, 20);
		createPlatform( root, levelTwo, platformGUIMap, 580, 170, 100, 20);

		// Create the EndPoint for the world
		createEndPoint(root, levelTwo, worldObjectMap, 150, 0, 50, 50);
		
		// Call the keyboard listener for the level
		gameAnimation(stage, scene, player, iv, worldObjectMap, platformGUIMap,bullet,bulletRect);
		
		// Set the scene and show it
		stage.setScene(scene);
		stage.show();

		
	}
	
}