package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static Models.Services.parseCsvLine;

class NameException extends Exception {
    NameException() {
        super("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
    }
}


class EmailException extends Exception {
    EmailException() {
        super("Email phải đúng định dạng abc@abc.abc");
    }
}

class BirthdayException extends Exception {

    BirthdayException() {
        super("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
    }
}

class GenderException extends Exception {
    GenderException() {
        super("Giới tính phải là: Male, Female hoặc Unknown");
    }
}

class IdNumberException extends Exception {
    IdNumberException() {
        super("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
    }
}

class PhoneNumberException extends Exception {
    PhoneNumberException() {
        super("Số điện thoại phải có dạng một chuỗi số");
    }
}

public class Customer implements Comparable<Customer> {


    private String name, dateOfBirth, gender, idNumber, phoneNumber, email, customerType, address;
    private Services servicesUsing;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getBirthYear() {
        return Integer.parseInt(this.getDateOfBirth().substring(6, 10));

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    private Services services;

    public void showInfor() {

    }

    @Override
    public String toString() {
        return "Họ và tên: " + name + "," + "Ngày sinh: " + dateOfBirth + "," + "Giới tính: " +
                gender + "," + "Số CMND: " + idNumber + "," + "SĐT: "
                + phoneNumber + "," + "Email: " + email +
                "," + "Loại khách: " + customerType + "," + "Địa chỉ: " +
                address;
    }

    public String toCSV() {
        return name + "," + dateOfBirth + "," + gender + "," + idNumber + "," + phoneNumber + "," +
                email + "," + customerType + "," + address;
    }

    public void nameValidate(String name) throws NameException {
        ArrayList<Character> upperCaseArray = new ArrayList<>();
        Character[] upperArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q'
                , 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        upperCaseArray.addAll(Arrays.asList(upperArray));
        boolean check = true;
        for (int index = 0; index < name.length(); index++) {
            if ((name.charAt(index) == ' ' && !upperCaseArray.contains(name.charAt(index + 1))) ||
                    (name.charAt(index) == ' ' && (index == 0 || index == name.length() - 1)) ||
                    (!upperCaseArray.contains(name.charAt(0)))) {
                check = false;
                break;
            }
        }
        if (!check) throw new NameException();
    }

    public void dobValidate(String dateOfBirth) throws BirthdayException {
        int i = 0;
        char[] dobArray = new char[10];
        char[] yearArray = new char[4];
        boolean check = true;
        int j = 0;
        for (Character ch : dateOfBirth.toCharArray()) {
            if (((i == 2 || i == 5) && !(ch == '/'))) check = false;
            if (i > 5) {
                yearArray[j] = ch;
                j++;
            }
            if (i != 2 && i != 5 && !Character.isDigit(ch)) check = false;
            dobArray[i] = ch;
            i++;
        }
        if (Integer.parseInt((String.valueOf(yearArray))) < 1900 || (Integer.parseInt((String.valueOf(yearArray)))) > 2003)
            check = false;
        if (!check) throw new BirthdayException();

    }

    public String genderChange(String gender) {
        int i = 0;
        ArrayList<Character> genderArray = new ArrayList<Character>();
        for (Character ch : gender.toCharArray()) {
            if (i == 0) genderArray.add(Character.toUpperCase(ch));
            else genderArray.add(Character.toLowerCase(ch));
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (Character s : genderArray) {
            sb.append(s);
        }
        return sb.toString();
    }

    public void genderValidate(String gender) throws GenderException {
        boolean check = true;
        String[] genderExample = {"Male", "Female", "Unknown"};
        List<String> genderExampleList = Arrays.asList(genderExample);
        if (!genderExampleList.contains(gender)) check = false;
        if (!check) throw new GenderException();
    }

    public void idNumberValidate(String idNumber) throws IdNumberException {
        if (!(idNumber.matches("^[0-9]{9}$"))) throw new IdNumberException();
    }

    public void phoneNumberValidate(String phoneNumber) throws PhoneNumberException {
        if (!(phoneNumber.matches("^[0-9]+$"))) throw new PhoneNumberException();
    }

    public void emailValidate(String email) throws EmailException {
        if (!(email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$"))) throw new EmailException();
    }

    public void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        boolean nameCheck = false;
        String name = "";
        while (!nameCheck) {
            try {
                System.out.println("Họ và tên: ");
                name = scanner.nextLine();
                nameValidate(name);
                nameCheck = true;
            } catch (Exception m) {
                System.out.println("Lỗi: " + new NameException());
                nameCheck = false;
            }
        }
        setName(name);
        boolean dobCheck = false;
        String dateOfBirth = "";
        while (!dobCheck) {
            try {
                System.out.println("Ngày sinh: ");
                dateOfBirth = scanner.nextLine();
                dobValidate(dateOfBirth);
                dobCheck = true;
            } catch (Exception m) {
                System.out.println("Lỗi: " + new BirthdayException());
                dobCheck = false;
            }
        }
        setDateOfBirth(dateOfBirth);
        boolean genderCheck = false;
        String gender = "";
        while (!genderCheck) {
            try {
                System.out.println("Giới tính: ");
                gender = scanner.nextLine();
                genderValidate(genderChange(gender));
                genderCheck = true;
                gender = genderChange(gender);
            } catch (Exception m) {
                System.out.println("Lỗi: " + new GenderException());
                genderCheck = false;
            }
        }
        setGender(gender);
        boolean idNumberCheck = false;
        String idNumber = "";
        while (!idNumberCheck) {
            try {
                System.out.println("Số CMND: ");
                idNumber = scanner.nextLine();
                idNumberValidate(idNumber);
                idNumberCheck = true;
            } catch (Exception m) {
                System.out.println("Lỗi: " + new IdNumberException());
                idNumberCheck = false;
            }
        }
        setIdNumber(idNumber);

        boolean phoneNumberCheck = false;
        String phoneNumber = "";
        while (!phoneNumberCheck) {
            try {
                System.out.println("Số điện thoại: ");
                phoneNumber = scanner.nextLine();
                phoneNumberValidate(phoneNumber);
                phoneNumberCheck = true;
            } catch (Exception m) {
                System.out.println("Lỗi: " + new PhoneNumberException());
                phoneNumberCheck = false;
            }
        }
        setPhoneNumber(phoneNumber);
        boolean emailCheck = false;
        String email = "";
        while (!emailCheck) {
            try {
                System.out.println("Email: ");
                email = scanner.nextLine();
                emailValidate(email);
                emailCheck = true;
            } catch (Exception m) {
                System.out.println("Lỗi: " + new EmailException());
                emailCheck = false;
            }
        }
        setEmail(email);
        System.out.println("Loại khách: ");
        String customerType = scanner.nextLine();
        setCustomerType(customerType);
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        setAddress(address);

        Services.WriteToFile writeToFileCustomer = new Services.WriteToFile("D:\\\\A1020I1-NguyenVinhDiem" +
                "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Customer.csv");
        writeToFileCustomer.write(name + "," + dateOfBirth + "," + gender + "," + idNumber + "," + phoneNumber + "," +
                email + "," + customerType + "," + address + "\n");
    }

    static ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void printDetail(String path) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                add(parseCsvLine(line));
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

    public void add(List<String> customer) {
        Customer customer1 = new Customer();
        customer1.setName(customer.get(0));
        customer1.setDateOfBirth(customer.get(1));
        customer1.setGender(customer.get(2));
        customer1.setIdNumber(customer.get(3));
        customer1.setPhoneNumber(customer.get(4));
        customer1.setEmail(customer.get(5));
        customer1.setCustomerType(customer.get(6));
        customer1.setAddress(customer.get(7));
        customerArrayList.add(customer1);
//        System.out.println(customer1.toString());
//        System.out.println("Họ và tên: " + customer.get(0) + "," + "Ngày sinh: " + customer.get(1) + "," + "Giới tính: " +
//                customer.get(2) + "," + "Số CMND: " + customer.get(3) + "," + "SĐT: "
//                + customer.get(4) + "," + "Email: " + customer.get(5) +
//                "," + "Loại khách: " + customer.get(6) + "," + "Địa chỉ: " +
//                customer.get(7));
    }

    public void showInformationCustomers() {
        Customer customer = new Customer();
        customer.printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Customer.csv");
        ArrayList<Customer> customerArrayList1 = new ArrayList<>(customerArrayList);
        Collections.sort(customerArrayList1);
        YearBirthComparator yearBirthComparator = new YearBirthComparator();
        Customer subCustomer = new Customer();
        ArrayList<Customer> sameNameCustomerList = new ArrayList<>();
        ArrayList<Customer> realCustomerList = new ArrayList<>();
        int customerNumber = 1;
        for (Customer customer1 : customerArrayList1) {
            if (((sameNameCustomerList.size() == 0) || (customer1.getName().equals(subCustomer.getName()))) && (customerNumber != customerArrayList1.size())) {
                sameNameCustomerList.add(customer1);
            } else {
                if (customerNumber == customerArrayList1.size()) sameNameCustomerList.add(customer1);
                Collections.sort(sameNameCustomerList, yearBirthComparator);
                realCustomerList.addAll(sameNameCustomerList);
                sameNameCustomerList.clear();
                sameNameCustomerList.add(customer1);
            }
            subCustomer = customer1;
            customerNumber++;
        }
        System.out.println("\n");
        for (Customer customer1 : realCustomerList) {
            System.out.println(customer1.toString());
        }
        customerArrayList.clear();
    }

    public void addNewBooking() throws NumberFormatException {
        Customer customer = new Customer();
        customer.printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Customer.csv");
        int index = 1;
        for (Customer customer1 : customerArrayList) {
            System.out.println("STT: " + index + "," + customer1.toString());
            index++;
        }
        System.out.println("Nhạp STT customer muốn  thực hiện booking: ");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        index = 0;
        Customer mainCustomer = new Customer();
        for (Customer customer1 : customerArrayList) {
            if (index == choose) {
                System.out.println("STT: " + index + "," + customer1.toString());
                mainCustomer = customer1;
            }
            index++;
        }
        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");

        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("Danh sách villa :");
                Villa villa = new Villa();
                villa.printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Villa.csv");
                boolean check=false;
                Villa subVilla = new Villa();
                int count =0;
                while (!check) {
                    System.out.println("Nhập ID villa bạn muốn chọn: ");
                    if (count==0) scanner.nextLine();
                    String idVilla = scanner.nextLine();
                    for (Villa villa1 : villa.villaArrayList) {
                        if (villa1.getId().equals(idVilla)) {
                            subVilla = villa1;
                            mainCustomer.setServices(subVilla);
                            check = true;
                        }
                    }
                    if (!check) System.out.println("Không có ID villa này!");
                    count++;
                }
                Services.WriteToFile writeToFileBooking = new Services.WriteToFile("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Booking.csv");
                writeToFileBooking.write(mainCustomer.toCSV() + "," + subVilla.toCSV());
                break;
            case 2:
                System.out.println("Danh sách house :");
                House house = new House();
                house.printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\House.csv");
                check=false;
                House subHouse = new House();
                count =0;
                while (!check) {
                    System.out.println("Nhập ID house bạn muốn chọn: ");
                    if (count==0) scanner.nextLine();
                    String idHouse = scanner.nextLine();
                    for (House house1 : house.houseArrayList) {
                        if (house1.getId().equals(idHouse)) {
                            subHouse = house1;
                            mainCustomer.setServices(subHouse);
                            check = true;
                        }
                    }
                    if (!check) System.out.println("Không có ID house này!");
                    count++;
                }
                Services.WriteToFile writeToFileBooking1 = new Services.WriteToFile("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Booking.csv");
                writeToFileBooking1.write(mainCustomer.toCSV() + "," + subHouse.toCSV());
                break;
            case 3:
                System.out.println("Danh sách room :");
                Room room = new Room();
                room.printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Room.csv");
                check=false;
                Room subRoom = new Room();
                count =0;
                while (!check) {
                    System.out.println("Nhập ID room bạn muốn chọn: ");
                    if (count==0) scanner.nextLine();
                    String idRoom = scanner.nextLine();
                    for (Room room1 : room.roomArrayList) {
                        if (room1.getId().equals(idRoom)) {
                            subRoom = room1;
                            mainCustomer.setServices(subRoom);
                            check = true;
                        }
                    }
                    if (!check) System.out.println("Không có ID room này!");
                    count++;
                }
                Services.WriteToFile writeToFileBooking2 = new Services.WriteToFile("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Booking.csv");
                writeToFileBooking2.write(mainCustomer.toCSV() + "," + subRoom.toCSV());
                break;
        }
        customerArrayList.clear();
    }

    @Override
    public int compareTo(Customer o) {
        return this.getName().compareTo(o.getName());
    }
}

class YearBirthComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getBirthYear() > o2.getBirthYear()) {
            return 1;
        } else if (o1.getBirthYear() == o2.getBirthYear()) {
            return 0;
        } else {
            return -1;
        }
    }
}
