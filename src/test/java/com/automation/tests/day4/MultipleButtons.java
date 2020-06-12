package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MultipleButtons {
    static WebDriver driver;
    public static void main(String[] args) {

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for(int i=0; i<buttons.size();i++){
            if(buttons.get(i).getText().contains("Don't click!")){
                buttons.get(i).click();
            }
        }

        List <WebElement> buts = driver.findElements(By.id("disappearing_button"));
        if(buts.size()==0){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
    driver.quit();
    }
}
