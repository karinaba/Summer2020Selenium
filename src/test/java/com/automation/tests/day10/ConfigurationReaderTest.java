package com.automation.tests.day10;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {
    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        System.out.println(browser);
        String userName = ConfigurationReader.getProperty("store_manager");
        String password = ConfigurationReader.getProperty("password");
    }
}
