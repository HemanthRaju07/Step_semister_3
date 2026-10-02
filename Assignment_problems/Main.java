package Assignment_problems;
import java.util.*;

interface Customer {
    double bill(double amount);
}

class Student implements Customer {
    public double bill(double amount) {
        return amount * 0.90;
    }
}

class Staff implements Customer {
    public double bill(double amount) {
        return amount * 0.95;
    }
}

class Guest implements Customer {
    public double bill(double amount) {
        return amount + 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Customer> map = new HashMap<>();
        map.put("STUDENT", new Student());
        map.put("STAFF", new Staff());
        map.put("GUEST", new Guest());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            double result = map.get(type).bill(amount);

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f", total);
    }
}