package models;

import java.util.Scanner;

public class BenhAnVIP extends BenhAn{
    private String loaiVip;
//    private String thoiHanVIP;
//
//    public String getThoiHanVIP() {
//        return thoiHanVIP;
//    }
//
//    public void setThoiHanVIP(String thoiHanVIP) {
//        this.thoiHanVIP = thoiHanVIP;
//    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public BenhAnVIP(int stt, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien,
                     String ngayRaVien, String liDoNhapVien, String loaiVip) {
        super(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
        this.loaiVip=loaiVip;

    }

    public BenhAnVIP() {
    }


    @Override
    public String toString() {
        return "BenhAnVIP{" + super.toString() +","+
                "loaiVip='" + loaiVip + '\'' +
                '}';
    }

    @Override
    public void showInfor() {

    }

    @Override
    public String toCSV() {
        return super.toCSV()+","+loaiVip;
    }

    public void themBenhAn() {
        super.themBenhAn();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loại VIP:");
        String loaiVIP="";
        System.out.println("1. VIP I\n2. VIP II\n3. VIP III");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1: loaiVIP="VIP I"; break;
            case 2: loaiVIP="VIP II"; break;
            case 3: loaiVIP="VIP III"; break;
        }
        setLoaiVip(loaiVIP);

//        while (true) {
//            System.out.println("Thời hạn VIP: ");
//            String thoiHanVIP = scanner.nextLine();
//            if (thoiHanVIP.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
//                break;
//            }
//            else System.out.println("Thời hạn VIP phải đúng định dạng dd/MM/YYYY");
//        }
//        setThoiHanVIP(thoiHanVIP);
    }
}
