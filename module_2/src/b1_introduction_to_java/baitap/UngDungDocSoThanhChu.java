package b1_introduction_to_java.baitap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Input number:");
        number = scanner.nextInt();
        String partOne = "", partTwo = "", partThree = "";
        int hundreds = number / 100;
        switch (hundreds) {
            case 0:
                partOne = "";
                break;
            case 1:
                partOne = "One" + " hundred ";
                break;
            case 2:
                partOne = "Two" + " hundred ";
                break;
            case 3:
                partOne = "Three" + " hundred ";
                break;
            case 4:
                partOne = "Four" + " hundred ";
                break;
            case 5:
                partOne = "Five" + " hundred ";
                break;
            case 6:
                partOne = "Six" + " hundred ";
                break;
            case 7:
                partOne = "Seven" + " hundred ";
                break;
            case 8:
                partOne = "Eight" + " hundred ";
                break;
            case 9:
                partOne = "Nine" + " hundred ";
        }
        if (hundreds!=0) partOne+="and ";
        int tens = (number / 10) - ((number / 100) * 10);
        int ones = (number % 10);
        switch (tens) {
            case 0:
                partTwo = "";
                break;
            case 1:
                switch (ones) {
                    case 0:  partTwo="ten "; break;
                    case 1:  partTwo="eleven "; break;
                    case 2:  partTwo="twelve "; break;
                    case 3:  partTwo="thirteen "; break;
                    case 4:  partTwo="fourteen "; break;
                    case 5:  partTwo="fifteen "; break;
                    case 6:  partTwo="sixteen "; break;
                    case 7:  partTwo="seventeen "; break;
                    case 8:  partTwo="eighteen "; break;
                    case 9:  partTwo="nineteen ";
                }
                break;
            case 2:
                partTwo = "twenty ";
                break;
            case 3:
                partTwo = "thirty ";
                break;
            case 4:
                partTwo = "forty ";
                break;
            case 5:
                partTwo = "fifty ";
                break;
            case 6:
                partTwo = "sixty " ;
                break;
            case 7:
                partTwo = "seventy ";
                break;
            case 8:
                partTwo = "eighty ";
                break;
            case 9:
                partTwo = "nighty ";
        }

        if (tens!=1) switch (ones) {
            case 0:
                partThree = "";
                break;
            case 1:
                partThree = "one";
                break;
            case 2:
                partThree = "two";
                break;
            case 3:
                 partThree = "three";
                break;
            case 4:
                 partThree = "four";
                break;
            case 5:
               partThree = "five";
                break;
            case 6:
                partThree = "six";
                break;
            case 7:
                partThree = "seven";
                break;
            case 8:
                 partThree = "eight";
                break;
            case 9:
                partThree = "nine";
                break;
        }

        System.out.println(partOne + partTwo + partThree);
    }
}
