package main.java.lesson5.inheritance;

public class Invoke {
    public static void main(String[] args) {
        // Cat cat = new Cat(); // Не очень понятная запись одни cat и Cat.
        // Cat vasiliy = new Cat(); // Так понятнее

        Cat vasiliy = new Cat("Vasiliy");
        System.out.println(vasiliy.getName()); // Не возможно увидеть имя (нет геттера)
        // пока в классе Cat не прописать наследование от базового класса

        Dog bobik = new Dog("Bobik");
        System.out.println(bobik.getName());

        vasiliy.setName("Vasiliy2");
        System.out.println(vasiliy.getName());


        // Animal animal = new Animal("Vova");
        // Если класс Animal не абстрактный, то можно создать экземпляр базового класса.
        // Если базовый класс - абстрактный, то нельзя.
        // Animal - абстрактное животное, заготовка для других классов.
        // Создавать экземпляр базового класса - как-то глупо.

// Cat victor = vasiliy; Объект не создается, а копируется по ссылке.


        System.out.println(vasiliy); // Вывод в консоль: main.java.lesson5.inheritance.Cat@1b6d3586
        // Печатается ссылка на адрес к памяти. Это до переопределения метода toString в Animal

        // Как сделать так, чтобы этот кот печатал полезную информацию о себе?
        // В Java можно наследоваться только от одного объекта.
        // Множественное наследование в Java запрещено, т.к. небезопасно.
        // Цепочка наследования может быть сколь угодно длинной
        // Наследование - сколь угодно долго, пока не упрется в самый главный класс.
        // Родителем для всего в Java называется класс Object.
        // У объекта Object есть свои методы, которые мы можем вызывать.
        //vasiliy. - то можно увидеть, какие методы существуют для данного объекта
        // Черным - его класса собственные реализованные методы
        // Серым - то, что унаследовано.
        vasiliy.toString(); // Если на метод toString навести мышкой и нажать Ctrl
        // подстветится Object, public String - до переопределения метода toString в Animal
        // Если нажать на метод мышкой, то перенесетесь в класс Object - файл Onject.java
        // Скопировано из Object.java:
//        public String toString() {
//            return getClass().getName() + "@" + Integer.toHexString(hashCode());
//        }
/////////////// До переопределения метода toString():
//        String info = vasiliy.toString();
//        // У следующих трех записей выводы в консоль абсолютно идентичные:
//        System.out.println(info);
//        System.out.println(vasiliy);
//        System.out.println(vasiliy.toString());// Вывод в консоль тот же что и для предыдущей строки.
//        // Дело в том, что когда мы вызываем System.out.println, то он автоматически пытается
//        //вызвать у любого объекта метод toString(); даже если мы явно его не передаем.
//
//        ////////////
// Как сделать так, чтобы мы когда печатаем, то печаталась нормальная информация?
// Нужно переопределить родительский метод toString()
        System.out.println(vasiliy); // My name is Vasiliy2 and my age is 50 -
        // это так отрабатывает уже после переопределения toString() в Animal

///////////////// Как сравнивать объекты?
        Cat victor = new Cat("Victor");
        System.out.println(vasiliy == victor); // false, объекты так нельзя сравнивать
        // Оператор == сравнивает по ссылке, можно использовать исключительно для примитивов
        // Для объектов необходимо вызвать метод equals
        victor.setName("Vasiliy");
        vasiliy.setName("Vasiliy");
        System.out.println(vasiliy.getName());
        System.out.println(victor.getName()); // вывод тот же, что и в предыдущей строке
        System.out.println(vasiliy.equals(victor)); // false по умолчанию, но после переопределения
        // метода equals() в Animal, выдает true.
        // Все равно не равны, так как объекты - это сложные сущности, они хранят в себе большое
        // количество данных, держать в памяти все время полное значение объекта - очень расточительно
        // Для того, чтобы манипулировать их значениями, передается адрес по ссылке.
        // В переменной хранится не само значение, а только ссылка.
        // Ссылки в любом случае будут разными.
        // Если нажать опять Ctrl на методе equals(), переместиться в Object.java,
        // Скопировано из Object.java:
//        public boolean equals(Object obj) {
//            return (this == obj); // банальное сравнение
//        }
        // Как же сравнить объекты? Единственный вариант - реализовать свой собственный метод equals()
        // в классе Animal.
        victor.setName("Victor");
        System.out.println(vasiliy.equals(victor)); // false так как имена котов разные, а наш метод
        // equals сравнивает их имена

        Animal cat = new Cat("AA"); // Приведение типов
        // Восходящее преобразование
        //cat. будут все методы из Animal, но созданные в Cat будут отсутствовать.
        // Cat cat2 = cat; // Ругается, т.к. мы пытаемся сузить этот тип
        Cat cat2 = (Cat) cat; // нужно явно преобразовывать

        Cat[] cats = {new Cat("A"), new Cat("B")}; // массив котов
        // Cat[] cats1 = {new Cat("A"), new Cat("B"), new Dog("C")}; // Ошибка
        Animal[] cats1 = {new Cat("A"), new Cat("B"), new Dog("C")}; // Использование родительских
        // классов для таких смешанных массивов
        // IAtackable[] atackable = {new Cat("A"), new Dog("B"), new Mouse("C")};
        IAtackable[] atackable = {new Dog("B"), new Mouse("C")};
        IAtackable animal = new Dog("DD");
        Mouse mouse = new Mouse("");

    }
}
