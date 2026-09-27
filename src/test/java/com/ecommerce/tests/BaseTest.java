package com.ecommerce.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;

    protected String username;
    protected String password;

    @BeforeMethod
    public void setUp() throws IOException {

        // Load configuration
        ConfigReader.loadProperties();

        // Get values from config.properties
        username = ConfigReader.getProperty("username");
        password = ConfigReader.getProperty("password");

        // Chrome options
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put(
                "credentials_enable_service",
                false
        );

        prefs.put(
                "profile.password_manager_enabled",
                false
        );

        prefs.put(
                "profile.password_manager_leak_detection",
                false
        );

        options.setExperimentalOption(
                "prefs",
                prefs
        );

        // Start browser
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        // Open URL from config.properties
        driver.get(
                ConfigReader.getProperty("baseUrl")
        );
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // Take screenshot if test fails
        if (result.getStatus() == ITestResult.FAILURE) {

            try {

                ScreenshotUtil.takeScreenshot(
                        driver,
                        result.getName()
                );

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}