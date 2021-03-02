package b12_java_collection_framework.thuchanh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Student1 {
    private String name;
    private int age;
    private String address;

    public Student1() {
    }

    public Student1(String name, int age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

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
        return "Student@name=" + name + ",age=" + age + ",address=" + address;
    }
}


public class PhanBietHashMapHashSet {
    public static void main(String[] args) {
        Student1 student1 = new Student1("Nam",20, "HN");
        Student1 student2 = new Student1("Hung",21, "HN");
        Student1 student3 = new Student1("Ha",22, "HN");
        Map<Integer, Student1> studentMap = new HashMap<Integer, Student1>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student1);
        for(Map.Entry<Integer, Student1> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println("...........Set");
        Set<Student1> students = new HashSet<Student1>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);
        for(Student1 student : students){
            System.out.println(student.toString());
        }
    }
}
