package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.DriverManager;

public class BaseTest {
	protected WebDriver driver; // Class level
	protected HomePage homePage; // Class level
	protected RegistrationPage registrationPage; // ✅ Add this line

	@BeforeMethod
	public void setUp() {
		DriverManager.createDriver(ConfigReader.getBrowser());
		driver = DriverManager.getDriver();
		driver.manage().window().maximize(); // Ensure window is full screen
		driver.get(ConfigReader.getPageURL()); // Automatically go to landing page
		homePage = new HomePage(driver); // Initialize HomePage once
		registrationPage = new RegistrationPage(driver); // ✅ Initialize here

	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver(); // Clean up
	}
}
