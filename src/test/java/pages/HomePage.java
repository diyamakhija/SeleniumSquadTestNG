package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class HomePage {

    private WebDriver driver;

    //  Constructor to accept WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
 // Locators
    private By getStartedBtn = By.xpath("//button[text()='Get Started']");
    private By signInLink = By.linkText("Sign in");
    private By registerLink = By.linkText("Register");
    private By dropdownToggle = By.cssSelector("a.nav-link.dropdown-toggle"); 
    private By dropdownOptions = By.xpath("//div[@class='dropdown-menu show']//a");
    private By warningMessage = By.className("alert");


    // Method to verify 'Get Started' button is visible
    public boolean isGetStartedVisible() {
        return driver.findElement(By.xpath("//button[text()='Get Started']")).isDisplayed();
    }
    // Click main Get Started button
    public void clickMainGetStarted() {
        driver.findElement(getStartedBtn).click();
    }

    // Check if Sign in and Register are visible on Introduction page
    public boolean isSignInVisible() {
        return driver.findElement(signInLink).isDisplayed();
    }

    public boolean isRegisterVisible() {
        return driver.findElement(registerLink).isDisplayed();
    }

    // Get all dropdown option texts
    public List<WebElement> getDropdownOptions() {
        return driver.findElements(dropdownOptions);
    }
    public void clickDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownToggle));
        dropdown.click();
        System.out.println(" Clicked on Data Structures dropdown.");
    }


   // Click on a specific item in dropdown (e.g. Array, Stack)
    public void clickDropdownItem(String itemName) {
        List<WebElement> options = getDropdownOptions();
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(itemName)) {
                option.click();
                break;
            }
        }
    }

    // Get warning message text
    public String getWarningMessage() {
        return driver.findElement(warningMessage).getText();
    }
}
