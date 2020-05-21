package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class A_Wait_Continue {
    WebDriver driver;
    WebDriverWait wait;
    String searchStr = "iPhone";
    String popupStrSelect = "[id = 'rz-banner']";
    // String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    By logo = By.cssSelector(".header__logo");
    By search = By.cssSelector("[name = 'search']");
    By iPhone = By.xpath("//div[@class = 'goods-tile__inner']/a/span[contains(text(), '" + searchStr + "')]");
    By popup = By.cssSelector(popupStrSelect);
    // By popup = By.cssSelector(popupStrSelect);
    By popupClose = By.cssSelector(popupStrSelect + " [class = 'exponea-close-cross']");
    // By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");
    By suggestion = By.cssSelector("[class = 'search-suggest'] a");
    // By suggestion = By.cssSelector("[class = 'search-suggest__item-text_type_nowrap']");
    // By suggestion = By.cssSelector("[data-rz-gtm-event = 'suggestedQuery']");


    @BeforeMethod // Гарантировано создается экземпляр браузера
    public void beforeMethod() { // Сюда перенесем все что касается инициализации браузера, инициализации опций,
        // добавления опций
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions(); // Чтобы не показывали нам навязчивое сообщение.
        options.addArguments("--disable-notifications"); // Аргумент этого метода будет как-то управлять браузером
        options.addArguments("--window-size=1000,1080"); // Размер окна по высоте и по длине
        // options.addArguments("--incognito");
        driver = new ChromeDriver(options); // Объявление driver перенесли в сам класс, а инициализацию в beforeMethod.
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testFirst() {
        driver.get("https://rozetka.com.ua/");
        WebElement searchEl = driver.findElement(search);

        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if (driver.findElements(popupClose).size() > 0) {
            driver.findElement(popupClose).click();
        }
        searchEl.sendKeys(searchStr);
        searchEl.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(iPhone))); // Без implicitlyWait валится на
        // этой строк, преподаватель не знает почему.

        driver.get("https://rozetka.com.ua/notebooks/c80004/preset=workteaching/");
        WebElement searchEl2 = driver.findElement(search);

        wait.until(ExpectedConditions.elementToBeClickable(searchEl2));
        if (driver.findElements(popup).size() > 0) {
            driver.findElement(popupClose).click();
        }
        searchEl2.click();
        // Нам надо дождаться пока появится выпадающий список
        wait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();

        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(iPhone),
                ExpectedConditions.urlContains(searchStr.toLowerCase())
        ));
        String actual = driver.getCurrentUrl();
        String expected = "/#search_text=" + searchStr.toLowerCase();
        assertTrue(actual.contains(expected),
                String.format("Expected '%s' to contain '%s'", actual, expected));
        // Это рабочий код:
        driver.findElement(logo).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(iPhone)));
    }

    @AfterMethod
    public void afterMethod() { // Гарантировано закрывает браузер
        driver.quit();
    }
}


