package pages;

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
    WebElement _username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement _password;
    @FindBy(xpath = "//input[@id='repeatPassword']")
    WebElement _repeatPassword;
    @FindBy(xpath = "//input[@id='firstCheck']")
    WebElement _firstCheck;
    @FindBy(xpath = "//input[@id='secondCheck']")
    WebElement _secondCheck;
    @FindBy(xpath = "//button[text() = 'Sign up']")
    WebElement _signUp;
    //@FindBy(xpath = "//button[contains(@class,'button btn button--secondary-rounded')]")
    By _registerBtn = By.xpath("//button[contains(@class,'button btn button--secondary-rounded')]");

    public RegistrationPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    public RegistrationPage openRegistrationPage() {
        WebElement registerBtn = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(_registerBtn)));
        registerBtn.click();

        Assert.assertEquals("https://betpassionfun.draft10.com/register", WD.getCurrentUrl());
        return this;
    }

    public RegistrationPage correctRegistration(String username, String password) {
        _username.sendKeys(username);
        _password.sendKeys(password);
        _repeatPassword.sendKeys(password);
        _firstCheck.click();
        _secondCheck.click();
        _signUp.click();

        WebElement successRegister = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//div[@class='success-register__wrapper']"))));
        Assert.assertTrue(successRegister.isDisplayed());
        return this;
    }

    public RegistrationPage wrongRegistration(String username, String password) {
        _username.sendKeys(username);
        _password.sendKeys(password);
        _repeatPassword.sendKeys(password + "1");
        _firstCheck.click();
        _secondCheck.click();
        _signUp.click();

        Assert.assertTrue(WD.findElement(By.xpath("//span[@class='input__error-text']")).
                isDisplayed());
        return this;
    }

    public RegistrationPage checkRegistrationCheckBox() {
        Assert.assertEquals(_signUp.getAttribute("disabled"), "true");

        _firstCheck.click();
        Assert.assertEquals(_signUp.getAttribute("disabled"), "true");

        _secondCheck.click();
        _firstCheck.click();
        Assert.assertEquals(_signUp.getAttribute("disabled"), "true");
        return this;
    }

    public RegistrationPage checkSameUserNameRegistration(String username, String password) throws InterruptedException {
        _username.sendKeys(username);
        _password.sendKeys(password);
        _repeatPassword.sendKeys(password);
        _firstCheck.click();
        _secondCheck.click();
        _signUp.click();

        Thread.sleep(1000);
        Assert.assertEquals(WD.switchTo().alert().getText(),
                String.format("Account with username %s already exists!", username));
        return this;
    }
}
