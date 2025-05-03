import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class Q8 {

    public static void main(String[] args) {
        String csvFile = "data.csv";
        String line;
        int rowNumber = 1;

       
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w+$");
       
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
           
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty CSV file.");
                return;
            }

            while ((line = br.readLine()) != null) {
                rowNumber++;
                String[] values = line.split(",");

               
                if (values.length < 3) {
                    System.out.println("Row " + rowNumber + " is incomplete: " + line);
                    continue;
                }

                String email = values[1].trim();
                String phone = values[2].trim();

                boolean emailValid = emailPattern.matcher(email).matches();
                boolean phoneValid = phonePattern.matcher(phone).matches();

                if (!emailValid || !phoneValid) {
                    System.out.println("Row " + rowNumber + " has errors:");
                    if (!emailValid) {
                        System.out.println(" - Invalid email: " + email);
                    }
                    if (!phoneValid) {
                        System.out.println(" - Invalid phone number: " + phone);
                    }
                    System.out.println(" - Original Data: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
