package b7_abstract_class_interface.baitap;

interface Colorable {
    abstract void howToColor();
}

public class TrienKhaiInterfaceColorableChoHinhHoc {
    public static void main(String[] args) {
        Shape[] shape = new Shape[5];
        shape[0] = new Rectangle(3, 5);
        shape[1] = new Square(4);
        shape[2] = new Circle(6);
        shape[3] = new Square(2);
        shape[4] = new Rectangle(8, 9);
        for (Shape shapes : shape) {
            if (shapes instanceof Circle) {
                System.out.println(((Circle) shapes).getArea());
            }
            if (shapes instanceof Square) {
                System.out.println(((Square) shapes).getArea());
            } else if (shapes instanceof Rectangle) {
                System.out.println(((Rectangle) shapes).getArea());
            }
            if (shapes instanceof Colorable) {
                ((Colorable) shapes).howToColor();
            }
        }
    }
}
