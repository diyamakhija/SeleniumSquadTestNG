package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.LoggerLoad;

public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 1; // Retry once

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            LoggerLoad.warn("Retrying test: " + result.getName() + ", Attempt: " + retryCount);
            return true;
        }
        return false;
    }
}
