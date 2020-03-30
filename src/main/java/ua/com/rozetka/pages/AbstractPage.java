package ua.com.rozetka.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.*;

public abstract class AbstractPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public String PAGE_URL;
    public String PAGE_TITLE;
    protected JavascriptExecutor jsExecutor;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        jsExecutor = ((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    public void loadPage() {
        driver.get(getPageUrl());
        assertEquals(driver.getTitle(), getPageTitle());
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForElementDisappear(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void scrollAndClickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public String getText(WebElement element) {
        return webElement(element).getText();
    }

    public void setElementText(WebElement element, String text) {
        webElement(element).clear();
        webElement(element).sendKeys(text);
        assertEquals(element.getAttribute("value"), text);
    }

    public void searchElementText(WebElement element, String text) {
        webElement(element).clear();
        webElement(element).sendKeys(text, Keys.ENTER);
    }

    public WebElement webElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> webElements(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }
}
