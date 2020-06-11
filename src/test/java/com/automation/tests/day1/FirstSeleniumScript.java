package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumScript {
    public static void main(String[]args){
       String st1 = "SNP HARP Eligible Tier 2 HCBS (H4 with H6)";
       String st2 = "SNP HARP Eligible (H4)";
       if(st1.contains(st2)){
           System.out.println("contains");
       }else{
           System.out.println("doesn't contain");
       }
    }

}
