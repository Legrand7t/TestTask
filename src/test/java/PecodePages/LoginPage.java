package PecodePages;

import Base.BasePage;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final String LOGIN_FORM = "//div[@class='wrapper']";
    private static final String USER_NAME_FIELD = "//div/input[@name='username']";
    private static final String PASSWORD_FIELD = "//div/input[@name='password']";
    private static final String LOGIN_BTN = "//div/input[@class='btn btn-success']";
    private static final String HELP_USER_NAME_MSG = "//div/input[@name='username']/following-sibling::span";
    private static final String HELP_PASSWORD_MSG = "//div/input[@name='password']/following-sibling::span";

    public LoginPage() {
        super();
    }

    public WebElement getLoginForm() {
        return getElement(LOGIN_FORM);
    }

    public WebElement getLoginField() {
        return getElement(USER_NAME_FIELD);
    }

    public WebElement getPasswordField() {
        return getElement(PASSWORD_FIELD);
    }

    public WebElement getLoginBtn() {
        return getElement(LOGIN_BTN);
    }

    public void login(String name, String password) {
        getLoginField().sendKeys(name);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }

    public String actualUserNameMsg() {
        return getElement(HELP_USER_NAME_MSG).getText();
    }

    public String actualUserPasswordMsg() {
        return getElement(HELP_PASSWORD_MSG).getText();
    }

}
