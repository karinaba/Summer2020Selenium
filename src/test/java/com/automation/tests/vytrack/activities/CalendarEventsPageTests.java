package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.*;

public class CalendarEventsPageTests {
    private WebDriver driver;

    private By callsLink = By.linkText("Calendar Events");
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private String username ="storemanager85";
    private String password = "UserUser123";
    private By createCalendarEventBy = By.xpath("//a[@title='Create Calendar event']");
    private By userNameMenuBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("id*='date_selector_oro_calendar_event_form_start-uid'");
    private By startTimeBy = By.cssSelector("id*='time_selector_oro_calendar_event_form_start-uid'");


    @Test
    public void CalendarEvents(){
        WebElement calEventButEl = driver.findElement(createCalendarEventBy);
        assertTrue(calEventButEl.isDisplayed());

    }

    @Test(description = "Default options")
    public void verifyDefaultValues(){
        driver.findElement(createCalendarEventBy).click();
        BrowserUtils.wait(3);
        String currentUserNameMenu = driver.findElement(userNameMenuBy).getText().trim();
        String defaultOwner = driver.findElement(ownerBy).getText();
        assertEquals(currentUserNameMenu, defaultOwner);

        WebElement titleEl = driver.findElement(titleBy);
        assertTrue(titleEl.getAttribute("value").isEmpty());

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        assertEquals(actualDate, expectedDate);

        String expectTime = LocalTime.now(ZoneId.of("GTM-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");
        assertEquals(actualTime, expectTime);




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
