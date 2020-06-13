package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        List<WebElement> rads = driver.findElements(By.tagName("input"));
        for(WebElement radBut: rads){
            String id = radBut.getAttribute("id");
            boolean isSelected = radBut.isSelected();
            if(radBut.isEnabled()){
                radBut.click();
                System.out.println("Clicked: "+ id);
                BrowserUtils.wait(1);
            }else{
                System.out.println("Button is disabled, not clicked: "+ id);
            }

        }
        driver.quit();

    }
}
