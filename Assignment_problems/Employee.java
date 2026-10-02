package Assignment_problems;
import java.util.*;

interface Employee {
    double bonus(double salary);
}

class Fulltime implements Employee {
    public double bonus(double salary) {
        return salary * 0.10;
    }
}

class Parttime implements Employee {
    public double bonus(double salary) {
        return salary * 0.05;
    }
}

class Intern implements Employee {
    public double bonus(double salary) {
        return 2000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Employee> map = new HashMap<>();
        map.put("FULLTIME", new Fulltime());
        map.put("PARTTIME", new Parttime());
        map.put("INTERN", new Intern());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            double result = map.get(type).bonus(salary);

            System.out.printf("%s: %.2f%n", name, result);
            total += result;
        }

        System.out.printf("Total Bonus: %.2f", total);
    }
}