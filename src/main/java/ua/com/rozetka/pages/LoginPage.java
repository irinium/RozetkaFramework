package ua.com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "div:nth-child(1) > .input-text.auth-input-text")
    private WebElement emailInput;

    @FindBy(css = "div:nth-child(2) > .input-text.auth-input-text")
    private WebElement passwordInput;

    @FindBy(css = ".btn-link-sign span")
    private WebElement enterButton;

    @FindBy(css = "div:nth-child(2) > div > div > div:nth-child(1) > div.addit-f-i-field")
    private WebElement userName;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "ROZETKA — Вход в интернет-магазин";
        this.PAGE_URL = "https://my.rozetka.com.ua/signin/";
    }

    public void login(String email, String pass) {
        setTextEmail(email);
        setTextPass(pass);
        clickButton();
    }

    public void setTextEmail(String text) {
        setElementText(emailInput, text);
    }

    public void setTextPass(String text) {
        setElementText(passwordInput, text);
    }

    public void clickButton() {
        clickElement(enterButton);
    }

    public String getUserName() {
        return getText(userName);
    }
}
