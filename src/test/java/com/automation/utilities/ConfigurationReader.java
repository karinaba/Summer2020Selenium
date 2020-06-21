package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;

    static {
        try{
            //location of the properties file
            String path = System.getProperty("user.dir")+ "/configuration.properties";
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create an object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            //close the inout stream at the end
            input.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     * This method returns property value from configuration file
     * @param keyName
     * @return
     */
    public static String getProperty(String keyName){
        return configFile.getProperty(keyName);
    }
}
