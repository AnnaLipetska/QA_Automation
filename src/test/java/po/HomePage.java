package test.java.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
import test.java.utils.PropertyLoader;
import io.qameta.allure.Step;

import java.util.List;

public class HomePage {
    public Logger logger = LogManager.getLogger(HomePage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    private final String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";

    @FindBy(css = "[name='search']")
    private WebElement search;
    @FindBy(css = popupStrSelect)
    private List<WebElement> popup;
    @FindBy(css = popupStrSelect + " [class='popup-close']")
    private WebElement popupClose;
    @FindBy(css = "[href='https://rozetka.com.ua/contacts/']")
    //@CacheLookup
    private WebElement contactBtn;


    public HomePage(WebDriver driver) {
        logger.trace("Home page initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Step("Open home page")
    public HomePage open() {
        logger.info("Open");
        logger.error("Open");
        logger.warn("Open");
        driver.get(PropertyLoader.loadProperty("url"));
        //el.sendKeys(PropertyLoader.loadProperty("login"));
        //el2.sendKeys(PropertyLoader.loadProperty("password"));
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    @Step("Open home page by url {url}")
    public HomePage open2(String url) {
        logger.info("Open");
        logger.error("Open");
        logger.warn("Open");
        driver.get(url);
        //el.sendKeys(PropertyLoader.loadProperty("login"));
        //el2.sendKeys(PropertyLoader.loadProperty("password"));
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    @Step("Search by {searchStr}")
    public HomePage search(String searchStr) {
        logger.info("Search on home page by " + searchStr);
        this.searchStr = searchStr;
        By searchResultItem = By
                .xpath("//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + searchStr.toLowerCase() + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(search));
        if( popup.size() > 0 ) {
            popupClose.click();
        }
        search.clear();
        search.sendKeys(this.searchStr);
        search.sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultItem)); //1
        //wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultItem)); // 2
        wait.until(new ExpectedCondition<Boolean>() { // 3
            @Override
            public Boolean apply(WebDriver driver) {
                int amount = driver.findElements(searchResultItem).size();
                return amount > 0;
            }
        });

        return this;
    }

    @Step("Click contacts")
    public HomePage clickContacts() {
        logger.info("Click contacts");
        wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
        contactBtn.click();
        return this;
    }
}