package utils;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import pages.LoginpagePF;

public class ExcelDataProvider {

	public static Object[][] getLoginDataForRow(String sheetName, int rowNum) {

		String filePath = ConfigReader.getExcelFilePath(); // Update with actual path
		List<Map<String, String>> data = ExcelReader.getData(filePath).get(sheetName);

		// Ensure row number is valid
		if (rowNum < 0 || rowNum >= data.size()) {
			throw new IllegalArgumentException("Invalid row number: " + rowNum);
		}

		Object[][] dataArray = new Object[1][data.get(rowNum).size()];
		int i = 0;
		for (Map.Entry<String, String> entry : data.get(rowNum).entrySet()) {
			dataArray[0][i] = entry.getValue();
			i++;
		}
		return dataArray;
	}

	@DataProvider(name = "invalidPythonCodeData")
	public Object[][] invalidPythonCode() {
		Map<String, List<Map<String, String>>> data = ExcelReader.getData(ConfigReader.getExcelFilePath());
		List<Map<String, String>> sheet = data.get("pythonCode");

//		Object[][] providerData = new Object[3][2];
//		providerData[0][0] = sheet.get(0).get("pCode");
//		providerData[0][1] = sheet.get(0).get("Result");
//		providerData[1][0] = sheet.get(1).get("pCode");
//		providerData[1][1] = sheet.get(1).get("Result");
//		providerData[2][0] = sheet.get(2).get("pCode");
//		providerData[2][1] = sheet.get(2).get("Result");
		return new Object[][] {
				// starting from index 1 since index 0 is valid usecase
				{ sheet.get(1).get("pCode"), sheet.get(1).get("Result") },
				{ sheet.get(2).get("pCode"), sheet.get(2).get("Result") },
				{ sheet.get(3).get("pCode"), sheet.get(3).get("Result") },};
	}

	@DataProvider(name = "validPythonCodeData")
	public Object[][] validPythonCode() {
		Map<String, List<Map<String, String>>> data = ExcelReader.getData(ConfigReader.getExcelFilePath());
		List<Map<String, String>> sheet = data.get("pythonCode");

		return new Object[][] {
				// starting from index 1 since index 0 is valid usecase
				{ sheet.get(0).get("pCode"), sheet.get(0).get("Result") },

		};
	}

	public static Object[][] fetchLoginData(int rowNum) {
		return getLoginDataForRow("userCredentials", rowNum);

	}
//	public void loginWithValidCredentials() {
//		// Load data from Excel
//		Map<String, List<Map<String, String>>> data =
//				ExcelReader.getData(ConfigReader.getExcelFilePath());
//		List<Map<String, String>> credentialsList = data.get("userCredentials");
//
//		// Find the row with a successful login message
//		Map<String, String> validLogin = credentialsList.stream()
//				.filter(row -> row.get("expectedmessage").equalsIgnoreCase("You are logged in"))
//				.findFirst()
//				.orElseThrow(() -> new RuntimeException("No valid login found in Excel"));
//
//		String username = validLogin.get("username").trim();
//		String password = validLogin.get("password").trim();
//
//		// Perform login
//		LoginpagePF loginPF = new LoginpagePF(driver);
//		loginPF.clickGetStarted();
//		loginPF.clickSignIn();
//		loginPF.enterUsername(username);
//		loginPF.enterPassword(password);
//		loginPF.submitLogin();
//	}
	
}
