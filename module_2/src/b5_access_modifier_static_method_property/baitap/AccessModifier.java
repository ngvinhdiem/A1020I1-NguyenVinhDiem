package b5_access_modifier_static_method_property.baitap;

class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle() {

    }

    Circle(double r) {
        this.radius=r;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius*radius*3.14;
    }
}

public class AccessModifier {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2);
        System.out.println("S1: "+circle1.getArea());
        System.out.println("R1: "+circle1.getRadius());
        System.out.println("S2: "+circle2.getArea());
        System.out.println("R2: "+circle2.getRadius());
    }
}
