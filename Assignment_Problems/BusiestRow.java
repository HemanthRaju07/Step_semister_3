package Assignment_Problems;
import java.util.Scanner;

public class BusiestRow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                grid[i][j] = sc.nextInt();

        int max = -1, row = 0;

        for (int i = 0; i < r; i++) {
            int sum = 0;

            for (int j = 0; j < c; j++)
                sum += grid[i][j];

            if (sum > max) {
                max = sum;
                row = i;
            }
        }

        System.out.println("Row " + row + ", Total " + max);
    }
}