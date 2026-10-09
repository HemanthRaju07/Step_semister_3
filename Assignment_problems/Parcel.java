package Assignment_problems;

import java.util.*;

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

interface Insurable {
    double insurance();
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return value * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance() {
        return value * 0.02;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;

            switch (type) {
                case "STANDARD": p = new Standard(weight, value); break;
                case "EXPRESS": p = new Express(weight, value); break;
                case "FRAGILE": p = new Fragile(weight, value); break;
                default: continue;
            }

            double charge = p.charge();
            double insurance = p instanceof Insurable
                    ? ((Insurable) p).insurance() : 0;
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grand += total;
        }

        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}