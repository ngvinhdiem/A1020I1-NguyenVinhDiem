package b3_mang_va_phuong_thuc_trong_java.baitap;
import java.util.Scanner;
public class DemSoLanXuatHienKiTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainString;
        System.out.print("Nhap 1 chuoi tu ban phim: ");
        mainString=scanner.nextLine();
        System.out.print("Nhap vao 1 ki tu muon kiem tra: ");
        char ch = scanner.next().charAt(0);
        int length = mainString.length();
        int count=0;
        for (int i=0;i<length;i++) {
            if (mainString.charAt(i)==ch) count++;
        }
        System.out.print("Ki tu "+ch+" xuat hien "+count+" lan!");
    }
}
