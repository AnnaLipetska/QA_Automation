package test.java.lesson5;

import main.java.lesson5.app.Server;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestServer {

    // Хотим протестировать метод getUsers() из класса Server
    @Test
    public static void getUsersShouldReturnProperAmount() {
        Server server = new Server();
        String usersNames = server.getUsers();
        int actualUsersAmount = usersNames.split(", ").length;
        int expectedUsersAmount = 3; //количество пользователей,
        // которых веренет нам наш сервер.
        // actualUsersAmount == expectedUsersAmount; Это нужно
        // запихнуть в проверку. Для этого используются Assertions.
        // assertEquals(actualUsersAmount, expectedUsersAmount); // Отдельная библиотека, нужно заимпорить.
        // Выбираем import static method, testng а не JUnit
        // Метод сравнивает два значения
        assertEquals(actualUsersAmount, expectedUsersAmount, "Expected amount of users to be 3" + expectedUsersAmount + " but got" + actualUsersAmount);
        // третий аргумент в методе assertEquals - опциональный,
        // на случай если наш тест упадет, для того чтобы мы могли
        // предоставить какую-то дополнительную информацию тому, кто будет
        // работать с этим тестом (в логах непонятно, что упало в тесте,
        // например, может писать expected [2] but found [3] - это
        // неинформативно). Такая информация будет выдаваться только если
        // тест красный, если зеленый - то будет игнорироваться данное
        // сообщение.
    }
}
