package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class March4 {
    static WebDriver driver;
    public static void main(String[] args)throws Exception{
        ebayTest();
//        amazonTest();
//        wikiTest();

    }

    public static void ebayTest()throws Exception{
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);
        WebElement searchResults = driver.findElement(By.tagName("h1"));



        System.out.println(searchResults.getText().split(" ")[0]);
        System.out.println(searchResults.toString());
        driver.quit();

    }
    public static void amazonTest(){
        driver = DriverFactory.createDriver("chrome");

    }
    public static void wikiTest(){
        driver = DriverFactory.createDriver("chrome");

    }
}
