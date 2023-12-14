package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(css = "a.shopping_cart_link")
    private WebElement cartLink;

    @FindBy(css = ".cart_list")
    private WebElement cartList;

    @FindBy(css = ".btn_action.checkout_button")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        cartLink.click();
    }

    public boolean isCartEmpty() {
        return cartList.findElements(By.cssSelector(".cart_item")).isEmpty();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }
    public void removeItem(WebElement cartItem) {
        cartItem.findElement(By.className("cart_button")).click();
    }

    public void removeItemsFromCart(){
        for (WebElement cartItem : cartList.findElements(By.cssSelector(".cart_item"))) {
            removeItem(cartItem);
        }
    }

}
