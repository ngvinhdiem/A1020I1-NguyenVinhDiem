package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class House extends Services {
    private String roomStandard,comfortsDescription;
    private int floorNumber;

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

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void showInfor() {
        System.out.println("ID: "+getId()+"\n"+"Tên dịch vụ: "+ getServiceName() + "\n" + "Diện tích sử dụng: " +
                getUsedArea() +"\n" + "Chi phí thuê: "+ getRentPrice() +"\n" +"Số lượng người tối đa: "
                + getMaxNumPeople() + "\n" + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): "+getRentType() +
                "\n" + "Tiêu chuẩn phòng: "+getRoomStandard()+"\n"+"Mô tả tiện nghi khác: "+getComfortsDescription()+
                "\n"+"Số tầng: "+getFloorNumber()+"\n"+"Dịch vụ đi kèm: "+"Tên dịch vụ đi kèm: "+serviceExtra.getName()+
                "\n"+"Đơn vị: "+ serviceExtra.getUnit()+"\n"+"Giá tiền: "+serviceExtra.getPrice());
    }

    public String toCSV() {
        return getId()+","+getServiceName() + "," + getUsedArea() + "," + getRentPrice() + "," + getMaxNumPeople()
                + ","  + getRentType() + ","  + getRoomStandard() + ","  + getComfortsDescription() + ","
                + getFloorNumber()+ ","+serviceExtra.getName()+","+serviceExtra.getUnit()+
                ","+serviceExtra.getPrice()+"\n";
    }


    Scanner scanner = new Scanner(System.in);
    public void addInformation() {
        System.out.println("ID: ");
        String id = scanner.nextLine();
        while (!id.matches("^SVHO-[0-9]{4}$")) {
            System.out.println("Error! Nhập lại ID: ");
            id = scanner.nextLine();
        }
        setId(id);
        super.addInformation();
        System.out.println("Tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
        while (!roomStandard.matches("^[A-Z][\\p{all}]{0,}$")) {
            System.out.println("Error! Nhập lại tiêu chuẩn phòng: ");
            roomStandard = scanner.nextLine();
        }
        setRoomStandard(roomStandard);
        System.out.println("Mô tả tiện nghi khác: ");
        setComfortsDescription(scanner.nextLine());
        System.out.println("Số tầng: ");
        int floorNumber = scanner.nextInt();
        while (floorNumber<=0) {
            System.out.println("Error! Nhập lại số tầng: ");
            floorNumber = scanner.nextInt();
        }
        setFloorNumber(floorNumber);
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

        public static void printNameAllHouseNotDuplicate() {
            BufferedReader br = null;
            try {
                String line;
                br = new BufferedReader(new FileReader("D:\\A1020I1-NguyenVinhDiem\\FuramaResortModule2" +
                        "\\src\\Data\\House.csv"));
                ArrayList<String> houseNameList = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    boolean check = true;
                    for (String houseName : houseNameList) {
                        if (parseCsvLine(line).get(1).equals(houseName)) {
                            check = false;
                            break;
                        }
                        ;
                    }
                    if (check == true) {
                        System.out.println(parseCsvLine(line).get(1));
                        houseNameList.add(parseCsvLine(line).get(1));
                    }

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
            List<String> result = new ArrayList();
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
