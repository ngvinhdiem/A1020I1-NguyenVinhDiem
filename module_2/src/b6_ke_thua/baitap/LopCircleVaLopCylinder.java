package b6_ke_thua.baitap;

import java.util.zip.CheckedInputStream;

class Circle {
    private double radius;
    private String color;

    Circle(double radius, String color) {
        this.radius=radius;
        this.color=color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return this.radius * this.radius * 3.14;
    }

    @Override
    public String toString() {
        return "Radius= " + getRadius() + " " + "Color= " + getColor() +" " +"Area= "+getArea();
    }
}

class Cylinder extends Circle {
    private double height;
    Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height=height;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ "Height= " + getHeight() + " " + "Volume= " + getVolume() ;
    }
}

public class LopCircleVaLopCylinder {
    public static void main(String[] args) {
        Circle circle1 = new Circle(6,"red");
        Circle cylinder1 = new Cylinder(6,"red", 4);
        Cylinder cylinder2 = new Cylinder(3,"blue",5);
        System.out.println(circle1);
        System.out.println(cylinder1);
        System.out.println(cylinder2);
    }
}
