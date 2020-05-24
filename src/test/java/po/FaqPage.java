package test.java.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FaqPage extends BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By qaLinks = By.cssSelector("[name='slider-block-active']");

    public FaqPage(WebDriver driver) {
        logger.trace("FAQ page initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public List<WebElement> getQuestions() {
        logger.info("Get questions");
        wait.until(ExpectedConditions.visibilityOfElementLocated(qaLinks));
        return driver.findElements(qaLinks);
    }
}
