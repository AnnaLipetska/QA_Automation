package main.java.lesson5.inheritance;

public class Cat extends Animal {
    public Cat(String  name) {
        super(name); // вызови конструктор базового класса
    }

    public String greet() {
        return "Hello, I am a cat";
    }
}
