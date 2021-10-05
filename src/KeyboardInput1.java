import processing.core.PApplet;

public class KeyboardInput1 extends PApplet
{
    public static void main(String[] args) {
        PApplet.main("KeyboardInput1");
    }

    public void settings() {
        size(600, 400);
    }

    public void setup() {
        background(0);
    }

    public void draw() {

    }

    public void keyPressed() {  // The PApplet detects when a key has been pressed and calls this method once for each keypress.
        if(key == 'r') {
            fill(200, 0, 0, 100);   // alpha is opacity
        } else if(key == 'g') {
            fill(0, 200, 0, 100);
        } else {
            fill(0, 0, 200, 100);
        }
        ellipse((float)Math.random() * width, (float)Math.random() * height, 150, 150);
    }
}
