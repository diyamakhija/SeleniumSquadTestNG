package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.QueuePF;
import utils.ExcelDataProvider;

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
		queuePF.queue_getStartedBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_URL, "User is not on the Dashboard Page");
	}

	@Test(priority = 2)
	public void implementationOfQueueInPythonPage() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_IMPLEMENTATION_LISTS_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 3)
	public void tryEditorPage() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.tryHereBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Dashboard Page");
	}

	@Test(priority = 4)
	@DataRow(3)
	public void runWithoutCode(String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.tryHereBtn();
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 5, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(1) // Fetch row 1
	public void nameErrorPythonCodeImplementationOfQueueInPythonBtn(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 6, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(2) // Fetch row 2
	public void syntaxErrorPythonCodeImplementationOfQueueInPythonBtn(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 7, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(0) // Fetch row 2
	public void validPythonCodeImplementationOfQueueInPythonBtn(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 8)
	public void implementationUsingCollectionsDequePage() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_IMPLEMENTATION_COLLECTIONS_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 9)
	public void implementationUsingCollectionsDequeTryEditorPage() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		queuePF.tryHereBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 10)
	@DataRow(3)
	public void runWithoutCode1(String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		queuePF.tryHereBtn();
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 11, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(1) // Fetch row 1
	public void nameErrorPythonCodeImplementationUsingCollectionsDeque_Row2(String codeSnippet,
			String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 12, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(2) // Fetch row 2
	public void syntaxErrorPythonCodeImplementationUsingCollectionsDeque(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 13, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(0) // Fetch row 2
	public void validPythonCodeImplementationUsingCollectionsDeque(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingCollectionsDeque();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 14)
	public void implementationUsingArrayPage() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_IMPLEMENTATION_ARRAY_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 15)
	public void implementationUsingArrayTryEditorPage() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		queuePF.tryHereBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 16)
	@DataRow(3)
	public void runWithoutCode2(String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		queuePF.tryHereBtn();
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 17, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(1) // Fetch row 1
	public void nameErrorPythonCodeImplementationUsingArray(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 18, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(2) // Fetch row 2
	public void syntaxErrorPythonCodeImplementationUsingArray(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 19, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(0) // Fetch row 2
	public void validPythonCodeimplementationUsingArray(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.implementationUsingArray();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 20)
	public void queueOperationsPage() {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_QUEUEOP_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 21)
	public void queueOperationsTryEditorPage() {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		queuePF.tryHereBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 22)
	@DataRow(3)
	public void runWithoutCode3(String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		queuePF.tryHereBtn();
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 23, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(1) // Fetch row 1
	public void nameErrorPythonCodeQueueOperations(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 24, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(2) // Fetch row 2
	public void syntaxErrorPythonCodeQueueOperations(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 25, dataProvider = "pythonCodeData", dataProviderClass = ExcelDataProvider.class)
	@DataRow(0) // Fetch row 2
	public void validPythonCodeQueueOperations(String codeSnippet, String expectedmessage) {
		queuePF.queue_getStartedBtn();
		queuePF.queueOperations();
		queuePF.tryHereBtn();
		queuePF.codeEditorInput(codeSnippet);
		queuePF.runBtn();
		String actulMessage = queuePF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 26)
	public void practiceQuestions() {
		queuePF.queue_getStartedBtn();
		queuePF.implementationOfQueueInPythonBtn();
		queuePF.practiceQuestionsBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.QUEUE_PRACTICE_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 27)
	public void dropDown() {
		queuePF.dropDownBtn();
		queuePF.treeOption();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.TREE_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 28)
	public void numpyNinja() {
		queuePF.queue_getStartedBtn();
		queuePF.numpyNinjaBtn();
		Assert.assertEquals(queuePF.getCurrentUrl(), UrlConstants.DS_ALGO_PORTAL_URL,
				"User is not on the Dashboard Page");

	}

}
