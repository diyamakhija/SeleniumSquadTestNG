package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.ArrayPF;
import utils.ExcelDataProvider;
import utils.LoggerLoad;

public class ArrayTests extends BaseTest {

	ArrayPF arrayPF;

	@BeforeClass
	public void initLogin() {
		shouldRunLoginMethod = true;
	}

	@BeforeMethod
	public void setUpTest() {
		arrayPF = new ArrayPF(driver);
	}

	@Test(priority = 1)
	public void navigateToArraysInPython() {
		LoggerLoad.info("Navigating to Arrays in Python");
		arrayPF.clickGetStartedArrayButton();
		arrayPF.clickArraysInPythonButton();
		Assert.assertEquals(arrayPF.getCurrentUrl(), UrlConstants.ARRAY_ARRAYS_IN_PYTHON_URL);
	}

	@Test(priority = 2)
	public void tryHereArraysInPython() {
		LoggerLoad.info("Trying editor on Arrays in Python page");
		arrayPF.clickGetStartedArrayButton();
		arrayPF.clickArraysInPythonButton();
		arrayPF.clickTryHereButton();
		Assert.assertEquals(arrayPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL);
	}

	@Test(priority = 3, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void testInvalidCode_ArraysInPython(String codeSnippet, String expectedMessage) {
		arrayPF.clickGetStartedArrayButton();
		arrayPF.clickArraysInPythonButton();
		arrayPF.clickTryHereButton();
		arrayPF.enterCodeInEditor(codeSnippet);
		arrayPF.clickRunButton();
		String actualMessage = arrayPF.handleAlert1();
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(priority = 4, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void testValidCode_ArraysInPython(String codeSnippet, String expectedMessage) {
		arrayPF.clickGetStartedArrayButton();
		arrayPF.clickArraysInPythonButton();
		arrayPF.clickTryHereButton();
		arrayPF.enterCodeInEditor(codeSnippet);
		arrayPF.clickRunButton();
		String actualMessage = arrayPF.output.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(priority = 5)
	public void arraysUsingListPage() {
	    LoggerLoad.info("The user is in Arrays Using List page");
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickArraysUsingListButton();
	    Assert.assertEquals(arrayPF.getCurrentUrl(), UrlConstants.ARRAY_ARRAYS_USING_LIST_URL,
	            "User is not on Arrays Using List page");
	}

	@Test(priority = 6)
	public void arraysUsingListTryHere() {
	    LoggerLoad.info("The user is in Try Editor for Arrays Using List");
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickArraysUsingListButton();
	    arrayPF.clickTryHereButton();
	    Assert.assertEquals(arrayPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
	            "User is not on Try Editor page");
	}

	@Test(priority = 7, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void arraysUsingListInvalidCode(String codeSnippet, String expectedMessage) {
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickArraysUsingListButton();
	    arrayPF.clickTryHereButton();
	    arrayPF.enterCodeInEditor(codeSnippet);
	    arrayPF.clickRunButton();
	    String actualMessage = arrayPF.handleAlert1();
	    Assert.assertEquals(actualMessage, expectedMessage, "Unexpected alert message!");
	}

	@Test(priority = 8, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void arraysUsingListValidCode(String codeSnippet, String expectedMessage) {
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickArraysUsingListButton();
	    arrayPF.clickTryHereButton();
	    arrayPF.enterCodeInEditor(codeSnippet);
	    arrayPF.clickRunButton();
	    String actualMessage = arrayPF.output.getText();
	    Assert.assertEquals(actualMessage, expectedMessage, "Unexpected output!");
	}
	
	@Test(priority = 9)
	public void basicOperationsInListsNavigation() {
	    LoggerLoad.info("The user is in Basic Operations in Lists page");
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickBasicOperaInListsButton();
	    Assert.assertEquals(arrayPF.getCurrentUrl(), UrlConstants.ARRAY_BASIC_OPERATIONS_IN_LISTS_URL,
	            "User is not on Basic Operations in Lists page");
	}

	@Test(priority = 10)
	public void basicOperaInListsTryHere() {
	    LoggerLoad.info("The user is in Basic Operations in Lists Try here page");
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickBasicOperaInListsButton();
	    arrayPF.clickTryHereButton();
	    Assert.assertEquals(arrayPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
	            "User is not on Try Editor page");
	}

	@Test(priority = 11, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void basicOperaInListsInvalidCode(String codeSnippet, String expectedMessage) {
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickBasicOperaInListsButton();
	    arrayPF.clickTryHereButton();
	    arrayPF.enterCodeInEditor(codeSnippet);
	    arrayPF.clickRunButton();
	    String actualMessage = arrayPF.handleAlert1();
	    Assert.assertEquals(actualMessage, expectedMessage, "Unexpected alert message!");
	}

	@Test(priority = 12, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void basicOperaInListsValidCode(String codeSnippet, String expectedMessage) {
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickBasicOperaInListsButton();
	    arrayPF.clickTryHereButton();
	    arrayPF.enterCodeInEditor(codeSnippet);
	    arrayPF.clickRunButton();
	    String actualMessage = arrayPF.output.getText();
	    Assert.assertEquals(actualMessage, expectedMessage, "Unexpected output message!");
	}
	@Test(priority = 13)
	public void applicationsOfArrayNavigation() {
	    LoggerLoad.info("The user is in Applications of Array page");
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickApplicationsOfArrayButton();
	    Assert.assertEquals(arrayPF.getCurrentUrl(), UrlConstants.ARRAY_APPLICATIONS_OF_ARRAY_URL,
	            "User is not on Applications of Array page");
	}

	@Test(priority = 14)
	public void applicationsOfArrayTryHere() {
	    LoggerLoad.info("The user is in Applications of Array Try Here page");
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickApplicationsOfArrayButton();
	    arrayPF.clickTryHereButton();
	    Assert.assertEquals(arrayPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
	            "User is not on Try Editor page");
	}

	@Test(priority = 15, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void applicationsOfArrayInvalidCode(String codeSnippet, String expectedMessage) {
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickApplicationsOfArrayButton();
	    arrayPF.clickTryHereButton();
	    arrayPF.enterCodeInEditor(codeSnippet);
	    arrayPF.clickRunButton();
	    String actualMessage = arrayPF.handleAlert1();
	    Assert.assertEquals(actualMessage, expectedMessage, "Unexpected alert message!");
	}

	@Test(priority = 16, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void applicationsOfArrayValidCode(String codeSnippet, String expectedMessage) {
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickApplicationsOfArrayButton();
	    arrayPF.clickTryHereButton();
	    arrayPF.enterCodeInEditor(codeSnippet);
	    arrayPF.clickRunButton();
	    String actualMessage = arrayPF.output.getText();
	    Assert.assertEquals(actualMessage, expectedMessage, "Unexpected output message!");
	}

	@Test(priority = 17)
	public void testPracticeQuestionsForArray() {
	    LoggerLoad.info("The user is in Array Practice Questions page");
	    arrayPF.clickGetStartedArrayButton();
	    arrayPF.clickPracticeQuestionsButton();
	    Assert.assertEquals(driver.getCurrentUrl(), UrlConstants.ARRAY_PRACTICE_URL,
	        "User is not on the Array Practice Questions page");
	}


}
