package com.automation.tests.vytrack.activities;


import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.TestBase;
import com.automation.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalendarEventsTest extends TestBase {



    @Test
    public void defaultOptionsTest(){

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());
    }
}
