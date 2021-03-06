package b11_dsa_stack_queue.baitap;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Nguoi {
    Nguoi(String hoTen, String gioiTinh, String ngayThangNamSinh) {
        this.hoTen=hoTen;
        this.gioiTinh=gioiTinh;
        this.ngayThangNamSinh=ngayThangNamSinh;
    }
    String hoTen;
    String gioiTinh;
    String ngayThangNamSinh;
   public String toString() {
        return hoTen+" "+gioiTinh+" "+ngayThangNamSinh+"\n";
    }
}

class WriteToFileDemergingMan {
    private static final String FILENAME = "D:\\A1020I1-NguyenVinhDiem\\module_2" +
            "\\src\\b11_dsa_stack_queue\\baitap\\OutputDemergingMan.csv";
    public void write(String a) {
        try {
            File file = new File(FILENAME);
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            bufferedWriter.write(a);
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file. \n");
        } catch (IOException e) {
            System.out.println("An error occurred. \n");
            e.printStackTrace();
        }
    }
}

class WriteToFileDemergingWoman {
    private static final String FILENAME = "D:\\A1020I1-NguyenVinhDiem\\module_2" +
            "\\src\\b11_dsa_stack_queue\\baitap\\OutputDemergingWoman.csv";
    public void write(String a) {
        try {
            File file = new File(FILENAME);
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            bufferedWriter.write(a);
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file. \n");
        } catch (IOException e) {
            System.out.println("An error occurred. \n");
            e.printStackTrace();
        }
    }
}

public class ToChucDuLieuHopLyDemerging {
    public static void main(String[] args) {
        Queue<Nguoi> NU = new LinkedList<>();
        Queue<Nguoi> NAM = new LinkedList<>();
        Nguoi[] p = new Nguoi[8];
        p[0] = new Nguoi("A","Nam","1991-01-01");
        p[1] = new Nguoi("B","Nu","1992-02-02");
        p[2] = new Nguoi("C","Nam","1993-03-03");
        p[3] = new Nguoi("D","Nu","1994-04-04");
        p[4] = new Nguoi("E","Nam","1995-05-05");
        p[5] = new Nguoi("F","Nu","1996-06-06");
        p[6] = new Nguoi("G","Nam","1997-07-07");
        p[7] = new Nguoi("H","Nu","1998-08-08");
        for (Nguoi each : p) {
            if (each.gioiTinh=="Nam") NAM.offer(each);
            else if (each.gioiTinh=="Nu") NU.offer(each);
        }
WriteToFileDemergingMan writeToFileDemergingMan = new WriteToFileDemergingMan();
WriteToFileDemergingWoman writeToFileDemergingWoman = new WriteToFileDemergingWoman();
for ( Nguoi eachMan : NAM) {
    writeToFileDemergingMan.write(eachMan.toString());
}
for ( Nguoi eachWoman : NU) {
    writeToFileDemergingWoman.write(eachWoman.toString());
}



    }
}
