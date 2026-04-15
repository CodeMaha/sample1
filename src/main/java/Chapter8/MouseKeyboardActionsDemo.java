package Chapter8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;


import java.time.Duration;

public class MouseKeyboardActionsDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;   //  declare outside try

        try {
            // 1. Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2. Open index.html
            driver.get("file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/actions.html");


            // Actions class
        Actions actions = new Actions(driver); //init the action class

        WebElement hoverBox = driver.findElement(By.id("hoverBox")); // identify the element

        actions.moveToElement(hoverBox).perform(); // perform action using action & api method
        System.out.println("Mouse hovered over the element");

        Thread.sleep(1500);

        /*
         * =========================
         * 2. Keyboard Actions
         * =========================
         */
        WebElement keyboardInput = driver.findElement(By.id("keyboardInput"));

        actions.click(keyboardInput)
                .sendKeys("selenium actions demo")
                .keyDown(Keys.CONTROL)
                .sendKeys("a")      // Select all text
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE) // Delete text
                .sendKeys("Keyboard Actions Working")
                .perform();

        System.out.println("Keyboard actions performed");

        Thread.sleep(1500);

        /*
         * =========================
         * 3. Drag and Drop
         * =========================
         */
        WebElement source = driver.findElement(By.id("drag"));
        WebElement target = driver.findElement(By.id("drop"));

        actions.dragAndDrop(source, target).perform();

        System.out.println("Drag and drop completed");

        Thread.sleep(1500);

        /*
         * =========================
         * 4. Slider Movement
         * =========================
         */
        WebElement slider = driver.findElement(By.id("slider"));

        // Click and move slider to the right (positive X offset)
        actions.clickAndHold(slider)
                .moveByOffset(80, 0)
                .release()
                .perform();

        System.out.println("Slider moved");

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
