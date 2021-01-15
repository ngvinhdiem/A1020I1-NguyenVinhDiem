package b3_mang_va_phuong_thuc_trong_java.baitap;
import java.util.Scanner;
public class UngDungDemSoLuongSVThiDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int size = scanner.nextInt();
        if (size>30) {
            System.out.print("So luong sinh vien khong vuot qua 30");
        }
        else {
            int[] array = new int[size];
            int count=0;
            for (int i = 0; i < size; i++) {
                System.out.print("Sinh vien thu " + (i+1) + " co diem la: ");
                array[i] = scanner.nextInt();
                if (array[i]>=5) count++;
            }
            System.out.print("So luong sinh vien thi do la: "+count);
        }
    }
}
