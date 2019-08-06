package com.vytrack.tests.components.login_navigation;
import com.vytrack.utilities.SeleniumUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        System.out.println("#######Open Vytrack login page##### ");
    }

    @Test (priority = 0)
    public void loginTestPositive() {

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


        System.out.println("------2. Verify name of the store manager is displayed on top right--------- ");
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // Get the element that has the name of the store manager on the top right
        WebElement nameElement = driver.findElement(By.xpath(nameLocator));
        String expectedMessage = "Scot Ritchie";
        String storeManagerName = nameElement.getText().trim();
        //  Verify name of the store manager is displayed on top right
        Assert.assertEquals(expectedMessage,storeManagerName);


        System.out.println("------3. Verify Dashboard page is open--------- ");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Get the element that has the name of the page on the left
        WebElement pageNameElement = driver.findElement(By.className("oro-subtitle"));
        expectedMessage = "Dashboard";
        String actualMessage = pageNameElement.getText();
        //  Verify Dashboard page is open
        Assert.assertEquals(expectedMessage,actualMessage);



        System.out.println("------4. Log out--------- ");
        //Click name to open menu for logout
        nameElement.click();
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        WebElement logoutElement = driver.findElement(By.linkText("Logout"));
        //Click the logout
        logoutElement.click();

        System.out.println("------5. Login to Vytrack as a sales manager--------- ");
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        //find the Web element for the username inputbox
        usernameField = driver.findElement(By.xpath(usernameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("salesmanager279");
        // find the Web element for the password inputbox
        passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("UserUser123");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(loginButtonLocator)).submit();

        System.out.println("------6. Verify Dashboard page is open--------- ");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Get the element that has the name of the page on the left
        pageNameElement = driver.findElement(By.className("oro-subtitle"));
        expectedMessage = "Dashboard";
        actualMessage = pageNameElement.getText();
        //  Verify Dashboard page is open
        Assert.assertEquals(expectedMessage,actualMessage);




        System.out.println("------7. A different name should be displayed on top right--------- ");
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // Get the element that has the name of the sales manager on the top right
        nameElement = driver.findElement(By.xpath(nameLocator));
        String salesManagerName = nameElement.getText().trim();
        //  Verify name of the sales manager is different than previous store manager
        Assert.assertNotEquals(salesManagerName,storeManagerName);



        System.out.println("------8. Logout--------- ");
        //Click name to open menu for logout
        nameElement.click();
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        logoutElement = driver.findElement(By.linkText("Logout"));
        //Click the logout
        logoutElement.click();


        System.out.println("------9. Login to Vytrack as a driver--------- ");
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        //find the Web element for the username inputbox
        usernameField = driver.findElement(By.xpath(usernameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("user183");
        // find the Web element for the password inputbox
        passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("UserUser123");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(loginButtonLocator)).submit();



        System.out.println("------10. Verify Dashboard/Quick Launchpad page is open--------- ");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        // Get the element that has the name of the page on the left
        pageNameElement = driver.findElement(By.className("oro-subtitle"));
        expectedMessage = "Quick Launchpad";
        actualMessage = pageNameElement.getText();
        //  Verify Dashboard page is open
        Assert.assertEquals(expectedMessage,actualMessage);


        System.out.println("------11. A different name should be displayed on top right--------- ");
        // wait for 2 seconds for the page to load
        SeleniumUtilities.waitPlease(2);
        // Get the element that has the name of the sales manager on the top right
        nameElement = driver.findElement(By.xpath(nameLocator));
        String driverName = nameElement.getText().trim();
        //  Verify name of the sales manager is different than previous store manager
        Assert.assertNotEquals(driverName,storeManagerName);
        Assert.assertNotEquals(driverName,salesManagerName);

    }  //  public void loginTestPositive() {



    @Test (priority = 1)
    public void loginTestNegative() {

        // Specifying Locators,etc to be able to reuse at a later time

        String usernameLocator = "//input[@id='prependedInput']";
        String passwordLocator = "//input[@id='prependedInput2']";
        String loginButtonLocator = "//button[@id='_submit']";
        String alertMessageLocator = "//div/div[.='Invalid user name or password.']";

        System.out.println("------2. Enter valid username and invalid password information--------- ");
        String initialpageTitle = driver.getTitle();
        String initialpageUrl = driver.getCurrentUrl();
        // wait implicitly up to 10 seconds to make sure that the web elements load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //find the Web element for the username inputbox
        WebElement usernameField = driver.findElement(By.xpath(usernameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("storemanager216");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("useruser13");

        System.out.println("------3. Click login--------- ");
        // wait for 2 seconds
        SeleniumUtilities.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(loginButtonLocator)).submit();


        System.out.println("------4. Message Invalid user name or password should be displayed--------- ");
        //find the Web element for alert Message for invalid user name or password
        WebElement alertElement = driver.findElement(By.xpath(alertMessageLocator));
        // assign the alert message to a String called alertText
        String alertText = alertElement.getText();
        String expectedMessage = "Invalid user name or password.";
        //  Verify alert Message is displayed
        alertElement.isDisplayed();
        //  Verify alert Message is equal to invalid user name or password
        Assert.assertEquals(expectedMessage,alertText);


        System.out.println("------5. Page title and url should be same--------- ");
        String pageTitle = driver.getTitle();
        String pageUrl = driver.getCurrentUrl();

        //  Verify page Title is the same
        Assert.assertEquals(pageTitle,initialpageTitle);
        //  Verify Url is the same
        Assert.assertEquals(pageUrl,initialpageUrl);

    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}