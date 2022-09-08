package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BetPass {
    public WebDriver WD;

    public BetPass(WebDriver webDriver) {
        this.WD = webDriver;
    }

    public BetPass openBetPassSite() {
        WD.get("https://betpassionfun.draft10.com/");

        Assert.assertEquals("https://betpassionfun.draft10.com/", WD.getCurrentUrl());
        return this;
    }

    public BetPass correctRegistration(String username, String password) {
        WebElement registerBtn = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//button[contains(@class,'button btn button--secondary-rounded')]"))));
        registerBtn.click();

        WD.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        WD.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        WD.findElement(By.xpath("//input[@id='repeatPassword']")).sendKeys(password);
        WD.findElement(By.xpath("//input[@id='firstCheck']")).click();
        WD.findElement(By.xpath("//input[@id='secondCheck']")).click();
        WD.findElement(By.xpath("//button[text() = 'Sign up']")).
                click();

        WebElement successRegister = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//div[@class='success-register__wrapper']"))));
        Assert.assertTrue(successRegister.isDisplayed());
        return this;
    }

    public BetPass correctLogIn(String username, String password) {
        WebElement logInBtn = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//button[contains(@class,'button btn button--primary-rounded')]"))));
        logInBtn.click();

        WD.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        WD.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        WD.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div/form/div[4]/button")).
                click();

        WebElement userIcon = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//i[@class='icon-user']"))));
        Assert.assertTrue(userIcon.isDisplayed());
        return this;
    }

    public BetPass wrongPasswordLogIn(String username, String password) throws InterruptedException {
        WebElement logInBtn = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//button[contains(@class,'button btn button--primary-rounded')]"))));
        logInBtn.click();

        WD.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        WD.findElement(By.xpath("//input[@id='password']")).sendKeys(password + "1");
        WD.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div/form/div[4]/button")).
                click();

        Thread.sleep(1000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid password");
        return this;
    }

    public BetPass wrongUserNameLogIn(String username, String password) throws InterruptedException {
        WebElement logInBtn = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//button[contains(@class,'button btn button--primary-rounded')]"))));
        logInBtn.click();

        WD.findElement(By.xpath("//input[@id='username']")).sendKeys(username + "1");
        WD.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        WD.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div/form/div[4]/button")).
                click();

        Thread.sleep(1000);
        Assert.assertEquals(WD.switchTo().alert().getText(), "Invalid username or password");
        return this;
    }

    public BetPass wrongRegistration(String username, String password) {
        WebElement registerBtn = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//button[contains(@class,'button btn button--secondary-rounded')]"))));
        registerBtn.click();

        WD.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        WD.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        WD.findElement(By.xpath("//input[@id='repeatPassword']")).sendKeys(password + "1");
        WD.findElement(By.xpath("//input[@id='firstCheck']")).click();
        WD.findElement(By.xpath("//input[@id='secondCheck']")).click();
        WD.findElement(By.xpath("//button[text() = 'Sign up']")).
                click();


        Assert.assertTrue(WD.findElement(By.xpath("//span[@class='input__error-text']")).
                isDisplayed());
        return this;
    }

    public BetPass checkRegistrationCheckBox() {
        WebElement registerBtn = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//button[contains(@class,'button btn button--secondary-rounded')]"))));
        registerBtn.click();

        Assert.assertEquals(WD.findElement(By.xpath("//button[text() = 'Sign up']")).
                getAttribute("disabled"), "true");

        WD.findElement(By.xpath("//input[@id='firstCheck']")).click();
        Assert.assertEquals(WD.findElement(By.xpath("//button[text() = 'Sign up']")).
                getAttribute("disabled"), "true");

        WD.findElement(By.xpath("//input[@id='secondCheck']")).click();
        WD.findElement(By.xpath("//input[@id='firstCheck']")).click();
        Assert.assertEquals(WD.findElement(By.xpath("//button[text() = 'Sign up']")).
                getAttribute("disabled"), "true");
        return this;
    }

    public BetPass checkSameUserNameRegistration(String username, String password) throws InterruptedException {
        WebElement registerBtn = (new WebDriverWait(WD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//button[contains(@class,'button btn button--secondary-rounded')]"))));
        registerBtn.click();

        WD.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        WD.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        WD.findElement(By.xpath("//input[@id='repeatPassword']")).sendKeys(password);
        WD.findElement(By.xpath("//input[@id='firstCheck']")).click();
        WD.findElement(By.xpath("//input[@id='secondCheck']")).click();
        WD.findElement(By.xpath("//button[text() = 'Sign up']")).
                click();

        Thread.sleep(1000);
        Assert.assertEquals(WD.switchTo().alert().getText(),
                String.format("Account with username %s already exists!", username));
        return this;
    }
}
