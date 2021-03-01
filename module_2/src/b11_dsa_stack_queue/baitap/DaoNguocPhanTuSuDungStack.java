package b11_dsa_stack_queue.baitap;

import java.util.Stack;
import java.util.Scanner;

public class DaoNguocPhanTuSuDungStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap size mang: ");
        int size;
        size = scanner.nextInt();
        int[] integerArray;
        integerArray = new int[size];
        for (int i = 0; i < size; i++) {
            integerArray[i] = scanner.nextInt();
        }
        Stack<Integer> integerStack = new Stack<>();
        for (int i=0;i<size;i++) integerStack.push(integerArray[i]);
        for (int i=0;i<size;i++) integerArray[i]=integerStack.pop();
        for (int i=0;i<size;i++) System.out.print(integerArray[i]+" ");

    }
}