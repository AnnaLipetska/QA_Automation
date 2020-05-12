package test.java.lesson5;

import main.java.lesson5.app.Server;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestServer { // Можно запустить весь класс
    Server server; // Объявляем переменную класса.

    // Все аннотации, которые не <Test> в тестировании называются хуками (крючки).
    // Крючки срабатывают каждый раз, когда срабатывает Test.

    // <BeforeClass> хук будет работать один раз перед исполнением тестового класса.
    // Такие методы принято называть setUp
    @BeforeClass
    public void setUp() {
        System.out.println("I am a Before Class");
        // BeforeClass можно использовать чтобы, например, не создавать перед каждым тестом новый экземпляр сервера.
        // Чтобы не тратить ресурсы и присоединяться к серверу только один раз.
    }

    @BeforeMethod
    public /*static*/ void initialize() { // <BeforeMethod> - срабатывает ровно один раз перед каждым тестовым методом
        // Убрать слово static, а то иначе не срабатывает this.server в следующем рядке кода
        /*Server*/
        this.server = new Server(); // Объявление переменной перенесли в класс.
        System.out.println("I am a Before Method hook."); // Если запускается два теста, то распечатывается два раза.
    }

    // Хотим протестировать метод getUsers() из класса Server
    @Test
    public /*static*/ void getUsersShouldReturnProperAmount() { // Тестовый метод
        // Server server = new Server(); // Перенесли в метод initialize
        //String usersNames = server.getUsers(); // После переноса предыдущей строки в метод initialize, эта строка
        // начинает ругаться. Дело в области видимости. Области видимости каждой переменной определяется фигурными
        // скобками. Нужно объявить переменную server как переменную класса, тогда у этой переменной будет область
        // видимости - весь класс.

        String usersNames = this.server.getUsers(); // ругается теперь на this, так как метод объявили static
        // Из статического метода нельзя обратиться к this, так как static существует вне контекста, он существует в
        // рамках одного класса. Соответственно мы к конкретному контексту обращаться не можем.
        // Если this не написать, то компиллятор все равно будет к нему обращаться, он понимает это.

        int actualUsersAmount = usersNames.split(", ").length;
        int expectedUsersAmount = 3; //количество пользователей,
        // которых веренет нам наш сервер.
        // actualUsersAmount == expectedUsersAmount; Это нужно
        // запихнуть в проверку. Для этого используются Assertions.
        // assertEquals(actualUsersAmount, expectedUsersAmount); // Отдельная библиотека, нужно заимпорить.
        // Выбираем import static method, testng а не JUnit
        // Метод сравнивает два значения
        assertEquals(
                actualUsersAmount,
                expectedUsersAmount,
                "Expected amount of users to be " + expectedUsersAmount + " but got " + actualUsersAmount
        );
        // третий аргумент в методе assertEquals - опциональный,
        // на случай если наш тест упадет, для того чтобы мы могли
        // предоставить какую-то дополнительную информацию тому, кто будет
        // работать с этим тестом (в логах непонятно, что упало в тесте,
        // например, может писать expected [2] but found [3] - это
        // неинформативно). Такая информация будет выдаваться только если
        // тест красный, если зеленый - то будет игнорироваться данное
        // сообщение.

        // Чаще всего пользуются assertEquals или assertTrue

        // Проверим, что каждое значение пользователя начинается с большой буквы:
    }

    @Test
    public /*static*/ void getUsersShouldReturnAllNamesInUppercase() { // Тестовый метод
        // Server server = new Server(); // Повтор, лучше вынести в какое-то единое место.
        // Перенесли в метод initialize

        String[] usersNames = this.server.getUsers().split(", "); // {"Vova", "Petya"}

        // for (int i = 0; i < usersNames.length; i++) {
        // полная запись
        // }

        // но удобнее пользоваться сокращенной записью:
        for (String name : usersNames) { // сокращенная запись для итерирования по массивам
            String actualFirstChar = String.valueOf(name.charAt(0)); // тип char не подойдет, нужен тип String
            // используется метод valueOf() для приведения символа к строке
            // Всегда после первого испытания теста, пробуем поламать тест:
            // Поменяем, например, на невалидную строку:
            // String actualFirstChar = String.valueOf(name.charAt(0)) + "!";
            // Или:
            // String actualFirstChar = String.valueOf(name.charAt(0)).toLowerCase();

            String expectedFirstChar = String.valueOf(name.charAt(0)).toUpperCase();
            // сегда после первого испытания теста, пробуем поламать тест:
            // Поменяем, например, на toLowerCase:
            // String expectedFirstChar = String.valueOf(name.charAt(0)).toLowerCase();

            // boolean isEqual = actualFirstChar.equals(expectedFirstChar);
            // Строки можно сравнить и через ==, но, если эти строки создаются через оператор new, то == не прокатит.
            // Лучше для строк пользоваться equals.
            // assertTrue(isEqual); // Красная лампочка -> import static method, выбрать не JUnit, а просто testng
            // assertTrue() принимает только один аргумент на вход - boolean
            // Лучше сделать в одну строку, а не в две:
            assertTrue(
                    actualFirstChar.equals(expectedFirstChar),
                    "Expected first char " + actualFirstChar + " in name " + name + " to be upper case.");
            // По умолчанию, если тест завалится, то совершенно непонятно почему.
            // java.lang.AssertionError: expected [true] but found [false]
            // Нужно обязательно в assertTrue передавать дополнительный параметр message: ...

            // После добавления сообщения:
            // java.lang.AssertionError: Expected first char V in name Vova to be upper case.
            // expected [true] but found [false]
        }
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I am a After method");
    }

    // <AfterClass> хук будет работать один раз после исполнением тестового класса.
    @AfterClass
    public void tearDown() {
        System.out.println("I am a After Class");
    }
    // Не обязательно располагать методы Before до тестов, а After после тестов. Порядок произвольный.
    // Но лучше располагать в порядке выполнения для облегчения чтения кода.

    // Остальные хуки нам объяснят, когда познакомимся с конфигурационным файлом.
}
