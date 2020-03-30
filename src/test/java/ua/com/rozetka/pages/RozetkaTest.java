package ua.com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.com.rozetka.data.RozetkaData;

import static org.testng.Assert.assertEquals;

@Listeners(ua.com.rozetka.utils.ListenerTest.class)
public class RozetkaTest {

    protected WebDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;
    CheckoutPage checkoutPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/home/home/Refinitiv/qa/RozetkaFramework/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    }

    @Test(dataProviderClass = RozetkaData.class, dataProvider = "login")
    public void loginTest(String email, String pass, String result) {
        //login
        loginPage.loadPage();
        loginPage.login(email, pass);
        assertEquals(result, loginPage.getUserName());
    }

    @Test(dataProviderClass = RozetkaData.class, dataProvider = "search")
    public void searchTest(String item, String status) {
        //search
        searchPage.loadPage();
        searchPage.setSearchText(item);
        //add to card
        searchPage.addToCardItem(item);
        //delete item
        checkoutPage.loadPage();
        checkoutPage.deleteItemFromCard(status);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
