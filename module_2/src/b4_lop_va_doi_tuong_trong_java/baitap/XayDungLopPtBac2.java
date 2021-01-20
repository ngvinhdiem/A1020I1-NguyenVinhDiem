package b4_lop_va_doi_tuong_trong_java.baitap;

import java.util.Scanner;

class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        if (this.a == 0) return 0;
        else return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        if (this.a == 0 && this.b != 0) return -c / b;
        else
            return (-b + Math.pow(this.getDiscriminant(), 0.5)) / (2 * a);
    }

    public double getRoot2() {
        if (this.a == 0 && this.b != 0) return -c / b;
        else
            return (-b - Math.pow(this.getDiscriminant(), 0.5)) / (2 * a);
    }
}


public class XayDungLopPtBac2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap cac tham so a,b,c cho pt bac 2: ax^2+bx+c=0");
        System.out.print("a = ");
        double a = input.nextDouble();
        System.out.print("b = ");
        double b = input.nextDouble();
        System.out.print("c = ");
        double c = input.nextDouble();
        QuadraticEquation quadEquation = new QuadraticEquation(a, b, c);
        if (quadEquation.getDiscriminant() > 0) {
            System.out.println("Pt co 2 nghiem phan biet");
            System.out.println("Nghiem thu 1: " + quadEquation.getRoot1());
            System.out.println("Nghiem thu 2: " + quadEquation.getRoot2());
        } else if (quadEquation.getDiscriminant() == 0 && ((quadEquation.a != 0) ||
                (quadEquation.b != 0 || quadEquation.c == 0))) {
            if (quadEquation.a == 0 && quadEquation.b == 0 && quadEquation.c == 0)
                System.out.println("Pt co vo so nghiem!");
            else System.out.println("Pt co 1 nghiem: " + quadEquation.getRoot1());
        } else System.out.println("Pt vo nghiem!");

    }
}
