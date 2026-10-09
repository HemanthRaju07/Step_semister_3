import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();

    abstract String shape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    String shape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shape() {
        return "TRIANGLE";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();
            Plot p;

            switch (type) {
                case "CIRCLE":
                    p = new Circle(owner, sc.nextDouble());
                    break;

                case "RECTANGLE":
                    p = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
                    break;

                case "TRIANGLE":
                    p = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
                    break;

                default:
                    continue;
            }

            double a = p.area();
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape(), a);
            total += a;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}