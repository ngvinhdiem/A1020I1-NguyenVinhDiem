package b1_introduction_to_java.thuchanh;
import java.util.Scanner;
public class KiemTraNamNhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Moi nhap nam:");
        year = scanner.nextInt();
        if (year%4==0&&year%100!=0) {
            System.out.println("Nam "+year+" la nam nhuan!");
        }
        else if (year%100==0) {
            if (year%400==0) {
                System.out.println("Nam "+year+" la nam nhuan!");
            }
            else {
                System.out.println("Nam "+year+" khong phai nam nhuan!");
            }
        }
        else {
            System.out.println("Nam "+year+" khong phai nam nhuan!");
        }
    }
}
