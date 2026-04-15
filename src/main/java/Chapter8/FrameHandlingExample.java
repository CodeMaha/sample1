package Chapter8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandlingExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;   //  declare outside try

        try {
            // 1. Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2. Open index.html
            driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/frames.html");
            // Method 1: Switch to frame using index
           driver.switchTo().frame(0);
            Thread.sleep(2000);
            // Get text from inside the frame 0
            String frameText = driver.findElement(By.tagName("h2")).getText();
            System.out.println("Text inside frame: " + frameText);
                // exception can access only after getting back to main frame page
        /*    driver.switchTo().frame(1);
            Thread.sleep(2000);
            // Get text from inside the frame 0
            String frameText1 = driver.findElement(By.tagName("h2")).getText();
            System.out.println("Text inside frame: " + frameText1);*/
             //Switch back to Main Page
            driver.switchTo().defaultContent();
            // Get text from main page
            String mainPageText = driver.findElement(By.tagName("h2")).getText();
            System.out.println("Text on main page: " + mainPageText);
            Thread.sleep(2000);
// switch to second frame
            driver.switchTo().frame(1);
            Thread.sleep(2000);
            // Get text from inside the frame 0
            String frameText1 = driver.findElement(By.tagName("h2")).getText();
            System.out.println("Text inside frame: " + frameText1);
        }
        catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            // Always executed
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
