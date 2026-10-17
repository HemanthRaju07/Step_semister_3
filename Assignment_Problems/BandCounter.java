package Assignment_Problems;
import java.util.Scanner;

public class BandCounter {
    static int search(int[] a, int x, boolean equal) {
        int l = 0, r = a.length;

        while (l < r) {
            int m = (l + r) / 2;

            if (a[m] < x || (equal && a[m] == x))
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();

        int low = sc.nextInt();
        int high = sc.nextInt();

        int start = search(scores, low, false);
        int end = search(scores, high, true);

        System.out.println(end - start);
    }
}