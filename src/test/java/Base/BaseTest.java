package Base;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public abstract class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Driver.getInstance().setWebDriver().getWebDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        Driver.getInstance().deleteWebDriver();
    }

    public void openWebsite(String url) {
        driver.get(url);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./target/allure-results/screenshots//" + screenshot.getName()));
        return Files.toByteArray(screenshot);
    }
}
