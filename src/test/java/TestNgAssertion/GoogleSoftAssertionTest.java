package TestNgAssertion;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
// after title validation , conti with logo &search box validation , exception details at end
public class GoogleSoftAssertionTest {
    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        softAssert = new SoftAssert();
    }
    @Test
    public void verifyGoogleHomePage() {
        // Title validation - fails
        System.out.println("Title validation");
        softAssert.assertEquals(driver.getTitle(),
                "Google123", "Title mismatch");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Logo validation (safe) - execution continues //Logo validation failed due to exception
        try {
            System.out.println("Logo validation");
            WebElement logo = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("img[alt='Google']")
                    )
            );
            softAssert.assertTrue(logo.isDisplayed(),
                    "Google logo not displayed");
        } catch (Exception e) {
            softAssert.fail("Logo validation failed due to exception");
        }
        // Search box validation (safe) - execution continues
        try {
            System.out.println("Box validation");
            WebElement searchBox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.name("q")
                    )
            );
            softAssert.assertTrue(searchBox.isEnabled(),
                    "Search box not enabled");
        } catch (Exception e) {
            softAssert.fail("Search box validation failed due to exception");
        }
        // Report all failures
        System.out.println("assertAll called");
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
