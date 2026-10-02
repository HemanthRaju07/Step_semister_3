package Practice_problems;
import java.util.*;

interface Delivery {
    double fee(double weight, double distance, double customs);
}

class Standard implements Delivery {
    public double fee(double weight, double distance, double customs) {
        return 5 + (0.5 * weight) + (0.1 * distance);
    }
}

class Express implements Delivery {
    public double fee(double weight, double distance, double customs) {
        return 15 + weight + (0.2 * distance);
    }
}

class International implements Delivery {
    public double fee(double weight, double distance, double customs) {
        return 25 + (2 * weight) + (0.5 * distance) + customs;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Delivery> map = new HashMap<>();
        map.put("STANDARD", new Standard());
        map.put("EXPRESS", new Express());
        map.put("INTERNATIONAL", new International());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customs = 0;

            if (type.equals("INTERNATIONAL"))
                customs = sc.nextDouble();

            double result = map.get(type).fee(weight, distance, customs);

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f", total);
    }
}