package ua.com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(css = ".search-form__input.ng-pristine")
    private WebElement searchInput;

    @FindBy(css = ".product-trade .buy-button")
    private WebElement buyButton;

    @FindBy(css = ".cart-modal__check-button .button-inner")
    private WebElement orderConfirmButton;

    @FindBy(css = ".catalog-grid > li .goods-tile__title")
    private List<WebElement> searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";
        this.PAGE_URL = "https://rozetka.com.ua/";
    }

    public void setSearchText(String text) {
        searchElementText(searchInput, text);
    }

    public void addToCardItem(final String text) {
        WebElement item = webElements(searchItems).stream()
                .filter(element -> element.getText().contains(text))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Result with [" + text + "] not found"));
        scrollToElement(item);
        clickElement(item);
        scrollAndClickElement(buyButton);
        scrollAndClickElement(orderConfirmButton);
    }
}
