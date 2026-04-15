package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CanvasHandlingDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;   //  declare outside try

        try {
            // 1. Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2. Open index.html
            driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/canvas.html");

            // 3. Locate the canvas element
            WebElement canvas = driver.findElement(By.id("myCanvas"));

            // 4. Create Actions class
            Actions actions = new Actions(driver);

            // -----------------------
            // CLICK ON RECTANGLE
            // Rectangle drawn at (20,20) width=100 height=60
            // So click inside it at offset (50, 40)
            // -----------------------
            actions.moveToElement(canvas, 50, 40)
                    .click()
                    .perform();

            System.out.println("Clicked inside Rectangle");

            Thread.sleep(2000);

            // -----------------------
            // CLICK ON CIRCLE
            // Circle center approx at (200,50)
            // -----------------------
            actions.moveToElement(canvas, 200, 50)
                    .click()
                    .perform();

            System.out.println("Clicked inside Circle");

            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
                e.printStackTrace();

            } finally {
                // Always executed
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }
