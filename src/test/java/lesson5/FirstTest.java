package test.java.lesson5;

import org.testng.annotations.Test;

public class FirstTest {
    // Нам здесь не нужно реализовывать main метод, библиотека сама их подкидывать будет
    // spec-файл описывает какое-то одно поведение
    // все тесты по логину будут в рамках одоного файла
    // добавление в корзину - будет в другом файле уже
    // test suite - это тестовый класс

    // Объявляем тестовый метод (test case). По умолчанию testNG предполагает, что все тесты будут void
    // К тесту нужно добавить аннотацию @Test.
    @Test // Если подсвечивает красным, так как из внешней библиотеки, и нужно заимпортить
    // нажать на подсвеченное красным Alt + Enter, выберите вариант testNG
    public static void successLogin() { // Не рекомендуется называть тесты test1, например, лучше описывать,
        // что вы тестируете, например, successLogin()
        System.out.println("First Hello");
    }

    @Test
    public static void successLogin2() {
        System.out.println("First Hello second method");
    }

    @Test
    public static void successLogin3() {
        System.out.println("First Hello third method");
    }

    @Test
    public static void wrongLogin3() {
        System.out.println("First Hello wrong method");
    }
}
