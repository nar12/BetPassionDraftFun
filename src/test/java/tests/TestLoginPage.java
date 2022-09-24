package tests;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BetPass;
import pages.LoginPage;
import common.Constants;

public class TestLoginPage {
    public static WebDriver webDriver;
    public LoginPage loginPage;

    public BetPass betPass;


    @BeforeClass
    public void startBrowser() {
        webDriver = Config.createWebDriver();
        betPass = new BetPass(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
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
                enterUsername(Constants.USERNAME).
                enterPassword(Constants.PASSWORD).
                clickLoginButton().
                checkLoginSuccess().
                logout();
    }

    @Test(description = "Check login with wrong password")
    public void wrongPassLogin() throws InterruptedException {
        loginPage.
                openLoginForm().
                enterUsername(Constants.USERNAME).
                enterPassword(Constants.WRONG_PASSWORD).
                clickLoginButton().
                checkWrongPassLogin();
    }

    @Test(description = "Check login with wrong username")
    public void wrongUserLogIn() throws InterruptedException {
        loginPage.
                openLoginForm().
                enterUsername(Constants.WRONG_USERNAME).
                enterPassword(Constants.USERNAME).
                clickLoginButton().
                checkWrongUserLogin();
    }

    @Test(description = "Check showPassword was working correct")
    public void checkPasswordShow() {
        loginPage.openLoginForm().
                enterPassword(Constants.PASSWORD).
                clickShowPassword().
                checkTextDisplayed().
                checkShowPasswordIconWasChanged();
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

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
