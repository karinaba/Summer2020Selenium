package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        String expected = "cba";
        String toReverse = "abc";
        String actual =reverseString("apple");
        verifyEquals(expected, actual);
    }

    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String exp = "elppa";
        String actual = reverseString("apple");

        Assert.assertEquals(actual, exp);


    }

    public static boolean verifyEquals(String expected, String actual){
        if(expected.equalsIgnoreCase(actual)){
            System.out.println("Passed");
            return true;
        }else{
            System.out.println("Failed");
            return false;
        }
    }

    /**
     * This method stands for reversing strings
     * @param str
     * @return
     */
    public static String reverseString(String str){
        String reversed ="";
        for(int i=str.length()-1;i>=0;i--){
            reversed+= str.charAt(i);

        }
        return reversed;

    }
}
