package b1_introduction_to_java.thuchanh;
import java.util.Scanner;
public class SuDungToanTu {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chieu rong: ");
        width = scanner.nextFloat();
        System.out.println("Nhap chieu cao: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("Dien tich: "+ area);

    }
}
