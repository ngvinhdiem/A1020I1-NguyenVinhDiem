package b11_dsa_stack_queue.baitap;

import java.util.Stack;
import java.util.Scanner;

public class ChuyenDoiHeThapPhanNhiPhan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap 1 so nguyen duong: ");
        int number = scanner.nextInt();
        Stack<Integer> integerStack = new Stack<>();
        while (true) {
            integerStack.push(number % 2);
            number /= 2;
            if (number==0) break;
        }
        String binaryString = "";
        while (!integerStack.empty()) {
            binaryString += integerStack.pop();
        }
        System.out.println(binaryString);
    }
}
