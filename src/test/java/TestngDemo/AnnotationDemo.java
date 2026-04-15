package TestngDemo;
import org.testng.annotations.*;
public class AnnotationDemo {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @Test
    public void testCase1() {
        System.out.println("Test Case 1");
    }
    @Test
    public void testCase2() {
        System.out.println("Test Case 2");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
}

// BM test1 AF //BM test2 AM