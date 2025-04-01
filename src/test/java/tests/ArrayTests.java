package tests;

import constants.UrlConstants;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ArrayPF;

public class ArrayTests extends BaseTest {

    ArrayPF arrayPF;

    @BeforeMethod
    public void setUpTest() {
    	loginWithValidCredentials(); // reads from Excel
    	arrayPF = new ArrayPF(driver);     // Your page class
    }

    @Test(priority = 1)
    public void testNavigateToArrayPage() {
        arrayPF.clickGetStartedArrayButton();
        Assert.assertEquals(driver.getCurrentUrl(),UrlConstants.ARRAY_PAGE_URL,"User is not on the Array Page");
    }

    @Test(priority = 2)
    public void testNavigateToArraysInPython() {
        arrayPF.clickGetStartedArrayButton(); // Make sure you're on Array page first
        arrayPF.clickArraysInPythonButton();
       
        Assert.assertEquals(driver.getCurrentUrl(),UrlConstants.ARRAY_ARRAYS_IN_PYTHON_URL,"User is not on Arrays in Python page");
    }

    @Test(priority = 3)
    public void testNavigateToArraysUsingList() {
        arrayPF.clickGetStartedArrayButton();
        arrayPF.clickArraysUsingListButton();
        Assert.assertEquals(driver.getCurrentUrl(),UrlConstants.ARRAY_ARRAYS_USING_LIST_URL,"User is not on Arrays Using List page");

    }

}
