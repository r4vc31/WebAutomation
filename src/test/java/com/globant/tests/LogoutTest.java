package com.globant.tests;

import com.globant.pages.LoginPage;
import com.globant.pages.LogoutPage;
import com.globant.utils.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private LogoutPage logoutPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @Test
    @Parameters({"username", "password", "url"})
    public void logoutTest(String username, String password, String url) {
        //log in
        loginPage.login(username, password);
        //open menu
        loginPage.openBurgerMenu();
        //log out
        logoutPage.logout();
        // Check redirection to login page
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
