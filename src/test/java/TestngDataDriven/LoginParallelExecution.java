package TestngDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginParallelExecution {

    // ThreadLocal ensures each parallel test gets its own WebDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Create a new WebDriver instance per test
    @BeforeMethod
    public void setUp() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://the-internet.herokuapp.com/login");
        driver.set(webDriver);
    }

    // Access WebDriver safely
    public WebDriver getDriver() {
        return driver.get();
    }
    

    // Test method receives data from testng.xml
    @Test
    @Parameters({"username", "password", "expectedResult"})
    public void verifyLogin(String username,
                            String password,
                            String expectedResult) {

        // Enter username
        getDriver().findElement(By.id("username")).clear();
        getDriver().findElement(By.id("username")).sendKeys(username);

        // Enter password
        getDriver().findElement(By.id("password")).clear();
        getDriver().findElement(By.id("password")).sendKeys(password);

        // Click login
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();

        // Validate result
        String pageText = getDriver().findElement(By.id("flash")).getText();

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

    // Close browser after each test
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}
