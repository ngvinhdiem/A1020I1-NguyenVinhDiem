package b3_mang_va_phuong_thuc_trong_java.thuchanh;
import  java.util.Scanner;
public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] students = {"Toan", "Nguyen", "Tuan", "Quang", "Le", "Long", "Diem", "Minh", "Hoang", "Dung"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten HS: ");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Vi tri cua HS " + input_name + " trong danh sach la: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("Khong tim thay" + input_name + " trong danh sach!.");
    }
}
