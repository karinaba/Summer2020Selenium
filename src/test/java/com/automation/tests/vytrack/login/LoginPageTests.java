package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;

public class LoginPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error']>div");
    private String username ="storemanager85";
    private String password = "UserUser123";


    @Test(description = "verify that warning is displayed when user enters invallid username")
    public void invalidUserName(){
    driver.findElement(usernameBy).sendKeys("invalidusername");
    driver.findElement(passwordBy).sendKeys("invalidpassword", Keys.ENTER);
        WebElement warnMess = driver.findElement(warningMessageBy);
        assertTrue(warnMess.isDisplayed(), "warning message is displayed");
        String expected = "Invalid user name or password.";
        String actual = warnMess.getText();

    }

    @Test(description = "login as store Manager, and verify that title equals to dashboard page")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(2);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,expectedTitle, "Page title is not correct");
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        if(driver!= null){
            driver.quit();
            driver = null;
        }
    }
}
