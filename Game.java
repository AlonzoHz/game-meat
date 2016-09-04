import java.awt.Graphics;

/**
 * Central class that initializes all game related objects 
 * and runs the game's main loop
 *
 * @author Alonzo Hernandez
 * @version 0.1a
 * @since 9/3/16
 */

public class Game {
	private boolean running = false;
	
	private Display display;
	
	private Screen currentScreen;

	//FPS Management\\
	final int FRAME_GOAL;
	long waitTime; //the real amount of time to wait based on how long the loop took
	long maxWaitTime; //roughly the amount of time to wait if the loop takes no time
	long startTime; //the time when run() was called
	long frameCount = 1; //how many frames have been computed to completion, waiting and all
	long loopStartTime; //the time the the loop starts
	long loopEndTime; //the time the loop ends
	long loopTime; //the total time the loop takes
	long elapsedTime; //the time the loop has been running since run() was called
	long FPS = 60; //the realtime FPS of the program

	/**
	 * Constructs the Game object by preparing the display
	 * and FPS information.
	 */
	public Game() {
		this("Game", 800, 600, 60);
	}

	public Game(String title, int width, int height, int frameGoal) {
		display = new Display(title, width, height);

		FRAME_GOAL = frameGoal;

		maxWaitTime = 1000 / FRAME_GOAL;
	}	

	/**
	 * The main loop, updates the screen and the display
	 * and maintains the desired FPS as accurately as possible
	 *
	 * setScreen(Screen) MUST BE CALLED BEFORE CALLING run()
	 *
	 * Terminable through killGame()
	 */
	public void run() {
		running = true;
		
		startTime = System.nanoTime();
		while(running) {
			//FPS\\
			loopStartTime = System.nanoTime();

			//Updates\\
			currentScreen.update();
			
			display.update(FPS);

			//FPS\\
			loopEndTime = System.nanoTime();
			loopTime = loopEndTime - loopStartTime;
			elapsedTime = loopEndTime - startTime;

			waitTime = (long) (maxWaitTime - loopTime / 1e6);

			FPS = (long) (frameCount * 1e9 / elapsedTime);

			try {
				if(waitTime > 0) {
					Thread.sleep(waitTime);
				} else {
					System.out.println("Dropped frame!");
				}
			} catch (Exception e) {
			}

			frameCount++;
		}

		System.exit(0);
	}

	/**
	 * Replaces the screen currently being updated
	 * and it's listeners with the new screen, in the process
	 * the new screen is initialized.
	 *
	 * @param newScreen The screen that should replace the current screen
	 */
	public void setScreen(Screen newScreen) {
		if (currentScreen != null) {
			display.removeListeners(currentScreen);
		}

		newScreen.init(this);

		currentScreen = newScreen;

		display.addListeners(currentScreen);
	}

	/**
	 * @return the display object associated with the game's window
	 */
	public Display getDisplay() {
		return display;
	}
	
	/**
	 * Kills the game by stopping execution of run()
	 */
	public void killGame() {
		running = false;
	}
}
