package NoGrid.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LocalTest {

    @Test
    @Parameters("browser")
    public void runTestWithoutGrid(String browser) throws Exception {

        WebDriver driver = null;

        //  Step 1: Print start info
        System.out.println("STARTED -> " + Thread.currentThread().getId() + " -> " + browser);

        // Step 2: Launch browser locally (NO GRID)
        if (browser.equalsIgnoreCase("chrome")) {

            // Launch Chrome browser on local machine
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            // Launch Firefox browser on local machine
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            // Launch Edge browser on local machine
            driver = new EdgeDriver();
        }

        //  Step 3: Open website
        driver.get("https://www.google.com");

        // Step 4: Wait to observe execution
        Thread.sleep(8000);

        //  Step 5: Print completion
        System.out.println("FINISHED -> " + Thread.currentThread().getId() + " -> " + browser);

        // Step 6: Close browser
        driver.quit();
    }
}
