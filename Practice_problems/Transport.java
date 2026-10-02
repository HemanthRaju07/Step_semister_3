package Practice_problems;
import java.util.*;

interface Transport {
    double fare(double distance, double factor);
}

class Bus implements Transport {
    public double fare(double distance, double factor) {
        return Math.min(10, 2 + 0.10 * distance);
    }
}

class Train implements Transport {
    public double fare(double distance, double factor) {
        return 3 + 0.15 * distance;
    }
}

class Metro implements Transport {
    public double fare(double distance, double factor) {
        return (1.50 + 0.20 * distance) * factor;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Transport> map = new HashMap<>();
        map.put("BUS", new Bus());
        map.put("TRAIN", new Train());
        map.put("METRO", new Metro());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            double factor = 1;

            if (type.equals("METRO"))
                factor = sc.nextDouble();

            double result = map.get(type).fare(distance, factor);

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f", total);
    }
}