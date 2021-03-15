package b16_io_text_file.baitap;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/b16_io_text_file/baitap/input.txt");
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        File outputFile = new File("src/b16_io_text_file/baitap/output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        int length;
        byte[] buffer = new byte[1];
        int characterCount=0;
        while ((length = fileInputStream.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, length);
            characterCount++;
        }
        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("File copied successfully.......; Characters: "+characterCount);
    }
}
