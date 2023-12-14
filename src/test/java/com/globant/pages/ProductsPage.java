package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {
    @FindBy(css = ".inventory_item")
    private List<WebElement> products;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void selectRandomProduct() {
        int randomIndex = new Random().nextInt(products.size());
        products.get(randomIndex).findElement(By.cssSelector(".inventory_item_label > a")).click();
    }

}