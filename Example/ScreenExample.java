import java.awt.Graphics2D;
import java.awt.event.*;

/**
 * An example cl:ass that extends Screen, on update, draws
 * a box and moves it across the screen.
 *
 * @Author Alonzo Hernandez
 * @Since 9/7/16
 */
public class ScreenExample extends Screen {
	
	Game game;

	Graphics2D graphics;

	public ScreenExample() {
	}

	public void init(Game g) {
		game = g;
		graphics = (Graphics2D) game.getDisplay().getGraphics();
	}
	
	private int x = 50;
	private int moveX = 4;

	public void update() {
		graphics.drawRect(x, 100, 50, 50);

		x += moveX;
		
		if (x < 0 || x + 50 > 800) {
			moveX *= -1;
		}	
	}

	public void mouseClicked(MouseEvent me) {
	}
	
	public void mouseEntered(MouseEvent me) {
	}

	public void mouseExited(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseDragged(MouseEvent me) {
	}

	public void mouseMoved(MouseEvent me) {
	}

	public void keyPressed(KeyEvent ke) {
	}

	public void keyReleased(KeyEvent ke) {
	}

	public void keyTyped(KeyEvent ke) {
	}
}
