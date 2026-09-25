package practice_problems;
import java.util.Arrays;

class Student implements Comparable<Student> {

    String name;
    double cgpa;
    int score;

    Student(String name, double cgpa, int score) {
        this.name = name;
        this.cgpa = cgpa;
        this.score = score;
    }

    static boolean eligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean eligible(double cgpa, int score) {
        return cgpa >= 6.5 && score >= 60;
    }

    double total() {
        return cgpa * 10 + score * 0.5;
    }

    public int compareTo(Student other) {
        return Double.compare(other.total(), this.total());
    }

    static String rank(Student[] students) {
        Student[] list = new Student[students.length];
        int count = 0;

        for (Student s : students) {
            if (eligible(s.cgpa) || eligible(s.cgpa, s.score)) {
                list[count++] = s;
            }
        }

        list = Arrays.copyOf(list, count);
        Arrays.sort(list);

        String result = "";

        for (int i = 0; i < list.length; i++) {
            result += (i + 1) + ". " + list[i].name +
                    " (" + String.format("%.1f", list[i].total()) + ")";

            if (i < list.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Aisha", 8.2, 40),
            new Student("Rohit", 6.8, 65),
            new Student("Meena", 6.0, 90),
            new Student("Karan", 7.5, 20)
        };

        System.out.println(rank(students));
    }
}