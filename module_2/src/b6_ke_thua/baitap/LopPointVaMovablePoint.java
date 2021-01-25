package b6_ke_thua.baitap;
class Point {
    protected float x = 0.0f;
    protected float y = 0.0f;

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    Point() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{this.x, this.y};
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}

class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    MovablePoint() {}
    MovablePoint(float x,float y,float xSpeed,float ySpeed) {
        super(x,y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    MovablePoint(float xSpeed,float ySpeed) {
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed (float xSpeed,float ySpeed) {
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed() {
        return new float[]{this.xSpeed, this.ySpeed};
    }
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "), speed=("+this.xSpeed+","+this.ySpeed+")";
    }
    public MovablePoint move() {
        this.x+=this.xSpeed;
        this.y+=this.ySpeed;
        return this;
    }
}

public class LopPointVaMovablePoint {
    public static void main(String[] args) {
        Point point = new Point(1,2);
        System.out.println(point);
        MovablePoint movablePoint = new MovablePoint(1,2,0,0);
        movablePoint.setSpeed(3,4);
        System.out.println((movablePoint.move()).toString());
    }
}
