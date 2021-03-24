package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class House extends Services {
    static ArrayList<House> houseArrayList = new ArrayList<>();
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

    public void print(List<String> house) {
        House house1 = new House();
        house1.setId(house.get(0));
        house1.setServiceName(house.get(1));
        house1.setUsedArea(Integer.parseInt(house.get(2)));
        house1.setRentPrice(Integer.parseInt(house.get(3)));
        house1.setMaxNumPeople(Integer.parseInt(house.get(4)));
        house1.setRentType(house.get(5));
        house1.setRoomStandard(house.get(6));
        house1.setComfortsDescription(house.get(7));
        house1.setFloorNumber(Integer.parseInt(house.get(8)));
        houseArrayList.add(house1);
        System.out.println("ID: "+house.get(0)+","+"Tên dịch vụ: " + house.get(1) + "," + "Diện tích sử dụng: " +
                house.get(2) + "," + "Chi phí thuê: " + house.get(3) + "," + "Số lượng người tối đa: "
                + house.get(4) + "," + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + house.get(5) +
                "," + "Tiêu chuẩn phòng: " + house.get(6) + "," + "Mô tả tiện nghi khác: " +
                house.get(7) + "," + "Số tầng: " +
                house.get(8));
    }
}
