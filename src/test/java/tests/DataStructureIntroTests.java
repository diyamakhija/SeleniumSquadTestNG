package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.UrlConstants;
import pages.DataStructureIntroPF;
import pages.LoginPF;

public class DataStructureIntroTests extends BaseTest {

	DataStructureIntroPF dataStructureIntroPF;
	LoginPF loginPF;

	@BeforeMethod
	private void init() {
		System.out.println("Coming to DataStructureIntroTests of init");
		dataStructureIntroPF = new DataStructureIntroPF();
		loginPF = new LoginPF();
		loginPF.getStartedBtn();
		loginPF.signInBtn();
		loginPF.userNameField();
		loginPF.passwordField();
		loginPF.logInBtn();
	}

	@Test(priority = 2)
	public void dataStructureIntro() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DATA_STRUCTURES_INRO_URL,
				"User is not on the Dashboard Page");
	}

	@Test(priority = 3)
	public void timeComplexityPage() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(),
				UrlConstants.DATA_STRUCTURES_INTRO_TIME_COMPLEXITY_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 4)
	public void tryEditorPage() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.tryHereBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");
	}

	@Test(priority = 5)
	public void practiceQuestions() {
		dataStructureIntroPF.dataStrIntro_getStartedBtn();
		dataStructureIntroPF.timeComplexityBtn();
		dataStructureIntroPF.practiceQuestionsBtn();
		Assert.assertEquals(dataStructureIntroPF.getCurrentUrl(), UrlConstants.DATA_STRUCTURES_INTRO_PRACTICE_URL,
				"User is not on the Dashboard Page");

	}

}
