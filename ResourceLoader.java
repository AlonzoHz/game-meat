import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A one-stop shopping class for loading resource files.
 * Currently only deals with images, but later iterations will
 * include loading capabilities for fonts and sounds.
 *
 * @Author Alonzo Hernandez
 * @Since 9/6/16
 */
public class ResourceLoader {
	/**
	 * Loads an image based on a path. 
	 *
	 * @param path the url to the image, relative paths will be relative the the class file
	 * @return the Image resource
	 */
	public static Image loadImage(String path) {
		Image resource = new ImageIcon(ResourceLoader.class.getResource(path)).getImage();
		return resource;
	}

	//ADD FONT LOADER
	
	//ADD SOUND LOADER
}
