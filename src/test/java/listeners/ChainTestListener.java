//package listeners;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class ExtentTestListener implements ITestListener {
//    private ExtentReports extentReports;
//    private ExtentTest extentTest;
//    
//    @Override
//    public void onStart(ITestContext context) {
//        // Initialize the report
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(htmlReporter);
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        // Create a test entry when a test starts
//        extentTest = extentReports.createTest(result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        // Mark the test as passed
//        extentTest.pass(result.getName() + " passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        // Mark the test as failed
//        extentTest.fail(result.getThrowable());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        // Mark the test as skipped
//        extentTest.skip(result.getName() + " skipped");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        // Write the test results to the report
//        extentReports.flush();
//    }
//}






//package listeners;
//
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import utils.DriverManager;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ChainTestListener implements ITestListener {
//    WebDriver driver = DriverManager.getDriver("");
//   
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        // Test started
//        System.out.println("Test started: " + result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        // Test passed
//        System.out.println("Test passed: " + result.getName());
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        // Capture screenshot on failure
//        String testName = result.getName();
//        System.out.println("Test failed: " + testName);
//
//        // Capture screenshot
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            // Define the path to save the screenshot
//            String screenshotPath = "C:\\DSALGOTestNG\\SeleniumSquadTestNG\\target" + testName + ".png";
//            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
//            System.out.println("Screenshot saved at: " + screenshotPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        // Test skipped
//        System.out.println("Test skipped: " + result.getName());
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        // Called after all tests are completed
//        System.out.println("Test suite completed");
//    }
//}

            











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
public class ChainTestListener implements ITestListener {
   @Override
   public void onTestFailure(ITestResult result) {
       LoggerLoad.error("Test Failed: " + result.getName());
       // Take screenshot
       WebDriver driver = DriverManager.getDriver(); // assuming you have this utility
       File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
       String fileName = "ChainTestscreenshots/" + result.getName() + "_" + timestamp + ".png";
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
