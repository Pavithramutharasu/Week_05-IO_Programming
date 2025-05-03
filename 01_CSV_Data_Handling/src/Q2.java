import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Q2 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Employeedataset.csv"));
			String i;
			while((i=br.readLine())!=null) {
				String[] arr = i.split(",");
			
				if(arr[1].equalsIgnoreCase("Janu")) {
					System.out.println("Janu's department : "+ arr[2] +"--Salary : "+ arr[3]);
				}
			}
			br.close();
			
		}catch(IOException e) {
			System.out.println("File not found");
		}
	}
}
