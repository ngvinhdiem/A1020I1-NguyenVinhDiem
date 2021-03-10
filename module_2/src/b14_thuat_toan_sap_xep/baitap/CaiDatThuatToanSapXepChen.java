package b14_thuat_toan_sap_xep.baitap;

import java.util.Arrays;

public class CaiDatThuatToanSapXepChen {
    public static void main(String[] args) {

        int[] a = {5, 9, 1, 3, 2, 6, 7};
        insertionSort(a);
    }
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {

            int curElement = list[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (curElement < list[j]) {
                    list[j + 1] = list[j];
                } else {
                    break;
                }
            }

            list[j + 1] = curElement;
        }

        System.out.println(Arrays.toString(list));
    }

}
