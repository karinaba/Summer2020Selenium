package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions;
    private By image1By = By.xpath("(//image)[1]");
    private By image2By = By.xpath("(//image)[2]");
    private By image3By = By.xpath("(//image)[3]");
    private By enabledBy = By.id("ui-id-3");
    private By downloadsBy = By.id("ui-id-4");
    private By pdfBy = By.id("ui-id-5");

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");

    }

    @Test
    private void hoverOver(){
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement image1 = driver.findElement(image1By);
        WebElement image2 = driver.findElement(image2By);
        WebElement image3 = driver.findElement(image3By);
        actions = new Actions(driver);
        //build is needed when we have couple of actions -- build.perform
        actions.moveToElement(image1).pause(1000).build().perform();
        actions.moveToElement(image2).pause(1000).build().perform();
        actions.moveToElement(image3).pause(1000).build().perform();
    }

    @Test
    private void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        BrowserUtils.wait(3);
        WebElement enabledEl = driver.findElement(enabledBy);
        WebElement downloadEl = driver.findElement(downloadsBy);
        WebElement pdfEl = driver.findElement(pdfBy);
        actions = new Actions(driver);

        actions.moveToElement(enabledEl).pause(1000).moveToElement(downloadEl).pause(1000).click(pdfEl).build().perform();


    }
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));
        actions = new Actions(driver);
        actions.dragAndDrop(moon, earth).perform();
        BrowserUtils.wait(2);

        String expected = "You did great!";
        String actual = earth.getText().trim();
        System.out.println(actual);
        assertEquals(expected, actual);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
