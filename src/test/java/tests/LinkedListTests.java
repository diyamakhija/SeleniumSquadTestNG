package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.LinkedListPF;
import utils.ExcelDataProvider;

public class LinkedListTests extends BaseTest {

	LinkedListPF linkedListPF;

	@BeforeClass
	public void initLogin() {
		shouldRunLoginMethod = true;
	}

	@BeforeMethod()
	public void setUpTest() {
		linkedListPF = new LinkedListPF();
	}

	@Test(priority = 1)
	public void linkedListPage() {
		linkedListPF.linkedListGetStartedBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 2)
	public void introductionPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.introductionBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_INTRO_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 3)
	public void introductionTryEditorPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.introductionBtn();
		linkedListPF.tryHereBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 4, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeIntroductionPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.introductionBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 5, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeIntroductionPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.introductionBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 6)
	public void creatingLinkedListPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.creatingLinkedListBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_CREATING_LINKED_LIST_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 7)
	public void creatingLinkedListTryEditorPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.creatingLinkedListBtn();
		linkedListPF.tryHereBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 8, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeCreatingLinkedList(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.creatingLinkedListBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 9, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeCreatingLinkedList(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.creatingLinkedListBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 10)
	public void typesOfLinkedListsPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.typesOfLinkedListBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_TYPES_OF_LINKED_LIST_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 11)
	public void typesOfLinkedListsTryEditorPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.typesOfLinkedListBtn();
		linkedListPF.tryHereBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 12, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeTypesOfLinkedListsPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.typesOfLinkedListBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 13, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeTypesOfLinkedListsPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.typesOfLinkedListBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 14)
	public void implementLinkedListInPythonPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.implementLinkedListInPythonBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_IMPLEMENT_LINKEDLIST_IN_PYTHON_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 15)
	public void implementLinkedListInPythonTryEditorPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.implementLinkedListInPythonBtn();
		linkedListPF.tryHereBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 16, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeImplementLinkedListInPythonPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.implementLinkedListInPythonBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 17, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeImplementLinkedListInPythonPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.implementLinkedListInPythonBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 18)
	public void traversalPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.traversalBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_TRAVERSAL_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 19)
	public void traversalTryEditorPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.traversalBtn();
		linkedListPF.tryHereBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 20, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeTraversalPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.traversalBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 21, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeTraversalPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.traversalBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 22)
	public void insertionPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.insertionBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_INSERTION_IN_LINKED_LIST_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 23)
	public void insertionTryEditorPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.insertionBtn();
		linkedListPF.tryHereBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 24, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeInsertionPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.insertionBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 25, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeInsertionPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.insertionBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 26)
	public void deletionPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.DeletionBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_DELETION_IN_LINKED_LIST_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 27)
	public void deletionTryEditorPage() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.DeletionBtn();
		linkedListPF.tryHereBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 28, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeDeletionPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.DeletionBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.handleAlert1();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 29, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeDeletionPage(String codeSnippet, String expectedmessage) {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.DeletionBtn();
		linkedListPF.tryHereBtn();
		linkedListPF.codeEditorInput(codeSnippet);
		linkedListPF.runBtn();
		String actulMessage = linkedListPF.output.getText();
		Assert.assertEquals(actulMessage, expectedmessage, "An unexpected error occurred:");

	}

	@Test(priority = 30)
	public void practiceQuestions() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.introductionBtn();
		linkedListPF.practiceQuestionsBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.LINKED_LIST_PRACTICE_URL,
				"User is not on the Dashboard Page");

	}

	@Test(priority = 31)
	public void dropDown() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.introductionBtn();
		linkedListPF.dropDownBtn();
		linkedListPF.treeOption();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.TREE_URL, "User is not on the Dashboard Page");

	}

	@Test(priority = 32)
	public void numpyNinja() {
		linkedListPF.linkedListGetStartedBtn();
		linkedListPF.introductionBtn();
		linkedListPF.numpyNinjaBtn();
		Assert.assertEquals(linkedListPF.getCurrentUrl(), UrlConstants.DS_ALGO_PORTAL_URL,
				"User is not on the Dashboard Page");

	}

}
