import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

public class Q9 {
    public static void main(String[] args) {
        String fileName = "students.csv";
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim().replace("\"", ""));
                    String name = parts[1].trim().replace("\"", "");
                    int age = Integer.parseInt(parts[2].trim().replace("\"", ""));
                    studentList.add(new Student(id, name, age));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}
