package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class House extends Services {
    private String roomStandard,comfortsDescription,floorNumber;

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

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void showInfor() {
        System.out.println("ID: "+getId()+"\n"+"Tên dịch vụ: "+ getServiceName() + "\n" + "Diện tích sử dụng: " +
                getUsedArea() +"\n" + "Chi phí thuê: "+ getRentPrice() +"\n" +"Số lượng người tối đa: "
                + getMaxNumPeople() + "\n" + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): "+getRentType() +
                "\n" + "Tiêu chuẩn phòng: "+getRoomStandard()+"\n"+"Mô tả tiện nghi khác: "+getComfortsDescription()+
                "\n"+"Số tầng: "+getFloorNumber());
    }
    public String toString() {
        return "ID,"+getId()+","+"Tên dịch vụ," + getServiceName() + "," + "Diện tích sử dụng," +
                getUsedArea() + "," + "Chi phí thuê," + getRentPrice() + "," + "Số lượng người tối đa,"
                + getMaxNumPeople() + "," + "Kiểu thuê (bao gồm thuê theo năm tháng ngày giờ)," + getRentType() +
                "," + "Tiêu chuẩn phòng," + getRoomStandard() + "," + "Mô tả tiện nghi khác," +
                getComfortsDescription() + "," + "Số tầng," + getFloorNumber();
    }
    public String toCSV() {
        return getId()+","+getServiceName() + "," + getUsedArea() + "," + getRentPrice() + "," + getMaxNumPeople()
                + ","  + getRentType() + ","  + getRoomStandard() + ","  + getComfortsDescription() + ","
                + getFloorNumber()+"\n";
    }
    public static class WriteToFileHouse {
        private static final String FILENAME = "D:\\A1020I1-NguyenVinhDiem\\FuramaResortModule2" +
                "\\src\\Data\\House.csv";
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
    public static class ReadFileHouse {

        private static final String COMMA_DELIMITER = ",";

        public static void printHouseDetail() {
            BufferedReader br = null;
            try {
                String line;
                br = new BufferedReader(new FileReader("D:\\A1020I1-NguyenVinhDiem\\FuramaResortModule2" +
                        "\\src\\Data\\House.csv"));

                while ((line = br.readLine()) != null) {
                    printHouse(parseCsvLine(line));
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
        public static void printHouse(List<String> house) {
            System.out.println("ID: "+house.get(0)+","+"Tên dịch vụ: " + house.get(1) + "," + "Diện tích sử dụng: " +
                    house.get(2) + "," + "Chi phí thuê: " + house.get(3) + "," + "Số lượng người tối đa: "
                    + house.get(4) + "," + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + house.get(5) +
                    "," + "Tiêu chuẩn phòng: " + house.get(6) + "," + "Mô tả tiện nghi khác: " +
                    house.get(7) + "," + "Số tầng: " +
                    house.get(8));
        }
    }
}
