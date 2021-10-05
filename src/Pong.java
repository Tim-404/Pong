import processing.core.PApplet;

public class Pong extends PApplet
{
    Paddle p;
    Ball b1;
    Ball b2;

    public static void main(String[] args) {
        PApplet.main("Pong");
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        p = new Paddle(this, 100, 10, height - 20);
        b1 = new Ball(this, width / 2, height / 2,0, 3);
        b2 = new Ball(this, width / 2 - 20, height / 2,0, 4);
        textSize(50);
    }

    public void draw() {
        background(0);
        p.display();
        b1.display();
        b2.display();
        b1.move();
        b1.checkCollision(p);
        b1.checkCollision(b2);
        b2.move();
        b2.checkCollision(p);
        b2.checkCollision(b1);
        text(p.getHitCount(), 10, p.getY());
    }

    public void keyPressed() {
        p.move(true);
    }
}
