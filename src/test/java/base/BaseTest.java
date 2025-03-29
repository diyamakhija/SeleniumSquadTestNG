package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import utils.ConfigReader;
import utils.DriverManager;

public class BaseTest {
    protected WebDriver driver; // Class level
    protected HomePage homePage; // Class level

    @BeforeMethod
    public void setUp() {
        DriverManager.createDriver(ConfigReader.getBrowser());
        driver = DriverManager.getDriver();
        driver.manage().window().maximize(); //  Ensure window is full screen
        driver.get(ConfigReader.getPageURL()); //  Automatically go to landing page
        homePage = new HomePage(driver); //  Initialize HomePage once
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver(); //  Clean up
    }
}
