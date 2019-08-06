package com.vytrack.tests.smoke_tests;
import com.vytrack.utilities.SeleniumUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();//set up here
        driver = new ChromeDriver();//define which webdrirever should be used
        driver.get("http://qa2.vytrack.com/user/login");

    }

    @Test(priority = 1)
    public void test1() {


            WebElement usernameField = driver.findElement(By.xpath("//input[@id='prependedInput']"));//burda user name yolluyrz
            usernameField.sendKeys("user183");
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
            passwordField.sendKeys("UserUser123");
            driver.findElement(By.xpath("//button[@id='_submit']")).submit();//burda username ve password u submit ediyrz
            SeleniumUtilities.waitPlease(3);
            WebElement dropDown =driver.findElement(By.xpath("//span[@class='title title-level-1']"));//burda fleet e gidyrz
            dropDown.click();
            SeleniumUtilities.waitPlease(3);
            driver.findElement(By.xpath("//span[@class='title title-level-2']")).click();//Vehicle open
        SeleniumUtilities.waitPlease(1);
        // Check if the title of the page is equal to "Car - Entities - System - Car - Entities - System" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("Car - Entities - System - Car - Entities - System"));
            SeleniumUtilities.waitPlease(2);
            WebElement CarsElement = driver.findElement(By.className("oro-subtitle"));//Page name is Cars.
            Assert.assertTrue(CarsElement.getText().equals("Cars"));//burda cars'in text ini  alaip onlari compare ediyrsn .
        SeleniumUtilities.waitPlease(1);

        WebElement Customers = driver.findElement(By.partialLinkText("Customers"));//find the customers and click on it
        Customers.click();
            SeleniumUtilities.waitPlease(3);
            WebElement AccountsElement= driver.findElement(By.partialLinkText("Accounts"));
            AccountsElement.click();
        SeleniumUtilities.waitPlease(3);
        Assert.assertTrue(driver.getTitle().equals("Accounts - Customers"));//verify the title
        SeleniumUtilities.waitPlease(1);
        // Check if the title of the page is equal to "Accounts - Customers" to verify that this is the correct page
        WebElement Accounts = driver.findElement(By.className("oro-subtitle"));
        Assert.assertTrue(Accounts.getText().equals("Accounts"));
        SeleniumUtilities.waitPlease(2);
        WebElement Customers1 = driver.findElement(By.partialLinkText("Customers"));//contacs checking
        Customers1.click();
        SeleniumUtilities.waitPlease(3);
        WebElement CustomerContacts=driver.findElement(By.partialLinkText("Contacts"));//customers after contacts find
        CustomerContacts.click();
        SeleniumUtilities.waitPlease(1);
        Assert.assertTrue(driver.getTitle().equals("Contacts - Customers"));
        SeleniumUtilities.waitPlease(3);
        WebElement Customer = driver.findElement(By.className("oro-subtitle"));
        Assert.assertTrue(Customer.getText().equals("Contacts"));
        SeleniumUtilities.waitPlease(2);
         WebElement Activities=driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));//activities is calling
         Activities.click();
        SeleniumUtilities.waitPlease(3);
         WebElement CalendarEvents=driver.findElement(By.partialLinkText("Calendar Events"));
         CalendarEvents.click();
        SeleniumUtilities.waitPlease(1);
        Assert.assertTrue(driver.getTitle().equals("Calendar Events - Activities"));//title is checki ng
        SeleniumUtilities.waitPlease(1);
        WebElement Calendar = driver.findElement(By.className("oro-subtitle"));
        Assert.assertTrue(Calendar.getText().equals("Calendar Events"));



    }

    @Test(priority=2)
    public void test2(){

        //The locators That can be used:
        String usernameLocator = "//input[@id='prependedInput']";
        String passwordLocator = "//input[@id='prependedInput2']";
        String loginButtonLocator = "//button[@id='_submit']";
        String fleetButtonLocator = "//div[contains(@id,'main-menu')]/ul/li[2]/a/span";


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//at the beginning put it

        //find the Web element for the username inputbox
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameField.sendKeys("storemanager216");////Put value into the username inputbox
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordField.sendKeys("UserUser123");//send password
        driver.findElement(By.xpath("//button[@id='_submit']")).submit();//after sending password to find the submit button and click it.
        SeleniumUtilities.waitPlease(3);//wait 3 sec
        WebElement DashboardElement = driver.findElement(By.className("oro-subtitle"));
        // Check if the text of the page name Dashboard is equal to "Dashboard" to verify that this is the correct page
        Assert.assertTrue(DashboardElement.getText().equals("Dashboard"));
        // Check if the title of the page is equal to "Dashboard" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("Dashboard"));
        SeleniumUtilities.waitPlease(2);


          //wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        //find the Web element for Dropdown Menu which has the name Fleet
        WebElement dropDown =driver.findElement(By.xpath(fleetButtonLocator));
        // Click the Fleet dropdown menu to display the dropdown menu elements
        dropDown.click();
        //wait 2 seconds
        SeleniumUtilities.waitPlease(2);
        // find the Web element for Vehicles in the menu that was displayed after Fleet was clicked and click it
        driver.findElement(By.linkText("Vehicles")).click();
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the page name All Cars
        WebElement CarsElement = driver.findElement(By.className("oro-subtitle"));
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Check if the text of the page name All Cars is equal to "All Cars" to verify that this is the correct page
        Assert.assertTrue(CarsElement.getText().equals("All Cars"));
        // Check if the title of the page is equal to "All - Car - Entities - System - Car - Entities - System" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("All - Car - Entities - System - Car - Entities - System"));

        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        //find the Web element for Dropdown Menu which has the name Customers
        WebElement Customers = driver.findElement(By.partialLinkText("Customers"));
        // Click the Customers dropdown menu to display the dropdown menu elements
        Customers.click();
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web element Accounts in the drop down menu that was displayed after Customers was clicked
        WebElement Accounts = driver.findElement(By.partialLinkText("Accounts"));
        // Click the Accounts Element
        Accounts.click();
        //wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the page name Accounts
        WebElement AccountsElement = driver.findElement(By.className("oro-subtitle"));
        // Check if the text of the page name All Accounts is equal to "All Accounts" to verify that this is the correct page
        Assert.assertTrue(AccountsElement.getText().equals("All Accounts"));
        // Check if the title of the page is equal to "All - Accounts - Customers" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("All - Accounts - Customers"));


        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        //find the Web element for Dropdown Menu which has the name Customers
        Customers = driver.findElement(By.partialLinkText("Customers"));
        // Click the Customers dropdown menu to display the dropdown menu elements
        Customers.click();
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web element Contacts in the drop down menu that was displayed after Customers was clicked
        WebElement Contacts = driver.findElement(By.partialLinkText("Contacts"));
        // Click the Contacts Element
        Contacts.click();
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the page name Contacts
        WebElement ContactsElement = driver.findElement(By.className("oro-subtitle"));
        // Check if the text of the page name Contacts is equal to "Contacts" to verify that this is the correct page
        Assert.assertTrue(ContactsElement.getText().equals("All Contacts"));
        // Check if the title of the page is equal to "Contacts - Customers" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("All - Contacts - Customers"));




        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        //find the Web element for Dropdown Menu which has the name Sales
        WebElement Sales = driver.findElement(By.partialLinkText("Sales"));
        // Click the Sales dropdown menu to display the dropdown menu elements
        Sales.click();
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // find the Web element Calendar Events in the drop down menu that was displayed after Activities was clicked
        WebElement Opportunity = driver.findElement(By.partialLinkText("Opportunities"));
        // Click the Opportunity Element
        Opportunity.click();
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the page name Open Opportunities
        WebElement OpportunityElement = driver.findElement(By.className("oro-subtitle"));
        // Check if the text of the page name Calendar Events is equal to "Calendar Events" to verify that this is the correct page
        Assert.assertTrue(OpportunityElement.getText().equals("Open Opportunities"));
        // Check if the title of the page is equal to "Calendar Events - Activities" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("Open Opportunities - Opportunities - Sales"));

         SeleniumUtilities.waitPlease(2);
        //find the Web element for Dropdown Menu which has the name Activities
        WebElement Activities = driver.findElement(By.partialLinkText("Activities"));
        // Click the Activities dropdown menu to display the dropdown menu elements
        Activities.click();
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // find the Web element Calls in the drop down menu that was displayed after Activities was clicked
        WebElement Calls = driver.findElement(By.partialLinkText("Calls"));
        // Click the Calls Element
        Calls.click();
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the page name All Calls
        WebElement CallsElement = driver.findElement(By.className("oro-subtitle"));
        // Check if the text of the page name Calendar Events is equal to "Calendar Events" to verify that this is the correct page
        Assert.assertTrue(CallsElement.getText().equals("All Calls"));
        // Check if the title of the page is equal to "Calendar Events - Activities" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("All - Calls - Activities"));


        System.out.println("-------Successful!---------");


        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        //find the Web element for Dropdown Menu which has the name Activities
        Activities = driver.findElement(By.partialLinkText("Activities"));
        // Click the Activities dropdown menu to display the dropdown menu elements
        Activities.click();
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // find the Web element Calendar Events in the drop down menu that was displayed after Activities was clicked
        WebElement Calender = driver.findElement(By.partialLinkText("Calendar Events"));
        // Click the Calendar Element
        Calender.click();
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the page name Calendar Events
        WebElement CalenderElement = driver.findElement(By.className("oro-subtitle"));
        // Check if the text of the page name Calendar Events is equal to "Calendar Events" to verify that this is the correct page
        Assert.assertTrue(CalenderElement.getText().equals("All Calendar Events"));
        // Check if the title of the page is equal to "Calendar Events - Activities" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("All - Calendar Events - Activities"));


        System.out.println("########## Cool!****************");



    }

    @AfterMethod
    public void tearDown() {
        driver.close();//to close browser after test
    }
}



