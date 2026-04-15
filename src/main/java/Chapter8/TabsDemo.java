package Chapter8;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class TabsDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;   //  declare outside try
        //System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        try {
            // 1. Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2. Open index.html
            driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/windows.html");
            Thread.sleep(2000);



            String parentWindow = driver.getWindowHandle();
            driver.findElement(By.xpath("//button[contains(text(),'Open New Tab')]")).click();
            // Get all window handles
            Set<String> allWindows = driver.getWindowHandles();

            for (String window : allWindows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    Thread.sleep(2000);
                    System.out.println("Switched to new tab for mousse and keyboard");

                    // Print page title
                    System.out.println("Child page title: " + driver.getTitle());

                    Thread.sleep(2000);
                    // Close child tab
                    driver.close();
                }
            }
            Thread.sleep(1000);

            System.out.println("Returned to parent window");
            Thread.sleep(2000);
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


