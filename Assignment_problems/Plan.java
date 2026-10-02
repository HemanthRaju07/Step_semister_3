package Assignment_problems;
import java.util.*;
import java.time.*;

interface Plan {
    LocalDate renewal(LocalDate date);
}

class Basic implements Plan {
    public LocalDate renewal(LocalDate date) {
        return date.plusDays(30);
    }
}

class Standard implements Plan {
    public LocalDate renewal(LocalDate date) {
        return date.plusDays(90);
    }
}

class Premium implements Plan {
    public LocalDate renewal(LocalDate date) {
        return date.plusDays(365);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Plan> map = new HashMap<>();
        map.put("BASIC", new Basic());
        map.put("STANDARD", new Standard());
        map.put("PREMIUM", new Premium());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            LocalDate result = map.get(type).renewal(date);

            System.out.println(name + ": " + result);
        }
    }
}