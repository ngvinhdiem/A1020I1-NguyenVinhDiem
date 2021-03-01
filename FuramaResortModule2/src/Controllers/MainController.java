package Controllers;

import Models.House;
import Models.Room;
import Models.Villa;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
                Villa.WriteToFileVilla writeToFileVilla = new Villa.WriteToFileVilla();
                writeToFileVilla.write(villa.toCSV());
                addNewServices();
                break;
            case 2:
                House house = new House();
                House.WriteToFileHouse writeToFileHouse = new House.WriteToFileHouse();
                writeToFileHouse.write(house.toCSV());
                addNewServices();
                break;
            case 3:
                Room room = new Room();
                Room.WriteToFileRoom writeToFileRoom = new Room.WriteToFileRoom();
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
                "6.Show All Name Name Not Duplicate\n" +
                "7.Back to menu\n" +
                "8.Exit\n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                Villa.ReadFileVilla readFileVilla = new Villa.ReadFileVilla();
                readFileVilla.printVillaDetail();
                String stop = scanner.nextLine();
                stop = scanner.nextLine();
                showServices();
                break;
            case 2:
                House.ReadFileHouse readFileHouse = new House.ReadFileHouse();
                readFileHouse.printHouseDetail();
                stop = scanner.nextLine();
                stop = scanner.nextLine();
                showServices();
                break;
            case 3:
                Room.ReadFileRoom readFileRoom = new Room.ReadFileRoom();
                readFileRoom.printRoomDetail();
                stop = scanner.nextLine();
                stop = scanner.nextLine();
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
