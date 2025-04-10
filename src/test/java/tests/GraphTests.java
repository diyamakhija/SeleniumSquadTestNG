package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.UrlConstants;
import pages.ArrayPF;
import pages.GraphPF;
import utils.ExcelDataProvider;
import utils.LoggerLoad;

public class GraphTests extends BaseTest {
	
    GraphPF graphPF;

    	@BeforeClass
    	public void initLogin() {
    		shouldRunLoginMethod = true;
    	}

    	@BeforeMethod
    	public void setUpTest() {
    		graphPF = new GraphPF(driver);
    	}

    @Test(priority = 1)
    public void graphLandingPage() {
        LoggerLoad.info("The user is in Graph page");
        graphPF.clickGetStartedButton();
        Assert.assertEquals(graphPF.getCurrentUrl(), UrlConstants.GRAPH_URL, "User is not on the Graph Page");
    }
    

    @Test(priority = 2)
    public void graphSubPage() {
        LoggerLoad.info("The user is in Graph -> Graph page");
        graphPF.clickGetStartedButton();
        graphPF.clickGraphButton();
        Assert.assertEquals(graphPF.getCurrentUrl(), UrlConstants.GRAPH_GRAPH_URL, "User is not on the Graph sub page");
    }

    @Test(priority = 3)
    public void tryHereGraphPage() {
        LoggerLoad.info("The user is in Graph -> Try Editor");
        graphPF.clickGetStartedButton();
        graphPF.clickGraphButton();
        graphPF.clickTryHereButton();
        Assert.assertEquals(graphPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "Try Editor did not open");
    }

    @Test(priority = 4, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void graphInvalidCode(String codeSnippet, String expectedMessage) {
        graphPF.clickGetStartedButton();
        graphPF.clickGraphButton();
        graphPF.clickTryHereButton();
        graphPF.writeCode(codeSnippet);
        graphPF.clickRunButton();
        String actualMessage = graphPF.handleAlert1(); 
        Assert.assertEquals(actualMessage, expectedMessage, "Mismatch in expected and actual alert message");
    }
    
    @Test(priority = 5, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void graphValidCode(String codeSnippet, String expectedMessage) {
        graphPF.clickGetStartedButton();
        graphPF.clickGraphButton();
        graphPF.clickTryHereButton();
        graphPF.writeCode(codeSnippet);
        graphPF.clickRunButton();
        String actulMessage = graphPF.output.getText();
		System.out.println("expectedmessage" + expectedMessage);
		Assert.assertEquals(actulMessage, expectedMessage, "An unexpected error occurred:");
    }

    @Test(priority = 6)
    public void graphRepresentationsPage() {
        LoggerLoad.info("The user is on the Graph Representations page");
        graphPF.clickGetStartedButton();
        graphPF.clickGraphButton();
        graphPF.graphRepresentations();
        Assert.assertEquals(graphPF.getCurrentUrl(), UrlConstants.GRAPH_GRAPH_REPRESENTATIONS_URL,
                "User is not on the Graph Representations page");
    }

    @Test(priority = 7)
    public void graphRepTryEditor() {
        LoggerLoad.info("The user is on the Graph Representations -> Try Editor page");
        graphPF.clickGetStartedButton();
        graphPF.clickGraphButton();
        graphPF.graphRepresentations();
        graphPF.clickTryHereButton();
        Assert.assertEquals(graphPF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL,
                "User is not on the Try Editor page");
    }

    @Test(priority = 8, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void graphRepInvalidCode(String codeSnippet, String expectedMessage) {
    	graphPF.clickGetStartedButton();
        graphPF.graphRepresentations();
        graphPF.clickTryHereButton();
        graphPF.writeCode(codeSnippet);
        graphPF.clickRunButton();
        String actualMessage = graphPF.handleAlert1(); 
        Assert.assertEquals(actualMessage, expectedMessage, "Mismatch in expected and actual alert message");
    }
    
    

    @Test(priority = 9, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void graphRepValidCode(String codeSnippet, String expectedMessage) {
        graphPF.clickGetStartedButton();
        graphPF.clickGraphButton();
        graphPF.graphRepresentations();
        graphPF.clickTryHereButton();
        graphPF.writeCode(codeSnippet);
        graphPF.clickRunButton();
        String actulMessage = graphPF.output.getText();
     		System.out.println("expectedmessage" + expectedMessage);
     		Assert.assertEquals(actulMessage, expectedMessage, "An unexpected error occurred:");
    }


    @Test(priority = 10)
    public void graphPracticeQuestions() {
        LoggerLoad.info("The user is on the Graph Practice Questions page");
        graphPF.clickGetStartedButton();
        graphPF.clickGraphButton();
        graphPF.practiceQuestions();
        Assert.assertEquals(graphPF.getCurrentUrl(), UrlConstants.GRAPH_GRAPH_PRACTICE_URL,
                "User is not on the Graph Practice Questions page");
    }
}
