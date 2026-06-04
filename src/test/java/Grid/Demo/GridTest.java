package Grid.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class GridTest {

    @Test
    @Parameters("browser")
    public void runTestOnGrid(String browser) throws Exception {

        WebDriver driver = null;

        //  Print which test started (important)
        System.out.println("STARTED -> " + Thread.currentThread().getId() + " -> " + browser);

        // Select browser
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444"),
                    new ChromeOptions()
            );

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444"),
                    new FirefoxOptions()
            );

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444"),
                    new EdgeOptions()
            );
        }

        // Open site
        driver.get("https://www.google.com");

        // Wait so we can SEE parallel execution
        Thread.sleep(8000);

        // Print completion
        System.out.println("FINISHED -> " + Thread.currentThread().getId() + " -> " + browser);

        driver.quit();
    }
}
