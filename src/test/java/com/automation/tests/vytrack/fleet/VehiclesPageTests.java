package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class VehiclesPageTests {
    private WebDriver driver;

    private By vehiclesLink = By.linkText("Vehicles");
    private By fleetLinkBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private String username ="storemanager85";
    private String password = "UserUser123";
    private By pageBy = By.xpath("//input[@type='number']");

    @Test
    public void verifyPageSubtitle(){


        WebElement subtitleEl = driver.findElement(subtitleBy);
        System.out.println(subtitleEl.getText());

    }
    @Test
    public void VerifyPageNumber(){

        WebElement pageEl = driver.findElement(pageBy);
        String pageNum = pageEl.getAttribute("value");
        assertTrue(pageNum.equalsIgnoreCase("1"));


    }


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(4);

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);


        //Actions class is used for more advanced commands
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetLinkBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(vehiclesLink).click();
        BrowserUtils.wait(4);
    }
    @AfterMethod
    public void tearDown(){
        if(driver!= null){
            driver.quit();
            driver = null;
        }
    }
}
