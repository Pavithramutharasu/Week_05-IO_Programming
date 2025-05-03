import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

class Record {
    private int id;
    private String name;
    private String email;

    public Record(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

public class Q15 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String user = "user";
        String password = "password123";

        List<Record> records = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, email FROM users")) {

            while (rs.next()) {
                records.add(new Record(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }

            ObjectMapper mapper = new ObjectMapper();
            String jsonReport = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


