package Project;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            driver.get("https://www.flipkart.com/");
            driver.manage().window().maximize();

            //  Close login popup
            try {
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='✕']"))).click();
            } catch (TimeoutException ignored) {}

            //  Search
            WebElement search = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            search.sendKeys("Home appliances");
            search.submit();

            // Store main window
            String parentWindow = driver.getWindowHandle();

            // Click first product
            WebElement product = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//a[contains(@href,'/p/')])[1]")));
            product.click();

            //  Switch ONLY to new window
            Set<String> windows = driver.getWindowHandles();
            for (String w : windows) {
                if (!w.equals(parentWindow)) {
                    driver.switchTo().window(w);
                    break;
                }
            }

            //  Wait until page REALLY loads
            wait.until(driver1 ->
                    ((JavascriptExecutor) driver1)
                            .executeScript("return document.readyState")
                            .equals("complete"));

            //  Force scroll to bottom (important!)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            //  Small buffer for lazy loading
            Thread.sleep(2000);

            //  Robust Add to Cart locator
            WebElement addToCart = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[.//text()[contains(.,'Add') or contains(.,'ADD')]]")));

            //  Scroll + click using JS (Flipkart-safe)
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToCart);
            js.executeScript("arguments[0].click();", addToCart);

            System.out.println(" Added to cart successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit(); // keep open while debugging
        }
    }
}
