/**
 * Example Main class for a game where a square bounces back and
 * forth on the screen at 60 fps. When running, put the file in the
 * same folder as the package java files, or otherwise import them.
 *
 * @Author Alonzo Hernandez
 * @Since 9/7/16
 */
public class Main {
	public static void main(String[] args) {
		Game game = new Game(); 		//Creates a new Game object
		game.setScreen(new ScreenExample());	//Sets the Game's screen to a ScreenExample
		game.run();				//Begins updating the game
	}
}
