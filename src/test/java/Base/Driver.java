package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private WebDriver driver;
    private static Driver instance;

    private Driver() {
    }

    public static Driver getInstance() {
        if (instance == null)
            instance = new Driver();
        return instance;
    }

    public Driver setWebDriver() {
        String currentBrowser = System.getProperty("browser", "chrome");
        if ("chrome".equals(currentBrowser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(currentBrowser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return this;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void deleteWebDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
