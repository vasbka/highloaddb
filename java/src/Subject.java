import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subject {
    public static List<Subj> subjects = new ArrayList<>();
    public static List<String> names = new ArrayList<>();
    public static List<String> descriptions = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader nameBuffered = new BufferedReader(new FileReader("subjects.txt"));
        BufferedReader descriptionReader = new BufferedReader(new FileReader("description.txt"));
        String name, subjecttypeid, description, anydate, popularity;


        while ((description = descriptionReader.readLine()) != null) {
            descriptions.add(description);
        }

        while ((name = nameBuffered.readLine()) != null) {
            names.add(name);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 349; j++) {
                Random random = new Random();
                int day = random.nextInt(25) + 1;
                int month = random.nextInt(12) + 1;
                int year = random.nextInt(220) + 1800;

                anydate = year + "-" + (month < 10 ? "0" : month) + (month < 10 ? month : "") + "-" + (day < 10 ? "0" : day) + (day < 10 ? day : "");
                description = descriptions.get(random.nextInt(descriptions.size() - 1));
                subjects.add(new Subj(names.get(random.nextInt(names.size() - 1)), String.valueOf(i),
                        description, anydate, String.valueOf(random.nextDouble() * 100)));
            }
        }

        subjects.forEach(System.out::println);
    }

}
class Subj {
    String name;
    String subjecttypeid;
    String description;
    String anyDate;
    String popularity;

    public Subj(String name, String subjecttypeid, String description, String anyDate, String popularity) {
        this.name = name;
        this.subjecttypeid = subjecttypeid;
        this.description = description;
        this.anyDate = anyDate;
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return name + "::" + subjecttypeid + "::" + description + "::" + anyDate + "::" + popularity;
    }
}
