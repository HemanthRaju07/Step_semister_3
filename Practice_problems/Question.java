package Practice_problems;
import java.util.*;

interface Question {
    double grade(String correct, String student, double points);
}

class MCQ implements Question {
    public double grade(String correct, String student, double points) {
        return correct.equals(student) ? points : 0;
    }
}

class TF implements Question {
    public double grade(String correct, String student, double points) {
        return correct.equals(student) ? points : 0;
    }
}

class Essay implements Question {
    public double grade(String correct, String student, double points) {
        String[] words = correct.split(",");
        int count = 0;

        for (String word : words) {
            if (student.toLowerCase().contains(word.trim().toLowerCase()))
                count++;
        }

        if (count >= 2)
            return points * 0.75;
        if (count == 1)
            return points * 0.50;

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Question> map = new HashMap<>();
        map.put("MCQ", new MCQ());
        map.put("TF", new TF());
        map.put("ESSAY", new Essay());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] p = line.split("\"");

            String type = p[0].trim();
            String question = p[1];
            String correct = p[3];
            String student = p[5];
            double points = Double.parseDouble(p[6].trim());

            double score = map.get(type).grade(correct, student, points);

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f", total);
    }
}