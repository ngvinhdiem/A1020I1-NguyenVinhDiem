package b2_vong_lap_trong_java.baitap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice=-1;
        while (choice!=0) {
            Scanner input = new Scanner(System.in);


            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Input width: ");
                    int width=input.nextInt();
                    System.out.print("Input length: ");
                    int height=input.nextInt();
                    for (int i=0;i<width;i++) {
                        for (int j=0;j<height;j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("The corner is square at 4 different angles:\n1.top-left\n2.top-right\n3.botton-left\n4.botton-right");
                    int choose=input.nextInt();
                    switch (choose) {
                        case 1:
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 5 - i; j++) {
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 2:
                            int count=-1;
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 5; j++) {
                                    if (j<=count) System.out.print(" ");
                                    else System.out.print("*");
                                }
                                count++;
                                System.out.print("\n");
                            }
                            break;
                        case 3:
                            count=0;
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 5; j++) {
                                    if (j>count) System.out.print(" ");
                                    else System.out.print("*");
                                }
                                count++;
                                System.out.print("\n");
                            }
                            break;
                        case 4:
                            count=4;
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 5; j++) {
                                    if (j<count) System.out.print(" ");
                                    else System.out.print("*");
                                }
                                count--;
                                System.out.print("\n");
                            }
                            break;
                        default:
                            System.out.println("No choice!");
                    }
                    break;
                case 3:
                    int count1=2;
                    int count2=2;
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (j>=count1&&j<=count2) System.out.print("*");
                            else System.out.print(" ");
                        }
                        count1--; count2++;
                        System.out.print("\n");
                        if (count1==-1||count2==5) break;
                    }
                    break;

                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }

        }
    }
}
