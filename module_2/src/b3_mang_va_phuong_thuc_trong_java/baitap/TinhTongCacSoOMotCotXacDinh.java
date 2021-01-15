package b3_mang_va_phuong_thuc_trong_java.baitap;
import java.util.Scanner;
public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so hang ma tran: ");
        int row=scanner.nextInt();
        System.out.println("Nhap so cot ma tran: ");
        int col=scanner.nextInt();
        int[][] array = new int[row][col];
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                System.out.print("Array["+i+"]["+j+"] = ");
                array[i][j]=scanner.nextInt();
            }
        }
        System.out.println("In ra ma tran: ");
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                System.out.print(array[i][j]+"   ");
            }
            System.out.print("\n");
        }
        System.out.print("Nhap vao cot can tinh tong: ");
        int colChoice=scanner.nextInt();
        int sumCol=0;
        for (int i=0;i<row;i++) {
            sumCol+=array[i][colChoice];
        }
        System.out.print("Tong cac phan tu cua cot "+colChoice+" la: "+sumCol);



    }
}
