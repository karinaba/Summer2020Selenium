package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTest {
    static WebDriver driver;
    public static void main(String[] args) throws Exception {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(1000);
        List<WebElement>links = driver.findElements(By.tagName("a"));
//        for(WebElement link: links){
//            System.out.println(link.getText());
//            System.out.println(link.getAttribute("href"));
//        }
        for(int i=1; i<links.size();i++){

            links.get(i).click();

            driver.navigate().back();
            links = driver.findElements(By.tagName("a"));
        }
        driver.quit();

    }
}
