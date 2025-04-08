package utils;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void createDriver(String browser) {
	    WebDriver webDriver;
	    switch (browser.toLowerCase()) {
	    case "chrome":
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");  // 👈 Enables incognito mode
	        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	        options.setExperimentalOption("useAutomationExtension", false);
	        webDriver = new ChromeDriver(options);
	        break;
	        case "firefox":
	            webDriver = new FirefoxDriver();
	            break;
	        case "edge":
	            webDriver = new EdgeDriver();
	            break;
	        default:
	            throw new IllegalArgumentException("Unsupported browser: " + browser);
	    }
	    driver.set(webDriver);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		WebDriver webDriver = driver.get();
		if (webDriver != null) {
			webDriver.quit();    //  Closes all windows and ends session
			driver.remove();     //  Clean up thread-local memory
		}
	}
}
