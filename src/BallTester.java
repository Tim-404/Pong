import processing.core.PApplet;

public class BallTester extends PApplet
{
    Ball b;
    Ball b2;

    public static void main(String[] args) {
        PApplet.main("BallTester");
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        b = new Ball(this, width / 2, height / 2,3, 0); // "this" is the object that called this method
        b2 = new Ball(this, width / 2 + 20, height / 2, 4, 0);
    }

    public void draw() {
        background(0);
        b.display();
        b2.display();
        b.move();
        b.checkCollision(b2);
        b2.move();

    }
}
