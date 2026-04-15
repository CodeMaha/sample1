package TestngDependson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DependsOnMethodsDemo {

    WebDriver driver;
    WebDriverWait wait;

    // Launch Site
    @Test
    public void launchSite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(
                driver.findElement(By.linkText("Form Authentication")).isDisplayed(),
                "Home page not loaded"
        );
    }

    //  Open Login Page
    @Test(dependsOnMethods = "launchSite")
    public void openLoginPage() {
        driver.findElement(By.linkText("Form Authentication")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        Assert.assertTrue(
                driver.findElement(By.id("username")).isDisplayed(),
                "Login page not opened"
        );
    }

    //  Login Test
    @Test(dependsOnMethods = "openLoginPage")
    public void loginTest() {
        driver.findElement(By.id("username"))
                .sendKeys("tomsmith");
        driver.findElement(By.id("password"))
                .sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // WAIT for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        Assert.assertTrue(
                driver.findElement(By.id("flash"))
                        .getText()
                        .contains("You logged into a secure area!"),
                "Login failed"
        );
    }

    // Logout Test
    @Test(dependsOnMethods = "loginTest")
    public void logoutTest() {
        driver.findElement(By.cssSelector("a[href='/logout']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        Assert.assertTrue(
                driver.findElement(By.id("flash"))
                        .getText()
                        .contains("You logged out"),
                "Logout failed"
        );
        driver.quit();
    }
}