package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;  
import java.util.Stack;

import static Models.Services.parseCsvLine;

public class FileCabinet {
    static Stack<Employee> employeeStack = new Stack<>();

    public void search(String id) {
        readFile();
        for (Employee employee : employeeStack) {
            if (employee.getId().equals(id)) System.out.println(employee.toString());
        }
        employeeStack.clear();
    }
    public void readFile() {
        String path = "D:\\\\A1020I1-NguyenVinhDiem" +
                "\\\\FuramaResortModule2\\\\src\\\\Data\\\\FileCabinet.csv";
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
    public void add(List<String> employee) {
        Employee employee1 = new Employee();
        employee1.setId(employee.get(0));
        employee1.setName(employee.get(1));
        employee1.setAge(Integer.parseInt(employee.get(2)));
        employee1.setAddress(employee.get(3));
        employeeStack.add(employee1);

    }
}
