package practice_problems;

import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }

    double bill() {
        if (units <= 100)
            return units * 5.0;
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }

    double bill() {
        return units * 8.0 + 100;
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }

    double bill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Connection c;

            switch (type) {
                case "HOME":
                    c = new Home(units);
                    break;
                case "SHOP":
                    c = new Shop(units);
                    break;
                case "FACTORY":
                    c = new Factory(units);
                    break;
                default:
                    continue;
            }

            double amount = c.bill();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}