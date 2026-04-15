package DatePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerExample {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            // Launch browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Open GlobalSQA DatePicker page
            driver.get("https://www.globalsqa.com/demo-site/datepicker/");

            // Switch to iframe (Simple DatePicker is inside iframe)
            WebElement frame =
                    driver.findElement(By.cssSelector("iframe.demo-frame"));
            driver.switchTo().frame(frame);

            // Click date input to open calendar
            WebElement dateInput =
                    driver.findElement(By.id("datepicker"));
            dateInput.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
// pass as string
            String targetMonth = "April";
            String targetYear = "2026";
            String targetDay = "15";

            //  Navigate to required month and year itetrate until condition is true
            while (true) {
                String month =
                        driver.findElement(By.className("ui-datepicker-month")).getText();
                String year =
                        driver.findElement(By.className("ui-datepicker-year")).getText();

                if (month.equals(targetMonth) && year.equals(targetYear)) {
                    break;
                }

                // Use JS click for Next button (important)
                WebElement nextBtn =
                        driver.findElement(By.xpath("//a[@title='Next']"));
                js.executeScript("arguments[0].click();", nextBtn);
            }

            // Select day
            driver.findElement(
                    By.xpath("//a[text()='" + targetDay + "']")
            ).click();

            //  Print selected date
            String selectedDate =
                    dateInput.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}