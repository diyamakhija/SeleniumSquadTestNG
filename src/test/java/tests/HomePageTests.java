package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utils.ConfigReader;

public class HomePageTests extends BaseTest {

	 @Test(priority = 1)
	public void openPortal_shouldShowGetStarted() {
		boolean isVisible = homePage.isGetStartedVisible();
		Assert.assertTrue(isVisible, "'Get Started' button should be visible on Landing page");

	}
	 @Test(priority = 2)
	    public void getStarted_shouldNavigateToIntroPage() {
		homePage.clickMainGetStarted();
		Assert.assertTrue(homePage.isSignInVisible(),"'Sign In' link should be visible on intro page");
		Assert.assertTrue(homePage.isRegisterVisible());
	}
	 
	 @Test(priority = 3)
	    public void dropdown_shouldShowAllOptions() {
		 homePage.clickMainGetStarted();
		 homePage.clickDropdown();
		 
		 List<String> expected = List.of("Arrays", "Linked List", "Stack", "Queue", "Tree", "Graph");
	        List<String> actual = new ArrayList<>();
	        for (WebElement el : homePage.getDropdownOptions()) {
	            actual.add(el.getText().trim());
	        }

	        Assert.assertEquals(actual, expected, "Dropdown options should match expected list");
	 }
	 
	 @Test(priority = 4)
	    public void arrayDropdownWithoutLogin_shouldShowWarning() {
		 homePage.clickMainGetStarted();
		 homePage.clickDropdown();
		 homePage.clickDropdownItem("Arrays");

	        String expected = "You are not logged in";
	        String actual = homePage.getWarningMessage();
	        Assert.assertTrue(actual.contains(expected), "Warning message should be shown when not logged in");
	   
	 } 
	
}
