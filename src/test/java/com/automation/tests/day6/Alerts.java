package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement>buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();
        BrowserUtils.wait(3);
        String popupText1 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        buttons.get(1).click();
        BrowserUtils.wait(3);
        String popupText2 = driver.switchTo().alert().getText();

        driver.switchTo().alert().dismiss();
        BrowserUtils.wait(3);

        buttons.get(2).click();
        driver.switchTo().alert().sendKeys("Hello");

        driver.switchTo().alert().accept();
        BrowserUtils.wait(3);
        driver.quit();
    }
}
