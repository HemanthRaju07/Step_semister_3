package Practice_problems;
import java.util.*;
import java.time.*;

interface Item {
    LocalDate dueDate();
}

class Book implements Item {
    public LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }
}

class DVD implements Item {
    public LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }
}

class Magazine implements Item {
    public LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Item> map = new HashMap<>();
        map.put("BOOK", new Book());
        map.put("DVD", new DVD());
        map.put("MAGAZINE", new Magazine());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.nextLine().trim();

            title = title.replace("\"", "");

            System.out.println(title + ": " + map.get(type).dueDate());
        }
    }
}