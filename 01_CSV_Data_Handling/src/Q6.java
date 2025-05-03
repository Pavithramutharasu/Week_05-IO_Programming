import java.io.*;
import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        String inputFile ="Employeedataset.csv";
        String outputFile = "updated_employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1].trim();
                String department = data[2].trim();
                double salary = Double.parseDouble(data[3].trim());

                if (department.equalsIgnoreCase("HR")) {
                    salary = salary * 1.10;
                }

               
                bw.write(name + "," + department + "," + String.format("%.2f", salary));
                bw.newLine();
            }

            System.out.println("Updated file saved as: " + outputFile);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary value.");
        }
    }
}
