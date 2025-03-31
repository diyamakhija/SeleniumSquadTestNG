package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.LoginPF;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.DriverManager;

public class BaseTest {
	LoginPF loginPF;
	protected WebDriver driver; // Class level
	protected HomePage homePage; // Class level
	protected RegistrationPage registrationPage; // ✅ Add this line
	protected boolean shouldRunLoginMethod = false;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		System.out.println("setup 1");
		DriverManager.createDriver(ConfigReader.getBrowser());
		driver = DriverManager.getDriver();
		driver.manage().window().maximize(); // Ensure window is full screen
		driver.get(ConfigReader.getPageURL()); // Automatically go to landing page
		homePage = new HomePage(driver); // Initialize HomePage once
		registrationPage = new RegistrationPage(driver); // ✅ Initialize here
	}

	@BeforeMethod(dependsOnMethods = "setUp")
	public void loginMethod() {
		System.out.println("shouldRunLoginMethod 2" + shouldRunLoginMethod);
		if (shouldRunLoginMethod) {
			loginPF = new LoginPF();
			loginPF.getStartedBtn();
			loginPF.signInBtn();
			loginPF.userNameField();
			loginPF.passwordField();
			loginPF.logInBtn();
		}
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver(); // Clean up
	}
}
