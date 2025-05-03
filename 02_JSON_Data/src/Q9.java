import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class Car1 {
    private String brand;
    private String model;
    private int year;

    public Car1(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class Q9 {
    public static void main(String[] args) {
        try {
            List<Car1> carList = new ArrayList<>();
            carList.add(new Car1("Toyota", "Camry", 2020));
            carList.add(new Car1("Honda", "Civic", 2019));
            carList.add(new Car1("Ford", "Mustang", 2021));

            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writeValueAsString(carList);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
