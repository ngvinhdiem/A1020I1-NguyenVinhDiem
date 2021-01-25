package b6_ke_thua.baitap;
import java.util.Scanner;
class Shape {
    protected String color;
    Shape() {

    }
    Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Triangle extends Shape {
    private double side1 = 1.0f;
    private double side2 = 1.0f;
    private double side3 = 1.0f;

    Triangle() {

    }

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double p = (side1+side2+side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    public double getPerimeter() {
        return side1+side2+side3;
    }

    @Override
    public String toString() {
        return "Side 1: "+this.side1+" ; Side 2: "+this.side2+" ; Side 3: "+this.side3
                +" ; Area: "+this.getArea()+" ; Perimeter: "+this.getPerimeter()+" ; Color: "
                +this.color;
    }
}


public class ThietKeVaTrienKhaiLopTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input side 1: ");
        double side1 = scanner.nextDouble();
        System.out.print("Input side 2: ");
        double side2 = scanner.nextDouble();
        System.out.print("Input side 3: ");
        double side3 = scanner.nextDouble();
        System.out.print("Input color: ");
        scanner.nextLine();
        String color = scanner.nextLine();
        Triangle triangle = new Triangle(side1,side2,side3);
        triangle.setColor(color);
        System.out.println(triangle);
    }
}
