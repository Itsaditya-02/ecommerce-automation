package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.ecommerce.utils.WaitUtil;

public class CartPage {

    WebDriver driver;
    WaitUtil waitUtil;

    // Locators
    By productName = By.className("inventory_item_name");
    By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    By checkoutButton = By.id("checkout");
    By cartItems = By.className("cart_item");
    By continueShoppingButton = By.id("continue-shopping");
    By productPrice = By.className("inventory_item_price");

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

    public String getProductPrice() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver -> {
            try {
                return webDriver.findElement(productPrice).getText();
            } catch (StaleElementReferenceException e) {
                return null;
            }
        });
    }

    public void continueShopping() {
        waitUtil.waitForElementToBeClickable(continueShoppingButton).click();
    }
}
