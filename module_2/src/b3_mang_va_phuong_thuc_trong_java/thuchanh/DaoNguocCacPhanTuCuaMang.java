package b3_mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class DaoNguocCacPhanTuCuaMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhap kich co mang:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Mang khong vuot qua 20 phan tu");
        } while (size > 20);

        array = new int[size];
        int i;
        for (i = 0; i < size; i++) {
            System.out.print("Nhap pt thu " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        int j=size-1;
        for (i = 0; j>=i; i++) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            j--;
        }
        for (i = 0; i < size; i++) {
            System.out.print("a["+i+"] = "+array[i]+"\n");
        }


    }
}
