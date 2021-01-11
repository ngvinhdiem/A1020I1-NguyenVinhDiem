package b2_vong_lap_trong_java.thuchanh;
import java.util.Scanner;
public class TimUCLN {
    public static void main(String[] args) {
        int a, b;
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhap so thu nhat: ");
        a = nhap.nextInt();
        System.out.println("Nhap so thu hai: ");
        b = nhap.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0)
            System.out.println("Khong co UCLN");

        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }

        System.out.println("UCLN: " + a);
    }
}
