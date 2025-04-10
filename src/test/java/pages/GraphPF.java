package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.LoggerLoad;


    public class GraphPF extends BaseClass{

        WebDriver driver;

        public GraphPF(WebDriver driver) {
            this.driver = driver;
            // If you're using PageFactory:
            // PageFactory.initElements(driver, this);
        }


	// WebElement for "Get Started" button in Graph Panel
        @FindBy(css = "a[href='graph'].btn.btn-primary")
        private WebElement getStartedButton;

	// WebElement for "Graph" button
        @FindBy(xpath = "//a[@href='graph' and text()='Graph']")
	private WebElement graphButton;

	// WebElement for "Try Here" button in Graph page
        @FindBy(xpath = "//a[@href='/tryEditor' and contains(text(), 'Try here')]")

	private WebElement tryHereButton;

	// WebElement for "Run" button in the Try Editor page
        @FindBy(css = "button[onclick='runit()']")
        private WebElement runButton;
        
        @FindBy(xpath = "//pre[@id='output']")
    	public WebElement output;

    	public void output() {

    		output.click();
    	}
	

	// WebElement for error alert in Try Editor page
	@FindBy(id = "errorAlert")
	private WebElement errorAlert;

	// WebElement for the Editor (Python code editor)
	@FindBy(id = "editor")
	private WebElement codeEditor;

	// WebElement for console output
	@FindBy(id = "console")
	private WebElement consoleOutput;

	// Method to click "Get Started" button in Graph Panel
	public void clickGetStartedButton() {
	    LoggerLoad.info("Clicking Get Started button under Graph card");

	    By graphBtnLocator = By.cssSelector("a[href='graph'].btn.btn-primary");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement graphBtn = wait.until(ExpectedConditions.elementToBeClickable(graphBtnLocator));

	    // Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", graphBtn);

	    // Click using JavaScript
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", graphBtn);

	    // Wait for URL to change
	    wait.until(ExpectedConditions.urlContains("graph"));

	    LoggerLoad.info("After clicking, current URL: " + driver.getCurrentUrl());
	}


	// Method to click "Graph" button
	public void clickGraphButton() {
		graphButton.click();
	}

	// Method to click "Try Here" button in Graph page
	public void clickTryHereButton() {
		tryHereButton.click();
	}

	// Method to click "Run" button in Try Editor page
	public void clickRunButton() {
		runButton.click();
	}

	// Method to write code using CodeMirror JavaScript API
	public void writeCode(String code) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", code);
	}

	// Method to get the error message from the alert window
	public String getErrorMessage() {
		return errorAlert.getText();
	}

	// Method to get the output from the console
	public String getConsoleOutput() {
		return consoleOutput.getText();
	}

	// Check if the editor is displayed
	public boolean isEditorDisplayed() {
		return codeEditor.isDisplayed();
	}

	// Check if the error alert is displayed
	public boolean isErrorAlertDisplayed() {
		return errorAlert.isDisplayed();
	}
	@FindBy(xpath = "//a[text()='Practice Questions']")
	private WebElement practiceQuestionsBtn;

	@FindBy(xpath = "//a[text()='Graph Representations']")
	private WebElement graphRepresentationsBtn;

	public void practiceQuestions() {
	    practiceQuestionsBtn.click();
	}

	public void graphRepresentations() {
	    graphRepresentationsBtn.click();
	}
	public String handleAlert1() {

		String handleAlert1 = handleAlert();
		return handleAlert1;

	}
}