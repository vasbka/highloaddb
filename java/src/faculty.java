import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class faculty {
    public static List<Fac> faculties = new ArrayList<>();
    public static List<String> names = new ArrayList<>();
    public static List<String> descriptions = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader facultyNameReader = new BufferedReader(new FileReader("faculty.txt"));
        BufferedReader descriptionReader = new BufferedReader(new FileReader("description.txt"));
        String name, generalCount, budgetCount, creationDate, popularity, description;
        while( (name = facultyNameReader.readLine()) != null ){
            names.add(name);
        }
        while((description = descriptionReader.readLine()) != null){
            descriptions.add(description);
        }

        for (int i = 0; i < 2000; i++) {
            Random ran = new Random();
            int toal = ran.nextInt(1000) + 1;
            String general = String.valueOf(toal);
            String budget = String.valueOf(ran.nextInt(toal));
            int day = ran.nextInt(25) + 1;
            int month = ran.nextInt(12) + 1;
            int year = ran.nextInt(220) + 1800;
            creationDate = day + "/" + month + "/" + year;
            String pop = String.valueOf(ran.nextDouble() * 100);
            faculties.add(new Fac(names.get(names.size() - 1) + i,
                    general, budget, creationDate, pop, descriptions.get(ran.nextInt(descriptions.size() - 1))));
        }

        faculties.forEach(System.out::println);
    }
}

class Fac {
    String name;
    String generalCount;
    String budgetCount;
    String createionDate;
    String popularity;
    String description;

    public Fac(String name, String generalCount, String budgetCount, String createionDate, String popularity, String description) {
        this.name = name;
        this.generalCount = generalCount;
        this.budgetCount = budgetCount;
        this.createionDate = createionDate;
        this.popularity = popularity;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "::" + generalCount + "::" + budgetCount + "::" + createionDate + "::" + popularity + "::" + description;
    }
}
