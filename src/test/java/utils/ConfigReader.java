package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties propertyData = new Properties();

	static {
		try (FileInputStream fis = new FileInputStream("src/test/resources/configfiles/config.properties")) {
			propertyData.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to load config.properties");
		}
	}

	// Generic getter
	public static String get(String key) {
		return propertyData.getProperty(key);
	}

	// Specific helper methods (optional)
	public static String getBrowser() {
		return get("browser");
	}

	public static String getPageURL() {
		return get("applicationurl");
	}

	public static String getExcelFilePath() {
		return get("excelFilePath");
	}
}
