import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.everit.json.schema.ValidationException;

public class Q11 {
    public static void main(String[] args) {
        
        String schemaString = """
        {
          "$schema": "http://json-schema.org/draft-07/schema#",
          "type": "object",
          "properties": {
            "email": {
              "type": "string",
              "format": "email"
            }
          },
          "required": ["email"]
        }
        """;

        String jsonString = """
        {
          "email": "test@example.com"
        }
        """;

        try {
            
            JSONObject rawSchema = new JSONObject(schemaString);
            Schema schema = SchemaLoader.load(rawSchema);
            JSONObject input = new JSONObject(jsonString);

            schema.validate(input);
            System.out.println("✅ Email is valid.");
        } catch (ValidationException e) {
            System.out.println("❌ Email is invalid: " + e.getMessage());
        }
    }
}
