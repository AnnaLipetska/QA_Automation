package test.java;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions optionsCh = new ChromeOptions();
        optionsCh.addArguments("--disable-notifications");
        optionsCh.addArguments("--window-size=1300,1080");

        FirefoxOptions optionsFF = new FirefoxOptions();
/*        try {
            driver = new RemoteWebDriver(new URL("http://ec2-13-59-33-74.us-east-2.compute.amazonaws.com:4444/wd/hub"), optionsCh);
            // driver = new RemoteWebDriver(new URL("http://ec2-13-59-33-74.us-east-2.compute.amazonaws.com:4444/wd/hub"), optionsFF);
            // driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), optionsCh);
            // driver = new RemoteWebDriver(new URL("localhost:4444/wd/hub"), optionsCh);
            // localhost - это синоним 127.0.0.1, это одно и то же
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
        driver = new ChromeDriver();
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        attachString();
        attachScreen();
        driver.quit();
    }

    @Attachment
    private String attachString() {
        return "Hello, some attach";
    }

    @Attachment(value = "screenshot", type = "image/png")
    private byte[] attachScreen() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
