package b19_string_regex.baitap;

import java.util.Scanner;

public class ValidateSoDienThoai {
    public static void main(String[] args) {
        String phoneNumberValidation = "\\([0-9]{2}\\)-\\(0[0-9]{9}\\)";
        System.out.println("Nhap so dien thoai:");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.matches(phoneNumberValidation)) {
            System.out.println("Hop le!");
        }
        else System.out.println("Khong hop le!");;

    }
}
