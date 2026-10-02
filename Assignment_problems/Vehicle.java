package Assignment_problems;
import java.util.*;

interface Vehicle {
    double charge(int hours);
}

class Bike implements Vehicle {
    public double charge(int hours) {
        return hours * 10;
    }
}

class Car implements Vehicle {
    public double charge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck implements Vehicle {
    public double charge(int hours) {
        return Math.max(100, hours * 50);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Vehicle> map = new HashMap<>();
        map.put("BIKE", new Bike());
        map.put("CAR", new Car());
        map.put("TRUCK", new Truck());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            double result = map.get(type).charge(hours);

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f", total);
    }
}