package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room extends Services {
    private String freeServiceIncluded;

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public void showInfor() {
        System.out.println("ID: "+getId()+"\n"+"Tên dịch vụ: " + getServiceName() + "\n" + "Diện tích sử dụng: " +
                getUsedArea() + "\n" + "Chi phí thuê: " + getRentPrice() + "\n" + "Số lượng người tối đa: "
                + getMaxNumPeople() + "\n" + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + getRentType() +
                "\n" + "Dịch vụ miễn phí đi kèm: "+getFreeServiceIncluded()+"\n"+"Dịch vụ đi kèm: "+
                "Tên dịch vụ đi kèm: "+serviceExtra.getName()+ "\n"+"Đơn vị: "+ serviceExtra.getUnit()+"\n"
                +"Giá tiền: "+serviceExtra.getPrice());
    }

    public String toCSV() {
        return getId()+","+getServiceName() + "," + getUsedArea() + "," + getRentPrice() + "," + getMaxNumPeople()
                + ","  + getRentType() + ","  + getFreeServiceIncluded()+ ","+serviceExtra.getName()+","
                +serviceExtra.getUnit()+","+serviceExtra.getPrice()+"\n";
    }

    Scanner scanner = new Scanner(System.in);
    public void addInformation() {
        System.out.println("ID: ");
        String id = scanner.nextLine();
        while (!id.matches("^SVRO-[0-9]{4}$")) {
            System.out.println("Error! Nhập lại ID: ");
            id = scanner.nextLine();
        }
        setId(id);
        super.addInformation();
        System.out.println("Dịch vụ miễn phí đi kèm: ");
        setFreeServiceIncluded(scanner.nextLine());
    }



    public static class WriteToFileRoom {
        private static final String FILENAME = "D:\\A1020I1-NguyenVinhDiem\\FuramaResortModule2" +
                "\\src\\Data\\Room.csv";
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

    public static class ReadFileRoom {

        private static final String COMMA_DELIMITER = ",";
        public static void printNameAllRoomNotDuplicate() {
            BufferedReader br = null;
            try {
                String line;
                br = new BufferedReader(new FileReader("D:\\A1020I1-NguyenVinhDiem\\FuramaResortModule2" +
                        "\\src\\Data\\Room.csv"));
                ArrayList<String> roomNameList = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    boolean check = true;
                    for (String roomName : roomNameList) {
                        if (parseCsvLine(line).get(1).equals(roomName)) {
                            check = false;
                            break;
                        }
                        ;
                    }
                    if (check == true) {
                        System.out.println(parseCsvLine(line).get(1));
                        roomNameList.add(parseCsvLine(line).get(1));
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
        public static void printRoomDetail() {
            BufferedReader br = null;
            try {
                String line;
                br = new BufferedReader(new FileReader("D:\\A1020I1-NguyenVinhDiem\\FuramaResortModule2" +
                        "\\src\\Data\\Room.csv"));

                while ((line = br.readLine()) != null) {
                    printRoom(parseCsvLine(line));
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
        public static void printRoom(List<String> room) {
            System.out.println("ID: "+room.get(0)+","+"Tên dịch vụ: " + room.get(1) + "," + "Diện tích sử dụng: " +
                    room.get(2) + "," + "Chi phí thuê: " + room.get(3) + "," + "Số lượng người tối đa: "
                    + room.get(4) + "," + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + room.get(5) +
                    "," + "Dịch vụ miễn phí đi kèm: "+ room.get(6));
        }
    }
}
