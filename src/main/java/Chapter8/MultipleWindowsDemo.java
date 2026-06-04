package Chapter8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;


public class MultipleWindowsDemo {
    public static void main(String[] args) throws InterruptedException {
// iteration - prt--> <list>ID --> wind1--> operation --> closewind--> wind2 --> opr-->close->wind3-->opr-->
        WebDriver driver = null;
        // Declare WebDriver reference
        // Initialized later so it can be used in finally block for cleanup

        try {
             // 1. Launch Chrome browser
            driver = new ChromeDriver();
            // Creates a ChromeDriver object and opens Chrome browser

            driver.manage().window().maximize();
            // Maximizes browser window for better visibility

            // 2. Open application
            driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/windows.html");
            // Navigates to the given URL

            Thread.sleep(2000);
            // Pauses execution for 2 seconds (demo purpose)

            // 3. Store Parent Window Handle
            String parentWindow = driver.getWindowHandle();
            // Captures the unique ID of the currently active (parent) window

            System.out.println("Parent Window ID: " + parentWindow);
            // Prints the parent window handle to the console

            // 4. Open multiple windows/tabs
            driver.findElement(By.xpath("//button[normalize-space()='Open New Window']")).click();
            // Locates and clicks the "Open New Window" button

            Thread.sleep(1000);
            // Small wait to allow new window/tab to open

            driver.findElement(By.xpath("//button[normalize-space()='Open New Tab']")).click();
            // Locates and clicks the "Open New Tab" button

            Thread.sleep(2000);
            // Wait to ensure both new windows/tabs are opened

            // 5. Get all window handles
            Set<String> allWindows = driver.getWindowHandles();
            // Retrieves IDs of all open windows/tabs

            System.out.println("Total Windows Opened: " + allWindows.size());
            // Prints number of open windows/tabs

            // 6. Iterate through all windows
            for (String windowHandle : allWindows) {
                // Loops through each window handle

                if (!windowHandle.equals(parentWindow)) {
                    // Checks if the window is NOT the parent window
                    // Ensures we switch only to child windows

                    driver.switchTo().window(windowHandle);
                    // Switches Selenium control to the child window/tab

                    System.out.println("Switched to window: " + windowHandle);
                    // Confirms successful switch

                    System.out.println("Title: " + driver.getTitle());
                    // Prints title of the current child window

                    Thread.sleep(2000);
                    // Pause for observation
// how to perforn seperate actions based on the page - use the id in if condition .. else if next unique id ---> perform the page action (testing condition )
                    driver.close();
                    // Closes the currently active child window only
                }
            }

            // 7. Switch back to parent window
            driver.switchTo().window(parentWindow);
            // Returns Selenium control back to the parent window

            System.out.println("Back to Parent Window");
            // Confirmation message

            System.out.println("Parent Title: " + driver.getTitle());
            // Prints the title of the parent window

            Thread.sleep(2000);
            // Final pause before ending test

        } finally {
            // finally block always executes (even if exception occurs)

            if (driver != null) {
                // Checks if the browser session exists

                driver.quit();
                // Closes all browser windows and ends WebDriver session
            }
        }
    }
}
