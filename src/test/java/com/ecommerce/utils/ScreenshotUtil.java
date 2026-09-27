package com.ecommerce.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void takeScreenshot(
            WebDriver driver,
            String testName) throws IOException {

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        File source =
                screenshot.getScreenshotAs(
                        OutputType.FILE
                );

        String timestamp =
                new SimpleDateFormat(
                        "yyyyMMdd_HHmmss"
                ).format(new Date());

        File destination = new File(
                "screenshots/"
                        + testName
                        + "_"
                        + timestamp
                        + ".png"
        );

        File screenshotFolder =
                new File("screenshots");

        if (!screenshotFolder.exists()) {
            screenshotFolder.mkdirs();
        }

        source.renameTo(destination);
    }
}