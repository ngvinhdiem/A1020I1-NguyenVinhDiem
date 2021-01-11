package b1_introduction_to_java.baitap;
import java.util.Scanner;
public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap USD:  ");
        int usd;
        usd = scanner.nextInt();
        int vnd;
        vnd = usd * 23000;
        System.out.println("To VND: "+vnd+ " VND");
    }
}
