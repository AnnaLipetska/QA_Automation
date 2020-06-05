package test.java;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.po.ContactPage;
import test.java.po.FaqPage;
import test.java.po.HomePage;
import test.java.utils.RetryAnalyzer;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TestFirst extends TestBaseSetup {
    HomePage homePage;
    ContactPage contactPage;
    FaqPage faqPage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
        faqPage = new FaqPage(driver);
    }

/*    @Test
    public void testA() {
        homePage.open();
    }*/

    @Test()
    public void testB() {
        homePage.open().clickContacts();
        contactPage.clickFaq();
        faqPage.getQuestions();
    }

    @Test()
    public void testC() {
        homePage.open().clickContacts();
        contactPage.clickFaq();
        faqPage.getQuestions();
    }

    @Test()
    public void testD() {
        homePage.open().clickContacts();
        contactPage.clickFaq();
        faqPage.getQuestions();
        assertTrue(false);
    }

    @Test()
    public void testE() {
        homePage.open().clickContacts();
        //throw new Error("Error");
        driver.findElement(By.id("AAAA")).click();
        contactPage.clickFaq();
        faqPage.getQuestions();
        assertTrue(true);
    }
}
