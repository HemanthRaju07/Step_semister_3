package Assignment_Problems;
import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int present = 0, count = 0, max = 0;

        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();

            if (day == 1) {
                present++;
                count++;
            } else {
                count = 0;
            }

            if (count > max)
                max = count;
        }

        System.out.println("Present: " + present + ", Longest streak: " + max);
    }
}