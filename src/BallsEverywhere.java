import processing.core.PApplet;

public class BallsEverywhere extends PApplet
{
    private int ballCount = 10;
    private Ball[] balls;

    public static void main(String[] args) {
        PApplet.main("BallsEverywhere");
    }

    public void settings() {
        size(1500, 500);
    }

    public void setup() {
        balls = new Ball[ballCount];
        for(int i = 0; i < ballCount; i++) {
            balls[i] = new Ball(this, width / 2, height / 2, (int)(Math.random() * 15) - 5, (int)(Math.random() * 15) - 7, (int)(Math.random() * 176) + 25);
        }
    }

    public void draw() {
        background(0);
        for(int i = 0; i < ballCount; i++) {
            balls[i].display();
            balls[i].move();
            for(int i_ = 0; i_ < ballCount; i_++) {
                if(i != i_) {
                    balls[i].checkCollision(balls[i_]);
                }
            }
        }
    }
}
