package b1_introduction_to_java.baitap;
import java.util.Scanner;
public class HienThiLoiChao {
    public static void main(String[] args) {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Hello: "+name);
    }
}
