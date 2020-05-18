package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class A_Wait_Intro {
    // Изначально скрипт скопировали из A_Run_browser.java, засунули в метод testFirst(),
    // и помечаем его аннотацией @Test. Тест работает

    // На занятии не запустился, что-то упало. Было написано NoSuchElementException no such element:
    // Unable to locate element .... [name='search']
    // Далее видно синеньким внутри стека A_Wait_Intro.java:18 - означает что ошибка на 18-й строке.

    // Если у кого-то заводится тест, а у кого-то нет - возможно, розетка по-разному отрисовывает DOM для разных
    // платформ. Может, зависит от локали или еще от чего-то. Может, на разные серверы обратились.

    // У кого не сработало, найти новый селектор и пофиксить код.
    @Test
    public void testFirst() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//.......................
        ChromeOptions options = new ChromeOptions(); // Используем для того чтобы заставить драйвер не показывать нам
        // навязчивое сообщение.
        options.addArguments("--disable-notifications"); // Аргумент этого метода будет как-то управлять браузером
        WebDriver driver = new ChromeDriver(options);
//.......................
        driver.manage().window().maximize(); // увеличивает окошко браузера, будет открываться на все окно
//.........................
        driver.get("https://rozetka.com.ua/");
        Thread.sleep(5000); // В будущем удалим, мы с этим работать дальше не будем
        By search = By.cssSelector("[name = 'search']");
        WebElement searchEl = driver.findElement(search);
        searchEl.sendKeys("iPhone");
        searchEl.click();
        Thread.sleep(10000);
        String name = driver.findElement(By.cssSelector("[class='header-topline__user-link link-dashed']")).getText();
        System.out.println(name);
        driver.quit();
    }
}
