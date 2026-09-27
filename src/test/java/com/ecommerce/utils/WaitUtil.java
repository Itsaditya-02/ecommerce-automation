package com.ecommerce.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    private WebDriverWait wait;

    public WaitUtil(WebDriver driver) {

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // Wait until element is clickable
    public WebElement waitForElementToBeClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    // Wait until element is visible
    public WebElement waitForElementToBeVisible(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    // Wait until text appears in an element
    public boolean waitForText(By locator, String text) {

        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        locator,
                        text
                )
        );
    }
}