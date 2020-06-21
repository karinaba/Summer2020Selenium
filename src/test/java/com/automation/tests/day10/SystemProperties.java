package com.automation.tests.day10;


import org.testng.annotations.Test;



public class SystemProperties {

    @Test
    public void test(){
        //System.getProperty("user.dir") + "/pom.xml
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));

        String pathDownloads = System.getProperty("user.home")+ "/Downloads";
        System.out.println(pathDownloads);
        System.out.println(System.getProperty("os.arch"));
    }
}
