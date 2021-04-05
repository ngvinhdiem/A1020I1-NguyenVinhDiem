package Models;

import java.io.*;
import java.util.*;

public abstract class Services {
    private String id, serviceName, rentType;
    private int usedArea, rentPrice, maxNumPeople;
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


//    public String toCSV() {
//       return "";
//    }

    //////////  write file
    public static class WriteToFile {
        String FILENAME;

        public WriteToFile(String path) {
            FILENAME = path;
        }

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

    ////////

    public abstract void showInfor();


    //////// add information
    public void addInformation() throws InputMismatchException {
        String[] serviceExtraList = {"massage", "food", "drink", "karaoke", "car"};
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
        while (Integer.parseInt(usedArea) <= 30) {
            System.out.println("Error! Nhập lại diện tích sử dụng: ");
            usedArea = scanner.nextLine();
        }
        setUsedArea(Integer.parseInt(usedArea));
        System.out.println("Chi phí thuê: ");
        String rentPrice = scanner.nextLine();
        while (Integer.parseInt(rentPrice) <= 0) {
            System.out.println("Error! Nhập lại chi phí thuê: ");
            rentPrice = scanner.nextLine();
        }
        setRentPrice(Integer.parseInt(rentPrice));
        System.out.println("Số lượng người tối đa: ");
        String maxNumPeople = scanner.nextLine();
        while (Integer.parseInt(maxNumPeople) <= 0 || Integer.parseInt(maxNumPeople) >= 20) {
            System.out.println("Error! Nhập lại số lượng người tối đa: ");
            maxNumPeople = scanner.nextLine();
        }
        setMaxNumPeople(Integer.parseInt(maxNumPeople));
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
        boolean check = false;
        while (check == false) {
            for (String extraService : serviceExtraList) {
                if (exService.equals(extraService)) {
                    check = true;
                    break;
                }
            }
            if (check == true) break;
            System.out.println("Error! Nhập lại tên dịch vụ đi kèm: ");
            exService = scanner.nextLine();
        }
        serviceExtra.setName(exService);
        System.out.println("Đơn vị: ");
        String unit = scanner.nextLine();
        while (Integer.parseInt(unit) <= 0) {
            System.out.println("Error! Nhập lại đơn vị: ");
            unit = scanner.nextLine();
        }
        serviceExtra.setUnit(Integer.parseInt(unit));
        System.out.println("Giá tiền: ");
        String price = scanner.nextLine();
        while (Integer.parseInt(price) <= 0) {
            System.out.println("Error! Nhập lại giá tiền: ");
            price = scanner.nextLine();
        }
        serviceExtra.setPrice(Integer.parseInt(price));
    }
    //////////////



    /////      ReadFile

    public void printAllNameNotDuplicate(String path) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            TreeSet<String> nameList = new TreeSet<>();
            while ((line = br.readLine()) != null) {
                boolean check = true;
                for (String name : nameList) {
                    if (parseCsvLine(line).get(1).equals(name)) {
                        check = false;
                        break;
                    }
                }
                if (check == true) {
//                    System.out.println(parseCsvLine(line).get(1));
                    nameList.add(parseCsvLine(line).get(1));
                }

            }
            System.out.println("All Name Not Duplicated:");
            for ( String name : nameList) {
                System.out.println(name);
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

    public void printDetail(String path) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                print(parseCsvLine(line));
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
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public void print(List<String> name) {
    }

    /////////////////////


}
