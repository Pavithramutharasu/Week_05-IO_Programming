import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Q5 {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            
            JsonNode schemaNode = mapper.readTree(new File("studentschema.json"));
            JsonNode dataNode = mapper.readTree(new File("students.json"));

           
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema schema = factory.getSchema(schemaNode);

            
            Set<ValidationMessage> errors = schema.validate(dataNode);

            if (errors.isEmpty()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("JSON is invalid:");
                for (ValidationMessage error : errors) {
                    System.out.println(error.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}
