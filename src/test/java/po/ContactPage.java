package test.java.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By qAndABn = By.cssSelector("[href='https://rozetka.com.ua/faq/']");


    public ContactPage(WebDriver driver) {
        logger.trace("Contact page initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public ContactPage clickFaq() {
        logger.info("Click FAQ");
        wait.until(ExpectedConditions.elementToBeClickable(qAndABn));
        driver.findElement(qAndABn).click();
        return this;
    }
}
