import org.json.JSONObject;
import org.json.XML;

public class Q13 {
    public static void main(String[] args) {
        String jsonString = """
        {
          "person": {
            "name": "Alice",
            "email": "alice@example.com",
            "age": 30
          }
        }
        """;

        JSONObject json = new JSONObject(jsonString);
        String xml = XML.toString(json);

        System.out.println("Converted XML:");
        System.out.println(xml);
    }
}
