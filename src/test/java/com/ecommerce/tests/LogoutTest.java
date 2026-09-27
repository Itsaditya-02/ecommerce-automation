package com.ecommerce.tests;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Login
        loginPage.login(
                username,
                password
        );

        // Logout
        productsPage.logout();

        // Verify login button is displayed
        boolean loginButtonDisplayed =
                loginPage.isLoginButtonDisplayed();

        Assert.assertTrue(
                loginButtonDisplayed
        );
    }
}