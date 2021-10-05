import processing.core.PApplet;

public class KeyboardInput2 extends PApplet
{
    private int x;

    public static void main(String[] args) {
        PApplet.main("KeyboardInput2");
    }

    public void settings() {
        size(600, 400);
    }

    public void setup() {
        x = width / 2;
    }

    public void draw() {
        background(0);
        if(keyPressed) {    // Not the keyPressed() method, but a boolean variable
            if(key == 'j') {
                x--;
            } else if(key == 'k') {
                x++;
            }
        }
        ellipse(x, height / 2, 150, 150);
    }
}
