package b15_xu_li_ngoai_le_debug.baitap;

import java.util.Scanner;

class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
        super("Khong phai 3 canh 1 tam giac!!!");
    }
}


public class SuDungLopTriangleException {
    public static boolean checkIllegalTriangle(int side1, int side2, int side3) throws IllegalTriangleException {
        if (side1 < 0 || side2 < 0 || side3 < 0 || side1 + side2 <= side3 || side2 + side3 <= side1 || side1 + side3 <= side2) {
            throw new IllegalTriangleException();
        }

        return true;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap 3 canh 1 tam giac: ");
//        int side1 = scanner.nextInt();
//        int side2 = scanner.nextInt();
//        int side3 = scanner.nextInt();
//        try {
//            if (checkIllegalTriangle(side1, side2, side3)) {
//                System.out.println("Day la 1 tam giac");
//            } else {
//                System.out.println("Day khong phai 1 tam giac");
//            }
//
//        } catch (IllegalTriangleException e) {
//            e.printStackTrace();
//        }
        try {
            int x = 0;
            int y = 5 / x;
        }catch (ArithmeticException e) {
            System.out.println("Arithmetic");
        }catch (Exception ae) {
            System.out.println("Exception");
        }
        System.out.println("finished");

    }
}
