package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.StackPF;
import utils.ExcelDataProvider;
import utils.LoggerLoad;

public class StackTests extends BaseTest {
	StackPF stackPF;

	@BeforeClass
	public void initLogin() {
		shouldRunLoginMethod = true;
	}

	@BeforeMethod()
	public void setUpTest() {
		stackPF = new StackPF();
	}

	@Test(priority = 1)
	public void queuePage() {
		LoggerLoad.info("The user is in Queue page");
		stackPF.stack_getStartedBtn();
		Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.STACK_URL, "User is not on the Dashboard Page");
	}

	@Test(priority = 2)
	public void operationsInStackPage() {
	    LoggerLoad.info("The user is in Operations in Stack page");
	    stackPF.stack_getStartedBtn();  
	    stackPF.operationInStackBtn();  
	    Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.STACK_OPERATIONS_IN_STACK_URL, "User is not on the Operations in Stack Page");
	}

	@Test(priority = 3)
	public void tryEditorPageForOperationsInStack() {
	    LoggerLoad.info("The user is in tryHereBtn page for Operations in Stack");
	    stackPF.stack_getStartedBtn();  
	    stackPF.operationInStackBtn();  
	    stackPF.tryHereBtn(); 
	    Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
	}

	@Test(priority = 4, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeOperationsInStack(String codeSnippet, String expectedmessage) {
	    stackPF.stack_getStartedBtn();  
	    stackPF.operationInStackBtn();  
	    stackPF.tryHereBtn();  
	    stackPF.codeEditorInput(codeSnippet);  
	    stackPF.runBtn(); 
	    String actualMessage = stackPF.handleAlert1();  
	    Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 5, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeOperationsInStack(String codeSnippet, String expectedmessage) {
	    stackPF.stack_getStartedBtn();  
	    stackPF.operationInStackBtn(); 
	    stackPF.tryHereBtn();  
	    stackPF.codeEditorInput(codeSnippet);  
	    stackPF.runBtn();  
	    String actualMessage = stackPF.output.getText();  
	    Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
	}
	
	@Test(priority = 6)
	public void implementationOfStackPage() {
	    LoggerLoad.info("The user is in Implementation of Stack page");
	    stackPF.stack_getStartedBtn();  
	    stackPF.implementation();  
	    Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.STACK_IMPLEMENTATION_URL, "User is not on the Implementation of Stack Page");
	}

	@Test(priority = 7)
	public void tryEditorPageForStackImplementation() {
	    LoggerLoad.info("The user is in tryHereBtn page for Implementation of Stack");
	    stackPF.stack_getStartedBtn(); 
	    stackPF.implementation();  
	    stackPF.tryHereBtn(); 
	    Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
	}

	@Test(priority = 8, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeStackImplementation(String codeSnippet, String expectedmessage) {
	    stackPF.stack_getStartedBtn();  
	    stackPF.implementation();  
	    stackPF.tryHereBtn(); 
	    stackPF.codeEditorInput(codeSnippet);  
	    stackPF.runBtn();  
	    String actualMessage = stackPF.handleAlert1();  
	    Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 9, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeStackImplementation(String codeSnippet, String expectedmessage) {
	    stackPF.stack_getStartedBtn();  
	    stackPF.implementation();  
	    stackPF.tryHereBtn(); 
	    stackPF.codeEditorInput(codeSnippet);  
	    stackPF.runBtn(); 
	    String actualMessage = stackPF.output.getText();  
	    Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 10)
	public void applicationsOfStackPage() {
	    LoggerLoad.info("The user is in Applications of Stack page");
	    stackPF.stack_getStartedBtn();  
	    stackPF.application();  
	    Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.STACK_STACK_APPLICATIONS_URL, "User is not on the Applications of Stack Page");
	}

	@Test(priority = 11)
	public void tryEditorPageForApplicationsOfStack() {
	    LoggerLoad.info("The user is in tryHereBtn page for Applications of Stack");
	    stackPF.stack_getStartedBtn(); 
	    stackPF.application();  
	    stackPF.tryHereBtn();  
	    Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
	}

	@Test(priority = 12, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void invalidPythonCodeApplicationsOfStack(String codeSnippet, String expectedmessage) {
	    stackPF.stack_getStartedBtn();  
	    stackPF.application();  
	    stackPF.tryHereBtn(); 
	    stackPF.codeEditorInput(codeSnippet);  
	    stackPF.runBtn();  
	    String actualMessage = stackPF.handleAlert1();  
	    Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
	}

	@Test(priority = 13, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
	public void validPythonCodeApplicationsOfStack(String codeSnippet, String expectedmessage) {
	    stackPF.stack_getStartedBtn();  
	    stackPF.application(); 
	    stackPF.tryHereBtn();  
	    stackPF.codeEditorInput(codeSnippet);  
	    stackPF.runBtn(); 
	    String actualMessage = stackPF.output.getText();  
	    Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
	}


	@Test(priority = 18)
	public void practiceQuestionsForStack() {
	    stackPF.stack_getStartedBtn();  
	    stackPF.implementation(); 
	    stackPF.practiceQuestionsBtn();  
	    Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.STACK_PRACTICE_URL, "User is not on the Practice Questions Page");
	}


	@Test(priority = 19)
	public void numpyNinjaForStack() {
	    stackPF.stack_getStartedBtn();  
	    stackPF.numpyNinjaBtn(); 
	    Assert.assertEquals(stackPF.getCurrentUrl(), UrlConstants.DS_ALGO_PORTAL_URL, "User is not on the Dashboard Page");
	}

}