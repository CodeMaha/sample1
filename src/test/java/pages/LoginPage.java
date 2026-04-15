package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    WebDriver driver;
    // Locators // called everytime so @findby is used so it is initiated just once
    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // Actions
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    // Business Method // testdata via parameter
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}
