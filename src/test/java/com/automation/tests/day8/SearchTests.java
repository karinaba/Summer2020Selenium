package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement item:searchItems){
            String var = item.getText();
            if(!var.isEmpty()){
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));

            }
        }
    }
    @Test(description = "Search for Java book on Amazon")
    public void  amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(2);
        List <WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));
        searchItems.get(0).click();
        BrowserUtils.wait(2);
        WebElement productTitle  = driver.findElement(By.id("title"));
        Assert.assertTrue(productTitle.getText().toLowerCase().contains("java"));
    }
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        // How to handle ssl issues in Selenium
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);

        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
