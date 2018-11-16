import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class City {
    public static List<Cit> cities = new ArrayList<>();
    public static List<String> descriptions = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader name = new BufferedReader(new FileReader("cityname.txt"));
        BufferedReader desc = new BufferedReader(new FileReader("citydescription.txt"));
        String cityName, cityDescription, area, date;

        while ((cityDescription = desc.readLine()) != null) {
            descriptions.add(cityDescription);
        }

        while ((cityName = name.readLine()) != null) {
            Random random = new Random();
            int day = random.nextInt(25) + 1;
            int month = random.nextInt(12) + 1;
            int year = random.nextInt(220) + 1800;

            date = year + "-" + (month < 10 ? "0" : month) + (month < 10 ? month : "") + "-" + (day < 10 ? "0" : day) + (day < 10 ? day : "");
            area = String.valueOf(random.nextDouble() * 1000000);
            cityDescription = descriptions.get(random.nextInt(descriptions.size() - 1));
            cities.add(new Cit(cityName, area, cityDescription, date));
        }

        cities.forEach(System.out::println);
    }
}

class Cit {
    private String name;
    private String area;
    private String description;
    private String date;

    public Cit(String name, String area, String description, String date) {
        this.name = name;
        this.area = area;
        this.description = description;
        this.date = date;
    }

    public String toFile() {
        return name + "," + area + "," + description + "," + date;
    }

    @Override
    public String toString() {
        return name + "::" + area + "::" + description + "::" + date;
    }
}