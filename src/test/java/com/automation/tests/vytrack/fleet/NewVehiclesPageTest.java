package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.vytrack.TestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesPageTest extends TestBase {

    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.navigateTo("Fleet", "Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actTitle = Driver.getDriver().getTitle();
        BrowserUtils.wait(4);
        Assert.assertEquals(actTitle, expectedTitle);
    }
}
