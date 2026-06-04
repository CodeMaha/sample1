package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Locators // called everytime so @findby is used so it is initiated just once
    //Instead of By.id, use @FindBy annotations.
   /* By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");*/
    // Locators (initialized once using @FindBy)

    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(css = "button[type='submit']")
    WebElement loginButton;
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
   /* public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }*/
    public void enterUsername(String user) {
        username.sendKeys(user);
    }
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }
    public void clickLogin() {
        loginButton.click();
    }

    // Business Method // testdata via parameter
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}
