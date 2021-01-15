package b3_mang_va_phuong_thuc_trong_java.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap kich co mang 1: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            System.out.print("array1[" + i + "] = ");
            array1[i] = scanner.nextInt();
        }
        System.out.print("Nhap kich co mang 2: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            System.out.print("array2[" + i + "] = ");
            array2[i] = scanner.nextInt();
        }
        int[] array3 = new int[size1 + size2];
        for (int i = 0; i < size1 + size2; i++) {
            if (i <= size1 - 1) {
                array3[i] = array1[i];
            } else {
                array3[i] = array2[i - size1];
            }
        }
        System.out.println("Mang 3: " + Arrays.toString(array3));
    }
}
