import java.io.*;
import java.util.*;

public class Q12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        String line = br.readLine();
        Set<String> seen = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length == 0) continue;
            String id = values[0].trim();
            if (!seen.add(id)) duplicates.add(line);
        }

        System.out.println("🔍 Duplicate Records Found:");
        for (String dup : duplicates) System.out.println(dup);
        br.close();
    }
}

