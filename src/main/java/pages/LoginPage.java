package pages;

import common.WaitElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    public WebDriver WD;
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//div[@class='auth__form']//button[text()='Log in']")
    WebElement loginBtn;
    @FindBy(xpath = "//span[@class='password-visibility-icon']")
    WebElement showPasswordBtn;
    @FindBy(xpath = "//span[@class='password-visibility-icon']//i")
    WebElement showPasswordIcon;
    @FindBy(xpath = "//button[@class='button btn button--primary-rounded']")
    WebElement homeLoginBtn;
    @FindBy(xpath = "//input[@id='username']/following-sibling::span")
    WebElement wrongUsernameMsg;
    @FindBy(xpath = "//input[@id='password']/following-sibling::span")
    WebElement wrongPasswordMsg;
    @FindBy(xpath = "//span[text()='*Username is required']")
    WebElement usernameRequireMsg;
    @FindBy(xpath = "//span[text()='*Password is required']")
    WebElement passwordRequireMsg;
    @FindBy(xpath = "//i[@class='icon-user']")
    WebElement userIcon;
    @FindBy(xpath = "//div[@class='S9gUrf-YoZ4jf']")
    WebElement googleAuthBtn;
    @FindBy(xpath = "//input[@type='email']")
    WebElement googleEmailInput;
    @FindBy(xpath = "//input[@type='password']")
    WebElement googlePasswordInput;
    @FindBy(xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")
    WebElement googleContinueBtn;
    @FindBy(xpath = "//div[@id='confirm_yes']")
    WebElement googleConfirmBtn;


    public LoginPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    @Step("Open login page")
    public LoginPage openLoginPage() {
        WaitElement.waitToBeClickable(WD, homeLoginBtn).click();

        return this;
    }

    @Step("Enter username field")
    public LoginPage enterUsername(String username) {
        this.usernameField.clear();
        this.usernameField.sendKeys(username);

        return this;
    }

    @Step("Enter password field")
    public LoginPage enterPassword(String password) {
        this.passwordField.clear();
        this.passwordField.sendKeys(password);

        return this;
    }

    @Step("Click login button")
    public LoginPage clickLoginButton() {
        loginBtn.click();

        return this;
    }

    @Step("Click show password button")
    public LoginPage clickShowPasswordButton() {
        showPasswordBtn.click();

        return this;
    }

    @Step("Authentication with google account")
    public LoginPage GoogleAuth(String email, String password) throws InterruptedException {
        googleAuthBtn.click();

        String winHandleBefore = WD.getWindowHandle();
        for (String winHandle : WD.getWindowHandles()) {
            WD.switchTo().window(winHandle);
        }

        googleEmailInput.sendKeys(email);
        googleContinueBtn.click();
        Thread.sleep(3000);
        googlePasswordInput.sendKeys(password);
        googleContinueBtn.click();
        Thread.sleep(3000);
        try {
            googleConfirmBtn.click();
        } catch (Exception ex) {
        }
        WD.switchTo().window(winHandleBefore);

        return this;
    }

    @Step("Logout from account")
    public LoginPage logout() {
        userIcon.click();
        WD.findElement(By.xpath("//button[contains(@class,'button btn button--logout-desktop')]")).click();

        return this;
    }

    @Step("Check login page was open")
    public LoginPage checkLoginPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/login", WD.getCurrentUrl());

        return this;
    }

    @Step("Check login success")
    public LoginPage checkLoginSuccess() {
        try {
            WD.findElement(By.xpath("//div[@class='bonus']"));
            WD.findElement(By.xpath("//button[contains(@class,'button btn button--tertiary')]")).click();
        } catch (Exception e) {
        }

        WaitElement.waitVisibilityOf(WD, userIcon);
        Assert.assertTrue(userIcon.isDisplayed());
        //Assert.assertEquals(WD.getCurrentUrl(), "https://betpassionfun.draft10.com/home");

        return this;
    }

    @Step("Check alert with wrong password login")
    public LoginPage checkWrongPassLogin() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid password");
        WD.switchTo().alert().accept();

        return this;
    }

    @Step("Check alert with wrong username login")
    public LoginPage checkWrongUserLogin() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid username or password");
        WD.switchTo().alert().accept();

        return this;
    }

    @Step("Check password displayed")
    public LoginPage checkPasswordDisplayed() {
        Assert.assertEquals(passwordField.getAttribute("type"), "text");

        return this;
    }

    @Step("Check show password 'on' state")
    public LoginPage checkShowPasswordIconOnState() {
        Assert.assertEquals(showPasswordIcon.getAttribute("class"), "icon-visibility");

        return this;
    }

    @Step("Check show password 'off' state")
    public LoginPage checkShowPasswordIconOffState() {
        Assert.assertEquals(showPasswordIcon.getAttribute("class"), "icon-visibility-off");

        return this;
    }

    @Step("Check username illegal symbols message")
    public LoginPage checkUsernameIllegalSymbolsMsg() {
        Assert.assertTrue(wrongUsernameMsg.isDisplayed());

        return this;
    }

    @Step("Check password illegal symbols message")
    public LoginPage checkPasswordIllegalSymbolsMsg() {
        Assert.assertTrue(wrongPasswordMsg.isDisplayed());

        return this;
    }

    @Step("Check username require message")
    public LoginPage checkUsernameRequiredMsg() {
        Assert.assertTrue(usernameRequireMsg.isDisplayed());

        return this;
    }

    @Step("Check password require message")
    public LoginPage checkPasswordRequiredMsg() {
        Assert.assertTrue(passwordRequireMsg.isDisplayed());

        return this;
    }
}
