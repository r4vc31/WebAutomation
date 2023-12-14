package com.globant.tests;

import com.globant.pages.*;
import com.globant.utils.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class PurchaseProductTest extends BaseTest {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;
    private ThankYouPage thankYouPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        thankYouPage = new ThankYouPage(driver);
    }

    @Test
    @Parameters({"username", "password", "firstname", "lastname", "postal-code", "header-thank-you-page"})
    public void purchaseProductTest(String username, String password, String firstName,
                                    String lastName, String postalCode, String headerThankYouPage) {
        //log in
        loginPage.login(username, password);
        //selecting a random product
        productsPage.selectRandomProduct();
        //adding it to the cart
        productPage.addToCart();
        //enter to the cart page
        cartPage.goToCart();
        //enter to the checkout page
        cartPage.proceedToCheckout();
        //adding the personal data
        checkoutPage.fillPersonalInfo(firstName, lastName, postalCode);
        //Go to payment page and finish
        checkoutPage.goToPayment();
        //Complete payment
        paymentPage.completePurchase();
        //check arrival at ThankYouPage
        Assert.assertEquals(thankYouPage.getThankYouHeaderText(), headerThankYouPage);
    }
}
