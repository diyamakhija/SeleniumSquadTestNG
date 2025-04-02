//package tests;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import base.BaseTest;
//import constants.UrlConstants;
//import pages.LinkedListPF;
//
//public class LinkedListTests extends BaseTest {
//
//	LinkedListPF linkedListPF;
//
//	@BeforeClass
//	public void initLogin() {
//		shouldRunLoginMethod = true;
//	}
//
//	@BeforeMethod()
//	public void setUpTest() {
//		linkedListPF = new LinkedListPF();
//	}
//
//	@Test(priority = 1)
//	public void linkedListPage() {
//		linkedListPF.linkedListGetStartedBtn();
//		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_URL,
//				"User is not on the Dashboard Page");
//	}
//
//	@Test(priority = 2)
//	public void introductionPage() {
//		linkedListPF.linkedListGetStartedBtn();
//		linkedListPF.introductionBtn();
//		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_INTRO_URL,
//				"User is not on the Dashboard Page");
//
//	}
//
//	@Test(priority = 3)
//	public void tryEditorPage() {
////			linkedListPF.queue_getStartedBtn();
////			linkedListPF.implementationOfQueueInPythonBtn();
//		linkedListPF.tryHereBtn();
//		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
//				"User is not on the Dashboard Page");
//	}
//
//	@Test(priority = 6)
//	public void practiceQuestions() {
////			queuePF.queue_getStartedBtn();
////			queuePF.implementationOfQueueInPythonBtn();
////			queuePF.practiceQuestionsBtn();
//////			Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_PRACTICE_URL,
////					"User is not on the Dashboard Page");
//
//	}
//
//	@Test(priority = 7)
//	public void dropDown() {
////			queuePF.dropDownBtn();
////			queuePF.treeOption();
////			Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TREE_URL, "User is not on the Dashboard Page");
//
//	}
//
//	@Test(priority = 8)
//	public void numpyNinja() {
////			queuePF.queue_getStartedBtn();
////			queuePF.numpyNinjaBtn();
////			Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.DS_ALGO_PORTAL_URL,
////					"User is not on the Dashboard Page");
//
//	}
//
//	@Test(priority = 9)
//	public void implementationUsingCollectionsDequePage() {
////			queuePF.queue_getStartedBtn();
////			queuePF.implementationUsingCollectionsDeque();
////			Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_IMPLEMENTATION_COLLECTIONS_URL,
////					"User is not on the Dashboard Page");
//
//	}
//
//	@Test(priority = 10)
//	public void implementationUsingArrayPage() {
////			queuePF.queue_getStartedBtn();
////			queuePF.implementationUsingArray();
////			Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_IMPLEMENTATION_ARRAY_URL,
////					"User is not on the Dashboard Page");
//
//	}
//
//	@Test(priority = 11)
//	public void queueOperationsPage() {
////			queuePF.queue_getStartedBtn();
////			queuePF.queueOperations();
////			Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_QUEUEOP_URL,
////					"User is not on the Dashboard Page");
//
//	}
//
//}
