import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class filldata {
    public static final String[] domen = new String[]{"mail", "yandex","google","qewrty","test"};
    public static final String[] countries = new String[] {"ru","ua","en","fr"};
    public static final List<Character> chars = new ArrayList<>();
    public static final List<String> logins = new ArrayList<>();
    public static final List<String> password = new ArrayList<>();
    public static final List<String> firstName = new ArrayList<>();
    public static final List<String> lastName = new ArrayList<>();
    public static final List<String> emails = new ArrayList<>();
    public static final List<String> hobbies = new ArrayList<>();
    public static final List<String> phrase = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        for (int i = 65; i < 91; i++) {
            chars.add((char)i);
        }
        for (int i = 97; i < 123; i++) {
            chars.add((char)i);
        }
        for (int i = 48; i < 58; i++) {
            chars.add((char)i);
        }
        Random random = new Random();
        for (int i = 0; i < 2000; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < random.nextInt(45); j++) {
                stringBuilder.append(chars.get(random.nextInt(chars.size())));
            }
            emails.add(stringBuilder.toString() + i
                    + "@" + domen[random.nextInt(domen.length)]
                    + "." +  countries[random.nextInt(countries.length)]);
        }
        for (int i = 0; i < 2000; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < random.nextInt(20) + 10; j++) {
                stringBuilder.append(chars.get(random.nextInt(chars.size())));
            }
            password.add(stringBuilder.toString());
        }


        for (int i = 0; i < 2000; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < random.nextInt(15) + 5; j++) {
                stringBuilder.append(chars.get(random.nextInt(chars.size())));
            }
            logins.add(stringBuilder.toString() + i);
        }
//        logins.forEach(System.out::println);
        BufferedReader br = new BufferedReader(new FileReader("last.txt"));
        String str;
        while((str = br.readLine()) != null) {
            lastName.add(str);
        }
        br = new BufferedReader(new FileReader("first.txt"));
        while((str = br.readLine()) != null) {
            firstName.add(str);
        }

        br = new BufferedReader(new FileReader("hobbies.txt"));
        while((str = br.readLine()) != null) {
            hobbies.add(str);
        }

        br = new BufferedReader(new FileReader("aboutHb.txt"));
        while((str = br.readLine()) != null) {
            phrase.add(str);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            StringBuilder add = new StringBuilder();
            for (int j = 0; j < random.nextInt(hobbies.size()); j++) {
                add.append(phrase.get(random.nextInt(phrase.size()))).append(" ").append(hobbies.get(random.nextInt(hobbies.size()))).append(".");
            }
            res.add(firstName.get(random.nextInt(firstName.size())) + ","
                + lastName.get(random.nextInt(lastName.size())) + ","
                + logins.get(i) + ","
                + password.get(i) + ","
                + emails.get(i) + ","
                + add);
        }
        res.forEach(System.out::println);


    }
}
