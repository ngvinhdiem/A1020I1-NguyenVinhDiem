package b3_mang_va_phuong_thuc_trong_java.baitap;
import java.util.Scanner;
public class TongCacSoDuongCheoChinhMTV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap co cua ma tran: ");
        int size=scanner.nextInt();
        int[][] array = new int[size][size];
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                System.out.print("Array["+i+"]["+j+"] = ");
                array[i][j]=scanner.nextInt();
            }
        }
        int sum=0;
        System.out.println("In ra ma tran: ");
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                System.out.print(array[i][j]+"   ");
                if (i==j) sum+=array[i][j];
            }
            System.out.print("\n");
        }
        System.out.print("Tong cac so tren duong cheo chinh: "+sum);
    }
}
