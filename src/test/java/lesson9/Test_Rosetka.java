package test.java.lesson9;

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

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Test_Rosetka {
    WebDriver driver;
    WebDriverWait wait;
    String searchStr = "iPhone";
    String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    //By logo = By.cssSelector("[class='logo-link responsive-img logo-link-svg']");
    By logo = By.cssSelector("[class='header__logo']");
    By search = By.cssSelector("[name='search']");
    //By iPhone = By.xpath("//div[@class='g-i-tile-i-title clearfix']/a[contains(text(), '" + searchStr + "')]");
    By iPhone = By.xpath("//span[contains(text(), '" + searchStr + "')]");
    By popup = By.cssSelector(popupStrSelect);
    By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");
    By suggestion = By.cssSelector("[data-rz-gtm-event='suggestedQuery']");
    By contactBtn = By.cssSelector("[href='https://rozetka.com.ua/contacts/']");
    By qAndABn = By.cssSelector("[href='https://rozetka.com.ua/faq/']");
    By qaLinks = By.cssSelector("[name='slider-block-active']");

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testA() {
        driver.get("https://rozetka.com.ua/");
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if( driver.findElements(popup).size() > 0 ) {
            driver.findElement(popupClose).click();
        }
        searchEl.sendKeys(searchStr);
        searchEl.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(iPhone)));
        wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
        driver.findElement(contactBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(qAndABn));
        driver.findElement(qAndABn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(qaLinks));
        List<WebElement> webLinks = driver.findElements(qaLinks);
        for (WebElement element: webLinks) {
            String expectedColor = "rgba(62, 119, 170, 1)";
            String actualColor = element.getCssValue("color");
            assertEquals(expectedColor, actualColor);
        }

//        homePage.open();
//        homePage.search("iPhone");
//        homePage.clickContacts();
//        contactPage.clickQA();
//        List<WebElement> webLinks = faqPage.getQuestions();
//        for (WebElement element: webLinks) {
//            String expectedColor = "rgba(62, 119, 170, 1)";
//            String actualColor = element.getCssValue("color");
//            assertEquals(expectedColor, actualColor);
//        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}