package main.java.lesson3;

public class F_Strings {
    public static void main(String[] args) {
        System.out.println("Hello world");
        //String str = 'c'; Ошибка
        String str = "Hello"; // Класс всегда начинается с большой буквы
        // String - это не примитив.
        // Java code convention
        System.out.println(str);
        // У объектов есть свои методы
        // У примитивов нет своего поведения
        System.out.println(str.length());
        System.out.println(str.charAt(2));


    }
}
