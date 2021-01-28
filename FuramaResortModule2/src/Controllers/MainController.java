package Controllers;
import sun.applet.Main;

import java.util.Scanner;
public class MainController {
    public static void main(String[] args) {
        MainController mainControl = new MainController();
        mainControl.displayMainMenu();
    }
    public void displayMainMenu() {
        System.out.println("1. Add New Services\n" +
                "2.Show Services\n" +
                "3.Add New Customer\n" +
                "4.Show Information of Customer\n" +
                "5.Add New Booking\n" +
                "6.Show Information of Employee\n" +
                "7.Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1: addNewServices(); break;
            case 2: showServices(); break;
        }
    }

    public void addNewServices() {
        System.out.println("1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "4.Back to menu\n" +
                "5.Exit\n");
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
    }
}
