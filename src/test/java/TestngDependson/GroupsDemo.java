package TestngDependson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class GroupsDemo {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com");
    }

    // SMOKE: Verify home page is loaded
    @Test(groups = {"smoke"})
    public void verifyHomePageLoaded() {
        Assert.assertTrue(
                driver.findElement(By.linkText("Form Authentication")).isDisplayed(),
                "Home page not loaded properly"
        );
    }

    //  SANITY: Open login page and verify fields exist
    @Test(groups = {"sanity"})
    public void verifyLoginPageUI() {
        driver.findElement(By.linkText("Form Authentication")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed(), "Username field missing");
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed(), "Password field missing");
        Assert.assertTrue(driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed(), "Login button missing");

        // Go back to home for other tests
        driver.navigate().back();
    }

    // REGRESSION: Login and verify success message
    @Test(groups = {"regression"})
    public void loginTest() {
        driver.findElement(By.linkText("Form Authentication")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        String msg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"), "Login success message not found");
    }

    // REGRESSION: Logout and verify message
    @Test(groups = {"regression"})
    public void logoutTest() {
        driver.findElement(By.cssSelector("a[href='/logout']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        String msg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("You logged out"), "Logout message not found");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

