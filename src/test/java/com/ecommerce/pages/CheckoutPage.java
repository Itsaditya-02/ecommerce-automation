package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utils.WaitUtil;

public class CheckoutPage {

    WebDriver driver;
    WaitUtil waitUtil;

    // Locators
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By pageTitle = By.className("title");
    By finishButton = By.id("finish");
    By confirmationMessage = By.className("complete-header");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    // Enter first name
    public void enterFirstName(String firstName) {
        waitUtil
                .waitForElementToBeVisible(firstNameField)
                .clear();

        waitUtil
                .waitForElementToBeVisible(firstNameField)
                .sendKeys(firstName);
    }

    // Enter last name
    public void enterLastName(String lastName) {
        waitUtil
                .waitForElementToBeVisible(lastNameField)
                .clear();

        waitUtil
                .waitForElementToBeVisible(lastNameField)
                .sendKeys(lastName);
    }

    // Enter postal code
    public void enterPostalCode(String postalCode) {
        waitUtil
                .waitForElementToBeVisible(postalCodeField)
                .clear();

        waitUtil
                .waitForElementToBeVisible(postalCodeField)
                .sendKeys(postalCode);
    }

    // Click Continue
    public void clickContinue() {
        waitUtil
                .waitForElementToBeClickable(continueButton)
                .click();
    }

    // Get page title
    public String getPageTitle() {
        return waitUtil
                .waitForElementToBeVisible(pageTitle)
                .getText();
    }

    // Click Finish
    public void clickFinish() {
        waitUtil
                .waitForElementToBeClickable(finishButton)
                .click();
    }

    // Get order confirmation message
    public String getConfirmationMessage() {
        return waitUtil
                .waitForElementToBeVisible(confirmationMessage)
                .getText();
    }

    // Complete customer information
    public void enterCustomerDetails(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }
}