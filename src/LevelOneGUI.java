/**
 * Level One of the GUI version of our classic platformer game.
 * 
 * This class contains the code needed to generate the first level in our GUI
 * version. This includes level size as well as player and enemy generation. The
 * play method allows the player to interact with the world.
 * 
 */


public class LevelOneGUI extends World {

	private final int LEVELWORLDMAXXCOORD = 16;
	private final int LEVELWORLDMAXYCOORD = 1;

	private final int LEVELSTARTXCOORD = 0;
	private final int LEVELSTARTYCOORD = 0;

	private final int LEVELGOALXCOORD = 16;
	private final int LEVELGOALYCOORD = 0;

	private boolean levelWin;

	public LevelOne() {
	}

	public LevelOne(int worldMaxX, int worldMaxY, int playerStartX, int playerStartY, int playerFinalX, int playerFinalY) {
		super(worldMaxX, worldMaxY, playerStartX, playerStartY, playerFinalX, playerFinalY);
	}

	/**
	 * The playLevelOne method allows the main player to interact in the level one
	 * world. The method draws out the world and continuously ask the player for
	 * input until the player has won (reached the final destination) or the player
	 * has lost (been killed).
	 * 
	 * @return levelWin - The boolean which returns true if the level has been won,
	 *         false otherwise.
	 */
	public boolean playLevelOne() {

		LevelOne level = new LevelOne(LEVELWORLDMAXXCOORD, LEVELWORLDMAXYCOORD, LEVELSTARTXCOORD, LEVELSTARTYCOORD,
				LEVELGOALXCOORD, LEVELGOALYCOORD);

		Enemy enemy1 = new Enemy(level);
		Enemy enemy2 = new Enemy(level);
		Enemy enemy3 = new Enemy(level);

		addToListOfEnemies(enemy1);
		addToListOfEnemies(enemy2);
		addToListOfEnemies(enemy3);

		Player mainPlayer = new Player(this, 5);

		// This will update the enemy position while the game is running
		while (mainPlayer.isAlive() && !level.isPlayerAtGoal(mainPlayer)) {
			enemy1.Update();
			enemy2.Update();
			enemy3.Update();
		}

		// After the loop for level play ends, check if player won/is still alive
		if (mainPlayer.isAlive()) {
			levelWin = true;
		} else {
			levelWin = false;
		}

		// Draw the world a final time before ending the level

		return levelWin;

	}

}
