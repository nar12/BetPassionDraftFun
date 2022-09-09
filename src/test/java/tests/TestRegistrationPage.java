package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BetPass;
import pages.RegistrationPage;

public class TestRegistrationPage {
    public static WebDriver webDriver;
    public RegistrationPage registrationPage;
    public BetPass betPass;
    String username = "nar12";
    String password = "asd456";
    String wrongPassword = "asd4561";

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        registrationPage = new RegistrationPage(webDriver);
        betPass = new BetPass(webDriver);
    }

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
                openBetPassSite();
    }

    @Test
    public void openRegistrationPage() {
        registrationPage.
                openRegistrationForm();
    }

    @Test
    public void registration() {
        registrationPage.
                openRegistrationForm().
                enterUsername(username).
                enterPassword(password).
                enterRepeatPassword(password).
                clickFirstCheck().
                clickSecondCheck().
                clickSignUpButton().
                checkRegistrationSuccess();
    }

    @Test
    public void wrongRepeatedPasswordRegister() {

        registrationPage.
                openRegistrationForm().
                enterUsername(username).
                enterPassword(password).
                enterRepeatPassword(wrongPassword).
                clickFirstCheck().
                clickSecondCheck().
                clickSignUpButton().
                checkWrongRepeatedPassword();
    }

    @Test
    public void checkRegCheckBox() {
        registrationPage.
                openRegistrationForm().
                checkSignUpButtonDisabled().
                clickFirstCheck().
                checkSignUpButtonDisabled().
                clickSecondCheck().
                clickFirstCheck().
                checkSignUpButtonDisabled();
    }

    @Test
    public void checkSameUserNameRegister() throws InterruptedException {
        registrationPage.
                openRegistrationForm().
                enterUsername(username).
                enterPassword(password).
                enterRepeatPassword(password).
                clickFirstCheck().
                clickSecondCheck().
                clickSignUpButton().
                checkSameUserNameAllert(username);
    }
}
