package main.java.lesson4;

public class Cat {
    // Объявляем свойства - переменные класса
    public static String type = "Home Cat";
    public static int counter = 0; // Работать с контекстом, нужны конструкторы. Статическая переменная.
    // 'age' has private access in 'main.java.lesson4.Cat' - Ошибка при попытке обратиться из метода Main
    // к переменной private, нужен геттер, который даст возможность считывать, но не изменять переменную.
    public final String COLOR = "рыжий"; // константа, UPPERCASE+нижнее подчеркивание COLOR_OF_CAT
    // Статические переменные существуют отдельно от экземпляров класса.
    // counter напрашивается на то чтобы его сделали private
    // private static int counter = 0;
    // Практически все переменные есть смысл объявлять как приватные.
    // Если private, то в других классах нельзя не только менять, но и считать.
    // Чтобы считать private переменную, нужно создать public метод
    // так называемый геттер getter, который будет возвращать нашу переменную.
    // public String name; // Дефолтное имя - null
    // public String name = "Vasiliy"; // Задаем дефолтное имя, но можно это сделать в конструкторе,
    // а точнее в перегрузке, которая не принимает строку с именем кота.
    public String name;
    //public int age = 10;
    private int age = 10;


    ///////// Конструктор - это по факту обыкновенный метод, (на самом деле нет) - гарантированно запускается
    // каждый раз, когда вы создаете новый экземпляр класса. Называется также как и класс.
    public Cat() { // Создаем конструктор - перегрузка 1
        //System.out.println("Cat was created");
        //this.name = "not defined"; // дефолтное имя кота
        //counter++; // Если счетчик не добавить, то будет считать только сходу именованных котов.
        // С другой стороны, дублирующийся код - это плохо. Нужно выносить его в методы.
        // this(); // ссылается на конструктор в рамках текущего контекста, вызовет самого себя
        this("not defined");
    }

    // Можно написать так:
    /*public Cat(String catName) { // Создаем конструктор
        System.out.println("Cat was created");
        counter++;
        name = catName;
    }*/
    // Или еще проще:
    //public Cat(String name) { // Создаем конструктор
    //System.out.println("Cat was created");
    //counter++;
    //name = name; // Такой вариант для компиллятора непонятно, нужно использовать ключевое слово this
    //}
    public Cat(String name) { // Создаем конструктор - перегрузка 2
        System.out.println("Cat was created");
        counter++;
        this.name = name; // this - ссылка на контекст, на объект в рамках которого был вызван метод
    }
    // Если не создавать конструктор, то сработает конструктор по умолчанию.
    // Метод-конструктор просто вызывать нельзя, к нему можно только обратиться, когда вы создаете переменную
    //класса. В конструктор можно передавать параметры.

    ///////// Раньше делали так, когда не было конструкторов:
    //public void Initialize(String catName) {
    //name = catName;
    //}

    public static void printCount() { // Можно создавать и статические методы
        System.out.println(counter + " cats were created");
    }

    private void techMethod() { // пример инкапсуляции

    }

    // Создание геттера для private int age
    public int getAge() {
        return this.age;
    }

    // Создаем публичный сеттер

    public void setAge(int age) {
        if (age > 0 && age < 20) {
            this.age = age;
        } else {
            System.out.println("You can't set age " + age);
            this.age = 0;
        }
    }

    void greet(String userName) { // package default, в других пакетах не будет видно
        // используется для создания библиотек внутренних каких-то
        System.out.println("Hello user " + userName + ". My name is " + this.name + ".");
    }

    public void Meow() {
        System.out.println("MEOW");
    }
}

