package com.ecommerce.tests;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProductPriceTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Login
        loginPage.login(
                username,
                password
        );

        // Get backpack price
        String price = productsPage.getProductPrice();

        // Verify price
        Assert.assertEquals(
                price,
                "$29.99"
        );
    }
}