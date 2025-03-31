package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.DataStructureIntroPF;

public class DataStructureIntroTests extends BaseTest {

	DataStructureIntroPF dataStructureIntroPF;

	@BeforeClass
	public void initLogin() {
		System.out.println("init first");
		shouldRunLoginMethod = true;
	}

	@BeforeMethod
	public void initDataStructure() {
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

	@Test(priority = 4)
	public void practiceQuestions() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.practiceQuestionsBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DATA_STRUCTURES_INTRO_PRACTICE_URL,
				"User is not on the Dashboard Page");

	}
	
	
}
