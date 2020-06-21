package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class JSExecutor {
    private WebDriver driver;

    @Test
    public void javaScriptExec(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        BrowserUtils.wait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //x, y coordinates
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
        BrowserUtils.wait(2);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
        BrowserUtils.wait(2);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");

    }

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
