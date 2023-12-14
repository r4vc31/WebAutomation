package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouPage extends BasePage {
    @FindBy(css = ".complete-header")
    private WebElement thankYouHeader;

    public ThankYouPage(WebDriver driver) {
        super(driver);
    }

    public String getThankYouHeaderText() {
        return thankYouHeader.getText();
    }

    public boolean isThankYouPageDisplayed() {
        return thankYouHeader.isDisplayed();
    }

}
