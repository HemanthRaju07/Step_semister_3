package Practice_Problems;
import java.util.Scanner;

public class Vowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toLowerCase();
        int v = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1)
                v++;
            else
                c++;
        }

        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);
    }
}