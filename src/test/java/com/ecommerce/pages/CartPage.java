package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utils.WaitUtil;

public class CartPage {

    WebDriver driver;
    WaitUtil waitUtil;

    // Locators
    By productName = By.className("inventory_item_name");
    By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    By checkoutButton = By.id("checkout");
    By cartItems = By.className("cart_item");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    // Get product name
    public String getProductName() {
        return waitUtil
                .waitForElementToBeVisible(productName)
                .getText();
    }

    // Remove backpack
    public void removeBackpack() {
        waitUtil
                .waitForElementToBeClickable(removeBackpackButton)
                .click();
    }

    // Check whether cart is empty
    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }

    // Proceed to checkout
    public void clickCheckout() {
        waitUtil
                .waitForElementToBeClickable(checkoutButton)
                .click();
    }
}