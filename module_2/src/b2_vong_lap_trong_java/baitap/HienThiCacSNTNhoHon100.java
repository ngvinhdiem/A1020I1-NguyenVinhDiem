package b2_vong_lap_trong_java.baitap;

public class HienThiCacSNTNhoHon100 {
    public static void main(String[] args) {
        int number=2;
        while (true) {

            boolean check = true;

            int i = 2;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check==true) {
                System.out.println(number);

            }
            number++;
            if (number==100) break;

        }

    }
}
