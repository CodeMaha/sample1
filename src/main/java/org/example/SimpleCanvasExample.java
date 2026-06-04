package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SimpleCanvasExample {

    public static void main(String[] args) throws InterruptedException {

        // Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open canvas page
        driver.get("https://www.w3schools.com/graphics/canvas_coordinates.asp");

        // Switch to iframe (IMPORTANT)
        driver.switchTo().frame("iframeResult");

        // Locate canvas element
        WebElement canvas = driver.findElement(By.id("myCanvas"));

        // Perform click inside canvas at (x=100, y=50)
        Actions action = new Actions(driver);
        action.moveToElement(canvas, 100, 50).click().perform();

        System.out.println("Clicked inside canvas!");

        Thread.sleep(3000);
        driver.quit();
    }
}