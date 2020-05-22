package test.java.lesson9.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    By search = By.cssSelector("[name='search']");
    //By iPhone = By.xpath("//div[@class='g-i-tile-i-title clearfix']/a[contains(text(), '" + searchStr + "')]");
    By popup = By.cssSelector(popupStrSelect);
    By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");
    By contactBtn = By.cssSelector("[href='https://rozetka.com.ua/contacts/']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }


    public HomePage open() {
        driver.get("https://rozetka.com.ua/");
        return this; // Необязательный подход, но он позволит, возможно, следать код более читабельным.
    }

    public HomePage search(String searchStr) {
        this.searchStr = searchStr;
        By searchResultItem = By.xpath("//span[contains(text(), '" + searchStr + "')]");
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if( driver.findElements(popup).size() > 0 ) {
            driver.findElement(popupClose).click();
        }
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultItem));
        return this;
    }

    public HomePage clickContacts() {
        wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
        driver.findElement(contactBtn).click();
        return this;
    }
}
