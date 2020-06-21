package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //same for all tests
    private static WebDriver driver;

    //so noone can create object of Driver Class
    //every test should call static getter method instead
    private Driver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    //WebDriverManager.chromedriver().version("79").setup();
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }

    return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }

}


