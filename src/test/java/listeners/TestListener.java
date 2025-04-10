package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.LoggerLoad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerLoad.error("Test Failed: " + result.getName());

        // Take screenshot
        WebDriver driver = DriverManager.getDriver(); // assuming you have this utility
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "screenshots/" + result.getName() + "_" + timestamp + ".png";

        try {
            File destFile = new File(fileName);
            destFile.getParentFile().mkdirs(); // create dir if not exists
            Files.copy(srcFile.toPath(), destFile.toPath());
            LoggerLoad.info("Screenshot saved to: " + fileName);
        } catch (IOException e) {
            LoggerLoad.error("Failed to save screenshot: " + e.getMessage());
        }

        // Write failed test name to file
        try (FileWriter fw = new FileWriter("test-output/failed-tests.txt", true)) {
            fw.write(result.getName() + System.lineSeparator());
        } catch (IOException e) {
            LoggerLoad.error("Failed to log failed test name: " + e.getMessage());
        }
    }
}
