package b1_introduction_to_java.thuchanh;
import java.util.Scanner;
public class GiaiPtBacNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a,b;
        System.out.println("Giai pt bac nhat ax+b=0:");
        System.out.println("Nhap a: ");
        a = scanner.nextFloat();
        System.out.println("Nhap b: ");
        b = scanner.nextFloat();
        if (a==0) {
            if (b==0) {
                System.out.println("Pt co vo so nghiem!");
            }
            else {
                System.out.println("Pt vo nghiem!");
            }
        }
        else {
            System.out.println("Pt co nghiem x la: "+-b/a);
        }
    }
}
