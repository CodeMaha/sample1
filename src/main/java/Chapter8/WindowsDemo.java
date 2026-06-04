package Chapter8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

//https://the-internet.herokuapp.com/windows

public class WindowsDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;

        try {
            // 1. Launch Chrome Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2. Open the HTML file
            driver.get(
                    "file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/windows.html"
            );
            Thread.sleep(2000);
// id -- > unique --> ctrl passed
            // 3. Store Parent Window Handle
            String parentWindow = driver.getWindowHandle();
            System.out.println("Parent Window ID: " + parentWindow);

            // 4. Click on "Open New Window" button
            driver.findElement(
                    By.xpath("//button[normalize-space()='Open New Window']")
            ).click();

            // 5. Wait for new window/tab to open
            Thread.sleep(2000);

            // 6. Get all window handles
            Set<String> allWindows = driver.getWindowHandles();
// iteration - prt--> <list>ID --> wind1--> operation --> closewind--> wind2 --> opr-->close->wind3-->opr-->
            // 7. Switch to Child Window
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(parentWindow)) {

                    driver.switchTo().window(windowHandle);
                    System.out.println("Switched to child window/tab");

                    // Print Title of Child Window
                    System.out.println("Child Window Title: " + driver.getTitle());

                    Thread.sleep(2000);

                    // Close Child Window
                    driver.close();
                }
            }

            // 8. Switch back to Parent Window
            driver.switchTo().window(parentWindow);
            System.out.println("Returned to parent window");

            Thread.sleep(2000);

        } finally {
            // 9. Quit Browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}