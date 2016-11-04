import java.awt.Image;

public abstract class Sprite {
    private int x;
    private int y;

    private Image texture;

    public Sprite(Image texture, int x, int y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    public Sprite(String path, int x, int y) {
        this(ResourceLoader.loadImage(path), x, y);
    }

    public Sprite(Image texture) {
        this(texture, 0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void changePosition(int changeX, int changeY) {
        x += changeX;
        y += changeY;
    }

    public void changeX(int changeX) {
        changePosition(changeX, 0);
    }

    public void changeY(int changeY) {
        changePosition(0, changeY);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }
}