package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorDemo {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            //  Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/Index.html");
            driver.manage().window().maximize();
            Thread.sleep(1000);

        // Locate Username using ID
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin");
            Thread.sleep(1000);
        //  Relative Locator: Password BELOW Username
        WebElement password = driver.findElement(
                RelativeLocator.with(By.tagName("input"))
                        .below(username)
                       // .above(radioval)
        );
        password.sendKeys("12345");
            Thread.sleep(1000);
        //  Relative Locator: Login button BELOW password
        WebElement loginButton = driver.findElement(
                RelativeLocator.with(By.tagName("button"))
                        .below(password)
                               // .above(clickbutton)

        );
        loginButton.click();
        Thread.sleep(1000);} catch (Exception e) {
        System.out.println("Unexpected error occurred: " + e.getMessage());
    }  finally {
        // Always close browser
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
}
