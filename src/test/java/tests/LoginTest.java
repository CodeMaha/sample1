package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        // Valid credentials for the demo site
        loginPage.login("tomsmith", "SuperSecretPasswords!");
        System.out.println("Login test executed successfully");
    }
}
