package b1_introduction_to_java.thuchanh;
import java.util.Scanner;
public class TinhChiSoCanNangCoThe {
    public static void main(String[] args) {
        float weight,height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi nhap can nang:");
        weight = scanner.nextFloat();
        System.out.println("Moi nhap chieu cao:");
        height = scanner.nextFloat();
        float bmi = weight / (height*height);
        String result;
        if (bmi<18.5) {
            result="Underweight";
        }
        else if (bmi<25.0) {
            result="Normal";
        }
        else if (bmi<30.0) {
            result="Overweight";
        }
        else result="Obese";
        System.out.print("Chi so BMI: "+bmi+"\nPhan loai: "+result);
    }
}
