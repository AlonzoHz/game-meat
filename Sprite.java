import java.awt.Image;

public Sprite {
    private Image texture;

    private int x;
    private int y;

    public Sprite(Image texture, int x, int y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return texture;
    }
}