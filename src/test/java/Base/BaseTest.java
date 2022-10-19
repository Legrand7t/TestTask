package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
}
