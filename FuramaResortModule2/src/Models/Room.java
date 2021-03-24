package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room extends Services {
    static ArrayList<Room> roomArrayList = new ArrayList<>();
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


    public void print(List<String> room) {
        Room room1 = new Room();
        room1.setId(room.get(0));
        room1.setServiceName(room.get(1));
        room1.setUsedArea(Integer.parseInt(room.get(2)));
        room1.setRentPrice(Integer.parseInt(room.get(3)));
        room1.setMaxNumPeople(Integer.parseInt(room.get(4)));
        room1.setRentType(room.get(5));
        room1.setFreeServiceIncluded(room.get(6));
        roomArrayList.add(room1);
        System.out.println("ID: "+room.get(0)+","+"Tên dịch vụ: " + room.get(1) + "," + "Diện tích sử dụng: " +
                room.get(2) + "," + "Chi phí thuê: " + room.get(3) + "," + "Số lượng người tối đa: "
                + room.get(4) + "," + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): " + room.get(5) +
                "," + "Dịch vụ miễn phí đi kèm: "+ room.get(6));
    }

}
