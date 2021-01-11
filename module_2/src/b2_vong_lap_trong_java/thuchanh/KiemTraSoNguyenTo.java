package b2_vong_lap_trong_java.thuchanh;
import java.util.Scanner;
public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        int i = 2;
        boolean check = true;
        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number = input.nextInt();

        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                check = false;
                break;
            }
            i++;
        }

        if (check)
            System.out.println(number + " la so nguyen to.");
        else
            System.out.println(number + " khong phai la so nguyen to.");
    }
}
