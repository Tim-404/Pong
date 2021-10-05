import processing.core.PApplet;

public class PongWithGravity extends PApplet
{
    Paddle p;
    Ball b;

    public static void main(String[] args) {
        PApplet.main("PongWithGravity");
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        p = new Paddle(this, 100, 10, height - 20);
        b = new Ball(this, width / 2, height / 2, 0, 0);
        textSize(50);
    }

    public void draw() {
        background(0);
        p.display();
        b.display();
        b.move();
        b.checkCollision(p);
        text(p.getHitCount(), 10, p.getY());
        b.fall();
    }

    public void keyPressed() {
        p.move(true);
    }
}