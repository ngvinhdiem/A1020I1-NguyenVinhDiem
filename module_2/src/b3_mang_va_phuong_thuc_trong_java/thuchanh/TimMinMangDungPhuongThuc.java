package b3_mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class TimMinMangDungPhuongThuc {

    public static void minSearch(int[] array) {
        int min = array[0];
        int index=0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                index=i;
            }
        }
        System.out.print("Phan tu nho nhat cua mang la: " + min+" , tai vi tri thu "+index);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap kich co mang: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        minSearch(array);
    }
}

