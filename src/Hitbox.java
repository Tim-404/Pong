import processing.core.PApplet;

public class Hitbox extends PApplet
{
    private int x;
    private int y;

    public static void main(String[] args) {
        PApplet.main("Hitbox");
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        x = 140;
        y = 145;
    }

    public void draw() {
        background(0);
        fill(255);
        ellipse(x, y, 20, 20);
        if(keyPressed) {
            if(key == CODED) {
                if(keyCode == UP) {
                    y--;
                } else if(keyCode == DOWN) {
                    y++;
                }
            }
        }
        if(collision()) {
            fill(0, 255, 0);
        }
        rect(100, 100, 80,30);
    }

    private boolean collision() {
        if(x > 90 && x < 190 && y > 90 && y < 140) {
            return true;
        }
        return false;
    }
}
