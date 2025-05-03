import java.sql.*;
import java.io.*;

public class Q13 {
    public static void main(String[] args) throws Exception {
       
        String url = "jdbc:mysql://localhost:3306/data";
        String user = "username";
        String password = "password123";
        Connection conn = DriverManager.getConnection(url, user, password);

       
        String query = "SELECT employee_id, name, department, salary FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // 📝 Write to CSV file
        BufferedWriter writer = new BufferedWriter(new FileWriter("employees.csv"));
        writer.write("Employee ID,Name,Department,Salary\n");

        while (rs.next()) {
            String row = rs.getInt("employee_id") + "," +
                         rs.getString("name") + "," +
                         rs.getString("department") + "," +
                         rs.getDouble("salary") + "\n";
            writer.write(row);
        }

        writer.close();
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("✅ CSV file 'employees.csv' generated successfully.");
    }
}

