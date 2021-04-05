package controller;

import common.DocGhiFile;
import models.BenhAn;
import models.BenhAnThuong;
import models.BenhAnVIP;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class NotFoundMedicalRecordException extends Exception {
    NotFoundMedicalRecordException() {
        super("Mã bệnh án phải đúng định dạng BA-XXXX, với XXXX là các kí tự số");
    }
}
public class MainController {
    public static void main(String[] args) {
        boolean check=true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--\nChọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới\n2. Xóa\n3. Xem danh sách các bệnh án\n4. Thoát\nChọn chức năng: ");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    System.out.println("1. Benh an thuong\n2. Benh an VIP");
                    int selection = Integer.parseInt(scanner.nextLine());
                    int stt = DocGhiFile.readBenhAn().size();
                    switch (selection) {
                        case 1:
                            List<BenhAnThuong> benhAnThuongList = new ArrayList<>();
                            BenhAnThuong benhAnThuong = new BenhAnThuong();
                            benhAnThuong.setStt(stt+1);
                            benhAnThuong.themBenhAn();
                            benhAnThuongList.add(benhAnThuong);
                            DocGhiFile.writeBenhAnThuong(benhAnThuongList,true);
                            break;
                        case 2:
                            List<BenhAnVIP> benhAnVIPList = new ArrayList<>();
                            BenhAnVIP benhAnVIP = new BenhAnVIP();
                            benhAnVIP.setStt(stt+1);
                            benhAnVIP.themBenhAn();
                            benhAnVIPList.add(benhAnVIP);
                            DocGhiFile.writeBenhAnVIP(benhAnVIPList,true);
                            break;
                        default:
                            System.out.println("Không có lựa chọn này!");
                            break;
                    }
                    break;
                case 2:
                    List<BenhAn> list = new ArrayList<>();
                    list = DocGhiFile.readBenhAn();
                    for (BenhAn benhAn :list) {
                        System.out.println(benhAn.toString());
                    }
                    System.out.println("Nhập STT bệnh án muốn xóa:");
                    String choose3 = scanner.nextLine();
                    System.out.println("Bạn chắc chắn muốn xóa không? \n1. YES\n2. NO");
                    int choose1 = Integer.parseInt(scanner.nextLine());
                    if (choose1==1) {
                        int choose=0;
                        for (BenhAn benhAn: list) {
                            if (benhAn.getMaBenhAn().equals(choose3)) choose=benhAn.getStt();
                        }
                        list.remove(list.get(choose - 1));
                        int index = 1;
                        for (BenhAn benhAn : list) {
                            benhAn.setStt(index);
                            index++;
                        }
                        for (BenhAn benhAn : list) {
                            DocGhiFile.writeBenhAn(list, false);
                        }
                        for (BenhAn benhAn :DocGhiFile.readBenhAn()) {
                            System.out.println(benhAn.toString());
                        }
                    }
                    break;
                case 3:
                    for (BenhAn benhAn :DocGhiFile.readBenhAn()) {
                        System.out.println(benhAn.toString());
                    }
                    break;
                case 4:
                    check=false;
                    break;
                default:
                    break;
            }
        } while (check);
        System.exit(0);
    }
}
