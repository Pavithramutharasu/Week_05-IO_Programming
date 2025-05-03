import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Q10 {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode users = mapper.readTree(new File("student.json"));

            for (JsonNode user : users) {
                int age = user.get("age").asInt();
                if (age > 25) {
                    System.out.println(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

