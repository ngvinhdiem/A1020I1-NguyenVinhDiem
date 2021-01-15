package b3_mang_va_phuong_thuc_trong_java.baitap;
import java.util.Scanner;
public class TimMinTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap kich co mang: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.print("array[0] = ");
        array[0] = scanner.nextInt();
        int min = array[0];
        for (int i = 1; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = scanner.nextInt();
            if (min>array[i]) min=array[i];
        }
        System.out.print("Phan tu nho nhat mang la: "+min);
        
    }
}
