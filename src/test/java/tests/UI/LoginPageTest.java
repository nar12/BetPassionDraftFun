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
                openLoginPage().
                checkLoginPageWasOpen();
    }

    @Test(description = "Check correct login")
    public void correctLogin() {
        loginPage.
                openLoginPage().
                enterUsername(USERNAME).
                enterPassword(PASSWORD).
                clickLoginButton().
                checkLoginSuccess().
                logout();
    }

    @Test(description = "Check login with wrong password")
    public void wrongPassLogin() throws InterruptedException {
        loginPage.
                openLoginPage().
                enterUsername(USERNAME).
                enterPassword(WRONG_PASSWORD).
                clickLoginButton().
                checkWrongPassLogin();
    }

    @Test(description = "Check login with wrong username")
    public void wrongUserLogIn() throws InterruptedException {
        loginPage.
                openLoginPage().
                enterUsername(WRONG_USERNAME).
                enterPassword(USERNAME).
                clickLoginButton().
                checkWrongUserLogin();
    }

    @Test(description = "Check showPassword was working correct")
    public void checkPasswordShow() {
        loginPage.openLoginPage().
                enterPassword(PASSWORD).
                clickShowPasswordButton().
                checkPasswordDisplayed().
                checkShowPasswordIconOnState();
    }

    @Test(description = "Check login with illegal parameters")
    public void loginWithIllegalParameters() {
        loginPage.
                openLoginPage().
                enterUsername("a").
                enterPassword("$2%").
                clickLoginButton().
                checkUsernameIllegalSymbolsMsg().
                checkPasswordIllegalSymbolsMsg();
    }

    @Test(description = "Check login without parameters")
    public void loginWithoutParameters() {
        loginPage.
                openLoginPage().
                clickLoginButton().
                checkUsernameRequiredMsg().
                checkPasswordRequiredMsg();
    }

    @Test
    public void GoogleAuth() throws InterruptedException {
        loginPage.
                openLoginPage().
                GoogleAuth("betpasstest@gmail.com","Bara077259914").
                checkLoginSuccess().
                logout();
    }
}
