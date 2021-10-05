import processing.core.PApplet;

public class Ball
{
    // Instance variables
    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;
    private float maxSpeed;
    private float diameter;
    private PApplet applet;

    // Constructors
    public Ball(PApplet applet_) {
        applet = applet_;
        x = applet.width / 2;
        y = applet.height / 2;
        xSpeed = 2;
        ySpeed = 2;
        diameter = 20;
        maxSpeed = 10;
    }
    public Ball(PApplet applet_, float xPos, float yPos) {
        this(applet_);
        x = xPos;
        y = yPos;
    }
    public Ball(PApplet applet_, float xPos, float yPos, float xS, float yS) {
        this(applet_, xPos, yPos);
        xSpeed = xS;
        ySpeed = yS;
    }
    public Ball(PApplet applet_, float xPos, float yPos, float xS, float yS, float d) {
        this(applet_, xPos, yPos, xS, yS);
        diameter = d;
    }
    public Ball(PApplet applet_, float xPos, float yPos, float xS, float yS, float d, float mS) {
        this(applet_, xPos, yPos, xS, yS, d);
        maxSpeed = mS;
    }

    // Methods
    public void display() {
        applet.ellipse(x, y, diameter, diameter);
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
        hitWall();
    }
    private void hitWall() {
        if(x > applet.width - diameter / 2) {
            xSpeed *= -1;
            x = applet.width - diameter / 2;
        } else if(x < diameter / 2) {
            xSpeed *= - 1;
            x = diameter / 2;
        }
        if(y > applet.height - diameter / 2) {
            ySpeed *= -1;
            y = applet.height - diameter / 2;
        } else if(y < diameter / 2) {
            ySpeed *= -1;
            y = diameter / 2;
        }
    }
    // Checks if this ball is in collision range of a paddle
    public void checkCollision(Paddle p) {
        if(x > p.getX() - diameter / 2 && x < p.getX() + p.getWidth() + diameter / 2 && y > p.getY() - diameter / 2 && y < p.getY() + p.getHeight() + diameter / 2) {
            rebound(p);
            p.hit();
        }
    }
    private void rebound(Paddle p) {    // Determines angle to rebound ball from paddle
        if(x >= p.getX() && x <= p.getX() + p.getWidth()) {
            ySpeed *= -1;
            xSpeed = maxSpeed * (x - p.getX() - p.getWidth() / 2) / (p.getWidth() / 2);
        } else if(y >= p.getY() && y <= p.getY() + p.getHeight()){
            xSpeed *= -1;
        } else if(x < p.getX()) {
            xSpeed = -maxSpeed;
            if(y < p.getY()) {
                ySpeed = -Math.abs(ySpeed);
            } else if(y > p.getY()){
                ySpeed = Math.abs(ySpeed);
            }
        } else {
            xSpeed = maxSpeed;
            if(y < p.getY()) {
                ySpeed = -Math.abs(ySpeed);
            } else if(y > p.getY()){
                ySpeed = Math.abs(ySpeed);
            }
        }
    }
    // Checks if this ball is in collision range of another ball
    public void checkCollision(Ball b) {
        float d = (float)Math.sqrt(Math.pow(x - b.getX(), 2) + Math.pow(y - b.getY(), 2));
        if(d < diameter / 2 + b.getDiameter() / 2 - 5) {
            while(d <= diameter / 2 + b.getDiameter() / 2) {
                x -= (b.getX() - x) / d / 2;
                y -= (b.getY() - y) / d / 2;
                d = (float)Math.sqrt(Math.pow(x - b.getX(), 2) + Math.pow(y - b.getY(), 2));
            }
            rebound(b);
        }
    }
    private void rebound(Ball b) {  // Determines speed and angle at which to rebound both balls
        float mass = (float)(Math.pow(diameter / 2, 3) * Math.PI * 4 / 3);
        float bMass = (float)(Math.pow(b.getDiameter() / 2, 3) * Math.PI * 4 / 3);
        float distance = (float)(Math.sqrt(Math.pow(x - b.getX(), 2) + Math.pow(y - b.getY(), 2)));

        // Vectors, yay! vToCon = velocity toward contact point
        float vToCon = ((b.getX() - x) * xSpeed + (b.getY() - y) * ySpeed) / distance;
        float bVToCon = ((b.getX() - x) * b.getXSpeed() + (b.getY() - y) * b.getYSpeed()) / distance;
        float vToCon_ = (mass * vToCon - bMass * vToCon + 2 * bMass * bVToCon) / (mass + bMass);
        float bVToCon_ = (bMass * bVToCon - mass * bVToCon + 2 * mass * vToCon) / (mass + bMass);

        xSpeed += (vToCon_ - vToCon) * (b.getX() - x) / distance;
        ySpeed += (vToCon_ - vToCon) * (b.getY() - y) / distance;
        b.setXSpeed(b.getXSpeed() + (bVToCon_ - bVToCon) * (b.getX() - x) / distance);
        b.setYSpeed(b.getYSpeed() + (bVToCon_ - bVToCon) * (b.getY() - y) / distance);
    }
    public float getX() { return x; }
    public float getY() { return y; }
    public void setX(float xPos) { x = xPos; }
    public void setY(float yPos) { y = yPos; }
    private float getXSpeed() { return xSpeed; }
    private float getYSpeed() { return ySpeed; }
    private float getDiameter() { return diameter; }
    public void setXSpeed(float xS) { xSpeed = xS; }
    public void setYSpeed(float yS) { ySpeed = yS; }

    public void fall() {    // Fun with gravity
        ySpeed++;
    }
}
