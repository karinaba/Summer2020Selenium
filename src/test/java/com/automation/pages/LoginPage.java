package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="prependedInput")
    private WebElement username;

    @FindBy(id="prependedInput2")
    private WebElement password;

    @FindBy(css="alert alert-error")
    private WebElement warningMessage;


    public LoginPage(){
        //to connect our webdriver, page class and page factory
        //pageFactory - used to use @FindBy annotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(),this);
    }

    /**
     * Method#1 Login as a specified User
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configurations.properties
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

    public boolean verifyTitle(){

        if(Driver.getDriver().getTitle().equalsIgnoreCase("Dashboard")){
            return true;
        }
        return false;
    }
     public String getWarningMessage(){
        return warningMessage.getText();
     }
}
