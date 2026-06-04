package Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // -------- Simple Alert --------
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println("Simple Alert Text: " + alert1.getText());
        alert1.accept(); // Click OK

        Thread.sleep(2000);

        // -------- Confirm Alert --------
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println("Confirm Alert Text: " + alert2.getText());
        alert2.dismiss(); // Click Cancel

        Thread.sleep(2000);

        // -------- Prompt Alert --------
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert3 = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println("Prompt Alert Text: " + alert3.getText());
        Thread.sleep(2000);
        alert3.sendKeys("Hello Selenium");
        Thread.sleep(2000);
        alert3.accept(); // Submit input

        Thread.sleep(2000);
        driver.quit();
    }
}

