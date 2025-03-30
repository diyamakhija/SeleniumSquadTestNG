package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
  
public class LoginpagePF{
 
	private WebDriver driver;

public LoginpagePF(WebDriver driver) {
    this.driver = driver;
}
    // Locators

private By getStartedBtn = By.xpath("//div[@class='content']/a/button");
private By signInLink = By.xpath("//div[@class='navbar-nav'][2]/ul/a[3]");
private By usernameField = By.id("id_username");
private By passwordField = By.id("id_password");
private By loginSubmitBtn = By.xpath("//div[@class='col-sm']/form/input[4]");
private By successMessage = By.xpath("//div[@class='alert alert-success']");
private By errorMessage = By.xpath("//div[@role='alert']");
  
//Actions for the Login Page
public void clickGetStarted() {
 driver.findElement(getStartedBtn).click();
}

public void clickSignIn() {
 driver.findElement(signInLink).click();
}

public void enterUsername(String username) {
 WebElement field = driver.findElement(usernameField);
 field.clear();
 field.sendKeys(username);
}

public void enterPassword(String password) {
 WebElement field = driver.findElement(passwordField);
 field.clear();
 field.sendKeys(password);
}

public void submitLogin() {
 driver.findElement(loginSubmitBtn).click();
}

public String getSuccessMessage() {
 return driver.findElement(successMessage).getText();
}

public String getErrorMessage() {
 return driver.findElement(errorMessage).getText();
}

}
