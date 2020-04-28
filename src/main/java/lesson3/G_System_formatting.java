package main.java.lesson3;

public class G_System_formatting {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.print("Hello");
        System.out.println("Bye");

        System.out.println("Hello Anna, my name is Vova and my age is 50");

        String greeting = "Hello Anna, my name is Vova and my age is 50";
        System.out.println(greeting);

        String greet = "Hello %s, my name is %s and my age is %d"; // %s - string, %d - double
        System.out.printf(greet, "Anna", "Vova", 50);
        System.out.println();

        System.out.printf(greet, "Max", "Bob", 40);
        System.out.println();
        System.out.printf(greet, "Max", "Bob", 40);
        System.out.println();
        // Экранирование \ backslash
        System.out.println("Hello \"Vova\"");
        System.out.println();
        System.out.println("\\");
        System.out.println();
        System.out.println("Hello \n Anna");

        //   \n - на следующую строчку
        //   \r - перенос каретки
        //   \t - четыре пробела
    }
}
