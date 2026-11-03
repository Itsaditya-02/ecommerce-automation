package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

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
    By cartBadge = By.className("shopping_cart_badge");
    By productSort = By.className("product_sort_container");
    By productNames = By.className("inventory_item_name");
    By productPrices = By.className("inventory_item_price");

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

    public String getCartBadgeCount() {
        return waitUtil.waitForElementToBeVisible(cartBadge).getText();
    }

    public void sortProducts(String option) {
        new Select(waitUtil.waitForElementToBeVisible(productSort)).selectByValue(option);
    }

    public List<String> getProductNames() {
        return driver.findElements(productNames).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        return driver.findElements(productPrices).stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());
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
