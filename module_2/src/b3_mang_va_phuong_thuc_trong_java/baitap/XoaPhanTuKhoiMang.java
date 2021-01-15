package b3_mang_va_phuong_thuc_trong_java.baitap;
import java.util.Arrays;
import java.util.Scanner;
public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap kich co mang: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Nhap phan tu can xoa: ");
        int y=scanner.nextInt();
        int count=0;
        for (int i=0;i<size;i++) {
            if (array[i]==y) {
                for (int j=i;j<size-1;j++) {
                    array[j]=array[j+1];
                }
                count++;
                array[size-count]=0;
            }
        }
        System.out.println("Mang sau khi xoa phan tu "+y+": "+Arrays.toString(array));
    }
}
