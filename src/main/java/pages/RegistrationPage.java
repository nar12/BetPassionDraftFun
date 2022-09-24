package pages;

import common.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationPage {
    public WebDriver WD;
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='repeatPassword']")
    WebElement repeatPassword;
    @FindBy(xpath = "//input[@id='firstCheck']")
    WebElement firstCheck;
    @FindBy(xpath = "//input[@id='secondCheck']")
    WebElement secondCheck;
    @FindBy(xpath = "//button[text() = 'Sign up']")
    WebElement signUp;
    @FindBy(xpath = "//button[contains(@class,'button btn button--secondary-rounded')]")
    WebElement register;

    public RegistrationPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    public RegistrationPage openRegistrationForm() {
        WaitElement.waitToBeClickable(WD, register).click();

        return this;
    }

    public RegistrationPage enterUsername(String username) {
        this.username.clear();
        this.username.sendKeys(username);

        return this;
    }

    public RegistrationPage enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);

        return this;
    }

    public RegistrationPage enterRepeatPassword(String password) {
        repeatPassword.clear();
        repeatPassword.sendKeys(password);

        return this;
    }

    public RegistrationPage clickSignUpButton() {
        signUp.click();

        return this;
    }

    public RegistrationPage clickFirstCheck() {
        firstCheck.click();

        return this;
    }

    public RegistrationPage clickSecondCheck() {
        secondCheck.click();

        return this;
    }

    public RegistrationPage checkRegPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/register", WD.getCurrentUrl());

        return this;
    }

    public RegistrationPage checkRegistrationSuccess() {
        WebElement successRegister = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//div[@class='success-register__wrapper']"))));
        Assert.assertTrue(successRegister.isDisplayed());

        return this;
    }

    public RegistrationPage checkWrongRepeatedPassword() {
        Assert.assertTrue(WD.findElement(By.xpath("//span[text()='*Passwords do not match']")).
                isDisplayed());

        return this;
    }

    public RegistrationPage checkSignUpButtonDisabled() {
        Assert.assertEquals(signUp.getAttribute("disabled"), "true");

        return this;
    }

    public RegistrationPage checkSignUpButtonEnabled() {
        Assert.assertEquals(signUp.getAttribute("disabled"), null);

        return this;
    }

    public RegistrationPage checkUsernameRequired() {
        Assert.assertTrue(WD.findElement(By.xpath("//span[text()='*Username is required']")).
                isDisplayed());

        return this;
    }

    public RegistrationPage checkPasswordRequired() {
        Assert.assertTrue(WD.findElement(By.xpath("//span[text()='*Password is required']")).
                isDisplayed());

        return this;
    }

    public RegistrationPage checkRepeatedPasswordRequired() {
        Assert.assertTrue(WD.findElement(By.xpath("//span[text()='*Repeat Password is required']")).
                isDisplayed());

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
