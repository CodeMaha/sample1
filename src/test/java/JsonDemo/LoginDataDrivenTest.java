package JsonDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.JsonUtil;

public class LoginDataDrivenTest extends BaseTest {

    // Data Provider using JSON
    @DataProvider(name = "loginData")
    public Object[][] loginTestData() {
       /* return JsonUtil.getLoginData(
                "src/test/resources/testdata/loginData.json"*/
        return JsonUtil.getLoginData("testdata/login"
        );
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expected) {

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.radius")).click();

        if (expected.equals("success")) {
            String successMsg =
                    driver.findElement(By.id("flash")).getText();
            Assert.assertTrue(successMsg.contains("You logged into"));
        } else {
            String errorMsg =
                    driver.findElement(By.id("flash")).getText();
            Assert.assertTrue(errorMsg.contains("Your username is invalid")
                    || errorMsg.contains("Your password is invalid"));
        }
    }
}

