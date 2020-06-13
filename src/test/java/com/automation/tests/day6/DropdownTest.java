package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        WebElement dropd = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropd);
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectYear.selectByVisibleText("1988");
        selectMonth.selectByVisibleText("April");
        selectDay.selectByVisibleText("13");

        List <WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth: months){
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        driver.quit();


    }
}
