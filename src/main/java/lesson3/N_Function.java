package main.java.lesson3;

// Функция должна лежать внутри класса
public class N_Function {
    public static void main(String[] args) {
        greet();
        greet("Vova");
        greet("Petr", 2);
        greet(80);
        //greet(80,60); - не скомпилируется
        //greet(80, "Vova"); - не скомпилируется

        int age = getAge();
        System.out.println(age);

        System.out.println(getAge());
    }

    public static void greet() {
        System.out.println("Hello");
        System.out.println("Good bye");
    }

    public static void greet(String name) {
        System.out.println("Hello, " + name);
        System.out.println("Good bye");
    }

    public static void greet(String name, int number) {
        System.out.println("Hello, " + name + ", your number is " + number);
        System.out.println("Good bye");
    }

    public static void greet(int number) {
        System.out.println("Hello, user your number is " + number);
        System.out.println("Good bye");
    }

    public static int getAge() {
        return 50;
    }

    public static boolean isValid() {
        return 1 == 1;
    }
}
