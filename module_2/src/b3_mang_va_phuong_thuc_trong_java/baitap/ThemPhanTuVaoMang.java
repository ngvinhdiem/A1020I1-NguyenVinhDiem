package b3_mang_va_phuong_thuc_trong_java.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap kich co mang: ");
        int size = scanner.nextInt();
        int[] array = new int[size+1];
        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Nhap phan tu can chen: ");
        int y = scanner.nextInt();
        System.out.print("Nhap vi tri can chen: ");
        int index = scanner.nextInt();
        if (index <= 1 || index >= array.length - 1) {
            System.out.println("Khong chen duoc!");
        } else {
            for (int j = size; j >= index + 1; j--) {
                array[j] = array[j - 1];
            }
            array[index]=y;
            System.out.println("Mang sau khi them phan tu " + y + ": " + Arrays.toString(array));


        }
    }
}
