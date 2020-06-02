package test.java;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.po.HomePage;
import test.java.utils.RetryAnalyzer;

import static org.testng.Assert.fail;

public class TestFirst extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

/*    @Test
    public void testA() {
        homePage.open();
    }*/

    @Test()
    public void testB() {
        homePage.open();
        fail();
    }
}
