package com.ecommerce.tests;

import com.ecommerce.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                username,
                password
        );

        String pageTitle = loginPage.getPageTitle();

        Assert.assertEquals(
                pageTitle,
                "Products"
        );
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "wrong_user",
                "wrong_password"
        );

        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(
                errorMessage.contains(
                        "Username and password do not match"
                )
        );
    }
}