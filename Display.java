import javax.swing.*;
import java.awt.*;

/**
 * Display is a capsule for the objects related to
 * the viewport for the game, including the window
 * and the graphics.
 *
 * @author Alonzo Hernandez
 * @since 9/3/16
 */
public class Display {
	JFrame frame;
	JPanel panel;
	
	Image bufferImage;
	Graphics bufferGraphics;

	int WIDTH;
	int HEIGHT;
	
	/**
	 * Constructs the display objects and makes them visible
	 */
	public Display() {
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(3);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 600));

		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		
		frame.setVisible(true);	
		frame.setResizable(false);

		WIDTH = panel.getWidth();
		HEIGHT = panel.getHeight();
		
		bufferImage = panel.createImage(WIDTH, HEIGHT);
		bufferGraphics = bufferImage.getGraphics();		
	}
	
	/**
	 * @return The graphics object that should be used to draw on the screen
	 */
	public Graphics getGraphics() {
		return bufferGraphics;
	}
	
	/**
	 * Draws the FPS, updates the window, and clears the buffered image
	 * for the next round of graphical updates
	 *
	 * @param FPS the FPS that should be displayed
	 */
	public void update(long FPS) {
		bufferGraphics.drawString(Long.toString(FPS), 10, 10);
		panel.getGraphics().drawImage(bufferImage, 0, 0, null);
		bufferGraphics.clearRect(0, 0, WIDTH, HEIGHT);
	}

	/**
	 * @param screen Removes the Screen as a listener for the window
	 */
	public void removeListeners(Screen screen) {
		panel.removeMouseListener(screen);
		panel.removeMouseMotionListener(screen);
		panel.removeKeyListener(screen);
	}

	/**
	 * @param screen Adds the Screen as a listener for the window
	 */
	public void addListeners(Screen screen) {
		panel.addMouseListener(screen);
		panel.addMouseMotionListener(screen);
		panel.addKeyListener(screen);
	}
}
