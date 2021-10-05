import processing.core.PApplet;

public class Pong2Player extends PApplet
{
    Paddle p1;
    Paddle p2;
    Ball b1;
    Ball b2;

    public static void main(String[] args) {
        PApplet.main("Pong2Player");
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        p1 = new Paddle(this, 100, 10, height - 40);
        p2 = new Paddle(this, 100, 10, 30);
        b1 = new Ball(this, width / 2, height / 2,0, 3);
        b2 = new Ball(this, width / 2, height / 2,0, 4);
        textSize(50);
    }

    public void draw() {
        background(0);
        p1.display();
        p2.display();
        b1.display();
        b2.display();
        b1.move();
        b2.move();
        b1.checkCollision(p1);
        b1.checkCollision(p2);
        b2.checkCollision(p1);
        b2.checkCollision(p2);
        text(p1.getHitCount(), 10, p1.getY());
        text(p2.getHitCount(), 10, p2.getY() + 40);
    }

    public void keyPressed() {
        p1.move(true);
        p2.move(false);
    }
}
