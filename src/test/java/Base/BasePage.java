package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    private static final int TIMER = 10;

    public BasePage() {
        this.driver = Driver.getInstance().getWebDriver();
    }

    public WebElement getElement(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMER));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        return driver.findElement(By.xpath(locator));
    }
}
