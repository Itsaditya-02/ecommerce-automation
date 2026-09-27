package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utils.WaitUtil;

public class LoginPage {

    WebDriver driver;
    WaitUtil waitUtil;

    // Locators
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By pageTitle = By.className("title");
    By errorMessage = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    // Enter username
    public void enterUsername(String username) {
        waitUtil
                .waitForElementToBeVisible(usernameField)
                .sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        waitUtil
                .waitForElementToBeVisible(passwordField)
                .sendKeys(password);
    }

    // Click login
    public void clickLogin() {
        waitUtil
                .waitForElementToBeClickable(loginButton)
                .click();
    }

    // Complete login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Get page title
    public String getPageTitle() {
        return waitUtil
                .waitForElementToBeVisible(pageTitle)
                .getText();
    }

    // Get error message
    public String getErrorMessage() {
        return waitUtil
                .waitForElementToBeVisible(errorMessage)
                .getText();
    }

    // Check whether login button is displayed
    public boolean isLoginButtonDisplayed() {
        return waitUtil
                .waitForElementToBeVisible(loginButton)
                .isDisplayed();
    }
}