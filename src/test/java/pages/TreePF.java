package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TreePF extends BaseClass {

    @FindBy(xpath = "//a[@href='tree']")
    public WebElement treeGetStartedBtn;

    @FindBy(xpath = "//a[text()='Overview of Trees']")
    public WebElement overviewOfTreesBtn;

    @FindBy(xpath = "//a[text()='Try here>>>']")
    public WebElement tryHereBtn;

    @FindBy(xpath = "//form[@id='answer_form']")
    public WebElement form;

    @FindBy(xpath = "//form/div/div/div/textarea")
    public WebElement editorInput;

    @FindBy(xpath = "//pre[@id='output']")
    public WebElement output;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement runBtn;

    @FindBy(xpath = "//a[text()='Practice Questions']")
    public WebElement practiceQuestionsBtn;

    @FindBy(xpath = "//div[@class='nav-item dropdown']/a")
    public WebElement dropDownBtn;
    
    @FindBy(xpath = "//a[text()='Get Started']")
    public WebElement terminologiesGetStartedBtn;

    @FindBy(xpath = "//a[@href='terminologies']")
    public WebElement terminologiesBtn;
    
    @FindBy(xpath = "/html/body/div[2]/ul[3]/a")  
    public WebElement typesOfTreesOverviewBtn;
    
    @FindBy(xpath = "//a[contains(text(),'Tree Traversals')]")
    WebElement treeTraversalsOverviewBtn;
    
    @FindBy(xpath = "/html/body/div[2]/ul[5]/a")
    WebElement traversalsIllustrationOverviewBtn;
    
    @FindBy(xpath = "//a[contains(text(),'Binary Trees')]")
    WebElement binaryTreesOverviewBtn;

    @FindBy(xpath = "//a[contains(text(),'Types of Binary Trees')]")
    WebElement typesOfBinaryTreesOverviewBtn;
    
    @FindBy(xpath = "/html/body/div[2]/ul[8]/a")
    WebElement implementationInPythonBtn;
   
    @FindBy(xpath = "/html/body/div[2]/ul[9]/a")
    WebElement binaryTreeTraversalsBtn;
    
    @FindBy(xpath = "/html/body/div[2]/ul[10]/a")
    WebElement implementationOfBinaryTreesBtn;
    
    @FindBy(xpath = "/html/body/div[2]/ul[11]/a")
    WebElement applicationOfBinaryTreesBtn;
    
    @FindBy(xpath = "//a[text()='Binary Search Trees']")
    WebElement binarySearchTreesBtn;
    
    @FindBy(xpath = "/html/body/div[2]/ul[13]/a")
    WebElement implementationOfBSTBtn;
    
    @FindBy(xpath = "//div[@class='nav-item dropdown show']/div/a[4]")
    public WebElement queueOption;

    @FindBy(xpath = "//div[@class='bs-example']/nav/a")
    public WebElement numpyNinjaBtn;

    // Method to click the "Get Started" button on the Tree page
    public void treeGetStartedBtn() {
        treeGetStartedBtn.click();
    }

    // Methods 
    public void overviewOfTreesBtn() {
        overviewOfTreesBtn.click();
    }

    public void tryHereBtn() {
        tryHereBtn.click();
    }
    
public void codeEditorInput(String codeSnippet) {
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		webDriverWait.until(ExpectedConditions.visibilityOf(form));
		form.click();
		editorInput.sendKeys(codeSnippet);
	}

    public void practiceQuestionsBtn() {
        practiceQuestionsBtn.click();
    }

    public void enterCode(String code) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(form));
        editorInput.sendKeys(code);
    }
    
    public void terminologiesGetStartedBtn() {
        terminologiesGetStartedBtn.click();
    }

    public void terminologiesBtn() {
        terminologiesBtn.click();
    }
    
    public void typesOfTreesOverviewBtn() {
        typesOfTreesOverviewBtn.click();
    }
    
    public void treeTraversalsOverviewBtn() {
        treeTraversalsOverviewBtn.click();
    }
    
    public void traversalsIllustrationOverviewBtn() {
        traversalsIllustrationOverviewBtn.click();
    }
    
    public void binaryTreesOverviewBtn() {
        binaryTreesOverviewBtn.click();
    }
    
    public void typesOfBinaryTreesOverviewBtn() {
    	typesOfBinaryTreesOverviewBtn.click();
    }
    
    public void implementationInPythonBtn(){
    	implementationInPythonBtn.click();
    	
    }
    
    public void binaryTreeTraversalsBtn() {
    	binaryTreeTraversalsBtn.click();
    	
    }
    
    public void implementationOfBinaryTreesBtn() {
    	implementationOfBinaryTreesBtn.click();
    }
    
    public void applicationOfBinaryTreesBtn() {
    	applicationOfBinaryTreesBtn.click();
    }
    
    public void binarySearchTreesBtn() {
    	binarySearchTreesBtn.click();
    }
    
    public void implementationOfBSTBtn() {
    	implementationOfBSTBtn.click();
    }
    public void runBtn() {
        runBtn.click();
    }

    public String getOutputText() {
        return output.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String handleAlert1() {

		 String handleAlert = handleAlert();
		 return handleAlert;

	}
    
   
}

