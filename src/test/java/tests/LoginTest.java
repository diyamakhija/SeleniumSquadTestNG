package tests;

import base.BaseTest;
import constants.UrlConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginpagePF;
import utils.ExcelReader;
import utils.LoggerLoad;

import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {

    LoginpagePF loginPagePF;

    @Test(priority = 1, retryAnalyzer = listeners.Retry.class)
    public void verifyUserCanLandOnLoginPage() {
        driver.get(UrlConstants.LOGIN_URL);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"), "User should be on the login page.");
    }

    @Test(dataProvider = "loginData", priority = 2, retryAnalyzer = listeners.Retry.class)
    public void loginWithDataSet(Map<String, String> data) {
        loginPagePF = new LoginpagePF(driver);
        loginPagePF.clickGetStarted();
        loginPagePF.clickSignIn();

        // Fetch values safely and trim only if not null
        String username = data.getOrDefault("userCredential", "").trim();
        String password = data.getOrDefault("password", "").trim();
        String expectedMessage = data.getOrDefault("expectedmessage", "").trim();

        // Skip test if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Skipping test case due to missing username or password.");
            return;
        }

        loginPagePF.enterUsername(username);
        loginPagePF.enterPassword(password);
        loginPagePF.submitLogin();

        String actualMessage = loginPagePF.getErrorMessage();
        LoggerLoad.info("Exp: '" + expectedMessage + "' | Act: '" + actualMessage + "'");
        Assert.assertTrue(actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()));
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        Map<String, List<Map<String, String>>> allData =
                ExcelReader.getData("./src/test/resources/testData/excelData.xlsx");

        List<Map<String, String>> dataList = allData.get("userCredentials");

        Object[][] dataArray = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i][0] = dataList.get(i);
        }
        return dataArray;
    }
}
