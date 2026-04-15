package TestngDataDriven;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CalculatorTestNG {

    WebDriver driver;
    Workbook workbook;
    Sheet sheet;
    String excelPath;

    // ====== TEST SETUP ======
    @BeforeClass
    public void setUp() throws Exception {

        excelPath = "C:\\Users\\532252\\IdeaProjects\\sample1\\Resource\\TestData.xlsx";

        String htmlPath =
                "file:///C:/Users/532252/OneDrive%20-%20Cognizant/Desktop/QE%20Batch/selinium/RefSite/ApachePOI/Calc.html";

        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(htmlPath);

        // Load Excel
        FileInputStream fis = new FileInputStream(excelPath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        fis.close();
    }

    // ====== TEST CASE ======
    @Test
    public void calculatorDataDrivenTest() throws Exception {

        // Create styles
        CellStyle passStyle = workbook.createCellStyle();
        passStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        passStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle failStyle = workbook.createCellStyle();
        failStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        failStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Loop through Excel rows
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            double input1 = row.getCell(0).getNumericCellValue();
            double input2 = row.getCell(1).getNumericCellValue();
            String operation = row.getCell(2).getStringCellValue().toLowerCase();
            double expected = row.getCell(3).getNumericCellValue();

            // UI actions
            driver.findElement(By.id("num1")).clear();
            driver.findElement(By.id("num1"))
                    .sendKeys(String.valueOf(input1));

            driver.findElement(By.id("num2")).clear();
            driver.findElement(By.id("num2"))
                    .sendKeys(String.valueOf(input2));

            Select select =
                    new Select(driver.findElement(By.id("operation")));
            select.selectByValue(operation);

            driver.findElement(By.tagName("button")).click();

            // Get result from UI
            String resultText = driver.findElement(By.id("result"))
                    .getText()
                    .replace("Result:", "")
                    .trim();

            double actual = Double.parseDouble(resultText);

            // Write Actual value
            Cell actualCell = row.createCell(4);
            actualCell.setCellValue(actual);

            // Write Status
            Cell statusCell = row.createCell(5);
            if (actual == expected) {
                statusCell.setCellValue("PASS");
                statusCell.setCellStyle(passStyle);
            } else {
                statusCell.setCellValue("FAIL");
                statusCell.setCellStyle(failStyle);
            }
        }
    }

    // ====== TEST CLEANUP ======
    @AfterClass
    public void tearDown() throws Exception {

        // Save Excel
        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        // Close browser
        driver.quit();

        System.out.println("Test execution completed using TestNG.");
    }
}
