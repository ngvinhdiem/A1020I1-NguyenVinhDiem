package b16_io_text_file.baitap;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DocFileCsv {
    public static void main(String[] args) throws IOException {
        File myObj = new File("src/b16_io_text_file/baitap/Country.csv");
        Scanner myReader = new Scanner(myObj);
        ArrayList<String> countryList = new ArrayList<String>();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] array = data.split(",");
            if (!countryList.contains(array[5])) countryList.add(array[5]);
        }
        myReader.close();
        System.out.println(countryList);
    }
}
