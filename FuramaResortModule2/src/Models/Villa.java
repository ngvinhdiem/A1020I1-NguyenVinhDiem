package Models;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Villa extends Services {
    static ArrayList<Villa> villaArrayList = new ArrayList<>();
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
        System.out.println("ID: " + getId() + "\n" + "Tên dịch vụ: " + getServiceName() + "\n" + "Diện tích sử dụng: " +
                getUsedArea() + "\n" + "Chi phí thuê: " + getRentPrice() + "\n" + "Số lượng người tối đa: "
                + getMaxNumPeople() + "\n" + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + getRentType() +
                "\n" + "Tiêu chuẩn phòng: " + getRoomStandard() + "\n" + "Mô tả tiện nghi khác: " +
                getComfortsDescription() + "\n" + "Diện tích hồ bơi: " + getPoolArea() + "\n" + "Số tầng: " +
                getFloorNumber()+"\n"+"Dịch vụ đi kèm:"+"Tên dịch vụ đi kèm: "+serviceExtra.getName()+"\n"+"Đơn vị: "+
                serviceExtra.getUnit()+"\n"+"Giá tiền: "+serviceExtra.getPrice());
    }


    public String toCSV() {
        return getId() + "," + getServiceName() + "," + getUsedArea() + "," + getRentPrice() + "," + getMaxNumPeople()
                + "," + getRentType() + "," + getRoomStandard() + "," + getComfortsDescription() + ","
                + getPoolArea() + "," + getFloorNumber() + ","+serviceExtra.getName()+","+serviceExtra.getUnit()+
                ","+serviceExtra.getPrice()+"\n";
    }

    Scanner scanner = new Scanner(System.in);

    public void addInformation() {
        System.out.println("ID: ");
        String id = scanner.nextLine();
        while (!id.matches("^SVVL-[0-9]{4}$")) {
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
        System.out.println("Diện tích hồ bơi: ");
        int poolArea = scanner.nextInt();
        while (poolArea<=30) {
            System.out.println("Error! Nhập lại diện tích hồ bơi: ");
            poolArea = scanner.nextInt();
        }
        setPoolArea(poolArea);
        System.out.println("Số tầng: ");
        int floorNumber = scanner.nextInt();
        while (floorNumber<=0) {
            System.out.println("Error! Nhập lại số tầng: ");
            floorNumber = scanner.nextInt();
        }
        setFloorNumber(floorNumber);
    }

         public void print(List<String> villa) {
        Villa villa1 = new Villa();
        villa1.setId(villa.get(0));
        villa1.setServiceName(villa.get(1));
        villa1.setUsedArea(Integer.parseInt(villa.get(2)));
        villa1.setRentPrice(Integer.parseInt(villa.get(3)));
        villa1.setMaxNumPeople(Integer.parseInt(villa.get(4)));
        villa1.setRentType(villa.get(5));
        villa1.setRoomStandard(villa.get(6));
        villa1.setComfortsDescription(villa.get(7));
        villa1.setPoolArea(Integer.parseInt(villa.get(8)));
        villa1.setFloorNumber(Integer.parseInt(villa.get(9)));
        villaArrayList.add(villa1);
            System.out.println("ID: " + villa.get(0) + "," + "Tên dịch vụ: " + villa.get(1) + "," + "Diện tích sử dụng: " +
                    villa.get(2) + "," + "Chi phí thuê: " + villa.get(3) + "," + "Số lượng người tối đa: "
                    + villa.get(4) + "," + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + villa.get(5) +
                    "," + "Tiêu chuẩn phòng: " + villa.get(6) + "," + "Mô tả tiện nghi khác: " +
                    villa.get(7) + "," + "Diện tích hồ bơi: " + villa.get(8) + "," + "Số tầng: " +
                    villa.get(9));
        }
}