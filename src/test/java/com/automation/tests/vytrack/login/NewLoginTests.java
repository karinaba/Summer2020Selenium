package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.TestBase;
import com.automation.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends TestBase {

    @Test
    public void verifyPageTitle(){
        //add test.. to every test at the beginning
        test = report.createTest("Verify Login ");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BrowserUtils.wait(5);
        test.info("Login as a store manager");
        Assert.assertTrue(loginPage.verifyTitle(),"title equals Dashboard");
        test.pass("Page title Dashboard was verified");

    }

    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify Warning Message test ");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        BrowserUtils.wait(4);
        Assert.assertEquals(loginPage.getWarningMessage(),"dash");
        //BrowserUtils.getScreenshot("loginPage");
        test.pass("Page title warning message was verified");
    }
}
