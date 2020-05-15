package main.java.lesson5.inheritance;

public class Mouse extends Animal implements IAtackable {
    public Mouse(String name) {
        super(name);
    }

    @Override
    public String greet() {
        return null;
    }

    @Override // Метод из интерфейса, который необходимо реализовать.
    public int getHealth() {
        return 0;
    }
}
