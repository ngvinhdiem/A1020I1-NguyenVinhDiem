package b3_mang_va_phuong_thuc_trong_java.thuchanh;
import java.util.Scanner;
public class ChuongTrinhChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu\n1. Fahrenheit to Celsius\n" + "2. Celsius to Fahrenheit\n" +
                "0. Exit ");
        System.out.print("Input your choice: ");
        int choice=scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Input Farenheit degree: ");
                float fahrenheit=scanner.nextFloat();
                System.out.print("Celcius degree: "+((5.0 / 9) * (fahrenheit - 32)));
                break;
            case 2:
                System.out.print("Input Celcius degree: ");
                float celsius=scanner.nextFloat();
                System.out.println("Fahrenheit degree: "+((celsius/(5.0 / 9)) +32));
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("No choice!");
        }
    }
}
