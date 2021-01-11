package b2_vong_lap_trong_java.baitap;


public class HienThi20SNTDauTien {
    public static void main(String[] args) {
        int count=0;
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
                count++;
            }
            number++;
            if (count==20) break;

        }

    }
}
