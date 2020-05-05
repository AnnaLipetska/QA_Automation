package main.java.lesson5.inheritance;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    public String getName() {
        System.out.println("Dog gives user its name");
        return super.getName();
    }

    @Override
    public String getName(String name, int a) {
        System.out.println("Dog gives user its name");
        return "Overriden method name";
    }


    public String greet() {
        return "Hello, I am a dog";
    }
}
