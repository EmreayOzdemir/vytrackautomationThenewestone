package com.vytrack.tests.components.activities;


import com.vytrack.CalendarEventsPage;
import com.vytrack.tests.Pages.LoginPage;

import com.vytrack.utilities.*;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class DateAndTime extends TestBase1 {


    String startDateLocator = "(//input[contains(@placeholder,'Choose a date')])[1]";
    String yearLocator = "//select[@class='ui-datepicker-year']";
    String year2022Locator = "//select[@class='ui-datepicker-year']//option[text()='2022']";
    String monthDecLocator = "//select[@class='ui-datepicker-month']//option[text()='Dec']";
    String monthLocator = "//select[@class='ui-datepicker-month']";
    String day26Locator = "//a[.='26']";
    String endDateLocator = "(//input[contains(@placeholder,'Choose a date')])[2]";
    String startTimeLocator = "(//input[@placeholder='time'])[1]";
    String endTimeLocator = "(//input[@placeholder='time'])[2]";
    String timeLocator = "//li[text()='9:30 AM']";
    String timeLocator2 = "//li[text()='10:30 AM']";
    String timeLocator3 = "//li[text()='11:30 PM']";
    String timeLocator4 = "//li[text()='12:30 AM']";
    String repeatCheckBoxLocator = "//input[@data-name='recurrence-repeat']";   //xpath
    String repeatsLocator = "recurrence-repeats__select";
    String repeatsEveryRadioLocator = "(//input[@type='radio'])[1]";  //xpath
    String repeatEveryInputLocator = "//input[@type='radio'][1]/following-sibling::input/following-sibling::input"; // xpath
    String summaryLocator = "div[data-name='recurrence-summary'] div span";
    String summary2Locator = "div[data-name='recurrence-summary'] div span ~ span";
    String weekdayRadioLocator = "(//input[@type='radio'])[2]";
    String failMessageLocator = "(//div[@class='recurrence-subview-control__item'])[1]/span/span/span"; //xpath
    String failMessage2Locator = "(//div[@class='recurrence-subview-control__item'])[4]/span"; //xpath
    String occurrenceInputLocator = "(//input[@type='radio'])[4]/following-sibling::input"; //xpath
    String endsAfterRadioLocator = "(//input[@type='radio'])[4]";  //xpath


    CalendarEventsPage calendarPage = new CalendarEventsPage();
    //LoginPage loginPage = new LoginPage();

    @Test(priority = 1)
    public void dateAndTimeTest1() {   // throws InterruptedException
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


    @Test(priority = 2)
    public void dateAndTimeTest2() {

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


    @Test(priority = 3)
    public void dateAndTimeTest3() {


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


//
//
//        // find today's date in date format
//        LocalDate today = LocalDate.now();
//        // convert today's date from date format to string format
//        String todaysDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
//        // calculate tomorrow's date by adding 1 day to today's date which is in date format
//        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
//        // convert tomorrow's date from date format to string format
//        String tomorrowsDate = tomorrow.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
//        System.out.println("Tomorrow's date is : " + tomorrowsDate);
//        System.out.println("Tomorrow's date received from end date Web Element is : " + endDateElement.getText());
//
//        // verify that the end date shows tomorrow's date
//        Assert.assertEquals(endDateElement.getText(), tomorrowsDate);

    }  //

    @Test(priority = 4)
    public void DailyRepeatTest1() {

        int waitTime = 1;

        // All steps from logging in to create calendar event button as used in all other methods
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


        // find the repeat checkbox element
        WebElement repeatCheckBoxElement = driver.findElement(By.xpath(repeatCheckBoxLocator));
        // scroll down until you see the repeat check box element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", repeatCheckBoxElement);
        // click the repeat checkbox element
        repeatCheckBoxElement.click();

        // find the element for Repeats dropdown menu
        WebElement dropdown = driver.findElement(By.className(repeatsLocator));
        Select select = new Select(dropdown);
        System.out.println("The first selected option is : " + select.getFirstSelectedOption().getText());
        // Verify that Daily is the default selected option in the Repeats dropdown menu
        Assert.assertEquals("Daily", select.getFirstSelectedOption().getText());


        //verify days checkbox is selected
        Assert.assertTrue(driver.findElement(By.xpath(repeatsEveryRadioLocator)).isSelected());
        //print out the the default value for days input box
        System.out.println("Default value in days input box : " + driver.findElement(By.xpath(repeatEveryInputLocator)).getAttribute("value"));
        //verify that days checkbox default value is 1
        Assert.assertEquals("1", driver.findElement(By.xpath(repeatEveryInputLocator)).getAttribute("value"));
        //verify summary says Daily every 1 day
        Assert.assertEquals("Daily every 1 day", driver.findElement(By.cssSelector(summaryLocator)).getText());
        // click the weekday radio button
        driver.findElement(By.xpath(weekdayRadioLocator)).click();
        //verify that days input is now disabled
        Assert.assertFalse(driver.findElement(By.xpath(repeatEveryInputLocator)).isEnabled());
        //verify summary says Daily every weekday
        Assert.assertEquals("Daily, every weekday", driver.findElement(By.cssSelector(summaryLocator)).getText());

    }  //public void repeatEverySummary(){

    @Test(priority = 5)
    public void DailyRepeatTest2() {

        int waitTime = 1;

        // All steps from logging in to create calendar event button as used in all other methods
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


        // find the repeat checkbox element
        WebElement repeatCheckBoxElement = driver.findElement(By.xpath(repeatCheckBoxLocator));
        // scroll down until you see the repeat check box element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", repeatCheckBoxElement);
        // click the repeat checkbox element
        repeatCheckBoxElement.click();

        // find the element for Repeats dropdown menu
        WebElement dropdown = driver.findElement(By.className(repeatsLocator));
        Select select = new Select(dropdown);
        System.out.println("The first selected option is : " + select.getFirstSelectedOption().getText());
        // Verify that Daily is the default selected option in the Repeats dropdown menu
        Assert.assertEquals("Daily", select.getFirstSelectedOption().getText());


        //verify days checkbox is selected
        Assert.assertTrue(driver.findElement(By.xpath(repeatsEveryRadioLocator)).isSelected());
        //print out the the default value for days input box
        System.out.println("Default value in days input box : " + driver.findElement(By.xpath(repeatEveryInputLocator)).getAttribute("value"));
        //verify that days checkbox default value is 1
        Assert.assertEquals("1", driver.findElement(By.xpath(repeatEveryInputLocator)).getAttribute("value"));
        //verify summary says Daily every 1 day
        Assert.assertEquals("Daily every 1 day", driver.findElement(By.cssSelector(summaryLocator)).getText());
    }


    @Test(priority = 6)
    public void DailyRepeatTest3() {

        int waitTime = 1;

        // All steps from logging in to create calendar event button as used in all other methods
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


        // find the repeat checkbox element
        WebElement repeatCheckBoxElement = driver.findElement(By.xpath(repeatCheckBoxLocator));
        // scroll down until you see the repeat check box element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", repeatCheckBoxElement);
        // click the repeat checkbox element
        repeatCheckBoxElement.click();

        // clear the days checkbox input element
        driver.findElement(By.xpath(repeatEveryInputLocator)).clear();
        // send a value less than 1 ( which is 0 ) to the days checkbox
        driver.findElement(By.xpath(repeatEveryInputLocator)).sendKeys("0");

        System.out.println(driver.findElement(By.xpath(failMessageLocator)).getText());
        System.out.println("There is " + driver.findElements(By.xpath(failMessageLocator)).size() + " fail message element");
        Assert.assertEquals("The value have not to be less than 1.", driver.findElement(By.xpath(failMessageLocator)).getText());

        // clear the days checkbox input element
        driver.findElement(By.xpath(repeatEveryInputLocator)).clear();
        // send a value more than ( which is 100 ) to the days checkbox
        driver.findElement(By.xpath(repeatEveryInputLocator)).sendKeys("100");

        System.out.println(driver.findElement(By.xpath(failMessageLocator)).getText());
        System.out.println("There is " + driver.findElements(By.xpath(failMessageLocator)).size() + " fail message element");
        Assert.assertEquals("The value have not to be more than 99.", driver.findElement(By.xpath(failMessageLocator)).getText());


        // clear the days checkbox input element
        driver.findElement(By.xpath(repeatEveryInputLocator)).clear();
        // send a valid value  ( which is 50 ) to the days checkbox
        driver.findElement(By.xpath(repeatEveryInputLocator)).sendKeys("50");

        //System.out.println(driver.findElement(By.className(failMessageLocator)).getText());

        Assert.assertTrue(driver.findElements(By.xpath(failMessageLocator)).size() == 0);
    }


    @Test(priority = 7)
    public void DailyRepeatTest4() {

        int waitTime = 1;

        // All steps from logging in to create calendar event button as used in all other methods
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


        // find the repeat checkbox element
        WebElement repeatCheckBoxElement = driver.findElement(By.xpath(repeatCheckBoxLocator));
        // scroll down until you see the repeat check box element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", repeatCheckBoxElement);
        // click the repeat checkbox element
        repeatCheckBoxElement.click();


        for (int i = 0; i < 30; i++) {
            // clear the days checkbox input element
            driver.findElement(By.xpath(repeatEveryInputLocator)).clear();
            // send a random value  to the days checkbox
            Random rand = new Random();
            int randomValue = rand.nextInt(99) + 1;
            String randomValueStr = String.valueOf(randomValue);
            driver.findElement(By.xpath(repeatEveryInputLocator)).sendKeys(randomValueStr, Keys.ENTER);

            if (randomValueStr.equals("1")) {
                Assert.assertEquals("Daily every 1 day", driver.findElement(By.cssSelector(summaryLocator)).getText());
            } else {
                Assert.assertEquals("Daily every " + randomValueStr + " days", driver.findElement(By.cssSelector(summaryLocator)).getText());
            }

        } //   for (int i=0; i>10;i++) {

    }  // public void DailyRepeatTest4() {

    @Test(priority = 8)
    public void DailyRepeatTest5() {

        int waitTime = 1;

        // All steps from logging in to create calendar event button as used in all other methods
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


        // find the repeat checkbox element
        WebElement repeatCheckBoxElement = driver.findElement(By.xpath(repeatCheckBoxLocator));
        // scroll down until you see the repeat check box element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", repeatCheckBoxElement);
        // click the repeat checkbox element
        repeatCheckBoxElement.click();


        for (int i = 0; i < 3; i++) {

            // clear the days checkbox input element
            driver.findElement(By.xpath(repeatEveryInputLocator)).clear();
            // send a value less than 1 ( which is 0 ) to the days checkbox
            //driver.findElement(By.xpath(repeatEveryInputLocator)).sendKeys("");

            System.out.println(driver.findElement(By.xpath(failMessageLocator)).getText());
            Assert.assertEquals("This value should not be blank.", driver.findElement(By.xpath(failMessageLocator)).getText());

            Random rand = new Random();
            int randomValue = rand.nextInt(99) + 1;
            String randomValueStr = String.valueOf(randomValue);
            // clear the days checkbox input element
            //driver.findElement(By.xpath(repeatEveryInputLocator)).clear();
            // send a valid value  ( which is 20 ) to the days checkbox
            driver.findElement(By.xpath(repeatEveryInputLocator)).sendKeys(randomValueStr);

            //System.out.println(driver.findElement(By.className(failMessageLocator)).getText());
            //Assert.assertFalse(driver.findElement(By.xpath(failMessageLocator)).isDisplayed());
            Assert.assertTrue(driver.findElements(By.xpath(failMessageLocator)).size() == 0);

        }


    } // public void DailyRepeatTest5() {

    @Test(priority = 9)
    public void DailyRepeatTest6() {

        int waitTime = 1;

        // All steps from logging in to create calendar event button as used in all other methods
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


        // find the repeat checkbox element
        WebElement repeatCheckBoxElement = driver.findElement(By.xpath(repeatCheckBoxLocator));
        // scroll down until you see the repeat check box element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", repeatCheckBoxElement);
        // click the repeat checkbox element
        repeatCheckBoxElement.click();


        // click the ends After radiobutton
        driver.findElement(By.xpath(endsAfterRadioLocator)).click();

        // clear the days checkbox input element
        driver.findElement(By.xpath(occurrenceInputLocator)).clear();
        // send a value less than 1 ( which is 0 ) to the days checkbox
        driver.findElement(By.xpath(occurrenceInputLocator)).sendKeys("0", Keys.ENTER);

        System.out.println(driver.findElement(By.xpath(failMessage2Locator)).getText());
        Assert.assertEquals("The value have not to be less than 1.", driver.findElement(By.xpath(failMessage2Locator)).getText());

        // clear the days checkbox input element
        driver.findElement(By.xpath(occurrenceInputLocator)).clear();
        // send a value more than ( which is 1000 ) to the days checkbox
        driver.findElement(By.xpath(occurrenceInputLocator)).sendKeys("1000", Keys.ENTER);

        System.out.println(driver.findElement(By.xpath(failMessage2Locator)).getText());
        Assert.assertEquals("The value have not to be more than 999.", driver.findElement(By.xpath(failMessage2Locator)).getText());


        // clear the days checkbox input element
        driver.findElement(By.xpath(occurrenceInputLocator)).clear();
        // send a valid value  ( which is 50 ) to the days checkbox
        driver.findElement(By.xpath(occurrenceInputLocator)).sendKeys("50", Keys.ENTER);

        //System.out.println(driver.findElement(By.className(failMessageLocator)).getText());
        System.out.println(driver.findElement(By.xpath(failMessage2Locator)).getText());
        Assert.assertFalse(driver.findElement(By.xpath(failMessage2Locator)).isDisplayed());
        //Assert.assertTrue(driver.findElements(By.xpath(failMessage2Locator)).size()==0);
    }


    @Test(priority = 10)
    public void DailyRepeatTest7() {

        int waitTime = 1;

        // All steps from logging in to create calendar event button as used in all other methods
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

        // find the repeat checkbox element
        WebElement repeatCheckBoxElement = driver.findElement(By.xpath(repeatCheckBoxLocator));
        // scroll down until you see the repeat check box element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", repeatCheckBoxElement);
        // click the repeat checkbox element
        repeatCheckBoxElement.click();


        for (int i = 0; i < 20; i++) {


            // clear the days checkbox input element
            driver.findElement(By.xpath(repeatEveryInputLocator)).clear();
            // send a random value  to the days checkbox
            Random rand = new Random();
            int randomValue = rand.nextInt(99) + 1;
            String randomValueStr = String.valueOf(randomValue);
            driver.findElement(By.xpath(repeatEveryInputLocator)).sendKeys(randomValueStr, Keys.ENTER);

            if (randomValueStr.equals("1")) {
                Assert.assertEquals("Daily every 1 day", driver.findElement(By.cssSelector(summaryLocator)).getText());
            } else {
                Assert.assertEquals("Daily every " + randomValueStr + " days", driver.findElement(By.cssSelector(summaryLocator)).getText());
            }


            // click the ends After radiobutton
            driver.findElement(By.xpath(endsAfterRadioLocator)).click();

            randomValue = rand.nextInt(999) + 1;
            String randomValueStr2 = String.valueOf(randomValue);
            // clear the days checkbox input element
            driver.findElement(By.xpath(occurrenceInputLocator)).clear();
            // send a value more than ( which is 1000 ) to the days checkbox
            driver.findElement(By.xpath(occurrenceInputLocator)).sendKeys(randomValueStr2, Keys.ENTER);


            if (randomValueStr.equals("1")) {
                if (randomValueStr2.equals("1")) {

                    //Assert.assertEquals("Daily every 1 day, end after 1 occurrence", driver.findElement(By.cssSelector(summaryLocator)).getText());
                    Assert.assertEquals("Daily every 1 day", driver.findElement(By.cssSelector(summaryLocator)).getText());
                    Assert.assertEquals(", end after 1 occurrence", driver.findElement(By.cssSelector(summary2Locator)).getText());
                    System.out.println(driver.findElement(By.cssSelector(summaryLocator)).getText() + driver.findElement(By.cssSelector(summary2Locator)).getText());
                } else {
                    //Assert.assertEquals("Daily every 1 day, end after " + randomValueStr2 + " occurrences", driver.findElement(By.cssSelector(summaryLocator)).getText());
                    Assert.assertEquals("Daily every 1 day", driver.findElement(By.cssSelector(summaryLocator)).getText());
                    Assert.assertEquals(", end after " + randomValueStr2 + " occurrences", driver.findElement(By.cssSelector(summary2Locator)).getText());
                    System.out.println(driver.findElement(By.cssSelector(summaryLocator)).getText() + driver.findElement(By.cssSelector(summary2Locator)).getText());
                }

            } else {
                if (randomValueStr2.equals("1")) {

                    //Assert.assertEquals("Daily every " + randomValueStr + " days, end after 1 occurrence", driver.findElement(By.cssSelector(summaryLocator)).getText());
                    Assert.assertEquals("Daily every " + randomValueStr + " days", driver.findElement(By.cssSelector(summaryLocator)).getText());
                    Assert.assertEquals(", end after 1 occurrence", driver.findElement(By.cssSelector(summary2Locator)).getText());
                    System.out.println(driver.findElement(By.cssSelector(summaryLocator)).getText() + driver.findElement(By.cssSelector(summary2Locator)).getText());
                } else {
                    //Assert.assertEquals("Daily every " + randomValueStr + " days, end after " + randomValueStr2 + " occurrences", driver.findElement(By.cssSelector(summaryLocator)).getText());
                    Assert.assertEquals("Daily every " + randomValueStr + " days", driver.findElement(By.cssSelector(summaryLocator)).getText());
                    Assert.assertEquals(", end after " + randomValueStr2 + " occurrences", driver.findElement(By.cssSelector(summary2Locator)).getText());
                    System.out.println(driver.findElement(By.cssSelector(summaryLocator)).getText() + driver.findElement(By.cssSelector(summary2Locator)).getText());
                }


            }


        } //  for


    }
}