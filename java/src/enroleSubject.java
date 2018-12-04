import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class enroleSubject {
    public static void main(String[] args) {
        List<String> lls = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            List<Integer> faculties = new ArrayList<>();
            for (int j = 0; j < 150; j++) {
                Random point = new Random();
                StringBuilder stringBuilder = new StringBuilder();
                Random subId = new Random();
                stringBuilder.append(i).append("::");
                int fcId = subId.nextInt(697);
                while (faculties.contains(fcId)) {
                    fcId = subId.nextInt();
                }
                faculties.add(fcId);
                stringBuilder.append(fcId).append("::");
                stringBuilder.append(point.nextDouble() * 100 + 100);
                lls.add(stringBuilder.toString());
            }
        }
        List<String> requests = new ArrayList<>();

        List<String> facts = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            List<Integer> subjs = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                StringBuilder str = new StringBuilder();
                Random rnd = new Random();
                str.append(rnd.nextDouble()).append("::");
                int subjId = rnd.nextInt(696) + 1;
                while (subjs.contains(subjId)) {
                    subjId = rnd.nextInt(696) + 1;
                }
                subjs.add(subjId);
                str.append(i).append("::");
                str.append(subjId);
                facts.add(str.toString());
            }
            List<Integer> facIds = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Random rnd = new Random();
                StringBuilder str = new StringBuilder();
                str.append(i).append("::");
                int facId = rnd.nextInt(1999) + 1;
                while (facIds.contains(facId)) {
                    facId = rnd.nextInt(1999) + 1;
                }
                facIds.add(facId);
                str.append(facId).append("::");
                str.append(rnd.nextDouble() * 100 + 100);
                requests.add(str.toString());
            }
        }

//        lls.forEach(System.out::println);
//        facts.forEach(System.out::println);
        requests.forEach(System.out::println);
    }
}
