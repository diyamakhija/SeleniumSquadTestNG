package base;

import org.testng.annotations.BeforeMethod;

import utils.DriverManager;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
