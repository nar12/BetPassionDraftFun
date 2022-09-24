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

public class LoginPage {
    public WebDriver WD;
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//div[@class='auth__form']//button[text()='Log in']")
    WebElement login;
    @FindBy(xpath = "//span[@class='password-visibility-icon']")
    WebElement showPassword;
    @FindBy(xpath = "//button[contains(@class,'button btn button--primary-rounded')]")
    WebElement homeLogin;
    @FindBy(xpath = "//input[@id='username']/following-sibling::span")
    WebElement wrongUsernameMsg;
    @FindBy(xpath = "//input[@id='password']/following-sibling::span")
    WebElement wrongPasswordMsg;
    @FindBy(xpath = "//span[text()='*Username is required']")
    WebElement usernameRequireMsg;
    @FindBy(xpath = "//span[text()='*Password is required']")
    WebElement passwordRequireMsg;


    public LoginPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    public LoginPage openLoginForm() {
        WaitElement.waitToBeClickable(WD, homeLogin).click();

        return this;
    }

    public LoginPage enterUsername(String username) {
        this.username.clear();
        this.username.sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);

        return this;
    }

    public LoginPage clickLoginButton() {
        login.click();

        return this;
    }

    public LoginPage clickShowPassword() {
        showPassword.click();

        return this;
    }

    public LoginPage logout() {
        try {
            WD.findElement(By.xpath("//div[@class='bonus']"));
            WD.findElement(By.xpath("//button[contains(@class,'button btn button--tertiary')]")).click();
        } catch (Exception e) {
        }
        WD.findElement(By.xpath("//i[@class='icon-user']")).click();
        WD.findElement(By.xpath("//button[contains(@class,'button btn button--logout-desktop')]")).click();

        return this;
    }

    public LoginPage checkLoginPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/login", WD.getCurrentUrl());

        return this;
    }

    public LoginPage checkLoginSuccess() {
        WebElement userIcon = (new WebDriverWait(WD, Duration.ofSeconds(10)).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//i[@class='icon-user']"))));
        Assert.assertTrue(userIcon.isDisplayed());
        //Assert.assertEquals(WD.getCurrentUrl(), "https://betpassionfun.draft10.com/home");

        return this;
    }

    public LoginPage checkWrongPassLogin() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid password");
        WD.switchTo().alert().accept();

        return this;
    }

    public LoginPage checkWrongUserLogin() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid username or password");
        WD.switchTo().alert().accept();

        return this;
    }

    public LoginPage checkTextDisplayed() {
        Assert.assertEquals(password.getAttribute("type"), "text");

        return this;
    }

    public LoginPage checkShowPasswordIconWasChanged() {
        Assert.assertEquals(WD.findElement(By.
                        xpath("//span[@class='password-visibility-icon']//i")).
                getAttribute("class"), "icon-visibility");

        return this;
    }

    public LoginPage checkUsernameIllegalSymbols() {
        Assert.assertTrue(wrongUsernameMsg.isDisplayed());

        return this;
    }

    public LoginPage checkPasswordIllegalSymbols() {
        Assert.assertTrue(wrongPasswordMsg.isDisplayed());

        return this;
    }

    public LoginPage checkUsernameRequired() {
        Assert.assertTrue(usernameRequireMsg.isDisplayed());

        return this;
    }

    public LoginPage checkPasswordRequired() {
        Assert.assertTrue(passwordRequireMsg.isDisplayed());

        return this;
    }
}
