package com.ecommerce.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;

public class AdditionalCoverageTest extends BaseTest {

    @Test
    public void loginWithBlankUsernameShowsValidationError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", password);

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @Test
    public void lockedOutUserCannotLogIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }

    @Test
    public void productsCanBeSortedByNameAscending() {
        new LoginPage(driver).login(username, password);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortProducts("az");
        List<String> displayedNames = productsPage.getProductNames();
        List<String> sortedNames = new ArrayList<>(displayedNames);
        Collections.sort(sortedNames);

        Assert.assertEquals(displayedNames, sortedNames);
    }

    @Test
    public void productsCanBeSortedByPriceAscending() {
        new LoginPage(driver).login(username, password);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortProducts("lohi");
        List<Double> displayedPrices = productsPage.getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(displayedPrices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(displayedPrices, sortedPrices);
    }

    @Test
    public void addingAProductUpdatesCartBadge() {
        new LoginPage(driver).login(username, password);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();

        Assert.assertEquals(productsPage.getCartBadgeCount(), "1");
    }

    @Test
    public void cartContinueShoppingReturnsToProductListing() {
        new LoginPage(driver).login(username, password);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.openCart();
        new CartPage(driver).continueShopping();

        Assert.assertEquals(new LoginPage(driver).getPageTitle(), "Products");
    }

    @Test
    public void cartShowsSelectedProductPrice() {
        new LoginPage(driver).login(username, password);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.openCart();

        Assert.assertEquals(new CartPage(driver).getProductPrice(), "$29.99");
    }

    @Test
    public void checkoutRequiresFirstName() {
        openCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCustomerDetails("", "Gupta", "110001");
        checkoutPage.clickContinue();

        Assert.assertTrue(checkoutPage.getErrorMessage().contains("First Name is required"));
    }

    @Test
    public void checkoutRequiresLastName() {
        openCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCustomerDetails("Aditya", "", "110001");
        checkoutPage.clickContinue();

        Assert.assertTrue(checkoutPage.getErrorMessage().contains("Last Name is required"));
    }

    @Test
    public void checkoutRequiresPostalCode() {
        openCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCustomerDetails("Aditya", "Gupta", "");
        checkoutPage.clickContinue();

        Assert.assertTrue(checkoutPage.getErrorMessage().contains("Postal Code is required"));
    }

    private void openCheckout() {
        new LoginPage(driver).login(username, password);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.openCart();
        new CartPage(driver).clickCheckout();
    }
}
