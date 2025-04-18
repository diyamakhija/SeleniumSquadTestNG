package base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.HomePage;
import pages.LoginpagePF;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.DriverManager;
import utils.ExcelDataProvider;
import utils.ExcelReader;

public class BaseTest {
	LoginpagePF loginpagePF;
	ExcelDataProvider excelDataProvider;
	protected WebDriver driver; // Class level
	protected HomePage homePage; // Class level
	protected RegistrationPage registrationPage; //  Add this line
	protected boolean shouldRunLoginMethod = false;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) {
		DriverManager.createDriver(browser);
		driver = DriverManager.getDriver();
		driver.manage().window().maximize(); // Ensure window is full screen
		driver.get(ConfigReader.getPageURL()); // Automatically go to landing page
		homePage = new HomePage(driver); // Initialize HomePage once
		registrationPage = new RegistrationPage(driver); //  Initialize here
	}

	@BeforeMethod(dependsOnMethods = "setUp")
	public void loginMethod() {
		if (shouldRunLoginMethod) {
			loginpagePF = new LoginpagePF(driver);
			loginpagePF.userCredentials();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverManager.quitDriver(); // Clean up
		
	}
	

}
