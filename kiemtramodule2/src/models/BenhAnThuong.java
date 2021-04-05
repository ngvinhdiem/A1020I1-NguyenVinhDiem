package models;

import java.util.Scanner;

public class BenhAnThuong extends BenhAn {
    private int phiNamVien;
private String except;
    public int getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(int phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhAnThuong(int stt, String maBenhAn, String maBenhNhan, String tenBenhNhan,
                        String ngayNhapVien, String ngayRaVien, String liDoNhapVien, int phiNamVien) {
        super(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public BenhAnThuong() {
    }

    @Override
    public String toString() {
        return "BenhAnThuong{" + super.toString() + "," +
                "phiNamVien=" + phiNamVien +
                '}';
    }

    @Override
    public void showInfor() {

    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + phiNamVien;
    }

    public void themBenhAn() {
        super.themBenhAn();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Phí nhập viện:");
        int phiNamVien = Integer.parseInt(scanner.nextLine());
        setPhiNamVien(phiNamVien);
    }


}
