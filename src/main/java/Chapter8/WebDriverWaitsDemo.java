package Chapter8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WebDriverWaitsDemo {

    public static void main(String[] args) {

       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Load local HTML file
        driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/wait.html");

        /*************** 1. IMPLICIT WAIT ****************/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement implicitElement = driver.findElement(By.id("implicit"));
        System.out.println("Implicit Wait Text: " + implicitElement.getText());

        /*************** 2. EXPLICIT WAIT ****************/
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement explicitElement = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("explicit"))
        );
        System.out.println("Explicit Wait Text: " + explicitElement.getText());

        /*************** 3. FLUENT WAIT ****************/
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)) //keeps rechecking each time (every 2 send)
                .ignoring(NoSuchElementException.class);

        WebElement fluentElement = fluentWait.until(driver1 ->
                driver1.findElement(By.id("fluent")));
        System.out.println("Fluent Wait Text: " + fluentElement.getText());

        driver.quit();
    }
}
