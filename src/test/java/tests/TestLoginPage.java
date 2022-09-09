package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BetPass;
import pages.LoginPage;

public class TestLoginPage {
    public static WebDriver webDriver;
    public LoginPage loginPage;

    public BetPass betPass;
    String username = "nar12";
    String wrongUsername = "nar121";
    String password = "asd456";
    String wrongPassword = "asd4561";

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        betPass = new BetPass(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
                openBetPassSite();
    }

    @Test
    public void openLoginPage() {
        loginPage.
                openLoginForm().
                checkLoginPageWasOpen();
    }

    @Test
    public void correctLogin() {
        loginPage.
                openLoginForm().
                enterUsername(username).
                enterPassword(password).
                clickLoginButton().
                checkLoginSuccess().
                logout();
    }

    @Test
    public void wrongPassLogin() throws InterruptedException {
        loginPage.
                openLoginForm().
                enterUsername(username).
                enterPassword(wrongPassword).
                clickLoginButton().
                checkWrongPassLogin();
    }

    @Test
    public void wrongUserLogIn() throws InterruptedException {
        loginPage.
                openLoginForm().
                enterUsername(wrongUsername).
                enterPassword(password).
                clickLoginButton().
                checkWrongUserLogin();
    }

    @Test
    public void checkPasswordShow() {
        loginPage.openLoginForm().
                enterPassword(password).
                clickShowPassword().
                checkTextDisplayed().
                checkShowPasswordIconWasChanged();
    }

    @Test
    public void loginWithIllegalParameters() {
        loginPage.
                openLoginForm().
                enterUsername("a").
                enterPassword("$2%").
                clickLoginButton().
                checkUsernameIllegalSymbols().
                checkPasswordIllegalSymbols();
    }

    @Test
    public void loginWithoutParameters() {
        loginPage.
                openLoginForm().
                clickLoginButton().
                checkUsernameRequired().
                checkPasswordRequired();
    }
}
