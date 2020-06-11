package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        String expecTitle = "Google";
        if(expecTitle.equals(title)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test FAILED!");
        }
        driver.close();
        driver.quit();
    }
}
