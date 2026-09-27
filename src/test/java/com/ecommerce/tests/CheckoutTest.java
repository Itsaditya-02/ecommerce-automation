package com.ecommerce.tests;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.login(
                username,
                password
        );

        // Add product
        productsPage.addBackpackToCart();

        // Open cart
        productsPage.openCart();

        // Proceed to checkout
        cartPage.clickCheckout();

        // Enter customer details
        checkoutPage.enterCustomerDetails(
                "Aditya",
                "Gupta",
                "110001"
        );

        // Continue
        checkoutPage.clickContinue();

        // Verify overview
        String pageTitle = checkoutPage.getPageTitle();

        Assert.assertEquals(
                pageTitle,
                "Checkout: Overview"
        );

        // Finish order
        checkoutPage.clickFinish();

        // Verify confirmation
        String confirmationMessage =
                checkoutPage.getConfirmationMessage();

        Assert.assertEquals(
                confirmationMessage,
                "Thank you for your order!"
        );
    }
}