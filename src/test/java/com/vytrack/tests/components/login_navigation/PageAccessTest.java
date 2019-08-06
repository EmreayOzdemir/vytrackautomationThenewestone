package com.vytrack.tests.components.login_navigation;

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

public class PageAccessTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        System.out.println("------ Open Vytrack login page for me--------- ");
    }

    @Test (priority = 0)
    public void storeManagerVehicleContractsTest() {

        // Specifying Locators,etc to be able to reuse at a later time

        String usernameLocator = "//input[@id='prependedInput']";
        String passwordLocator = "//input[@id='prependedInput2']";
        String loginButtonLocator = "//button[@id='_submit']";
        String nameLocator = "//li/a[@class='dropdown-toggle']";

        System.out.println("------1. Login to Vytrack as a store manager--------- ");
        // wait implicitly up to 10 seconds to make sure that the web elements load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //find the Web element for the username inputbox
        WebElement usernameField = driver.findElement(By.xpath(usernameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("storemanager216");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("UserUser123");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(loginButtonLocator)).submit();


        System.out.println("------2. Verify that you can access Vehicle contracts page--------- ");
        //wait for 3 seconds for the page to load
        SeleniumUtilities.waitPlease(3);
        //find the Web element for Dropdown Menu which has the name Fleet
        WebElement dropDown =driver.findElement(By.xpath("//li/a/span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        //wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Click the Fleet dropdown menu to display the dropdown menu elements
        dropDown.click();
        //wait 2 seconds
        SeleniumUtilities.waitPlease(2);
        // find the Web element for Vehicles Contracts in the menu that was displayed after Fleet was clicked and click it
        driver.findElement(By.xpath("//a/span[contains(text(),'Vehicle Contracts')]")).click();
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the page name All Vehicle Contract
        WebElement pageNameElement = driver.findElement(By.className("oro-subtitle"));
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Check if the text of the page name All Vehicle Contract is equal to "All Vehicle Contract" to verify that this is the correct page
        Assert.assertTrue(pageNameElement.getText().equals("All Vehicle Contract"));
        // Check if the title of the page is equal to "All - Vehicle Contract - Entities - System - Car - Entities - System" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("All - Vehicle Contract - Entities - System - Car - Entities - System"));
    }

    @Test (priority = 1)
    public void salesManagerVehicleContractsTest() {

        // Specifying Locators,etc to be able to reuse at a later time

        String usernameLocator = "//input[@id='prependedInput']";
        String passwordLocator = "//input[@id='prependedInput2']";
        String loginButtonLocator = "//button[@id='_submit']";
        String nameLocator = "//li/a[@class='dropdown-toggle']";
        //String fleetButtonLocator = "//div[contains(@id,'main-menu')]/ul/li[2]/a/span";
        // String fleetButtonLocator =

        System.out.println("------1. Login to Vytrack as a sales manager--------- ");
        // wait implicitly up to 10 seconds to make sure that the web elements load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //find the Web element for the username inputbox
        WebElement usernameField = driver.findElement(By.xpath(usernameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("salesmanager279");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("UserUser123");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(loginButtonLocator)).submit();


        System.out.println("------2. Verify that you can access Vehicle contracts page--------- ");
        //wait for 3 seconds for the page to load
        SeleniumUtilities.waitPlease(3);
        //find the Web element for Dropdown Menu which has the name Fleet
        WebElement dropDown =driver.findElement(By.xpath("//li/a/span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        //wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Click the Fleet dropdown menu to display the dropdown menu elements
        dropDown.click();
        //wait 2 seconds
        SeleniumUtilities.waitPlease(2);
        // find the Web element for Vehicles Contracts in the menu that was displayed after Fleet was clicked and click it
        driver.findElement(By.xpath("//a/span[contains(text(),'Vehicle Contracts')]")).click();
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the page name All Vehicle Contract
        WebElement pageNameElement = driver.findElement(By.className("oro-subtitle"));
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Check if the text of the page name All Vehicle Contract is equal to "All Vehicle Contract" to verify that this is the correct page
        Assert.assertTrue(pageNameElement.getText().equals("All Vehicle Contract"));
        // Check if the title of the page is equal to "All - Vehicle Contract - Entities - System - Car - Entities - System" to verify that this is the correct page
        Assert.assertTrue(driver.getTitle().equals("All - Vehicle Contract - Entities - System - Car - Entities - System"));
    }

    @Test (priority = 2)
    public void truckDriverVehicleContractsTest() {

        // Specifying Locators,etc to be able to reuse at a later time

        String usernameLocator = "//input[@id='prependedInput']";
        String passwordLocator = "//input[@id='prependedInput2']";
        String loginButtonLocator = "//button[@id='_submit']";
        String nameLocator = "//li/a[@class='dropdown-toggle']";

        System.out.println("------1. Login to Vytrack as a driver--------- ");
        // wait implicitly up to 10 seconds to make sure that the web elements load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //find the Web element for the username inputbox
        WebElement usernameField = driver.findElement(By.xpath(usernameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("user183");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("UserUser123");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(loginButtonLocator)).submit();


        System.out.println("------2. Verify that you cannot access Vehicle contracts page--------- ");
        System.out.println("------3. Message You do not have permission to perform this action should be displayed--------- ");
        //wait for 3 seconds for the page to load
        SeleniumUtilities.waitPlease(3);
        //find the Web element for Dropdown Menu which has the name Fleet
        WebElement dropDown =driver.findElement(By.xpath("//li/a/span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        //wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Click the Fleet dropdown menu to display the dropdown menu elements
        dropDown.click();
        //wait 2 seconds
        SeleniumUtilities.waitPlease(2);
        // find the Web element for Vehicles Contracts in the menu that was displayed after Fleet was clicked and click it
        driver.findElement(By.xpath("//a/span[contains(text(),'Vehicle Contracts')]")).click();


        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // find the Web Element for the alert message "You do not have permission to perform this action"
        WebElement alertElement = driver.findElement(By.xpath("//div[@class='message'][contains(text(),'permission')]"));
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Check if the alert message is equal to "You do not have permission to perform this action." to verify that this is the correct page
        Assert.assertTrue(alertElement.getText().equals("You do not have permission to perform this action."));

    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}