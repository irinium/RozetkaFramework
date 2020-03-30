package ua.com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class CheckoutPage extends AbstractPage {
    
    @FindBy(css = ".check-edit-order a")
    private WebElement editOrder;

    @FindBy(css = ".cart-check")
    private WebElement deleteItem;

    @FindBy(css = ".cart-i-delete-link")
    private WebElement confirmDelete;

    @FindBy(css = ".preloader-big")
    private WebElement loader;

    @FindBy(css = ".empty-cart-title")
    private WebElement cardStatus;

    @FindBy(css = ".hub-i-cart-link")
    private WebElement card;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "ROZETKA— Авторизованный пользователь | Оформление заказа";
        this.PAGE_URL = "https://my.rozetka.com.ua/checkout/#step=delivery";
    }

    public void deleteItemFromCard(String item){
        waitForElementDisappear(loader);
        clickElement(editOrder);
        clickElement(deleteItem);
        clickElement(confirmDelete);
        clickElement(card);
        assertTrue(getText(cardStatus).trim().contains(item));
    }
}
