package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class A_Wait_Intro {

    @Test
    public void testFirst() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver.get("https://rozetka.com.ua/");
        Thread.sleep(5000);
        By search = By.cssSelector("[name = 'search']");
        WebElement searchEl = driver.findElement(search);
        searchEl.sendKeys("iPhone");
        searchEl.click();
        Thread.sleep(2000);
        // String name = driver.findElement(By.cssSelector("header-topline__user-link link-dashed")).getText();
        // На следующий день перестало срабатывать, т.к. на сайте поменяли селектор.
        String name = driver.findElement(By.cssSelector("header-topline__user-link link-dashed")).getText();
        System.out.println(name);
        driver.quit();
    }
}
