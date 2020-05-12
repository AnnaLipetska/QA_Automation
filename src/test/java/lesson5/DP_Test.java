package test.java.lesson5;

import main.java.lesson5.app.Server;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DP_Test {
    // DDT - Data Driven Testing
    // Data providing
    Server server; // Объявляем переменную

    @BeforeMethod
    public void beforeMethod() {
        server = new Server();
    }

    /*    @Test
        public void testStatus() {
            // Чтобы протестировать метод getStatus сколько реально нужно значений?
            // Понятие граничных значений, эквивалентное разбиение

            // 10 - "Student", 18, 19, 25, 60, 61, 70, 90, 91, -10
            // Дублировать код - плохо. Много копировать, читать такие тесты тяжело, рефакторить - тяжело.
            // Паттерн дата провайдер
            String actualStatus = server.getStatus(10);
            String expectedStatus = "Student";
            assertEquals(actualStatus, expectedStatus);
        }*/
    @Test(dataProvider = "statuses") // Привязываем дата провайдер к тесту - по имени или по названию метода
    public void testStatus(int age, String expectedStatus) { // Предоставляем данные извне
        String actualStatus = server.getStatus(age);
        System.out.println(" age " + age + " status " + expectedStatus); // Дописали чтобы видеть что тест выполнялся
        // String expectedStatus = "Student"; // Убираем эту строчку
        assertEquals(
                actualStatus,
                expectedStatus,
                "Expected status " + expectedStatus + " with age " + age); //Когда тест падает,
        // не хватает каког-то сообщения более понятного
        // Для того чтобы вызвать тест n раз на разных данных используется дата провайдер.
    }

    // int[] arr = {2,4,6};
    // int[][] matrix = {{2,4}, {6,8}}; - массив массивов, в массиве могут быть только одного типа данные
    // Object[][] matrix = {{2, "A"}, {6, 8}}; // Прокатывают разного типа значениня, потому что мы не указываем тип
    // данных, которые храним. Мы намеренно указываем самый верхний тип данных Object. В объект можно запихнуть и
    // строку и число, т.к. они от него наследуются

    // Реализуем дата провайдер:
    @DataProvider(name = "statuses") // Можно дать опционально имя
    public Object[][] getData() { // Этот метод должен возвращать массив объектов потому что тестов будет более чем один.
        // На каждый тест мы должны вернуть определенный набор данных.
        // В рамках каждого набора данных будет некоторое количество значений.
        // Например, 10 - "Student", поэтому простого массива нам не хватит, нужен массив массивов.
        return new Object[][]{
                {10, "Student"},
                {18, "Worker"},
                {19, "Worker"},
                {25, "Worker"},
                {60, "Pensioner"},
                {70, "Pensioner"},
                {90, "Pensioner"}, // Такой тест упадет, соответственно, если это ошибка программиста, то
                // программист должен исправить это в коде
                {91, "Not valid input"},
                {-10, "Not valid input"} // Такой тест упадет, после исправления программистом в первый раз - все
                // равно падает Not valid input with age -10 expected [Not valid input] but found [Worker]
        };
    }
}
