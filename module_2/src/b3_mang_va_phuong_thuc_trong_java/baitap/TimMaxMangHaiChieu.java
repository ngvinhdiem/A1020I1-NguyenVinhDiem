package b3_mang_va_phuong_thuc_trong_java.baitap;
import java.util.Scanner;
public class TimMaxMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so hang ma tran: ");
        int row=scanner.nextInt();
        System.out.println("Nhap so cot ma tran: ");
        int col=scanner.nextInt();
        int[][] array = new int[row][col];
        int max=0;
        System.out.print("Array[0][0] = ");
        array[0][0]=scanner.nextInt();
        max=array[0][0];
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (i==0&&j==0) continue;
                System.out.print("Array["+i+"]["+j+"] = ");
                array[i][j]=scanner.nextInt();
                if (max<array[i][j]) max=array[i][j];
            }
        }
        System.out.print("Phan tu lon nhat cua mang 2 chieu la: "+max);
    }
}
