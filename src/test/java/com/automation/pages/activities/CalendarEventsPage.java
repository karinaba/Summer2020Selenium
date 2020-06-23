package com.automation.pages.activities;

import com.automation.pages.AbstractBasePage;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarEventsPage extends AbstractBasePage {

    @FindBy(css = "[title='Create Calendar Event']")
    private WebElement createCalendarEvent;

    @FindBy(css = "#user-menu > a")
    private WebElement userNameMenu;

    @FindBy(className = "select1-chosen")
    private WebElement owner;


    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

    }
    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }
}
