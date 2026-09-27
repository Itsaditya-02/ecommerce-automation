package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utils.WaitUtil;

public class ProductsPage {

    WebDriver driver;
    WaitUtil waitUtil;

    // Locators
    By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartButton = By.className("shopping_cart_link");
    By productPrice = By.className("inventory_item_price");
    By menuButton = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    // Constructor
    public ProductsPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    // Add backpack to cart
    public void addBackpackToCart() {

        waitUtil
                .waitForElementToBeClickable(backpackAddButton)
                .click();
    }

    // Open cart
    public void openCart() {

        waitUtil
                .waitForElementToBeClickable(cartButton)
                .click();
    }

    // Get product price
    public String getProductPrice() {

        return waitUtil
                .waitForElementToBeVisible(productPrice)
                .getText();
    }

    // Logout
    public void logout() {

        // Click menu
        waitUtil
                .waitForElementToBeClickable(menuButton)
                .click();

        // Click logout
        waitUtil
                .waitForElementToBeClickable(logoutLink)
                .click();
    }
}