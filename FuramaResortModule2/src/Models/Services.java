package Models;
import java.util.Scanner;
public abstract class Services {
    private String id,serviceName,rentType;
    private int usedArea,rentPrice,maxNumPeople;
    ServiceExtra serviceExtra = new ServiceExtra();
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public int getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(int usedArea) {
        this.usedArea = usedArea;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getMaxNumPeople() {
        return maxNumPeople;
    }

    public void setMaxNumPeople(int maxNumPeople) {
        this.maxNumPeople = maxNumPeople;
    }

    public abstract void showInfor();
    public void addInformation() throws NumberFormatException {
        String[] serviceExtraList ={"massage","food","drink","karaoke","car"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tên dịch vụ: ");
        String serviceName = scanner.nextLine();
        while (!serviceName.matches("^[A-Z][a-z]{0,}$")) {
            System.out.println("Error! Nhập lại tên dịch vụ: ");
            serviceName = scanner.nextLine();
        }
        setServiceName(serviceName);
        System.out.println("Diện tích sử dụng: ");
        String usedArea = scanner.nextLine();
        while (Integer.parseInt(usedArea)<=30) {
            System.out.println("Error! Nhập lại diện tích sử dụng: ");
            usedArea = scanner.nextLine();
        }
        setUsedArea(Integer.parseInt(usedArea));
        System.out.println("Chi phí thuê: ");
        String rentPrice = scanner.nextLine();
        while (Integer.parseInt(rentPrice)<=0) {
            System.out.println("Error! Nhập lại chi phí thuê: ");
            rentPrice = scanner.nextLine();
        }
        setRentPrice(Integer.parseInt(rentPrice));
        System.out.println("Số lượng người tối đa: ");
        String maxNumPeople = scanner.nextLine();
        while (Integer.parseInt(maxNumPeople)<=0||Integer.parseInt(maxNumPeople)>=20) {
            System.out.println("Error! Nhập lại số lượng người tối đa: ");
            maxNumPeople = scanner.nextLine();
        }
        setMaxNumPeople(Integer.parseInt(maxNumPeople));
        scanner.nextLine();
        System.out.println("Kiểu thuê ̣(bao gồm thuê theo năm tháng ngày giờ):");
        String rentType = scanner.nextLine();
        while (!rentType.matches("^[A-Z][\\p{all}]{0,}$")) {
            System.out.println("Error! Nhập lại kiểu thuê ̣(bao gồm thuê theo năm tháng ngày giờ): ");
            rentType = scanner.nextLine();
        }
        setRentType(rentType);
        System.out.println("Dịch vụ đi kèm:");
        System.out.println("Tên dịch vụ đi kèm:");
        String exService = scanner.nextLine();
        boolean check=false;
        while (check==false) {
            for (String extraService : serviceExtraList) {
                if (exService.equals(extraService)) {
                    check = true;
                    break;
                } else {
                    System.out.println("Error! Nhập lại tên dịch vụ đi kèm: ");
                    exService = scanner.nextLine();
                }
            }
        }
        serviceExtra.setName(exService);
        System.out.println("Đơn vị: ");
        String unit = scanner.nextLine();
        while (Integer.parseInt(unit)<=0) {
            System.out.println("Error! Nhập lại đơn vị: ");
            unit = scanner.nextLine();
        }
        serviceExtra.setUnit(Integer.parseInt(unit));
        System.out.println("Giá tiền: ");
        String price = scanner.nextLine();
        while (Integer.parseInt(price)<=0) {
            System.out.println("Error! Nhập lại giá tiền: ");
            price = scanner.nextLine();
        }
        serviceExtra.setPrice(Integer.parseInt(price));
    }
}
