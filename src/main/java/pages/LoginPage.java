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
    By homeLogin = By.xpath("//button[contains(@class,'button btn button--primary-rounded')]");

    public LoginPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    public LoginPage openLoginForm() {
        WebElement loginBtn = (new WebDriverWait(WD, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(homeLogin)));
        loginBtn.click();

        return this;
    }

    public LoginPage enterUsername(String uName){
        username.clear();
        username.sendKeys(uName);

        return this;
    }

    public LoginPage enterPassword(String pswd){
        password.clear();
        password.sendKeys(pswd);

        return this;
    }

    public LoginPage clickLoginButton(){
        login.click();

        return this;
    }

    public LoginPage clickShowPassword(){
        showPassword.click();

        return this;
    }

    public LoginPage logout(){
        try {
            WD.findElement(By.xpath("//div[@class='bonus']"));
            WD.findElement(By.xpath("//button[contains(@class,'button btn button--tertiary')]")).click();
        } catch (Exception e){}
        WD.findElement(By.xpath("//i[@class='icon-user']")).click();
        WD.findElement(By.xpath("//button[contains(@class,'button btn button--logout-desktop')]")).click();

        return this;
    }

    public LoginPage checkLoginPageWasOpen(){
        Assert.assertEquals("https://betpassionfun.draft10.com/login", WD.getCurrentUrl());

        return this;
    }

    public LoginPage checkLoginSuccess(){
        WebElement userIcon = (new WebDriverWait(WD, Duration.ofSeconds(10)).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//i[@class='icon-user']"))));
        Assert.assertTrue(userIcon.isDisplayed());
        //Assert.assertEquals(WD.getCurrentUrl(), "https://betpassionfun.draft10.com/home");

        return this;
    }

    public LoginPage checkWrongPassLogin() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid password");
        WD.switchTo().alert().accept();

        return this;
    }

    public LoginPage checkWrongUserLogin() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid username or password");
        WD.switchTo().alert().accept();

        return this;
    }

    public LoginPage checkTextDisplayed(){
        Assert.assertEquals(password.getAttribute("type"), "text");

        return this;
    }

    public LoginPage checkShowPasswordIconWasChanged(){
        Assert.assertEquals(WD.findElement(By.
                        xpath("//span[@class='password-visibility-icon']//i")).
                getAttribute("class"),"icon-visibility");

        return this;
    }

    public LoginPage checkUsernameIllegalSymbols(){
        Assert.assertTrue(WD.findElement(By.xpath("//input[@id='username']/following-sibling::span")).
                isDisplayed());

        return this;
    }

    public LoginPage checkPasswordIllegalSymbols(){
        Assert.assertTrue(WD.findElement(By.
                        xpath("//input[@id='password']/following-sibling::span")).
                isDisplayed());

        return this;
    }

    public LoginPage checkUsernameRequired(){
        Assert.assertTrue(WD.findElement(By.xpath("//span[text()='*Username is required']")).
                isDisplayed());

        return this;
    }

    public LoginPage checkPasswordRequired(){
        Assert.assertTrue(WD.findElement(By.xpath("//span[text()='*Password is required']")).
                isDisplayed());

        return this;
    }
}
