package BrokenLink;  // Defines the package name

// Import classes needed for HTTP connection and URL handling
import java.net.HttpURLConnection;
import java.net.URL;

// Import utility classes
import java.time.Duration;
import java.util.List;

// Selenium imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

    // Main method – program execution starts here
    public static void main(String[] args) {

        // Create ChromeDriver object (launches Chrome browser)
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the local HTML file in the browser
        driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/index.html");

        // Find all <a> (anchor) tags on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Loop through each link
        for (WebElement link : links) {

            // Get the value of href attribute
            String url = link.getAttribute("href");

            // Check if href is missing or empty
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty or not configured");
                continue; // Skip this link and go to next one
            }

            try {
                // Convert String URL into URL object
                URL linkUrl = new URL(url);

                // Open HTTP connection
                HttpURLConnection connection =
                        (HttpURLConnection) linkUrl.openConnection();

                // Set connection timeout (3 seconds)
                connection.setConnectTimeout(3000);

                // Establish the connection
                connection.connect();

                // Get HTTP response code
                int responseCode = connection.getResponseCode();

                // Check if link is broken
                if (responseCode >= 400) {
                    System.out.println(url + " ---- Broken Link ("
                            + responseCode + ")");
                } else {
                    System.out.println(url + " ---- Valid Link ("
                            + responseCode + ")");
                }

            } catch (Exception e) {
                // Handle any exception (invalid URL, connection issues etc.)
                System.out.println(url + " ---- Exception Occurred");
            }
        }

        // Close the browser
        driver.quit();
    }
}