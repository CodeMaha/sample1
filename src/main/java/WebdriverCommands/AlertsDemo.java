package WebdriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


public class AlertsDemo {

    public static void main(String[] args) {

        WebDriver driver = null;   //  declare outside try

        try {
            // 1. Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2. Open index.html
            driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/index.html");
            // Find Element by ID


        // Click Login without entering data
        driver.findElement(By.id("loginBtn")).click();
Thread.sleep(1000);
        // Switch to Alert - native alert browser generated as no script/alert from pg
        Alert alert = driver.switchTo().alert();
            Thread.sleep(1000);
        // Read Alert message
        System.out.println("Alert text: " + alert.getText());
            Thread.sleep(1000);
        // Accept Alert
        alert.accept();
            Thread.sleep(1000);
        // Now enter valid data
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("loginBtn")).click();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // Always executed
            if (driver != null) {
                driver.quit();
            }
        }
    }
}



