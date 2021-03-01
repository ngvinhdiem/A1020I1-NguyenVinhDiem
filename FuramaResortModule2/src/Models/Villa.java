package Models;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class Villa extends Services {
    private String roomStandard, comfortsDescription;
    private int poolArea, floorNumber;
    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getComfortsDescription() {
        return comfortsDescription;
    }

    public void setComfortsDescription(String comfortsDescription) {
        this.comfortsDescription = comfortsDescription;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void showInfor() {
        System.out.println("ID: "+getId()+"\n"+"Tên dịch vụ: " + getServiceName() + "\n" + "Diện tích sử dụng: " +
                getUsedArea() + "\n" + "Chi phí thuê: " + getRentPrice() + "\n" + "Số lượng người tối đa: "
                + getMaxNumPeople() + "\n" + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + getRentType() +
                "\n" + "Tiêu chuẩn phòng: " + getRoomStandard() + "\n" + "Mô tả tiện nghi khác: " +
                getComfortsDescription() + "\n" + "Diện tích hồ bơi: " + getPoolArea() + "\n" + "Số tầng: " +
                getFloorNumber());
    }
    public String toString() {
        return "ID,"+getId()+","+"Tên dịch vụ," + getServiceName() + "," + "Diện tích sử dụng," +
                getUsedArea() + "," + "Chi phí thuê," + getRentPrice() + "," + "Số lượng người tối đa,"
                + getMaxNumPeople() + "," + "Kiểu thuê (bao gồm thuê theo năm tháng ngày giờ)," + getRentType() +
                "," + "Tiêu chuẩn phòng," + getRoomStandard() + "," + "Mô tả tiện nghi khác," +
                getComfortsDescription() + "," + "Diện tích hồ bơi," + getPoolArea() + "," + "Số tầng," +
                getFloorNumber();
    }
    public String toCSV() {
        return getId()+","+getServiceName() + "," + getUsedArea() + "," + getRentPrice() + "," + getMaxNumPeople()
                + ","  + getRentType() + ","  + getRoomStandard() + ","  + getComfortsDescription() + ","
                + getPoolArea() + ","  + getFloorNumber()+"\n";
    }

Scanner scanner = new Scanner(System.in);
    public void addInformation() {
        System.out.println("ID: ");
        setId(scanner.nextLine());
        System.out.println("Tên dịch vụ: ");
        setServiceName(scanner.nextLine());
        System.out.println("Diện tích sử dụng: ");
        setUsedArea(scanner.nextInt());
        System.out.println("Chi phí thuê: ");
        setRentPrice(scanner.nextInt());
        System.out.println("Số lượng người tối đa: ");
        setMaxNumPeople(scanner.nextInt());
        System.out.println("Kiểu thuê ̣(bao gồm thuê theo năm tháng ngày giờ):");
        setRentType(scanner.nextLine());
        System.out.println("Tiêu chuẩn phòng: ");
        setRoomStandard(scanner.nextLine());
        System.out.println("Mô tả tiện nghi khác: ");
        setComfortsDescription(scanner.nextLine());
        System.out.println("Diện tích hồ bơi: ");
        setPoolArea(scanner.nextInt());
        System.out.println("Số tầng: ");
        setFloorNumber(scanner.nextInt());
    }





   public static class WriteToFileVilla {
        private static final String FILENAME = "D:\\A1020I1-NguyenVinhDiem\\FuramaResortModule2" +
                "\\src\\Data\\Villa.csv";
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
    public static class ReadFileVilla {
        private static final String COMMA_DELIMITER = ",";
        public static void printVillaDetail() {
            BufferedReader br = null;
            try {
                String line;
                br = new BufferedReader(new FileReader("D:\\A1020I1-NguyenVinhDiem\\FuramaResortModule2" +
                        "\\src\\Data\\Villa.csv"));

                while ((line = br.readLine()) != null) {
                    printVilla(parseCsvLine(line));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException crunchifyException) {
                    crunchifyException.printStackTrace();
                }
            }
        }
        public static List<String> parseCsvLine(String csvLine) {
            List<String> result = new ArrayList<String>();
            if (csvLine != null) {
                String[] splitData = csvLine.split(COMMA_DELIMITER);
                for (int i = 0; i < splitData.length; i++) {
                    result.add(splitData[i]);
                }
            }
            return result;
        }
        private static void printVilla(List<String> villa) {
            System.out.println("ID: "+villa.get(0)+","+"Tên dịch vụ: " + villa.get(1) + "," + "Diện tích sử dụng: " +
                    villa.get(2) + "," + "Chi phí thuê: " + villa.get(3) + "," + "Số lượng người tối đa: "
                    + villa.get(4) + "," + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + villa.get(5) +
                    "," + "Tiêu chuẩn phòng: " + villa.get(6) + "," + "Mô tả tiện nghi khác: " +
                    villa.get(7) + "," + "Diện tích hồ bơi: " + villa.get(8) + "," + "Số tầng: " +
                    villa.get(9));
        }
    }
}