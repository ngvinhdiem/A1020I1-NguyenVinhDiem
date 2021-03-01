package b11_dsa_stack_queue.baitap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class KiemTraPalindrome {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        Queue<String> stringQueue = new LinkedList<>();
        System.out.println("Nhap 1 chuoi:");
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();
        for (String letter : stringInput.split("")) {
            stringStack.push(letter);
            stringQueue.offer(letter);
        }
        boolean check = true;
       while (!stringStack.empty()) {
            if (!stringStack.pop().equals(stringQueue.poll())) {
                check=false;
                break;
            }
        }
        if (check) System.out.println("Y");
        else System.out.println("N");

    }
}
