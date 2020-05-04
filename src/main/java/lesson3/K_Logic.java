package main.java.lesson3;

public class K_Logic {
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
        ///
        //Тернарные
        String status;
        if (age > 18) {
            status = "Worker";
        } else {
            status = "Student";
        }
        // Можно поменять на
        String status1 = (age > 18) ? "Worker" : "Student";
        // Switch-case
        int dayOfWeek = 0;
        if (dayOfWeek == 0) {
            System.out.println("Monday");
        } else if (dayOfWeek == 1) {
            System.out.println("Tuesday");
        }
        // Можно поменять на:
        switch (dayOfWeek) {
            case 0:
                System.out.println("Monday");
                break;
            case 1:
                System.out.println("Tuesday");
                break;
            case 2:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("No such day");
                // По умолчанию все проваливается вниз до конца, начиная от того, который подошел,
                // нужно указывать break;
                // Для последнего блока можно break не писать
        }
        switch (dayOfWeek) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("Будний день");
                break;
            case 5:
            case 6:
                System.out.println("Выходной день");
        }
        // Без операторных скобок можно, если в одну строчку
        if (age > 18) status = "Worker";
        else status = "Student";
    }
}

