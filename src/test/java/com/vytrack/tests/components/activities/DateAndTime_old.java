package com.vytrack.tests.components.activities;

import com.vytrack.CalendarEventsPage;
import com.vytrack.tests.Pages.LoginPage;
import com.vytrack.utilities.*;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateAndTime_old extends TestBase1 {
    //int waitTime = 1;
    String startDateLocator = "(//input[contains(@placeholder,'Choose a date')])[1]";
    String yearLocator = "//select[@class='ui-datepicker-year']";
    String year2022Locator = "//select[@class='ui-datepicker-year']//option[text()='2022']";
    String monthDecLocator = "//select[@class='ui-datepicker-month']//option[text()='Dec']";
    String monthLocator = "//select[@class='ui-datepicker-month']";
    String day26Locator = "//a[.='26']";
    String endDateLocator = "(//input[contains(@placeholder,'Choose a date')])[2]";
    String startTimeLocator = "(//input[@placeholder='time'])[1]";
    String endTimeLocator = "(//input[@placeholder='time'])[2]";
    //String timeLocator = "//li[contains(text(),'10:30 AM')]";
    String timeLocator = "//li[text()='9:30 AM']";
    //String timeLocator2 = "//li[contains(text(),'11:30 AM')]";
    String timeLocator2 = "//li[text()='10:30 AM']";
    String timeLocator3 = "//li[contains(text(),'11:30 PM')]";
    String timeLocator4 = "//li[contains(text(),'12:30 AM')]";
    // String datePickerLocator= "ui-datepicker-div";  //id
    //String actualDayLocator = "ui-state-default ui-state-active";  //class
    //String repeatCheckBoxLocator = "//input[@id='recurrence-repeat-view99']";   //xpath
    String repeatCheckBoxLocator = "//input[@data-name='recurrence-repeat']";   //xpath
    CalendarEventsPage calendarPage = new CalendarEventsPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void dateandtimetest() {   // throws InterruptedException
        int waitTime = 2;
        String username = ConfigurationReader.getProperty("truckdriverusername");
        String password = ConfigurationReader.getProperty("truckdriverpassword");
        loginPage.login(username, password);
        SeleniumUtilities.waitPlease(waitTime);
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        SeleniumUtilities.waitPlease(waitTime);
        //find start date and click it to open up the date picker
        WebElement startDateElement = driver.findElement(By.xpath(startDateLocator));
        startDateElement.click();
        SeleniumUtilities.waitPlease(waitTime);
        // find the year element from the date picker
        WebElement yearElement = driver.findElement(By.xpath(yearLocator));
        yearElement.click();
        SeleniumUtilities.waitPlease(waitTime);
        // Select year 2022 from date picker and click it
        driver.findElement(By.xpath(year2022Locator)).click();
        SeleniumUtilities.waitPlease(waitTime);
        // find the month element from the date picker
        WebElement monthElement = driver.findElement(By.xpath(monthLocator));
        monthElement.click();
        SeleniumUtilities.waitPlease(waitTime);
        // Select month December from date picker and click it
        driver.findElement(By.xpath(monthDecLocator)).click();
        SeleniumUtilities.waitPlease(waitTime);
        // Select day 26 from date picker anc click it
        driver.findElement(By.xpath(day26Locator)).click();
        // Get the value of the start date and assign it to startDate
        String startDate = startDateElement.getAttribute("value");
        SeleniumUtilities.waitPlease(waitTime);
        // find the element for end date
        WebElement endDateElement = driver.findElement(By.xpath(endDateLocator));
        SeleniumUtilities.waitPlease(waitTime);
        // Get the value of the end date and assign it to endDate
        String endDate = endDateElement.getAttribute("value");
        System.out.println("Start Date :" + startDate);
        System.out.println("End Date :" + endDate);
        // Verify that the end date changes to the same date as Start Date
        Assert.assertEquals(startDate, endDate);
        //store today's date in todaysDate string in the format that the calendar uses
        String todaysDate = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        System.out.println("Today's Date is : " + todaysDate);
        // extract the current day, current month and current year from todaysDate
        String dayOfToday;
        String monthOfToday;
        String yearOfToday;
        if (todaysDate.length() == 12) {
            dayOfToday = todaysDate.substring(4, 6);
            monthOfToday = todaysDate.substring(0, 3);
            yearOfToday = todaysDate.substring(8);
        } else {
            dayOfToday = todaysDate.substring(4, 5);
            monthOfToday = todaysDate.substring(0, 3);
            yearOfToday = todaysDate.substring(7);
        }
        System.out.println(dayOfToday + " " + monthOfToday + " " + yearOfToday);
        SeleniumUtilities.waitPlease(waitTime);
        //find start date and click it to open up the date picker
        startDateElement = driver.findElement(By.xpath(startDateLocator));
        startDateElement.click();
        SeleniumUtilities.waitPlease(waitTime);
        // select the current year from the date picker and click it
        driver.findElement(By.xpath(yearLocator + "//option[text()='" + yearOfToday + "']")).click();
        SeleniumUtilities.waitPlease(waitTime);
        // select the current month from the date picker and click it
        driver.findElement(By.xpath(monthLocator + "//option[text()='" + monthOfToday + "']")).click();
        SeleniumUtilities.waitPlease(waitTime);
        // select the current day from the date picker and click it
        driver.findElement(By.xpath("//a[.='" + dayOfToday + "']")).click();
        SeleniumUtilities.waitPlease(waitTime);
        // Get the value of the start date and assign it to startDate
        startDate = startDateElement.getAttribute("value");
        // Get the value of the end date and assign it to endDate
        endDate = startDateElement.getAttribute("value");
        System.out.println("Start Date :" + startDate);
        System.out.println("End Date :" + endDate);
        // Verify that the end date changes to the same date as Start Date
        Assert.assertEquals(startDate, endDate);
    }  // dateandtimetest(){

    @Test
    public void autoAdjust() {
        int waitTime = 1;
        String username = ConfigurationReader.getProperty("truckdriverusername");
        String password = ConfigurationReader.getProperty("truckdriverpassword");
        loginPage.login(username, password);
        SeleniumUtilities.waitPlease(waitTime);
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        SeleniumUtilities.waitPlease(waitTime);
        //find start time Element and click it
        WebElement startTimeElement = driver.findElement(By.xpath(startTimeLocator));
        startTimeElement.click();
        SeleniumUtilities.waitPlease(waitTime);
        // Select 9:30 AM for time and click it
        driver.findElement(By.xpath(timeLocator)).click();
        SeleniumUtilities.waitPlease(waitTime);
        System.out.println("Start Time is : " + startTimeElement.getAttribute("value"));
        SeleniumUtilities.waitPlease(waitTime);
        // find the end time element
        WebElement endTimeElement = driver.findElement(By.xpath(endTimeLocator));
        SeleniumUtilities.waitPlease(waitTime);
        System.out.println("End Time is : " + driver.findElement(By.xpath(endTimeLocator)).getAttribute("value"));
        //Verify that end time changes exactly 1 hours later which is 10:30 AM
        Assert.assertEquals(driver.findElement(By.xpath(endTimeLocator)).getAttribute("value"), "10:30 AM");
    }  //


    @Test
    public void autoAdjust2() {
        int waitTime = 1;
        String username = ConfigurationReader.getProperty("truckdriverusername");
        String password = ConfigurationReader.getProperty("truckdriverpassword");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        SeleniumUtilities.waitPlease(waitTime);
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        SeleniumUtilities.waitPlease(waitTime);
        //find start time Element and click it
        WebElement startTimeElement = driver.findElement(By.xpath(startTimeLocator));
        startTimeElement.click();
        SeleniumUtilities.waitPlease(waitTime);
        // Select 11:30 PM for time and click it
        driver.findElement(By.xpath(timeLocator3)).click();
        SeleniumUtilities.waitPlease(waitTime);
        System.out.println("Start Time is : " + startTimeElement.getAttribute("value"));
        SeleniumUtilities.waitPlease(waitTime);
        // find the start date and end date and print them on screen
        String startDate = driver.findElement(By.xpath(startDateLocator)).getAttribute("value");
        String endDate = driver.findElement(By.xpath(endDateLocator)).getAttribute("value");
        System.out.println("Start date is : " + startDate);
        System.out.println("End date is : " + endDate);
        int startDay;
        String startMonth = startDate.substring(0, 3);
        int startYear;
        if (startDate.length() == 12) {
            startDay = Integer.valueOf(startDate.substring(4, 6));
            startYear = Integer.valueOf(startDate.substring(8));
        } else {
            startDay = Integer.valueOf(startDate.substring(4, 5));
            startYear = Integer.valueOf(startDate.substring(7));
        }
        int endDay;
        String endMonth = endDate.substring(0, 3);
        int endYear;
        if (endDate.length() == 12) {
            endDay = Integer.valueOf(endDate.substring(4, 6));
            endYear = Integer.valueOf(endDate.substring(8));
        } else {
            endDay = Integer.valueOf(endDate.substring(4, 5));
            endYear = Integer.valueOf(endDate.substring(7));
        }
        boolean result = false;
        //verify that the end date is 1 day later than the start date
        if (startMonth.equals(endMonth)) {
            if (startDay == endDay - 1) result = true;
        } else {
            if (endDay == 1) result = true;
        }
        Assert.assertTrue(result);
        SeleniumUtilities.waitPlease(waitTime);
        // find the end time element
        WebElement endTimeElement = driver.findElement(By.xpath(endTimeLocator));
        SeleniumUtilities.waitPlease(waitTime);
        String endTime = driver.findElement(By.xpath(endTimeLocator)).getAttribute("value");
        System.out.println("End Time is : " + endTime);
        Assert.assertEquals(endTime, "12:30 AM");

//    @Test(priority = 1)
//    public void Date_time_End_time_auto_adjust() {
//
//        String username = ConfigurationReader.getProperty("truckdriverusername");
//        String password = ConfigurationReader.getProperty("truckdriverpassword");
//        VYTrackUtils.login(driver, username, password);
//        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
//        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
//        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();
//        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
//        SeleniumUtilities.waitPlease(3);
//
//        WebElement startTimeElement = driver.findElement(By.xpath(startTimeLocator));
//        startTimeElement.click();
//        SeleniumUtilities.waitPlease(3);
//        driver.findElement(By.xpath(timeLocator)).click();
//        //startTimeElement.clear();
//        //startTimeElement.sendKeys("1:30 PM",Keys.ENTER);
//        SeleniumUtilities.waitPlease(3);
//        //BrowserUtils.waitForVisibility(By.xpath(timeLocator2),5);
//        //find end time Element
//        WebElement endTimeElement = driver.findElement(By.xpath(timeLocator2));
//        SeleniumUtilities.waitPlease(3);
//        System.out.println(endTimeElement.getAttribute("innerHTML"));
//        //System.out.println(driver.findElement(By.xpath(timeLocator3)).getText());
//        String expectedTime = "11:30 AM";
//        SeleniumUtilities.waitPlease(5);
//        //verify that the end time changes its time to 12.30
//        Assert.assertEquals(endTimeElement.getAttribute("innerHTML"), expectedTime);
//    }
    }

}
