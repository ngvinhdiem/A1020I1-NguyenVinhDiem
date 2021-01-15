package b3_mang_va_phuong_thuc_trong_java.thuchanh;
import java.util.Scanner;
public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhap kich co mang: ");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Mang khong qua 20 phan tu");
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhap phan tu thu " + (i + 1) + " :");
            array[i] = scanner.nextInt();
            i++;
        }

        System.out.print("In mang: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("\nPhan tu lon nhat trong mang la " + max + " ,tai vi tri " + index);
    }
}
