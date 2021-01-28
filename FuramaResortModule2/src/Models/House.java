package Models;

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
        System.out.println("Tên dịch vụ: "+ getServiceName() + "\n" + "Diện tích sử dụng: " +
                getUsedArea() +"\n" + "Chi phí thuê: "+ getRentPrice() +"\n" +"Số lượng người tối đa: "
                + getMaxNumPeople() + "\n" + "Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ): "+getRentType() +
                "\n" + "Tiêu chuẩn phòng: "+getRoomStandard()+"\n"+"Mô tả tiện nghi khác: "+getComfortsDescription()+
                "\n"+"Số tầng: "+getFloorNumber());
    }
}
