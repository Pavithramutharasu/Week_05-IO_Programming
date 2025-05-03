import java.util.ArrayList;
import java.util.List;

class Cars {
    String brand;
    String model;
    int year;

    Cars(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Method to convert Car object to JSON string
    public String toJson() {
        return "{"
                + "\"brand\":\"" + brand + "\","
                + "\"model\":\"" + model + "\","
                + "\"year\":" + year
                + "}";
    }
}

public class Q6 {
    public static void main(String[] args) {
        List<Cars> cars = new ArrayList<>();
        cars.add(new Cars("Toyota", "Camry", 2020));
        cars.add(new Cars("Honda", "Civic", 2019));
        cars.add(new Cars("Ford", "Mustang", 2021));

        StringBuilder jsonArray = new StringBuilder();
        jsonArray.append("[");
        for (int i = 0; i < cars.size(); i++) {
            jsonArray.append(cars.get(i).toJson());
            if (i < cars.size() - 1) {
                jsonArray.append(",");
            }
        }
        jsonArray.append("]");

        System.out.println("JSON Array:");
        System.out.println(jsonArray.toString());
    }
}
