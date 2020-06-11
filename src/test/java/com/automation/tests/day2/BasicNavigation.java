package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        String expecTitle = "Google";
        if(expecTitle.equals(title)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test FAILED!");
        }
        driver.navigate().to("http://amazon.com");
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test FAILED!");
        }
        driver.navigate().back();
        verifyEquals(driver.getTitle(), "Google");
        driver.close();
        driver.quit();
    }
    public static void verifyEquals(String st1, String st2){
        if(st1.equals(st2)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test FAILED!");
        }
    }
}
