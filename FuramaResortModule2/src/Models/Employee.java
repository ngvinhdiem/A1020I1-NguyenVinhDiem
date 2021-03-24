package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static Models.Services.parseCsvLine;

public class Employee {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public void printAllEmployee(String path) {
        readFile(path);
//        System.out.println(employeeMap.toString());


        for (String key : employeeMap.keySet()) {
            String value = employeeMap.get(key).toString();
            System.out.println(key + " " + value);
        }
        employeeMap.clear();
    }

    static Map<String ,Employee> employeeMap = new LinkedHashMap<>();


    public void readFile(String path) {
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
        employeeMap.put(employee.get(0),employee1);
//        System.out.println(employee1.toString());
//        System.out.println("Họ và tên: " + customer.get(0) + "," + "Ngày sinh: " + customer.get(1) + "," + "Giới tính: " +
//                customer.get(2) + "," + "Số CMND: " + customer.get(3) + "," + "SĐT: "
//                + customer.get(4) + "," + "Email: " + customer.get(5) +
//                "," + "Loại khách: " + customer.get(6) + "," + "Địa chỉ: " +
//                customer.get(7));
    }

}
