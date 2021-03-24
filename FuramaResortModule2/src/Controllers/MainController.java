package Controllers;

import Models.*;

import java.util.Scanner;


public class MainController {
    public static void main(String[] args) {
        MainController mainControl = new MainController();
        mainControl.displayMainMenu();
    }

    public void displayMainMenu() {
        System.out.println("1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information of Customer\n" +
                "5. Add New Booking\n" +
                "6. Show Information of Employee\n" +
                "7. Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                Customer customer = new Customer();
                customer.addNewCustomer();
                scanner.nextLine();
                scanner.nextLine();
                displayMainMenu();
                break;
            case 4:
                Customer customer1 = new Customer();
                customer1.showInformationCustomers();
                scanner.nextLine();
                scanner.nextLine();
                displayMainMenu();
                break;
            case 5:
                Customer customer2 = new Customer();
                customer2.addNewBooking();
                scanner.nextLine();
                scanner.nextLine();
                displayMainMenu();
                break;
            case 6:
                Employee employee = new Employee();
                employee.printAllEmployee("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Employee.csv");
                break;



        }
    }

    public void addNewServices() {
        System.out.println("1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "4.Back to menu\n" +
                "5.Exit\n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                Villa villa = new Villa();
                villa.addInformation();
                Services.WriteToFile writeToFileVilla = new Services.WriteToFile("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Villa.csv");
                writeToFileVilla.write(villa.toCSV());
                addNewServices();
                break;
            case 2:
                House house = new House();
                house.addInformation();
                Services.WriteToFile writeToFileHouse = new Services.WriteToFile("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\House.csv");
                writeToFileHouse.write(house.toCSV());
                addNewServices();
                break;
            case 3:
                Room room = new Room();
                room.addInformation();
                Services.WriteToFile writeToFileRoom = new Services.WriteToFile("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Room.csv");
                writeToFileRoom.write(room.toCSV());
                addNewServices();
                break;
            case 4:
                MainController mainControl = new MainController();
                mainControl.displayMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    public void showServices() {
        System.out.println("1.Show all Villa\n" +
                "2.Show all House\n" +
                "3.Show all Room\n" +
                "4.Show All Name Villa Not Duplicate\n" +
                "5.Show All Name House Not Duplicate\n" +
                "6.Show All Name Room Not Duplicate\n" +
                "7.Back to menu\n" +
                "8.Exit\n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                new Villa().printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Villa.csv");
                scanner.nextLine();
                scanner.nextLine();
                showServices();
                break;
            case 2:
                new House().printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\House.csv");
                scanner.nextLine();
                scanner.nextLine();
                showServices();
                break;
            case 3:
                new Room().printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Room.csv");
                scanner.nextLine();
                scanner.nextLine();
                showServices();
                break;
            case 4:
                new Villa().printAllNameNotDuplicate("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Villa.csv");
                scanner.nextLine();
                scanner.nextLine();
                showServices();
                break;
            case 5:
                new House().printAllNameNotDuplicate("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\House.csv");
                scanner.nextLine();
                scanner.nextLine();
                showServices();
                break;
            case 6:
                new Room().printAllNameNotDuplicate("D:\\\\A1020I1-NguyenVinhDiem" +
                        "\\\\FuramaResortModule2\\\\src\\\\Data\\\\Room.csv");
                scanner.nextLine();
                scanner.nextLine();
                showServices();
                break;
            case 7:
                MainController mainControl = new MainController();
                mainControl.displayMainMenu();
                break;
            case 8:
                System.exit(0);
                break;
        }
    }
}
