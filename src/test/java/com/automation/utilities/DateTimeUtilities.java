package com.automation.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * This method returns current date
 * MM - to specify month like this: 01,02,03..
 * MMM - tp specify month like this: Jan,Feb,Mar,
 * dd - to specify day like this: 01,02,03
 * yyyy - to specify year like this: 2010,2020
 * @param format for example - "MMM dd, yyyy"
 * @return current date as a string
 */
public class DateTimeUtilities {
    public static String getTodaysDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }
}
