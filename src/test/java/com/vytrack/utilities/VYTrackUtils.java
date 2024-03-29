package com.vytrack.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VYTrackUtils {
    //we don't want to access these variables outside
    private static String usernamelocator = "prependedInput";
    private static String passwordLocator = "prependedInput2";
    private static String loaderMaskLocator = "div[class='loader-mask shown']";


    /**
     * Login into vytrack application
     *
     * @param driver
     * @param username
     * @param password
     */
    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.id(usernamelocator)).sendKeys(username);
        //Keys.ENTER means click enter after entering password
        //in this way, we don't need to click login button
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtilities.waitPlease(4);
    }

    public static void navigateToModule(WebDriver driver, String tab, String module) {
        String tabLocator = "//span[contains(text(),'" + tab + "') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'" + module + "') and contains(@class, 'title title-level-2')]";
        //waitUntilLoaderScreenDisappear(driver);
        SeleniumUtilities.clickWithWait(driver, By.xpath(tabLocator), 5);
        SeleniumUtilities.waitPlease(4);
        driver.findElement(By.xpath(moduleLocator)).click();
        SeleniumUtilities.waitPlease(4);

    }

    public static void waitUntilLoaderScreenDisappear(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(loaderMaskLocator))));
        }catch (Exception e){
            System.out.println(e+" :: Loader mask doesn't present.");
        }
    }
}
