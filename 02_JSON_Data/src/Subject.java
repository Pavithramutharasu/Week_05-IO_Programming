import org.json.JSONArray;
import org.json.JSONObject;
public class Subject {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Alice");
        student.put("age", 20);


        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Physics");
        subjects.put("Chemistry");


        student.put("subjects", subjects);


        System.out.println(student.toString(2));
    }
}
