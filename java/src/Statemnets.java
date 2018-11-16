import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Statemnets {
    public static List<Statement> sts = new ArrayList<>();
    public static List<String> descriptions = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader facultyNameReader = new BufferedReader(new FileReader("faculty.txt"));
        BufferedReader descriptionReader = new BufferedReader(new FileReader("description.txt"));
        String date, popularity, description;
        StringBuilder name = new StringBuilder();
        while((description = descriptionReader.readLine()) != null){
            descriptions.add(description);
        }
        for (int i = 0; i < 2000; i++) {
            name = new StringBuilder();
            Random rn = new Random();
            char sym;
            for (int j = 0; j < 10 + rn.nextInt(40); j++) {
                sym = (char) rn.nextInt(175);
                while ((sym < 65 || sym > 90) && (sym < 97 || sym > 122)) {
                    sym = (char) rn.nextInt(174);
                }
                name.append(sym);
            }
            int day = rn.nextInt(25) + 1;
            int month = rn.nextInt(12) + 1;
            int year = rn.nextInt(220) + 1800;
            String rndDate = year + "-" + (month < 10 ? "0" : month) + (month < 10 ? month : "") + "-" + (day < 10 ? "0" : day) + (day < 10 ? day : "");
            sts.add(new Statement(rndDate, String.valueOf(rn.nextDouble()*100),
                    descriptions.get(rn.nextInt(descriptions.size() - 1)), name.toString()));
        }
        sts.forEach(System.out::println);
    }
}
class Statement {
    String date;
    String popularity;
    String description;
    String name;

    public Statement(String date, String popularity, String description, String name) {
        this.date = date;
        this.popularity = popularity;
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "::" + popularity + "::" + description + "a::" + date;
    }
}
