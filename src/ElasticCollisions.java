import processing.core.PApplet;

public class ElasticCollisions extends PApplet
{
    Ball b1;
    Ball b2;
    Ball b3;
    Ball b4;

    public static void main(String[] args) {
        PApplet.main("ElasticCollisions");
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        b1 = new Ball(this, 100, 100, 0, 2, 80);
        b2 = new Ball(this, 120, 400, -1, -2, 40);
        b3 = new Ball(this, 200, 300, 4, 3, 20);
        b4 = new Ball(this, 400, 100, 10, 0, 10);
    }

    public void draw() {
        background(0);
        b1.display();
        b2.display();
        b3.display();
        b4.display();
        b1.move();
        b1.checkCollision(b2);
        b1.checkCollision(b3);
        b1.checkCollision(b4);
        b2.move();
        b2.checkCollision(b1);
        b2.checkCollision(b3);
        b2.checkCollision(b4);
        b3.move();
        b3.checkCollision(b1);
        b3.checkCollision(b2);
        b3.checkCollision(b4);
        b4.move();
        b4.checkCollision(b1);
        b4.checkCollision(b2);
        b4.checkCollision(b3);
    }
}
