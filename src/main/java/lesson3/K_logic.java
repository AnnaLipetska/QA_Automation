package main.java.lesson3;

public class K_logic {
    public static void main(String[] args) {
        String name = "Anna";
        int age = 50;

        if (true) { // Всегда выполняется, если false - то никогда не будет выполняться
            System.out.println("Hello user");
        }
        if (age > 18) {
            System.out.println("Hello, you are too old for this");
        }
        //Логическо И и логическое ИЛИ
        if (age > 18 && name == "Anna") {
            System.out.println("Hello Anna");
        }
        if (age > 18 || name == "Vova") {
            System.out.println("Hello user");
        } else if (age > 10) {
            System.out.println("User's age is more than 10");
        } else {
            System.out.println("No");
        }
        if (age == 18) {
            System.out.println("Your age is 18");
        }
    }
}
