package main.java.lesson5.inheritance;

public class Invoke {
    public static void main(String[] args) {
        Cat vasiliy = new Cat("Vasiliy");
        vasiliy.age = 2;
        Dog bobik = new Dog("Bobik");
        //Animal animal = new Animal("Vova");// это абстракция, заготовка, создавать экземпляр такой
        //глупо, можно запретить создавать это путем private.
        vasiliy.setName("Vaili2");
        System.out.println(vasiliy.getName());
        System.out.println(bobik.getName());

        System.out.println(vasiliy.toString()); // распечатывает main.java.lesson5.inheritance.Cat@1b6d3586, т.е.
        // ссылка
        //Множественные наследования в джаве запрещены, но цепочка может быть длинной
        //Родителем для всего в джаве является object
        vasiliy.toString();
        // Переопределить метод toString
    }
}
