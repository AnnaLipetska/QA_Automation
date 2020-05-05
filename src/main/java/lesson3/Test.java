package main.java.lesson3;

import main.java.lesson4.Cat;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat(); // Cat находится в другом пакете, нужно заимпортить
        // Alt + Enter, автоматически подтянет
        // добавляет перед объявлением класса import main.java.lesson4.Cat;
        //cat.greet(); // Не работает, так как метод package default.
    }
}
