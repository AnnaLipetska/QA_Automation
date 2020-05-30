package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.Screenshot;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {
    WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        // driver = new ChromeDriver();
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hb"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        screenshot = new Screenshot(driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        screenshot.getScreenshot(result);
        driver.quit();
    }
}
