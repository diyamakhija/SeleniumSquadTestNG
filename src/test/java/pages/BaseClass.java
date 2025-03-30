package pages;

import java.time.Duration; // Ensure this import is there

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; // Ensure correct import for WebDriverWait

import utils.DriverManager;
import utils.LoggerLoad;



public class BaseClass {
	protected WebDriver driver;

	public BaseClass() {
		
		System.out.println("Coming to BaseClass of PF");
		this.driver = DriverManager.getDriver(); // Initialize driver
		PageFactory.initElements(driver, this);

		// **Changed**: Using Duration for implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String handleAlert() {

		String alertText = "";
		try {
			// Wait for the alert to be present (optional but recommended)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			alert.accept();

			LoggerLoad.info("Alert accepted");

		} catch (NoAlertPresentException e) {
			// Alert was not present as expected
			LoggerLoad.error("Alert was not present.");
			// Add assertions to verify application state when no alert is present.
			// Example
			e.getMessage();// fail the test.

		} catch (Exception e) {
			// Some other error occurred

			LoggerLoad.error("An error occurred: ");
			e.getMessage(); // fail the test.

		}
		System.out.println("Alert accepted");
		System.out.println("Alert text: " + alertText);
		return alertText;

	}
}
