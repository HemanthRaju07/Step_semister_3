package Assignment_problems;

import java.util.*;

abstract class Cab {
    double km;
    static final double MINIMUM = 100;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    boolean nightService() {
        return false;
    }

    double fare(String time) {
        double amount = Math.max(km * rate(), MINIMUM);

        if (time.equals("NIGHT")) {
            if (!nightService())
                return -1;
            amount *= 1.2;
        }

        return amount;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class Sedan extends Cab {
    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    boolean nightService() {
        return true;
    }
}

class SUV extends Cab {
    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    boolean nightService() {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab c;

            switch (type) {
                case "MINI": c = new Mini(km); break;
                case "SEDAN": c = new Sedan(km); break;
                case "SUV": c = new SUV(km); break;
                default: continue;
            }

            double fare = c.fare(time);

            if (fare == -1) {
                System.out.println(type + ": night service not available");
            } else {
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
