package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StackPF extends BaseClass {

       
    @FindBy(xpath = "//div[@class='col'][4]/div/div/a")
	public WebElement stack_getStartedBtn;
	
	@FindBy(xpath = "//a[text()='Operations in Stack']")
		WebElement OperationinStackBtn;
	
	@FindBy(xpath = "//a[text()='Try here>>>']")
	public WebElement tryHereBtn;

	@FindBy(xpath = "//textarea[@tabindex='0']")
	public WebElement input;

	@FindBy(xpath = "//button[text()='Run']")
	public WebElement runBtn;

	@FindBy(xpath = "//a[text()='Implementation']")
	public WebElement implementation;

	@FindBy(xpath = "//pre[@id='output']")
	public WebElement output;
	
	@FindBy(xpath = "/html/body/div[2]/ul[3]/a")
	public WebElement Application;
	
	@FindBy(xpath = "//a[text()='Practice Questions']")
	public WebElement practiceQuestionsBtn;

	@FindBy(xpath = "//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[3]")
	public WebElement dropDownBtn;
	
	@FindBy(xpath = "//div[@class='col'][5]/div/div/a")
	public WebElement queueOption;
	
	@FindBy(xpath = "//form[@id='answer_form']")
	public WebElement form;
	
	@FindBy(xpath = "//form/div/div/div/textarea")
	public WebElement editorInput;
	
	@FindBy(xpath = "//div[@class='bs-example']/nav/a")
	public WebElement numpyNinjaBtn;
	


// Methods 
	
    public void stack_getStartedBtn() {
        stack_getStartedBtn.click();
    }

    public void operationInStackBtn() {
        OperationinStackBtn.click();
    }
    
    public void tryHereBtn() {
        tryHereBtn.click();
    }
 
    public void input(String code) {
        input.sendKeys(code);
    }
    
    public void runBtn() {
        runBtn.click();
    }
    
public void codeEditorInput(String codeSnippet) {
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		webDriverWait.until(ExpectedConditions.visibilityOf(form));
		form.click();
		editorInput.sendKeys(codeSnippet);
	}
    public void implementation() {
        implementation.click();
    }
   
    public void output() {
        output.click();
    }

    public void practiceQuestionsBtn() {
        practiceQuestionsBtn.click();
    }
    
    public void dropDownBtn() {
        dropDownBtn.click();
    }
    
    public void queueOption() {
        queueOption.click();
    }

    
    public void application() {
        Application.click();
    }
    
    public void numpyNinjaBtn() {

		numpyNinjaBtn.click();
	}

    public String handleAlert1() {
        return handleAlert();  
    }
    
}

