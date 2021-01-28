package b7_abstract_class_interface.baitap;
interface Resizeable {
    abstract void resize(double percent);
}

public class TrienKhaiInterfaceResizeableChoHinhHoc {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,6);
        Circle circle = new Circle(4);
        Square square = new Square(7);
        System.out.println("Before resizing:");
        System.out.println("S Rectangle: "+rectangle.getArea());
        System.out.println("S Circle: "+circle.getArea());
        System.out.println("S Square: "+square.getArea());
        System.out.println("After resizing: ");
        rectangle.resize(30);
        circle.resize(25);
        square.resize(50);
        System.out.println("S Rectangle: "+rectangle.getArea());
        System.out.println("S Circle: "+circle.getArea());
        System.out.println("S Square: "+square.getArea());
    }
}


class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}

class Circle extends Shape implements Resizeable {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public void resize(double percent) {
        this.radius=this.radius*Math.sqrt((100+percent)/100.0);
    }
}

class Rectangle extends Shape implements Resizeable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public void resize(double percent) {
        this.width*=(100+percent)/100;
    }
}

class Square extends Rectangle implements Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public void resize(double percent) {
        setSide(getSide()*(Math.sqrt((100+percent)/100)));
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}