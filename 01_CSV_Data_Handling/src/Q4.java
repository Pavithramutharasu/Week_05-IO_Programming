import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q4 {
    public static void main(String[] args) {
        String filePath = "studentsdata.csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine();

            System.out.println("Students scoring more than 80:");

            while ((line = br.readLine()) != null) {
                
                line = line.replaceAll("^\"|\"$", "");

                String[] data = line.split(",");
                if (data.length < 3) continue;

                String name = data[0].trim();
                int marks = Integer.parseInt(data[2].trim());

                if (marks > 80) {
                    System.out.println(name + " scored " + marks);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
