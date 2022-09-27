package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
                openBetPassSite();
    }

    @Test(description = "Check registration page was open")
    public void openRegistrationPage() {
        registrationPage.
                openRegistrationForm();
    }

    /*@Test(description = "Check correct registration")
    public void registration() {
        registrationPage.
                openRegistrationForm().
                enterUsername(USERNAME).
                enterPassword(PASSWORD).
                enterRepeatPassword(PASSWORD).
                clickFirstCheck().
                clickSecondCheck().
                clickSignUpButton().
                checkRegistrationSuccess();
    }*/

    @Test(description = "Check error of wrong repeated password registration")
    public void wrongRepeatedPasswordRegister() {

        registrationPage.
                openRegistrationForm().
                enterUsername(USERNAME).
                enterPassword(PASSWORD).
                enterRepeatPassword(WRONG_PASSWORD).
                clickFirstCheck().
                clickSecondCheck().
                clickSignUpButton().
                checkWrongRepeatedPassword();
    }

    @Test(description = "Check resister button disable when checkboxes not checked")
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

    @Test(description = "Check exist of username on registration")
    public void checkSameUserNameRegister() throws InterruptedException {
        registrationPage.
                openRegistrationForm().
                enterUsername(USERNAME).
                enterPassword(PASSWORD).
                enterRepeatPassword(PASSWORD).
                clickFirstCheck().
                clickSecondCheck().
                clickSignUpButton().
                checkSameUserNameAlert(USERNAME);
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
}
