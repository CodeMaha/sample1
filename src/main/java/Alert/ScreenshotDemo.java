package Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotDemo {

    public static void main(String[] args) throws IOException {

        // Set chromedriver path
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Open local HTML file
        driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/index.html");

        // screenshot BEFORE any action
        takeScreenshot(driver, "Before_Actions.png");

        Actions actions = new Actions(driver);

        /*************** Mouse Hover ****************/
        WebElement hoverBox = driver.findElement(By.id("hoverBox"));
        actions.moveToElement(hoverBox).perform();

        /*************** Keyboard Action ****************/
        WebElement input = driver.findElement(By.id("keyboardInput"));
        input.sendKeys("Selenium Screenshot Demo");

        /*************** Drag and Drop ****************/
        WebElement drag = driver.findElement(By.id("drag"));
        WebElement drop = driver.findElement(By.id("drop"));
        actions.dragAndDrop(drag, drop).perform();

        /*************** Slider ****************/
        WebElement slider = driver.findElement(By.id("slider"));
        actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();

        // Screenshot AFTER actions
        takeScreenshot(driver, "After_Actions.png");

        driver.quit();
    }

    // Utility method to take screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\532252\\InputOutputFiles" + fileName);
        FileHandler.copy(source, destination);
    }
}
