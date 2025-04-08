package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

import java.time.Duration;
import utils.ExcelReader;

public class ArrayPF extends BaseClass{

    WebDriver driver;

    public ArrayPF(WebDriver driver) {
        this.driver = driver;
        // If you're using PageFactory:
        // PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//a[@href='array' and contains(@class, 'btn-primary')]")
    WebElement getStartedArrayButton;

    public void clickGetStartedArrayButton() {
        getStartedArrayButton.click(); 
    }
    @FindBy(xpath = "//form[@id='answer_form']")
    public WebElement form;

    @FindBy(xpath = "//a[@href='arrays-in-python']")
    WebElement arraysInPythonButton;

    @FindBy(xpath = "//a[text()='Arrays Using List']")
    WebElement arraysUsingListButton;

    @FindBy(xpath = "//a[text()='Basic Operations in Lists']")
    WebElement basicOperaInListsButton;

    @FindBy(xpath = "//a[text()='Applications of Array']")
    WebElement applicationsOfArrayButton;

    @FindBy(xpath = "//a[text()='Try here>>>']")
    WebElement tryHereButton;

    @FindBy(xpath = "//button[@type='button']")
    WebElement runButton;

    @FindBy(xpath = "//a[text()='Practice Questions']")
    WebElement practiceQuestionsButton;

    @FindBy(xpath = "//a[text()='Search the array']")
    WebElement searchArrayLink;

    @FindBy(css = "div.CodeMirror div.CodeMirror-code")
    private WebElement codeMirrorEditor;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//textarea[@tabindex='0']")
    public WebElement input;

    @FindBy(xpath = "//form/div/div/div/textarea")
    public WebElement editorInput;

    @FindBy(xpath = "//pre[@id='output']")
    public WebElement output;

    @FindBy(xpath = "//div[@class='alert-message']")
    WebElement alertMessage;

    @FindBy(xpath = "//div[@class='output']")
    WebElement consoleOutput;

    // Methods for interacting with elements on the page
    public void clickRunButton() {
        runButton.click();
    }
    
	public String handleAlert1() {

		String handleAlert1 = handleAlert();
		return handleAlert1;

	}

    public void clickArraysInPythonButton() {
        arraysInPythonButton.click();
    }

    public void clickArraysUsingListButton() {
        arraysUsingListButton.click();
    }

    public void clickBasicOperaInListsButton() {
        basicOperaInListsButton.click();
    }

    public void clickApplicationsOfArrayButton() {
        applicationsOfArrayButton.click();
    }

    public void clickTryHereButton() {
        tryHereButton.click();
    }

    public void clickPracticeQuestionsButton() {
        practiceQuestionsButton.click();
    }

    public void clickSearchArrayLink() {
        searchArrayLink.click();
    }
    public void enterCodeInEditor(String code) {
        WebElement editorDiv = driver.findElement(By.cssSelector("div.CodeMirror"));

        // Click to focus editor
        editorDiv.click();

        // Use JavaScript to send keys directly into the editor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "arguments[0].CodeMirror.setValue(arguments[1]);",
            editorDiv,
            code
        );
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getAlertMessage() {
        return alertMessage.getText();
    }

    public String getConsoleOutput() {
        return consoleOutput.getText();
    }

    public void output() {
        consoleOutput.click();
    }

public String getCurrentUrl() {
    return driver.getCurrentUrl();  // Ensure this returns the actual browser URL
}

//    public String getCurrentUrl() {
//        return driver.getCurrentUrl();
//    }
//
//    public void codeEditorInput() {
//		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		webDriverWait.until(ExpectedConditions.visibilityOf(form));
//		form.click();
//		editorInput.sendKeys();
//	}

} 