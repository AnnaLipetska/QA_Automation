package test.java.lesson5;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SecondTest {
/*    // @Parameters({"chrome"}) // Хочу чтобы тест параметризировался браузером chrome, если запустить ничего не
    // получится, сюда должно попадать не конкретное значение, а переменная.
    @Parameters({"browser"}) // Вносим название переменной, но ошибка та же, так как переменную мы не прокинули.
    // Как прокинуть переменную? В testng.xml на тестом вносим <parameter>
    // Проводим параметризацию через testng.xml
    @Test
    //public static void successLogin(String browser) { // Версия браузера, на которой будем тестировать
    // Если запускать не из консоли, а прямо отсюда тест, то выдает ошибку - Parameter ... browser ... is required
    // Когда запускаем через консоль, сначала запускается pom.xml, в нем написано в конфигурации, что нужно
    // использовать smoke-testng.xml файл. Дальше вычитывается информация из smoke-testing.xml
    // А если нажать на зеленый треугольник здесь, то smoke-testng.xml не участвует в данной операции.
    // TestNG напрямую пытается исполнить этот тест, минуя конфигурацию.
    // Как побороть эту проблему? Есть optional parameter.
    // Если никакого параметра не залетело будет взят дефолтный.
    public static void successLogin(@Optional("firefox") String browser) {
        // Если через консоль будет прокидываться "chrome",
        // если отсюда запускать, то "firefox"
        System.out.println("Second Hello " + browser);
    }
    // Чтобы запараметризировать browser нужна аннотация @Parameters*/

    //..........................
    // Если несколько параметров, то
    @Parameters({"browser", "version"})
    @Test
    public static void successLogin(@Optional("firefox") String browser, @Optional("v50") String version) {
        System.out.println("Second Hello " + browser + " " + version);
    }
}
