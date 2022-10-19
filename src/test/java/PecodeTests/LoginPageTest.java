package PecodeTests;

import Base.BaseTest;
import Base.TestAllureListener;
import PecodePages.LoginPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {

    private static final String URL = "https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php";
    private static final String USER_NAME = "user123";
    private static final String USER_PASSWORD = "$tEst321";
    private static final String EXPECTED_LOGIN_MSG = "Please enter username.";
    private static final String EXPECTED_PASSWORD_MSG = "Please enter your password.";
    private static final String NON_EXISTENT_ACCOUNT_MSG = "No account found with that username.";


    @Description("Login form is present on the page")
    @Test(priority = 1)
    public void checkLoginForm() {
        openWebsite(URL);
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.getLoginForm().isDisplayed());
    }

    @Description("Login with invalid credentials")
    @Test(priority = 2)
    public void loginWithInvalidData() {
        openWebsite(URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login(USER_NAME, USER_PASSWORD);
        Assert.assertEquals(loginPage.actualUserNameMsg(), NON_EXISTENT_ACCOUNT_MSG);
    }

    @Description("Login with empty password and username fields")
    @Test(priority = 3)
    public void loginWithEmptyData() {
        openWebsite(URL);
        LoginPage loginPage = new LoginPage();
        loginPage.getLoginBtn().click();
        Assert.assertEquals(loginPage.actualUserNameMsg(), EXPECTED_LOGIN_MSG);
        Assert.assertEquals(loginPage.actualUserPasswordMsg(), EXPECTED_PASSWORD_MSG);
    }

    @Description("Login with empty password field")
    @Test(priority = 4)
    public void loginWithEmptyPassword() {
        openWebsite(URL);
        LoginPage loginPage = new LoginPage();
        loginPage.getLoginField().sendKeys(USER_NAME);
        loginPage.getLoginBtn().click();
        Assert.assertEquals(loginPage.actualUserPasswordMsg(), EXPECTED_PASSWORD_MSG);
    }

    // this test should fail
    @Description("Verify that login is successful")
    @Test(priority = 5)
    public void loginWithInvalidDataFailed() {
        openWebsite(URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login(USER_NAME, USER_PASSWORD);
        Assert.assertFalse(loginPage.getLoginForm().isDisplayed());
    }
}
