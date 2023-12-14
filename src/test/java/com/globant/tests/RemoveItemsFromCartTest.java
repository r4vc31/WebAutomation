package com.globant.tests;

import com.globant.pages.CartPage;
import com.globant.pages.LoginPage;
import com.globant.pages.ProductPage;
import com.globant.pages.ProductsPage;
import com.globant.utils.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class RemoveItemsFromCartTest extends BaseTest {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

    }

    @Test
    @Parameters({"username", "password", "productsToAdd"})
    public void removeItemsFromCart(String username, String password, int productsToAdd) {
        //log in
        loginPage.login(username, password);
        //Add some random products
        for (int i = 0; i < productsToAdd; i++) {
            do {
                productsPage.selectRandomProduct();
            }while (!productPage.addToCart());
            productPage.goBackToProducts();
        }
        //enter to the cart page
        cartPage.goToCart();
        //remove all products from the cart
        cartPage.removeItemsFromCart();
        // Check that the cart is empty
        boolean isCartEmpty = cartPage.isCartEmpty();
        Assert.assertTrue(isCartEmpty, "Cart is not empty after removing items");
    }
}
