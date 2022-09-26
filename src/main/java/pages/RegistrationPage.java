package pages;

import common.WaitElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage {
    public WebDriver WD;
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='repeatPassword']")
    WebElement repeatPasswordField;
    @FindBy(xpath = "//input[@id='firstCheck']")
    WebElement firstCheckBox;
    @FindBy(xpath = "//input[@id='secondCheck']")
    WebElement secondCheckBox;
    @FindBy(xpath = "//button[text() = 'Sign up']")
    WebElement signUpBtn;
    @FindBy(xpath = "//button[@class='button btn button--secondary-rounded']")
    WebElement registerBtn;
    @FindBy(xpath = "//div[@class='success-register__wrapper']")
    WebElement successRegisterWrap;
    @FindBy(xpath = "//input[@id='username']/following-sibling::span")
    WebElement wrongUsernameMsg;
    @FindBy(xpath = "//input[@id='password']/following-sibling::span")
    WebElement wrongPasswordMsg;
    @FindBy(xpath = "//span[text()='*Username is required']")
    WebElement usernameRequireMsg;
    @FindBy(xpath = "//span[text()='*Password is required']")
    WebElement passwordRequireMsg;
    @FindBy(xpath = "//span[text()='*Passwords do not match']")
    WebElement wrongRepeatedPasswordMsg;
    @FindBy(xpath = "//span[text()='*Repeat Password is required']")
    WebElement repeatPasswordRequireMsg;

    public RegistrationPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    public RegistrationPage openRegistrationForm() {
        WaitElement.waitToBeClickable(WD, registerBtn).click();

        return this;
    }

    public RegistrationPage enterUsername(String username) {
        this.usernameField.clear();
        this.usernameField.sendKeys(username);

        return this;
    }

    public RegistrationPage enterPassword(String password) {
        this.passwordField.clear();
        this.passwordField.sendKeys(password);

        return this;
    }

    public RegistrationPage enterRepeatPassword(String password) {
        repeatPasswordField.clear();
        repeatPasswordField.sendKeys(password);

        return this;
    }

    public RegistrationPage clickSignUpButton() {
        signUpBtn.click();

        return this;
    }

    public RegistrationPage clickFirstCheck() {
        firstCheckBox.click();

        return this;
    }

    public RegistrationPage clickSecondCheck() {
        secondCheckBox.click();

        return this;
    }

    public RegistrationPage checkRegPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/register", WD.getCurrentUrl());

        return this;
    }

    public RegistrationPage checkRegistrationSuccess() {
        WaitElement.waitVisibilityOf(WD,successRegisterWrap);
        Assert.assertTrue(successRegisterWrap.isDisplayed());

        return this;
    }
    public RegistrationPage checkUsernameIllegalSymbols() {
        Assert.assertTrue(wrongUsernameMsg.isDisplayed());

        return this;
    }

    public RegistrationPage checkPasswordIllegalSymbols() {
        Assert.assertTrue(wrongPasswordMsg.isDisplayed());

        return this;
    }

    public RegistrationPage checkWrongRepeatedPassword() {
        Assert.assertTrue(wrongRepeatedPasswordMsg.isDisplayed());

        return this;
    }

    public RegistrationPage checkSignUpButtonDisabled() {
        Assert.assertEquals(signUpBtn.getAttribute("disabled"), "true");

        return this;
    }

    public RegistrationPage checkSignUpButtonEnabled() {
        Assert.assertEquals(signUpBtn.getAttribute("disabled"), null);

        return this;
    }

    public RegistrationPage checkUsernameRequired() {
        Assert.assertTrue(usernameRequireMsg.isDisplayed());

        return this;
    }

    public RegistrationPage checkPasswordRequired() {
        Assert.assertTrue(passwordRequireMsg.isDisplayed());

        return this;
    }

    public RegistrationPage checkRepeatedPasswordRequired() {
        Assert.assertTrue(repeatPasswordRequireMsg.isDisplayed());

        return this;
    }

    public RegistrationPage checkSameUserNameAlert(String username) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(WD.switchTo().alert().getText(),
                String.format("Account with username %s already exists!", username));
        WD.switchTo().alert().accept();

        return this;
    }
}
