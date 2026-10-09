package practice_problems;

import java.util.*;

abstract class Item {
    String title;
    int daysLate;

    Item(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class Book extends Item {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate * 2.0;
    }
}

class DVD extends Item {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class Magazine extends Item {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate * 1.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            Item item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, days);
                    break;
                case "DVD":
                    item = new DVD(title, days);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, days);
                    break;
                default:
                    continue;
            }

            double amount = item.fine();
            System.out.printf("%s: %.2f%n", item.title, amount);
            total += amount;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
