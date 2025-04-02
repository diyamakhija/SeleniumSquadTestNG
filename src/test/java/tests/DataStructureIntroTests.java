package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.DataStructureIntroPF;
import utils.ExcelDataProvider;

public class DataStructureIntroTests extends BaseTest {

	DataStructureIntroPF dataStructureIntroPF;

	@BeforeClass
	public void initLogin() {
		shouldRunLoginMethod = true;
	}

	@BeforeMethod()
	public void setUpTest() {
		dataStructureIntroPF = new DataStructureIntroPF();
	}

	@Test(priority = 1)
	public void dataStructureIntro() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DATA_STRUCTURES_INRO_URL,
				"User is not on the Dashboard Page");
	}

	@Test(priority = 2)
	public void timeComplexityPage() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(),
				UrlConstants.DATA_STRUCTURES_INTRO_TIME_COMPLEXITY_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 3)
	public void tryEditorPage() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");
	}

	@Test(priority = 4,retryAnalyzer = listeners.Retry.class,dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(3)
	public void runWithoutCode(String expectedmessage) {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		dataStructureIntroPF.runBtn();
		String actulMessage = dataStructureIntroPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 5, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(1) // Fetch row 1
	public void nameErrorPythonCode_Row2(String codeSnippet, String expectedmessage) {
		System.out.println("Executing with code: " + codeSnippet);
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		dataStructureIntroPF.codeEditorInput(codeSnippet);
		dataStructureIntroPF.runBtn();
		String actulMessage = dataStructureIntroPF.handleAlert1();
		System.out.println("expectedmessage" + expectedmessage);
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 6, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(2) // Fetch row 2
	public void syntaxErrorPythonCode_Row3(String codeSnippet, String expectedmessage) {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		dataStructureIntroPF.codeEditorInput(codeSnippet);
		dataStructureIntroPF.runBtn();
		String actulMessage = dataStructureIntroPF.handleAlert1();
		System.out.println("expectedmessage" + expectedmessage);
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 7, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(0) // Fetch row 2
	public void validPythonCode_Row3(String codeSnippet, String expectedmessage) {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		dataStructureIntroPF.codeEditorInput(codeSnippet);
		dataStructureIntroPF.runBtn();
		String actulMessage = dataStructureIntroPF.output.getText();
		System.out.println("expectedmessage" + expectedmessage);
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 8)
	public void practiceQuestions() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.practiceQuestionsBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DATA_STRUCTURES_INTRO_PRACTICE_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 9)
	public void dropDown() {
		dataStructureIntroPF.dropDownBtn();
		dataStructureIntroPF.queueOption();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.QUEUE_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 10)
	public void numpyNinja() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.numpyNinjaBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DS_ALGO_PORTAL_URL,
				"User is not on the Dashboard Page");

	}

}