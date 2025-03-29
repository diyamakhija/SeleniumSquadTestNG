package tests;

import base.BaseTest;
import constants.UrlConstants;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.ExcelReader;
import utils.LoggerLoad;

import java.util.List;
import java.util.Map;

public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage;

  
    @Test(priority = 1, retryAnalyzer = listeners.Retry.class)
    public void verifyUserCanLandOnRegisterPage() {
        driver.get(UrlConstants.REGISTER_URL);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/register"), "User should be on the registration page.");
    }

    @Test(dataProvider = "registrationData", priority = 2, retryAnalyzer = listeners.Retry.class)
    public void registerWithDataSet(Map<String, String> data) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickGetStarted();
        registrationPage.clickRegister();

        // Fetch values safely and trim only if not null
        String username = data.getOrDefault("username", "").trim();
        String password = data.getOrDefault("password", "").trim();
        String passwordConfirm = data.getOrDefault("passwordConfirm", "").trim();
        String expectedMessage = data.getOrDefault("expectedmessage", "").trim();

        //  Skip native validation test case
        if (username.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
            System.out.println(" Skipping test case due to browser-native validation.");
            return;
        }

        registrationPage.enterUsername(username);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(passwordConfirm);
        registrationPage.submit();

        String actualMessage = registrationPage.getMessage(5);
        LoggerLoad.info("Exp: '" + expectedMessage + "' | Act: '" + actualMessage + "'");
        Assert.assertTrue(actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()));

    }

    
    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        Map<String, List<Map<String, String>>> allData =
                ExcelReader.getData("./src/test/resources/testData/excelData.xlsx");

        List<Map<String, String>> dataList = allData.get("registration");

        Object[][] dataArray = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i][0] = dataList.get(i);
        }
        return dataArray;
    }
} 
