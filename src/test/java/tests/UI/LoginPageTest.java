package tests.UI;

import org.testng.annotations.*;

public class LoginPageTest extends BaseTest {
    @BeforeMethod
    public void openBetPassSite() {
        homePage.
                openBetPassSite();
    }

    @Test(description = "Check Login page was open")
    public void openLoginPage() {
        loginPage.
                openLoginForm().
                checkLoginPageWasOpen();
    }

    @Test(description = "Check correct login")
    public void correctLogin() {
        loginPage.
                openLoginForm().
                enterUsername(USERNAME).
                enterPassword(PASSWORD).
                clickLoginButton().
                checkLoginSuccess().
                logout();
    }

    @Test(description = "Check login with wrong password")
    public void wrongPassLogin() throws InterruptedException {
        loginPage.
                openLoginForm().
                enterUsername(USERNAME).
                enterPassword(WRONG_PASSWORD).
                clickLoginButton().
                checkWrongPassLogin();
    }

    @Test(description = "Check login with wrong username")
    public void wrongUserLogIn() throws InterruptedException {
        loginPage.
                openLoginForm().
                enterUsername(WRONG_USERNAME).
                enterPassword(USERNAME).
                clickLoginButton().
                checkWrongUserLogin();
    }

    @Test(description = "Check showPassword was working correct")
    public void checkPasswordShow() {
        loginPage.openLoginForm().
                enterPassword(PASSWORD).
                clickShowPassword().
                checkTextDisplayed().
                checkShowPasswordIconOnState();
    }

    @Test(description = "Check login with illegal parameters")
    public void loginWithIllegalParameters() {
        loginPage.
                openLoginForm().
                enterUsername("a").
                enterPassword("$2%").
                clickLoginButton().
                checkUsernameIllegalSymbols().
                checkPasswordIllegalSymbols();
    }

    @Test(description = "Check login without parameters")
    public void loginWithoutParameters() {
        loginPage.
                openLoginForm().
                clickLoginButton().
                checkUsernameRequired().
                checkPasswordRequired();
    }

    /*@Test
    public void GoogleAuth() throws InterruptedException {
        loginPage.
                openLoginForm().
                GoogleAuth("betpasstest@gmail.com","Bara077259914").
                checkLoginSuccess();
    }*/
}
