package ua.com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class CheckoutPage extends AbstractPage {
    
    @FindBy(css = ".check-edit-order a")
    private WebElement editOrder;

    @FindBy(css = ".cart-check-wrap")
    private WebElement deleteItem;

    @FindBy(css = ".cart-i-delete a")
    private WebElement confirmDelete;

    @FindBy(css = ".preloader-big")
    private WebElement loader;

    @FindBy(css = ".cart-modal__dummy")
    private WebElement cardStatus;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "ROZETKA — Новый покупатель | Оформление заказа";
        this.PAGE_URL = "https://my.rozetka.com.ua/checkout/#step=delivery";
    }

    public void deleteItemFromCard(String item){
        waitForElementDisappear(loader);
        clickElement(editOrder);
        clickElement(deleteItem);
        clickElement(confirmDelete);
        assertTrue(getText(cardStatus).trim().contains(item));
    }
}
