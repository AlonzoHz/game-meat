import java.awt.event.*;

/**
 * A listener based class for handling all of the game-related
 * actions on a screen within the game, any screens within the game
 * should have a class that extends Screen and implements the listener
 * functions
 *
 * @author Alonzo Hernandez
 * @since 9/3/16
 */
public abstract class Screen implements MouseListener, MouseMotionListener, KeyListener {
	/**
	 * Called when the Screen is set as the current screen
	 * through Game.setScreen()
	 *
	 * @param game The Game object using the Screen
	 */
	public abstract void init(Game game);
	
	/**
	 * Called in loop in Game.run()
	 */
	public abstract void update();
}
