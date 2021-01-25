package b6_ke_thua.baitap;

class Point2D {
    protected float x = 0.0f;
    protected float y = 0.0f;

    Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    Point2D() {

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

class Point3D extends Point2D {
    private float z = 0.0f;

    Point3D() {
    }

    Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        this.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{this.x, this.y,this.z};
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ","+this.z+ ")";
    }
}

public class LopPoint2DVaLopPoint3D {
    public static void main(String[] args) {
        Point2D point3d1 = new Point3D(1,2,3);
        Point3D point3d2 = new Point3D(7,8,9);
        Point2D point2d = new Point2D(4,5);
        System.out.println(point3d1);
        System.out.println(point3d2);
        System.out.println(point2d);
    }
}
