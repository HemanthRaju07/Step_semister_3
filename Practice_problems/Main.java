package Practice_problems;
import java.util.*;

interface Payment {
    double calculate(double amount);
}

class Card implements Payment {
    public double calculate(double amount) {
        return amount * 1.02;
    }
}

class Wallet implements Payment {
    public double calculate(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer implements Payment {
    public double calculate(double amount) {
        return amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Payment> map = new HashMap<>();
        map.put("CARD", new Card());
        map.put("WALLET", new Wallet());
        map.put("BANKTRANSFER", new BankTransfer());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            double result = map.get(type).calculate(amount);

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f", total);
    }
}