package TestNgAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
// after title validation failure , further execution is truncated
public class GoogleHardAssertionTest {
    WebDriver driver = null;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    @Test
    public void verifyGoogleHomePage() {
        // Verify Page Title
        System.out.println("Title valiadtion");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google123";
        Assert.assertEquals(actualTitle, expectedTitle,
                "Page title does not match!");
        //  Verify Google Logo is displayed //fail exception
        System.out.println("Logo valiadtion");
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));
        Assert.assertTrue(logo.isDisplayed(),
                "Google logo is not displayed!");
        //  Verify Search box is enabled
        System.out.println("Box valiadtion");
        WebElement searchBox = driver.findElement(By.name("q"));
        Assert.assertTrue(searchBox.isEnabled(),
                "Search box is not enabled!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
