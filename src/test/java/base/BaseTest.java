package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginpagePF;

import pages.RegistrationPage;
import utils.ConfigReader;
import utils.DriverManager;
import utils.ExcelReader;

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
	public void loginWithValidCredentials() {
		// Load data from Excel
		Map<String, List<Map<String, String>>> data =
				ExcelReader.getData("./src/test/resources/testData/excelData.xlsx");
		List<Map<String, String>> credentialsList = data.get("userCredentials");

		// Find the row with a successful login message
		Map<String, String> validLogin = credentialsList.stream()
				.filter(row -> row.get("expectedmessage").equalsIgnoreCase("You are logged in"))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No valid login found in Excel"));

		String username = validLogin.get("username").trim();
		String password = validLogin.get("password").trim();

		// Perform login
		LoginpagePF loginPF = new LoginpagePF(driver);
		loginPF.clickGetStarted();
		loginPF.clickSignIn();
		loginPF.enterUsername(username);
		loginPF.enterPassword(password);
		loginPF.submitLogin();
	}
}
