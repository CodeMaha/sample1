package org.example;

/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.ChromiumDriver;*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.time.Duration;


public class App
{
    public static void main(String[] args) {
      //  ChromeOptions options = new ChromeOptions();
        EdgeOptions options = new EdgeOptions();

        WebDriver driver = null;
        try {
           // driver = new ChromeDriver(options);
            driver = new EdgeDriver(options);
            // Open url
            //driver.get("https://www.google.com/");
            driver.get("https://www.opencart.com/");  // ind tekstac given url
            // Optional:
            driver.manage().window().maximize();
            Thread.sleep(5000);
            // Simple check
            System.out.println("Title: " + driver.getTitle());
            String act_title=driver.getTitle();

            String result = act_title.equals("Google")? "Title is Google": "Title is not Google";
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (driver != null) {
               driver.quit();
            }
        }
    }
}
