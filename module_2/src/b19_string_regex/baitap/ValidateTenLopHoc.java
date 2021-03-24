package b19_string_regex.baitap;

import java.util.Scanner;

public class ValidateTenLopHoc {
    public static void main(String[] args) {
        String classNameValidation = "[CAP][0-9]{4}[GHIKLM]";
        System.out.println("Nhap ten lop hoc:");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        if (className.matches(classNameValidation)) {
            System.out.println("Hop le!");
        }
        else System.out.println("Khong hop le!");;
    }
}
