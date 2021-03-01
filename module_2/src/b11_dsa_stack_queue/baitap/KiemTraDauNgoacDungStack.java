package b11_dsa_stack_queue.baitap;

import java.util.Stack;
import java.util.Scanner;
public class KiemTraDauNgoacDungStack {
    public static void main(String[] args) {
        boolean check=true;
        char left;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap bieu thuc:");
        String expression = scanner.nextLine();
        Stack<Character> bStack = new Stack<Character>();
        for (char sym : expression.toCharArray()) {
            if (sym=='(') bStack.push(sym);
            else if (sym==')') {
                if (bStack.empty()) {
                 check=false;
                 break;
                }
                  left=bStack.pop();
                if (sym==left) {
                    check=false;
                    break;
                }
            }
        }

        if (bStack.isEmpty()&&check==true) check=true;
        else check=false;

        if (check==true) System.out.println("WELL");
        else System.out.println("???");
    }
}
