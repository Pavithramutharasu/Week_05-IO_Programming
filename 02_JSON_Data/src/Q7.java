import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Q7 {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootArray = mapper.readTree(new File("student.json"));

            for (JsonNode student : rootArray) {
                int age = student.get("age").asInt();
                if (age > 25) {
                    System.out.println("Name: " + student.get("name").asText() + ", Age: " + age);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }
}
