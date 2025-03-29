package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By getStartedBtn = By.xpath("//a[@href='/home']/button");
    private By registerLink = By.linkText("Register");
    private By usernameField = By.id("id_username");
    private By passwordField = By.id("id_password1");
    private By confirmPasswordField = By.id("id_password2");
    private By registerSubmitBtn = By.xpath("//input[@value='Register']");
    private By messageBox = By.cssSelector("div.alert");

    // Actions
    public void clickGetStarted() {
        driver.findElement(getStartedBtn).click();
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
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

    public void enterConfirmPassword(String confirmPassword) {
        WebElement field = driver.findElement(confirmPasswordField);
        field.clear();
        field.sendKeys(confirmPassword);
    }

    public void submit() {
        driver.findElement(registerSubmitBtn).click();
    }

    public String getMessage(int waitSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(messageBox));
        return alert.getText();
    }
}
