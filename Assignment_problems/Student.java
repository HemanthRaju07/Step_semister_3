package Assignment_problems;

import java.util.*;

abstract class Student {
    String name;
    static final double TRANSPORT = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double fee();

    boolean usesBus() {
        return false;
    }

    double total() {
        return fee() + (usesBus() ? TRANSPORT : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double fee() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double fee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double fee() {
        return 20000;
    }

    boolean usesBus() {
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
            String name = sc.next();
            Student s;

            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER": s = new Hosteller(name); break;
                case "SCHOLAR": s = new Scholar(name); break;
                default: continue;
            }

            double amount = s.total();
            System.out.printf("%s: %.2f%n", name, amount);
            total += amount;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}