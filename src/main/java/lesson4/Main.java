package main.java.lesson4;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {
    public static void main(String[] args) {
        Cat vasiliy = new Cat(); // Экземпляр класса
        Cat victor = new Cat();// В переменной victor - хранится ссылка на ячейку памяти
        Cat petr = victor; // В переменной petr ссылаемся на ту же ячейку памяти, что и victor
        // Это не новый экземпляр класса, а тот же.
        // Counter не меняется при "добавлении" кота petr.
        //Dog bobik = new Dog();
        // Названия классов - с большой буквы, название экземпляра - с маленькой буквы.
        //int age = vasiliy.age;
        //System.out.println(vasiliy.age); // печатает 10, если age - public
        System.out.println(vasiliy.getAge()); // если age - private
        System.out.println(vasiliy.COLOR);
        System.out.println(vasiliy.name);

        System.out.println(vasiliy == victor); // false
        System.out.println(vasiliy.equals(victor)); // false
        // Единственный вариант сравнить котов, самостоятельно руками создать свой метод equals.
        //System.out.println("Victor age is " + victor.age); // 10 если age - public
        System.out.println("Victor age is " + victor.getAge()); // 10 если age - public
        // petr.age = 2; // У кота victor возраст тоже автоматически поменяется, если age - public
        // Если age - private, то ничего поменять нельзя нигде
        System.out.println("Victor age is " + victor.getAge()); // 2, если age - public, и мы смогли его поменять

        vasiliy.Meow();

        System.out.println("Vasiliy age is " + vasiliy.getAge());

        System.out.println("Было создано " + Cat.counter + " кота"); // К статическим переменным можно обращаться напрямую, не создавая
        // отдельный экземпляр класса.
        // Было создано 2 кота

        Cat.printCount(); // 2 cats were created

        // Когда не использовали конструктор, а использовали метод public void Initialize, то писали
        //Cat cat1 = new Cat();
        //cat1.Initialize("Vasiliy");
        // С конструктором:
        Cat cat1 = new Cat("Василий");
        Cat cat2 = new Cat();
        System.out.println(cat1.name); // Василий
        System.out.println(cat2.name); // null
        cat2.name = "Petr";
        System.out.println(cat1.name); // Василий
        System.out.println(cat2.name); // Petr
        // Изменения имен этих котов не влияют друг на друга.
        // Когда создаем экземпляр класса, у него появляется такая штука как контекст со своими уже собственными
        // переменными.

        cat2.greet("Anna");

        Cat cat3 = new Cat();
        cat3.greet("Vova");


        //Если мы хотим чтобы пользователь мог менять age кота, но в случае ввода невалидного значения
        // , например, отрицательного числа, мы хотим как-то сообщить об этом,
        // то в классе Cat создаем публичный сеттер
        System.out.println("Vasiliy age is " + vasiliy.getAge()); // Пользователь может считать age
        cat1.setAge(-10); // Пользователь может установить age
        System.out.println(cat1.getAge());

        //cat1.COLOR = "yellow"; // невозможно изменить константу
    }
}
