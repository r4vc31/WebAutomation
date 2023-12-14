package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class ProductPage extends BasePage {
    @FindBy(id = "back-to-products")
    private WebElement backButton;

    @FindBy(css = ".btn_inventory")
    private WebElement inventoryButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean addToCart() {
        boolean success = false;
        if(Objects.equals(inventoryButton.getText(), "Remove"))
            goBackToProducts();
        else{
            inventoryButton.click();
            success = true;
        }
        return success;
    }

    public void goBackToProducts(){
        backButton.click();
    }

}
