package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.UrlConstants;
import pages.TreePF;
import utils.ExcelDataProvider;
import utils.LoggerLoad;

public class TreeTests extends BaseTest {
    TreePF treePF;

    @BeforeClass
    public void initLogin() {
        shouldRunLoginMethod = true;
    }

    @BeforeMethod()
    public void setUpTest() {
        treePF = new TreePF();
    }

    @Test(priority = 1)
    public void treePage() {
    	LoggerLoad.info("The user is in Tree page");
        treePF.treeGetStartedBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_URL, "User is not on the Tree Page");
    }

    @Test(priority = 2)
    public void treeOverviewPage() {
    	LoggerLoad.info("The user is in Over ViewOf Tree Page");
        treePF.treeGetStartedBtn();
        treePF.overviewOfTreesBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_OVERVIEW_OF_TREES_URL, "User is not on the Tree Overview Page");
    }

    @Test(priority = 3)
    public void tryEditorPage() {
    	LoggerLoad.info("The user is in tryHereBtn page for Tree");
        treePF.treeGetStartedBtn();
        treePF.overviewOfTreesBtn();
        treePF.tryHereBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }
    
    @Test(priority = 4, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeOverViewOfTreeInPython(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.overviewOfTreesBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn();  
        String actualMessage = treePF.handleAlert1();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 5, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeTreeOverview(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.overviewOfTreesBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.output.getText();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }
    
    @Test(priority = 6)
  public void terminologiesPage() {
      LoggerLoad.info("The user is in Tree Terminologies Page");    
      treePF.treeGetStartedBtn();
      treePF.terminologiesBtn();
      Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_TERMINOLOGIES_URL, "User is not on the Terminologies Page");
  }

  @Test(priority = 7)
  public void terminologiesTryEditorPage() {
	  LoggerLoad.info("The user is in tryHereBtn page for Tree Terminologies");
      treePF.treeGetStartedBtn();
      treePF.terminologiesBtn();
      treePF.tryHereBtn();
      Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
  }

  @Test(priority = 8, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
  public void invalidPythonCodeTreeTerminologies(String codeSnippet, String expectedmessage) {
      treePF.treeGetStartedBtn();
      treePF.terminologiesBtn();
      treePF.tryHereBtn();
      treePF.codeEditorInput(codeSnippet);
      treePF.runBtn();
      String actualMessage = treePF.handleAlert1();
      Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
  }
  
  @Test(priority = 9, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
  public void validPythonCodeTerminologies(String codeSnippet, String expectedmessage) {
      treePF.treeGetStartedBtn();
      treePF.terminologiesBtn();
      treePF.tryHereBtn();
      treePF.codeEditorInput(codeSnippet);
      treePF.runBtn();
      String actualMessage = treePF.output.getText();
      Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
  }

  @Test(priority = 10)
  public void typesOfTreesPage() {
      LoggerLoad.info("The user is in Types of Trees Page");
      treePF.treeGetStartedBtn();  
      treePF.typesOfTreesOverviewBtn();  
      Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_TPES_OF_TREES_URL, "User is not on the Types of Trees Page");
  }

  @Test(priority = 11)
  public void tryEditorPageForTypesOfTrees() {
      LoggerLoad.info("The user is in tryHereBtn page for Types of Trees");
      treePF.treeGetStartedBtn();  
      treePF.typesOfTreesOverviewBtn(); 
      treePF.tryHereBtn();  
      Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
  }

  @Test(priority = 12, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
  public void invalidPythonCodeTypesOfTrees(String codeSnippet, String expectedmessage) {
      treePF.treeGetStartedBtn();  
      treePF.typesOfTreesOverviewBtn(); 
      treePF.tryHereBtn();  
      treePF.codeEditorInput(codeSnippet);  
      treePF.runBtn();  
      String actualMessage = treePF.handleAlert1();  
      Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
  }

  @Test(priority = 13, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
  public void validPythonCodeTypesOfTrees(String codeSnippet, String expectedmessage) {
      treePF.treeGetStartedBtn(); 
      treePF.typesOfTreesOverviewBtn(); 
      treePF.tryHereBtn(); 
      treePF.codeEditorInput(codeSnippet);  
      treePF.runBtn(); 
      String actualMessage = treePF.output.getText();  
      Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
  }

 
    @Test(priority = 14)
    public void treeTraversalsPage() {
    	LoggerLoad.info("The user is in Tree Traversals Page");
        treePF.treeGetStartedBtn();
        treePF.treeTraversalsOverviewBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_TREE_TRAVERSALS_URL, "User is not on the Tree Traversals Page");
    }

    @Test(priority = 15)
    public void treeTraversalsTryEditorPage() {
    	LoggerLoad.info("The user is in tryHereBtn page for Tree Traversals");
        treePF.treeGetStartedBtn();
        treePF.treeTraversalsOverviewBtn();
        treePF.tryHereBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }
    
    @Test(priority = 16, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
   
   
    public void invalidPythonCodeTreeTraversals(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.treeTraversalsOverviewBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.handleAlert1();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 17, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeTreeTraversals(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.treeTraversalsOverviewBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.output.getText();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 18)
    public void traversalsIllustrationPage() {
    	LoggerLoad.info("The user is in Traversals Illustration Page");
        treePF.treeGetStartedBtn();
        treePF.traversalsIllustrationOverviewBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_TRAVERSALS_ILLUSTRATION_URL, "User is not on the Traversals Illustration Page");
    }

    @Test(priority = 19)
    public void traversalsIllustrationTryEditorPage() {
    	LoggerLoad.info("The user is in tryHereBtn page for Traversals Illustration");
        treePF.treeGetStartedBtn();
        treePF.traversalsIllustrationOverviewBtn();
        treePF.tryHereBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

    @Test(priority = 20, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeTraversalsIllustration(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.traversalsIllustrationOverviewBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.handleAlert1();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 21, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeTraversalsIllustration(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.traversalsIllustrationOverviewBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.output.getText();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }
    
    @Test(priority = 22)
    public void binaryTreesPage() {
    	LoggerLoad.info("The user is in Binary Trees Page");
        treePF.treeGetStartedBtn();
        treePF.binaryTreesOverviewBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_BINARY_TREES_URL, "User is not on the Binary Trees Page");
    }

    @Test(priority = 23)
    public void binaryTreesTryEditorPage() {
    	LoggerLoad.info("The user is in tryHereBtn page for Binary Trees");
        treePF.treeGetStartedBtn();
        treePF.binaryTreesOverviewBtn();
        treePF.tryHereBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

    @Test(priority = 24, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeBinaryTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.binaryTreesOverviewBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.handleAlert1();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 25, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeBinaryTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.binaryTreesOverviewBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.output.getText();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 26)
    public void typesOfBinaryTreesPage() {
    	LoggerLoad.info("The user is in Types of Binary Trees Page");
        treePF.treeGetStartedBtn();
        treePF.typesOfBinaryTreesOverviewBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_TYPES_OF_BINARY_TREES_URL, "User is not on the Types of Binary Trees Page");
    }

    @Test(priority = 27)
    public void typesOfBinaryTreesTryEditorPage() {
    	LoggerLoad.info("The user is in tryHereBtn page for Types of Binary Trees");
        treePF.treeGetStartedBtn();
        treePF.typesOfBinaryTreesOverviewBtn();
        treePF.tryHereBtn();
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

   
    @Test(priority = 28, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeTypesOfBinaryTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.typesOfBinaryTreesOverviewBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.handleAlert1();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 29, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeTypesOfBinaryTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();
        treePF.typesOfBinaryTreesOverviewBtn();
        treePF.tryHereBtn();
        treePF.codeEditorInput(codeSnippet);
        treePF.runBtn();
        String actualMessage = treePF.output.getText();
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 30)
    public void implementationInPythonPage() {
        LoggerLoad.info("The user is in Implementation in Python Page");
        treePF.treeGetStartedBtn();  
        treePF.implementationInPythonBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_IMPLEMENTATION_IN_PYTHON_URL, "User is not on the Implementation in Python Page");
    }

    @Test(priority = 31)
    public void tryEditorPageForImplementationInPython() {
        LoggerLoad.info("The user is in tryHereBtn page for Implementation in Python");
        treePF.treeGetStartedBtn();  
        treePF.implementationInPythonBtn();  
        treePF.tryHereBtn(); 
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

    @Test(priority = 32, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeImplementationInPython(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.implementationInPythonBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn();  // Run the code
        String actualMessage = treePF.handleAlert1();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 33, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeImplementationInPython(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.implementationInPythonBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn();  // Execute the code
        String actualMessage = treePF.output.getText();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }
    
    @Test(priority = 34)
    public void binaryTreeTraversalsPage() {
        LoggerLoad.info("The user is in Binary Tree Traversals Page");
        treePF.treeGetStartedBtn();  
        treePF.binaryTreeTraversalsBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_BINARY_TREE_TRAVERSALS_URL, "User is not on the Binary Tree Traversals Page");
    }

    @Test(priority = 35)
    public void tryEditorPageForBinaryTreeTraversals() {
        LoggerLoad.info("The user is in tryHereBtn page for Binary Tree Traversals");
        treePF.treeGetStartedBtn(); 
        treePF.binaryTreeTraversalsBtn();  
        treePF.tryHereBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

    @Test(priority = 36, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeBinaryTreeTraversals(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.binaryTreeTraversalsBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet); 
        treePF.runBtn();  
        String actualMessage = treePF.handleAlert1();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 37, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeBinaryTreeTraversals(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.binaryTreeTraversalsBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet); 
        treePF.runBtn(); 
        String actualMessage = treePF.output.getText();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }
    
    
    @Test(priority = 38)
    public void implementationOfBinaryTreesPage() {
        LoggerLoad.info("The user is in Implementation of Binary Trees Page");
        treePF.treeGetStartedBtn();  
        treePF.implementationOfBinaryTreesBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_IMPLEMENTATION_OF_BINARY_TREES_URL, "User is not on the Implementation of Binary Trees Page");
    }

    @Test(priority = 39)
    public void tryEditorPageForImplementationOfBinaryTrees() {
        LoggerLoad.info("The user is in tryHereBtn page for Implementation of Binary Trees");
        treePF.treeGetStartedBtn();  
        treePF.implementationOfBinaryTreesBtn();  
        treePF.tryHereBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

    @Test(priority = 40, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeImplementationOfBinaryTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.implementationOfBinaryTreesBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet); 
        treePF.runBtn();  
        String actualMessage = treePF.handleAlert1();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 41, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeImplementationOfBinaryTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.implementationOfBinaryTreesBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn(); 
        String actualMessage = treePF.output.getText();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 42)
    public void applicationOfBinaryTreesPage() {
        LoggerLoad.info("The user is in Application of Binary Trees Page");
        treePF.treeGetStartedBtn();  
        treePF.applicationOfBinaryTreesBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_APPLICATIONS_OF_BINARY_TREES_URL, "User is not on the Application of Binary Trees Page");
    }

    @Test(priority = 43)
    public void tryEditorPageForApplicationOfBinaryTrees() {
        LoggerLoad.info("The user is in tryHereBtn page for Application of Binary Trees");
        treePF.treeGetStartedBtn();  
        treePF.applicationOfBinaryTreesBtn();  
        treePF.tryHereBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

    @Test(priority = 44, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeApplicationOfBinaryTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.applicationOfBinaryTreesBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn(); 
        String actualMessage = treePF.handleAlert1();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 45, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeApplicationOfBinaryTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.applicationOfBinaryTreesBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn();  // Execute the code
        String actualMessage = treePF.output.getText();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }
    
    @Test(priority = 46)
    public void binarySearchTreesPage() {
        LoggerLoad.info("The user is in Binary Search Trees Page");
        treePF.treeGetStartedBtn();  
        treePF.binarySearchTreesBtn(); 
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_BINARY_SEARCH_TREES_URL, "User is not on the Binary Search Trees Page");
    }

    @Test(priority = 47)
    public void tryEditorPageForBinarySearchTrees() {
        LoggerLoad.info("The user is in tryHereBtn page for Binary Search Trees");
        treePF.treeGetStartedBtn();  
        treePF.binarySearchTreesBtn();  
        treePF.tryHereBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

    @Test(priority = 48, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeBinarySearchTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.binarySearchTreesBtn(); 
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet); 
        treePF.runBtn();  
        String actualMessage = treePF.handleAlert1();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 49, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeBinarySearchTrees(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn(); 
        treePF.binarySearchTreesBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn();  
        String actualMessage = treePF.output.getText();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }
    
    @Test(priority = 50)
    public void implementationOfBSTPage() {
        LoggerLoad.info("The user is in Implementation of Binary Search Tree Page");
        treePF.treeGetStartedBtn();  
        treePF.implementationOfBSTBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TREE_IMPLEMENTATION_OF_BST_URL, "User is not on the Implementation of BST Page");
    }

    @Test(priority = 51)
    public void tryEditorPageForBSTImplementation() {
        LoggerLoad.info("The user is in tryHereBtn page for Implementation of Binary Search Tree");
        treePF.treeGetStartedBtn();  
        treePF.implementationOfBSTBtn();  
        treePF.tryHereBtn();  
        Assert.assertEquals(treePF.getCurrentUrl(), UrlConstants.TRYEDITOR_URL, "User is not on the Try Editor Page");
    }

    @Test(priority = 52, dataProvider = "invalidPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void invalidPythonCodeBSTImplementation(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.implementationOfBSTBtn();  
        treePF.tryHereBtn();  
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn();  
        String actualMessage = treePF.handleAlert1();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }

    @Test(priority = 53, dataProvider = "validPythonCodeData", dataProviderClass = ExcelDataProvider.class)
    public void validPythonCodeBSTImplementation(String codeSnippet, String expectedmessage) {
        treePF.treeGetStartedBtn();  
        treePF.implementationOfBSTBtn();  
        treePF.tryHereBtn(); 
        treePF.codeEditorInput(codeSnippet);  
        treePF.runBtn();  
        String actualMessage = treePF.output.getText();  
        Assert.assertEquals(actualMessage, expectedmessage, "An unexpected error occurred:");
    }


}
