package Assignment_Problems;
import java.util.Arrays;
import java.util.Scanner;

public class Roster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++)
            names[i] = sc.next();

        int k = sc.nextInt();
        k = k % n;

        String[] result = new String[n];

        for (int i = 0; i < n; i++)
            result[(i + k) % n] = names[i];

        System.out.println(Arrays.toString(result));
    }
}