package test.java.po;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    private String searchStr;

    @FindBy(css = "[name='search']")
    private WebElement search;
    @FindBy(css = popupStrSelect)
    private List<WebElement> popup;
    @FindBy(css = popupStrSelect + " [class='popup-close']")
    private WebElement popupClose;
    @FindBy(css = "[href='https://rozetka.com.ua/contacts/']")
    private WebElement contactBtn;
    @FindBy(css = "[class='header__logo']")
    @CacheLookup
    private WebElement logo;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }


    public HomePage open() {
        driver.get("https://rozetka.com.ua/");
        return this; // Необязательный подход, но он позволит, возможно, следать код более читабельным.
    }

    public HomePage search(String searchStr) {
        this.searchStr = searchStr;
        By searchResultItem = By.xpath
                ("//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                        + searchStr.toLowerCase() + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(search));
        if (popup.size() > 0) {
            popupClose.click();
        }
        search.sendKeys(this.searchStr);
        search.sendKeys(Keys.ENTER);
//.................
        // 1st option:
        // wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultItem));
        // 2nd option:
        // wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultItem));
        // 3rd option:
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return driver.findElements(searchResultItem).size() > 0;
            }
        });
//.....................
        return this;
    }

    public HomePage clickContacts() {
        wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
        contactBtn.click();
        return this;
    }
}
