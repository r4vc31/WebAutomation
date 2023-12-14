package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
    @FindBy(id = "card-number")
    private WebElement cardNumberInput;

    @FindBy(id = "card-expiration")
    private WebElement cardExpirationInput;

    @FindBy(id = "card-cvv")
    private WebElement cardCVVInput;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void completePurchase() {
        finishButton.click();
    }

}
