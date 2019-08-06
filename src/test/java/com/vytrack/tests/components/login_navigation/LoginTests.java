package com.vytrack.tests.components.login_navigation;

import com.vytrack.tests.Pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase1;
import org.testng.annotations.Test;

public class LoginTests extends TestBase1 {
    LoginPage loginPage=new LoginPage();

    @Test
    public void login(){
        String userName= ConfigurationReader.getProperty("truckdriverusername");
        String password=ConfigurationReader.getProperty("truckdriverpassword");
        loginPage.login(userName, password);

    }


}
