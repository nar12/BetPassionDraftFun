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
    WebElement _username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement _password;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div/form/div[4]/button")
    WebElement _logIn;
    //@FindBy(xpath = "//button[contains(@class,'button btn button--primary-rounded')]")
    By _homeLogIn = By.xpath("//button[contains(@class,'button btn button--primary-rounded')]");

    public LoginPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    public LoginPage openLoginPage() {
        WebElement logInBtn = (new WebDriverWait(WD, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(_homeLogIn)));
        logInBtn.click();

        Assert.assertEquals("https://betpassionfun.draft10.com/login", WD.getCurrentUrl());
        return this;
    }

    public LoginPage correctLogIn(String username, String password) {
        _username.sendKeys(username);
        _password.sendKeys(password);
        _logIn.click();

        WebElement userIcon = (new WebDriverWait(WD, Duration.ofSeconds(10)).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//i[@class='icon-user']"))));
        Assert.assertTrue(userIcon.isDisplayed());
        return this;
    }

    public LoginPage wrongPasswordLogIn(String username, String password) throws InterruptedException {
        _username.sendKeys(username);
        _password.sendKeys(password + "1");
        _logIn.click();

        Thread.sleep(1000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid password");
        return this;
    }

    public LoginPage wrongUserNameLogIn(String username, String password) throws InterruptedException {
        _username.sendKeys(username + "1");
        _password.sendKeys(password);
        _logIn.click();

        Thread.sleep(1000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid username or password");
        return this;
    }
}
