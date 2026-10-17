package Assignment_Problems;
import java.util.Scanner;

public class SecondHighest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();

        int highest = -1, second = -1;

        for (int i = 0; i < n; i++) {
            if (scores[i] > highest) {
                second = highest;
                highest = scores[i];
            } else if (scores[i] < highest && scores[i] > second) {
                second = scores[i];
            }
        }

        System.out.println(second);
    }
}