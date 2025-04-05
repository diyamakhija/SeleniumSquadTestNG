package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.DataStructureIntroPF;
import utils.ExcelDataProvider;
import utils.LoggerLoad;

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
		LoggerLoad.info("The user is in Data structure Introduction page");
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DATA_STRUCTURES_INRO_URL,
				"User is not on the Dashboard Page");
	}

	@Test(priority = 2)
	public void timeComplexityPage() {
		LoggerLoad.info("The user is in TimeComplexity page");
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(),
				UrlConstants.DATA_STRUCTURES_INTRO_TIME_COMPLEXITY_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 3)
	public void tryEditorPage() {
		LoggerLoad.info("The user is in Datastructure Introduction Try here page");
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");
	}


	@Test(priority = 4, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCode(String codeSnippet, String expectedmessage) {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		dataStructureIntroPF.codeEditorInput(codeSnippet);
		dataStructureIntroPF.runBtn();
		String actulMessage = dataStructureIntroPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	
	@Test(priority = 5, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCode(String codeSnippet, String expectedmessage) {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		dataStructureIntroPF.codeEditorInput(codeSnippet);
		dataStructureIntroPF.runBtn();
		String actulMessage = dataStructureIntroPF.output.getText();
		System.out.println("expectedmessage" + expectedmessage);
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 6)
	public void practiceQuestions() {
		LoggerLoad.info("The user is in practice question page");
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.practiceQuestionsBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DATA_STRUCTURES_INTRO_PRACTICE_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 7)
	public void dropDown() {
		LoggerLoad.info("The user is in Queue page");
		dataStructureIntroPF.dropDownBtn();
		dataStructureIntroPF.queueOption();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.QUEUE_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 8)
	public void numpyNinja() {
		LoggerLoad.info("The user is in Numpy Ninja page");
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.numpyNinjaBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DS_ALGO_PORTAL_URL,
				"User is not on the Dashboard Page");

	}

}