import java.io.*;

public class Q11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("large.csv"));
        String line;
        int count = 0, chunk = 100;
        br.readLine();
        while ((line = br.readLine()) != null) {
            count++;
           
            if (count % chunk == 0) System.out.println("Processed " + count + " records");
        }
        System.out.println("Total records processed: " + count);
        br.close();
    }
}

