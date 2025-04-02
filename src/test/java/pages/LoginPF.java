package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPF extends BaseClass{

	@FindBy(xpath = "//div[@class='content']/a/button")
	public WebElement getStartedBtn;

	@FindBy(xpath = "//div[@class='navbar-nav'][2]/ul/a[3]")
	public WebElement signInBtn;

	@FindBy(id = "id_username")
	public WebElement userNameField;

	@FindBy(id = "id_password")
	public WebElement passwordField;

	@FindBy(xpath = "//div[@class='col-sm']/form/input[4]")
	public WebElement logInBtn;

	public void getStartedBtn() {

		getStartedBtn.click();
	}

	public void signInBtn() {

		signInBtn.click();
	}

	public void userCredentials() {

		userNameField.sendKeys("SeleniumSquad");
		passwordField.sendKeys("Squad2025#");
		logInBtn.click();
	}	
	}


