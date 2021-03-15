package b16_io_text_file.thuchanh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
}
public class TinhTongCacSoTrongFileText {
    public static void main(String[] args) {
        String path = "src/b16_io_text_file/baitap/number.txt";
        ReadFileExample readfileEx = new ReadFileExample();
        readfileEx.readFileText(path);
    }

}
