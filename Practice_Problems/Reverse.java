package Practice_Problems;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String r = new StringBuilder(s).reverse().toString();

        System.out.println(r + (s.equals(r) ? " - palindrome" : " - not a palindrome"));
    }
}