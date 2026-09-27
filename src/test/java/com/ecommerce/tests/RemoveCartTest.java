package com.ecommerce.tests;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveCartTest extends BaseTest {

    @Test
    public void removeProductFromCartTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Login
        loginPage.login(
                username,
                password
        );

        // Add product
        productsPage.addBackpackToCart();

        // Open cart
        productsPage.openCart();

        // Remove product
        cartPage.removeBackpack();

        // Verify cart is empty
        Assert.assertTrue(
                cartPage.isCartEmpty()
        );
    }
}