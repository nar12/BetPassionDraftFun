package tests;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BetPass;
import pages.RegistrationPage;
import common.Constants;

public class TestRegistrationPage {
    public static WebDriver webDriver;
    public RegistrationPage registrationPage;
    public BetPass betPass;

    @BeforeClass
    public void startBrowser() {
        webDriver = Config.createWebDriver();
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

    /*@Test
    public void registration() {
        registrationPage.
                openRegistrationForm().
                enterUsername(Constants.USERNAME).
                enterPassword(Constants.PASSWORD).
                enterRepeatPassword(Constants.PASSWORD).
                clickFirstCheck().
                clickSecondCheck().
                clickSignUpButton().
                checkRegistrationSuccess();
    }*/

    @Test
    public void wrongRepeatedPasswordRegister() {

        registrationPage.
                openRegistrationForm().
                enterUsername(Constants.USERNAME).
                enterPassword(Constants.PASSWORD).
                enterRepeatPassword(Constants.WRONG_PASSWORD).
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
                enterUsername(Constants.USERNAME).
                enterPassword(Constants.PASSWORD).
                enterRepeatPassword(Constants.PASSWORD).
                clickFirstCheck().
                clickSecondCheck().
                clickSignUpButton().
                checkSameUserNameAlert(Constants.USERNAME);
    }

    @Test(description = "check registration without parameters but with checked checkboxes")
    public void checkRegistrationWithoutParametersAndCheckedBoxes() {
        registrationPage.
                openRegistrationForm().
                checkRegPageWasOpen().
                checkSignUpButtonDisabled().
                clickFirstCheck().
                clickSecondCheck().
                checkSignUpButtonEnabled().
                clickSignUpButton().
                checkUsernameRequired().
                checkPasswordRequired().
                checkRepeatedPasswordRequired();
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
