package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
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

public class CallsPageTests {
    private WebDriver driver;

    private By callsLink = By.linkText("Calls");
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private String username ="storemanager85";
    private String password = "UserUser123";
    private By logCallBy = By.cssSelector("a[title='Log call']");

    @Test
    public void verifyLogCallButton(){
        WebElement logBut = driver.findElement(logCallBy);
        assertTrue(logBut.isDisplayed());
    }
    @BeforeMethod
    public void setUp(){

        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        BrowserUtils.wait(4);

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);


        //Actions class is used for more advanced commands

        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(callsLink).click();
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
