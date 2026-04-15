package TestngDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginDataDrivenTest {
    WebDriver driver;
    // Browser setup
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }
    // Data Provider  //name used for calling // object
    @DataProvider(name = "loginData")
    public Object[][] loginTestData() {

        return new Object[][] {
                {"tomsmith", "SuperSecretPassword!", "success"},
                {"invalidUser", "secret123", "failure"},
                {"tomsmith", "wrongPass", "failure"}
        };
    }

    // Test Case using Data Provider
    @Test(dataProvider = "loginData")
    public void verifyLogin(String username,
                            String password,
                            String expectedResult) {
        // Enter username
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        // Enter password
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        // Click login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Verify result
        String pageText = driver.findElement(By.id("flash")).getText();
        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(pageText.contains("You logged into a secure area!"),
                    "Login success message not displayed");
        } else {
            Assert.assertTrue(pageText.contains("Your username is invalid!")
                            || pageText.contains("Your password is invalid!"),
                    "Login failure message not displayed");
        }
    }

    // Close browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


