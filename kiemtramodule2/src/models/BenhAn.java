package models;

import java.util.Scanner;

class MaBenhNhanException extends Exception {
    MaBenhNhanException() {
        super("Mã bệnh nhân phải đúng định dạng BN-XXXX, với XXXX là các kí tự số");
    }
}

class NgayNhapVienException extends Exception {
    NgayNhapVienException() {
        super("Phải đúng định dạng dd/mm/yyyy");
    }
}

class NgayRaVienException extends Exception {
    NgayRaVienException() {
        super("Phải đúng định dạng dd/mm/yyyy");
    }
}

class ThoiHanVIPException extends Exception {
    ThoiHanVIPException() {
        super("Phải đúng định dạng dd/mm/yyyy");
    }
}

class LoaiVIPException extends Exception {
    LoaiVIPException() {
        super("Loại VIP thuộc 1 trong 3: VIP I, VIP II, VIP III");
    }
}

public abstract class BenhAn {
    private int stt = 0;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String liDoNhapVien;

    @Override
    public String toString() {
        return "BenhAn{" +
                "stt=" + stt +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", maBenhNhan='" + maBenhNhan + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", liDoNhapVien='" + liDoNhapVien + '\'' +
                '}';
    }

    public abstract void showInfor();

    public String toCSV() {
        return stt + "," + maBenhAn + "," + maBenhNhan + "," + tenBenhNhan + "," + ngayNhapVien + "," + ngayRaVien + "," + liDoNhapVien;
    }

    public BenhAn(int stt, String maBenhAn, String maBenhNhan, String tenBenhNhan,
                  String ngayNhapVien, String ngayRaVien, String liDoNhapVien) {
        this.stt = stt;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.liDoNhapVien = liDoNhapVien;
    }

    public BenhAn() {

    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLiDoNhapVien() {
        return liDoNhapVien;
    }

    public void setLiDoNhapVien(String liDoNhapVien) {
        this.liDoNhapVien = liDoNhapVien;
    }

    //    public void maBenhAnValidate(String maBenhAn) throws NotFoundMedicalRecordException {
//        if (!maBenhAn.matches("^BA-[0-9]{4}$")) throw new NotFoundMedicalRecordException();
//    }
    public void themBenhAn() {
        Scanner scanner = new Scanner(System.in);
        String maBenhAn = "";
        while (true) {
            System.out.println("Mã bệnh án: ");
            maBenhAn = scanner.nextLine();
            if (maBenhAn.matches("^BA-[0-9]{4}$")) {
                break;
            } else System.out.println("Mã bệnh án phải đúng định dạng BA-XXXX, với XXXX là các kí tự số");
        }
        setMaBenhAn(maBenhAn);
        String maBenhNhan = "";
        while (true) {
            System.out.println("Mã bệnh nhân: ");
            maBenhNhan = scanner.nextLine();
            if (maBenhNhan.matches("^BN-[0-9]{4}$")) {
                break;
            } else System.out.println("Mã bệnh nhân phải đúng định dạng BN-XXXX, với XXXX là các kí tự số");
        }
        setMaBenhNhan(maBenhNhan);
        System.out.println("Tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();
        setTenBenhNhan(tenBenhNhan);
        String ngayNhapVien = "";
        while (true) {
            System.out.println("Ngày nhập viện: ");
            ngayNhapVien = scanner.nextLine();
            if (ngayNhapVien.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
                break;
            } else System.out.println("Ngày nhập viện phải đúng định dạng dd/MM/YYYY");
        }
        setNgayNhapVien(ngayNhapVien);
        String ngayRaVien = "";
        while (true) {
            System.out.println("Ngày ra viện: ");
            ngayRaVien = scanner.nextLine();
            if (ngayRaVien.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
                break;
            } else System.out.println("Ngày ra viện phải đúng định dạng dd/MM/YYYY");
        }
        setNgayRaVien(ngayRaVien);
        System.out.println("Lí do nhập viện: ");
        String liDoNhapVien = scanner.nextLine();
        setLiDoNhapVien(liDoNhapVien);
    }


}
