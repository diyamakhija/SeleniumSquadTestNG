package utils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import tests.DataRow;

public class ExcelDataProvider {

	public static Object[][] getTestDataForRow(String sheetName, int rowNum) {
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

	@DataProvider(name = "pythonCodeData")
	public static Object[][] fetchPythonCodeData(Method method) {
		DataRow dataRow = method.getAnnotation(DataRow.class);
		if (dataRow == null) {
			throw new IllegalArgumentException("Test method must have @DataRow annotation");
		}
		int rowNum = dataRow.value();
		Object[][] data = getTestDataForRow("pythonCode", rowNum);
		return data;

	}
	
	public static Object[][] fetchLoginData(int rowNum) {		
		return getTestDataForRow("userCredentials", rowNum);

	}
	
}
