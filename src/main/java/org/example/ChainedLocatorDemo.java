package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChainedLocatorDemo {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            //  Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/Index.html");
            driver.manage().window().maximize();
        Thread.sleep(1000);
        //  Parent container
        WebElement container = driver.findElement(By.className("container"));

        //  Chained locator: Username inside container
        WebElement username = container.findElement(By.id("username"));
        username.sendKeys("User1");
        Thread.sleep(1000);
        //  Chained locator: Password inside container
        WebElement password = container.findElement(By.id("password"));
        password.sendKeys("password");
        Thread.sleep(1000);
        //  Chained locator: Accept Terms checkbox
        WebElement termsCheckbox = container.findElement(By.id("terms"));
        termsCheckbox.click();
        Thread.sleep(1000);
        //  Chained locator: City list → Coimbatore
        WebElement cityList = container.findElement(By.id("cityList"));
        WebElement coimbatore = cityList.findElement(By.xpath(".//li[text()='Coimbatore']"));
        coimbatore.click();
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
