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
	private JFrame frame;
	private JPanel panel;
	
	private Image bufferImage;
	private Graphics bufferGraphics;

	private String title; 
	private int width;
	private int height;
	
	/**
	 * Constructs the display objects and makes them visible
	 */
	public Display(String t, int w, int h) {
		title = t;
		width = w;
		height = h;

		frame = new JFrame(title);
		frame.setDefaultCloseOperation(3);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));

		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		
		frame.setVisible(true);	
		frame.setResizable(false);
		
		bufferImage = panel.createImage(width, height);
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
		bufferGraphics.clearRect(0, 0, width, height);
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

	public void setIcon(Image icon) {
		frame.setImageIcon(icon.getImageIcon());
	}

	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
