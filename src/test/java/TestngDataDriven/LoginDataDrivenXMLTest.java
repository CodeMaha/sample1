package TestngDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginDataDrivenXMLTest {

    WebDriver driver;

    // Browser setup – runs once before all tests
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // Test method receives parameters from testng.xml
    @Test
    @Parameters({"username", "password", "expectedResult"})
    public void verifyLogin(String username,
                            String password,
                            String expectedResult) {

        // Enter username
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        // Enter password
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        // Click Login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Capture result message
        String pageText = driver.findElement(By.id("flash")).getText();

        // Validation logic
        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(
                    pageText.contains("You logged into a secure area!"),
                    "Login success message not displayed"
            );
        } else {
            Assert.assertTrue(
                    pageText.contains("Your username is invalid!")
                            || pageText.contains("Your password is invalid!"),
                    "Login failure message not displayed"
            );
        }
    }

    // Close browser after all tests
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
