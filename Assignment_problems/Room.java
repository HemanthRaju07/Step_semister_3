package Assignment_problems;
import java.util.*;

interface Room {
    double bill(int units);
}

class Single implements Room {
    public double bill(int units) {
        return units * 8;
    }
}

class Shared implements Room {
    int occupants;

    Shared(int occupants) {
        this.occupants = occupants;
    }

    public double bill(int units) {
        return (units * 6) / occupants;
    }
}

class AC implements Room {
    public double bill(int units) {
        return units * 10 + 200;
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

            Room room;

            if (type.equals("SINGLE"))
                room = new Single();
            else if (type.equals("SHARED"))
                room = new Shared(sc.nextInt());
            else
                room = new AC();

            double result = room.bill(units);

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f", total);
    }
}