package Alert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotsDemo {

    public static void main(String[] args) throws IOException {
        // Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.w3schools.com/");

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

/*
        Return the screenshot as a File object
        OutputType.FILE   // returns File
        OutputType.BYTES  // returns byte[]
        OutputType.BASE64 // returns Base64 string
*/

        // Save screenshot
        File dest = new File("C:\\Screenshots\\homepage.png");
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot captured successfully!");
        driver.quit();
    }
}

