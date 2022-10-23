package Base;


import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners
public class TestAllureListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        WebDriver driver = Driver.getInstance().getWebDriver();
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            try {
                saveScreenshot(driver);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
