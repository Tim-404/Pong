import processing.core.PApplet;

public class Paddle
{
    // Instance variables
    private float x;
    private float y;
    private int width;
    private int height;
    PApplet applet;
    private int hitCount;

    // Constructors
    public Paddle(PApplet applet_) {
        applet = applet_;
        width = 100;
        height = 10;
        x = applet.width / 2 - width / 2;
        y = applet.height - 20;
        hitCount = 0;
    }
    public Paddle(PApplet applet_, int w, int h) {
        this(applet_);
        width = w;
        height = h;
    }
    public Paddle(PApplet applet_, int w, int h, float yPos) {
        this(applet_, w, h);
        y = yPos;
    }

    // Methods
    public void display() {
        applet.rect(x, y, width, height);
    }
    // Moving codes for left/right arrow keys and 'a' and 'd' for second player
    public void move(boolean coded) {
        if(coded) {
            if(applet.keyCode == applet.RIGHT) {
                x += 10;
            } else if(applet.keyCode == applet.LEFT) {
                x -= 10;
            }
        } else {
            if(applet.key == 'd') {
                x += 10;
            } else if(applet.key == 'a') {
                x -= 10;
            }
        }
    }
    public void hit() {
        hitCount++;
    }
    public int getHitCount() {
        return hitCount;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
