package main.java.lesson5.inheritance;

abstract class Animal { // 2-й вариант - чтобы не создавали экземпляры этого класса - abstract
    private String name;
    public int age;

    public Animal(String name) { // чтобы не создавали экземпляры классов поставить private
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        System.out.println("Dog gives user its name");
        return "Overriden method name";
    }

    public String getName(String name, int a) {
        System.out.println("Dog gives user its name");
        return "Overriden method name";
    }

    public abstract String greet();

    //этот метод будет без реализации
    //описываю поведение, но без деталей
    public String toString() {
        return ("My name is " this.name + " and my age is" + this.age);
    }

}
