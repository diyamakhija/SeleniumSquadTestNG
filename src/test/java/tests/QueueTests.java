package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.QueuePF;
import utils.ExcelDataProvider;
import utils.LoggerLoad;

public class QueueTests extends BaseTest {
	QueuePF queuePF;

	@BeforeClass
	public void initLogin() {
		shouldRunLoginMethod = true;
	}

	@BeforeMethod()
	public void setUpTest() {
		queuePF = new QueuePF();
	}

	@Test(priority = 1)
	public void queuePage() {
		LoggerLoad.info("The user is in Queue page");
		queuePF.queue_getStartedBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_URL, "User is not on the Dashboard Page");
	}

	@Test(priority = 2)
	public void implementationOfQueueInPythonPage() {
		LoggerLoad.info("The user is in implementationOfQueueInPython page ");
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_IMPLEMENTATION_LISTS_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 3)
	public void tryEditorPage() {
		LoggerLoad.info("The user is in tryHereBtn page ");
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.tryHereBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Dashboard Page");
	}

	@Test(priority = 4, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)	
	public void invalidPythonCodeImplementationOfQueueInPython(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 5, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeImplementationOfQueueInPythonBtn(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 6)
	public void implementationUsingCollectionsDequePage() {
		LoggerLoad.info("The user is in implementationUsingCollectionsDeque page ");
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_IMPLEMENTATION_COLLECTIONS_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 7)
	public void implementationUsingCollectionsDequeTryEditorPage() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		queuePF.tryHereBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 8, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeImplementationUsingCollectionsDeque(String codeSnippet,
			String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 9, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeImplementationUsingCollectionsDeque(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 10)
	public void implementationUsingArrayPage() {
		LoggerLoad.info("The user is in implementationUsingArray page ");
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_IMPLEMENTATION_ARRAY_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 11)
	public void implementationUsingArrayTryEditorPage() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		queuePF.tryHereBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 12, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeImplementationUsingArray(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 13, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeimplementationUsingArray(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 14)
	public void queueOperationsPage() {
		LoggerLoad.info("The user is in queueOperations page ");
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_QUEUEOP_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 15)
	public void queueOperationsTryEditorPage() {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		queuePF.tryHereBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Dashboard Page");

	}
	
	@Test(priority = 16, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeQueueOperations(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}
	
	@Test(priority = 17, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeQueueOperations(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 18)
	public void practiceQuestions() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.practiceQuestionsBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_PRACTICE_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 19)
	public void dropDown() {
		queuePF.dropDownBtn();
		queuePF.treeOption();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TREE_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 20)
	public void numpyNinja() {
		queuePF.queue_getStartedBtn();
		queuePF.numpyNinjaBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.DS_ALGO_PORTAL_URL,
				"User is not on the Dashboard Page");

	}

}
