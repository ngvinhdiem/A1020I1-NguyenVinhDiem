package common;


import models.BenhAn;
import models.BenhAnThuong;
import models.BenhAnVIP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    static final String PATH ="src/data/medical_records.csv";
    static  File file = new File(PATH);
    public static void writeBenhAnThuong(List<BenhAnThuong> list, boolean selection){
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (models.BenhAnThuong BenhAnThuong: list) {
                bufferedWriter.write(BenhAnThuong.toCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeBenhAnVIP(List<BenhAnVIP> list, boolean selection){
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (models.BenhAnVIP BenhAnVIP: list) {
                bufferedWriter.write(BenhAnVIP.toCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeBenhAn(List<BenhAn> list, boolean selection){
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (models.BenhAn BenhAn: list) {
                bufferedWriter.write(BenhAn.toCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<BenhAn> readBenhAn(){
        List<BenhAn> list = new ArrayList<>();
        FileReader fileReader=null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line="";
            String[] arr = null;
            while ((line=bufferedReader.readLine())!=null){
                arr = line.split(",");
                if (arr[7].contains("VIP")) {
                    BenhAnVIP benhAnVIP = new BenhAnVIP(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],
                            arr[4],arr[5],arr[6],arr[7]);
                    list.add(benhAnVIP);
                }
                else {
                    BenhAnThuong benhAnThuong = new BenhAnThuong(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4]
                            ,arr[5],arr[6],Integer.parseInt(arr[7]));
                    list.add(benhAnThuong);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(" lỗi đọc file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

